package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.internal;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.internal.launching.StandardVMType;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jst.server.core.IJavaRuntimeWorkingCopy;
import org.eclipse.jst.server.tomcat.core.internal.TomcatServer;
import org.eclipse.oomph.setup.SetupTaskContext;
import org.eclipse.oomph.setup.log.ProgressLog.Severity;
import org.eclipse.oomph.util.SubMonitor;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerType;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.internal.ServerWorkingCopy;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;

public class TomcatServerCreator {
  private static final Map<TomcatBaseline, TomcatPluginInfo> INFOS;

  static {
    var map = new EnumMap<TomcatBaseline, TomcatPluginInfo>(TomcatBaseline.class);
    for (var value : TomcatBaseline.values()) {
      var name = value.name();
      if (name.startsWith("TOMCAT_")) {
        var suffix = name.substring("TOMCAT_".length());
        map.put(value, TomcatPluginInfo.of(suffix));
      }
    }
    INFOS = unmodifiableMap(map);
  }

  private final TomcatServerTask task;

  public TomcatServerCreator(final TomcatServerTask task) {
    this.task = task;
  }

  public boolean isNeeded(final SetupTaskContext context) {
    return isValid(context) && (ServerCore.findRuntime(task.getRuntimeName()) == null || ServerCore.findServer(task.getServerName()) == null);
  }

  public boolean isValid(final SetupTaskContext context) {
    return isAttributeValid(context, "runtimeName", task.getRuntimeName())
        && isAttributeValid(context, "serverName", task.getServerName())
        && isAttributeValid(context, "serverVersion", task.getServerVersion())
        && isAttributeValid(context, "location", task.getLocation())
        && isAttributeValid(context, "jreVersion", task.getJreVersion());
  }

  private boolean isAttributeValid(final SetupTaskContext context, final String name, final String value) {
    return isAttributeValid0(context, name, value != null && !value.isBlank());
  }

  private boolean isAttributeValid(final SetupTaskContext context, final String name, final Object value) {
    return isAttributeValid0(context, name, value != null);
  }

  private boolean isAttributeValid0(final SetupTaskContext context, final String name, final boolean valid) {
    if (!valid) {
      context.log("Attribute %s is null or blank".formatted(name), Severity.WARNING);
    }
    return valid;
  }

  public void perform(final SetupTaskContext context) throws TomcatSetupTaskException, CoreException {
    if (isValid(context)) {
      return;
    }

    var info = INFOS.get(task.getServerVersion());
    if (info == null) {
      throw new TomcatSetupTaskException("Unsupported tomcat version: " + task.getServerVersion());
    }

    var taskName = "Setup Tomcat [%s ~ %s]".formatted(task.getRuntimeName(), task.getServerName());
    var monitor = SubMonitor.convert(context.getProgressMonitor(true), taskName, 1);

    try {
      new Installer(context, task, monitor, info).install();
    } finally {
      monitor.done();
    }
  }

  static class Installer {
    private final SetupTaskContext context;
    private final TomcatServerTask task;
    private final IProgressMonitor monitor;
    private final TomcatPluginInfo info;

    public Installer(final SetupTaskContext context, final TomcatServerTask task, final IProgressMonitor monitor, final TomcatPluginInfo info) {
      this.context = context;
      this.task = task;
      this.monitor = monitor;
      this.info = info;
    }

    private void info(final String fmt, final Object... args) {
      context.log(fmt.formatted(args), Severity.INFO);
    }

    private void warn(final String fmt, final Object... args) {
      context.log(fmt.formatted(args), Severity.WARNING);
    }

    public void install() throws TomcatSetupTaskException, CoreException {
      removeMatching(IRuntime.class.getSimpleName(), filtering(ServerCore.getRuntimes(), task.getRuntimeName(), IRuntime::getName), IRuntime::delete);
      removeMatching(IServer.class.getSimpleName(), filtering(ServerCore.getServers(), task.getServerName(), IServer::getName), IServer::delete);

      var runtime = createRuntimeIfNeeded();
      var holder = createServerIfNeeded(runtime);
      customizeLaunchConfigurations(holder.server(), task.getLaunchProgramArgs(), task.getLaunchVmArgs());
      customizeTomcatPorts(holder.workingCopy(), holder.server());

      monitor.worked(1);
    }

    private <T> Stream<T> filtering(final T[] items, final String name, final Function<T, String> eclipseExtractor) {
      var initial = Arrays.stream(items);
      if (task.isCleanPreviousRuntimes()) {
        return initial;
      }
      return initial.filter(item -> name.equals(eclipseExtractor.apply(item)));
    }

    private <T> void removeMatching(final String typeName, final Stream<T> stream, final DeleteHandler<T> handler)
        throws CoreException {
      var list = stream.toList();
      if (list.isEmpty()) {
        info("No %s to remove", typeName);
      } else {
        info("Removing %d %s", list.size(), typeName);
        for (var item : list) {
          info("  Removing %s (%s)", item, typeName);
          handler.delete(item);
        }
      }
    }

    private IRuntime createRuntimeIfNeeded() throws TomcatSetupTaskException, CoreException {
      var runtimeType = info.runtimeType();

      info("creating runtime %s - %s", task.getRuntimeName(), runtimeType);

      var vmInstallType = Optional.ofNullable(JavaRuntime.getVMInstallType(StandardVMType.ID_STANDARD_VM_TYPE));

      var javaRuntime = vmInstallType.map(vmi -> vmi.findVMInstallByName(task.getJreVersion()))
                                     .orElseThrow(() -> new TomcatSetupTaskException(
                                         "Could not find a JVM with name: " + task.getJreVersion() + listVMByName(vmInstallType)));

      var rwc = runtimeType.createRuntime(task.getRuntimeName(), monitor);
      rwc.setLocation(Path.fromOSString(task.getLocation()));
      rwc.setName(task.getRuntimeName());

      var jwc = (IJavaRuntimeWorkingCopy) rwc.loadAdapter(IJavaRuntimeWorkingCopy.class, null);
      jwc.setVMInstall(javaRuntime);

      var status = rwc.validate(monitor);
      if (!status.isOK()) {
        throw new TomcatSetupTaskException("Could not a create a server runtime " + task.getRuntimeName() + ": " + status.getMessage());
      }
      return rwc.save(false, monitor);
    }

    private String listVMByName(final Optional<IVMInstallType> vmInstallType) {
      return vmInstallType.map(vmi -> Arrays.stream(vmi.getVMInstalls())
                                            .map(IVMInstall::getName)
                                            .collect(joining(", ", "(Available JRE: ", ")")))
                          .orElse("");
    }

    private ServerWorkingCopyAndServer createServerIfNeeded(final IRuntime runtime) throws TomcatSetupTaskException, CoreException {
      var serverType = info.serverType();

      info("creating server %s - %s", task.getServerName(), serverType);

      var server = serverType.createServer(task.getServerName(), null, runtime, monitor);
      server.setHost(task.getHostname());
      server.setName(task.getServerName());

      if (server.loadAdapter(ServerWorkingCopy.class, monitor) instanceof ServerWorkingCopy s) {
        s.setAutoPublishSetting(toAutoPublishSettings(task.getAutoPublish()));
        toInt("startTimeout", task.getStartTimeout()).ifPresent(s::setStartTimeout);
        toInt("stopTimeout", task.getStopTimeout()).ifPresent(s::setStopTimeout);
      }

      return new ServerWorkingCopyAndServer(server, server.save(false, monitor));
    }

    private void customizeLaunchConfigurations(final IServer server, final String launchProgramArgs, final String launchVmArgs) throws CoreException {
      var attributes = Stream.of(LaunchAttribute.of(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, launchProgramArgs),
                                 LaunchAttribute.of(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, launchVmArgs))
                             .filter(LaunchAttribute::isNotEmpty)
                             .toList();

      if (attributes.isEmpty()) {
        return;
      }

      info("customizing launch configuration for server %s", task.getServerName());

      var launch = server.getLaunchConfiguration(true, monitor);
      var copy = launch.getWorkingCopy();
      for (var attr : attributes) {
        var actual = attr.get(launch);
        if (!actual.endsWith(attr.userValue())) {
          attr.set(copy, actual + " " + attr.userValue());
        }
      }
      if (copy.isDirty()) {
        copy.doSave();
      }
    }

    private void customizeTomcatPorts(final IServerWorkingCopy workingCopy, final IServer server) throws CoreException, TomcatSetupTaskException {
      var tomcat = (TomcatServer) server.loadAdapter(TomcatServer.class, monitor);
      if (tomcat == null) {
        warn("Could not adapt %s into a %s, won't configure Tomcat HTTP(s) port(s)", server, TomcatServer.class);
        return;
      }

      info("customizing Tomcat ports for server %s", task.getServerName());

      var config = tomcat.getTomcatConfiguration();
      for (var port : workingCopy.getServerPorts(monitor)) {
        if (port.getId().indexOf('/') == -1) {
          getNewValueForPort(port).ifPresent(value -> config.modifyServerPort(port.getId(), value));
        }
      }
      tomcat.saveConfiguration(monitor);
    }

    private OptionalInt getNewValueForPort(final ServerPort port) throws TomcatSetupTaskException {
      if ("http".equalsIgnoreCase(port.getProtocol())) {
        return toInt("httpPort", task.getHttpPort());
      }
      if ("ssl".equalsIgnoreCase(port.getProtocol())) {
        return toInt("httpsPort", task.getHttpsPort());
      }
      return OptionalInt.empty();
    }

    private static int toAutoPublishSettings(final AutoPublish autoPublish) {
      return switch (autoPublish) {
        case null -> org.eclipse.wst.server.core.internal.Server.AUTO_PUBLISH_RESOURCE;
        case BUILD -> org.eclipse.wst.server.core.internal.Server.AUTO_PUBLISH_BUILD;
        case RESOURCE -> org.eclipse.wst.server.core.internal.Server.AUTO_PUBLISH_RESOURCE;
        case DISABLE -> org.eclipse.wst.server.core.internal.Server.AUTO_PUBLISH_DISABLE;
      };
    }

    private OptionalInt toInt(final String what, final String value) throws TomcatSetupTaskException {
      if (value == null || value.isBlank()) {
        return OptionalInt.empty();
      }
      var v = value.strip();
      try {
        return OptionalInt.of(Integer.parseInt(v));
      } catch (NumberFormatException e) {
        throw new TomcatSetupTaskException("Could not convert " + what + " (" + v + ") to int: " + e.getMessage());
      }
    }
  }

  record LaunchAttribute(String key, String userValue) {

    public static LaunchAttribute of(final String key, final String userValue) {
      return new LaunchAttribute(key, userValue == null ? "" : userValue.strip());
    }

    public void set(final ILaunchConfigurationWorkingCopy copy, final String value) {
      copy.setAttribute(key, value);
    }

    public String get(final ILaunchConfiguration launch) throws CoreException {
      return launch.getAttribute(key, "");
    }

    boolean isNotEmpty() {
      return !userValue.isEmpty();
    }
  }

  @FunctionalInterface
  interface DeleteHandler<T> {
    void delete(T instance) throws CoreException;
  }

  record ServerWorkingCopyAndServer(IServerWorkingCopy workingCopy, IServer server) {}

  record TomcatPluginInfo(String runtimeId, String serverId) {

    public static TomcatPluginInfo of(final String suffix) {
      return new TomcatPluginInfo("org.eclipse.jst.server.tomcat.runtime." + suffix, "org.eclipse.jst.server.tomcat." + suffix);
    }

    public IRuntimeType runtimeType() throws TomcatSetupTaskException {
      return findById(IRuntimeType.class, runtimeId(), ServerCore::findRuntimeType);
    }

    public IServerType serverType() throws TomcatSetupTaskException {
      return findById(IServerType.class, serverId(), ServerCore::findServerType);
    }

    private static <T> T findById(final Class<T> type, final String id, final Function<String, T> fctor) throws TomcatSetupTaskException {
      var value = fctor.apply(id);
      if (value == null) {
        throw new TomcatSetupTaskException("Could not find " + type.getSimpleName() + " with " + id);
      }
      return value;
    }

  }

}
