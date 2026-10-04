package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.internal;

import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.internal.launching.StandardVMType;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
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
import org.eclipse.wst.server.core.model.ServerBehaviourDelegate;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;

public class TomcatServerCreator {
  private static final String CATALINA_HOME_PREFIX = "${catalina.home}/";
  private static final String CATALINA_BASE_PREFIX = "${catalina.base}/";

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
        && isAttributeValid(context, "jreVersion", task.getJreVersion())
        && isClasspathEntriesValid(context, task.getAdditionalClassPathEntry());
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

  private boolean isClasspathEntriesValid(final SetupTaskContext context, final List<ClasspathEntry> bootstrapEntries) {
    if (bootstrapEntries == null || bootstrapEntries.isEmpty()) {
      return true;
    }

    var i = 0;
    for (var bootstrapEntry : bootstrapEntries) {
      var entry = bootstrapEntry.getEntry();
      if (entry == null || entry.isBlank()) {
        context.log("Attribute bootstrapEntry[%d] is null or blank".formatted(i), Severity.WARNING);
        return false;
      }
      ++i;
    }
    return true;
  }

  public void perform(final SetupTaskContext context) throws TomcatSetupTaskException, CoreException {
    if (!isValid(context)) {
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

    private void error(final String fmt, final Object... args) {
      context.log(fmt.formatted(args), Severity.ERROR);
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

      var javaRuntime = findJre();

      var rwc = runtimeType.createRuntime(task.getRuntimeName(), monitor);
      rwc.setLocation(IPath.fromOSString(task.getLocation()));
      rwc.setName(task.getRuntimeName());

      var jwc = (IJavaRuntimeWorkingCopy) rwc.loadAdapter(IJavaRuntimeWorkingCopy.class, null);
      jwc.setVMInstall(javaRuntime);

      var status = rwc.validate(monitor);
      if (!status.isOK()) {
        throw new TomcatSetupTaskException("Could not a create a server runtime " + task.getRuntimeName() + ": " + status.getMessage());
      }
      return rwc.save(false, monitor);
    }

    private IVMInstall findJre() throws TomcatSetupTaskException {
      var vmInstallType = JavaRuntime.getVMInstallType(StandardVMType.ID_STANDARD_VM_TYPE);
      if (vmInstallType == null) {
        throw new TomcatSetupTaskException("Could not find a VMInstallType for " + StandardVMType.ID_STANDARD_VM_TYPE);
      }

      var javaRuntime = vmInstallType.findVMInstallByName(task.getJreVersion());
      if (javaRuntime != null) {
        info("Using JRE named %s installed in %s", javaRuntime.getName(), javaRuntime.getInstallLocation());
        return javaRuntime;
      }

      // try to use this instead
      var executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
      var executionEnvironment = executionEnvironmentsManager.getEnvironment(task.getJreVersion());
      if (executionEnvironment != null) {
        javaRuntime = executionEnvironment.getDefaultVM();
        if (javaRuntime != null) {
          info("Using Execution Environment %s default JRE named %s installed in %s", executionEnvironment.getId(), javaRuntime.getName(),
               javaRuntime.getInstallLocation());
          return javaRuntime;
        }
      }

      error("Could not find a JVM with name: %s in %s", task.getJreVersion(), vmInstallType.getName());
      error("Available JREs: %s", Arrays.stream(vmInstallType.getVMInstalls())
                                        .map(IVMInstall::getName)
                                        .collect(joining(", ", "[", "]")));
      error("Available Execution Environments: %s",
            Arrays.stream(executionEnvironmentsManager.getExecutionEnvironments())
                  .filter(ee -> ee.getDefaultVM() != null)
                  .map(ee -> ee.getId() + " (default vm: " + ee.getDefaultVM().getName() + ")")
                  .collect(joining(", ", "[", "]")));
      throw new TomcatSetupTaskException("Could not find a JVM with name: " + task.getJreVersion());
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

    private void customizeLaunchConfigurations(final IServer server, final String launchProgramArgs, final String launchVmArgs)
        throws CoreException, TomcatSetupTaskException {
      var attributes = Stream.of(LaunchAttribute.of(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, launchProgramArgs),
                                 LaunchAttribute.of(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS, launchVmArgs))
                             .filter(LaunchAttribute::isNotEmpty)
                             .toList();

      info("customizing launch configuration for server %s", task.getServerName());

      var launch = server.getLaunchConfiguration(true, monitor);
      var copy = launch.getWorkingCopy();
      for (var attr : attributes) {
        var actual = attr.get(launch);
        if (!actual.endsWith(attr.userValue())) {
          attr.set(copy, actual + " " + attr.userValue());
        }
      }
      customizeLaunchClassPath(server, copy);

      if (copy.isDirty()) {
        copy.doSave();
      }
    }

    private void customizeLaunchClassPath(final IServer server, final ILaunchConfigurationWorkingCopy copy)
        throws TomcatSetupTaskException, CoreException {
      var userBootstrapEntries = new UserBootstrapEntryConfigurer(server).collect(task.getAdditionalClassPathEntry());
      if (userBootstrapEntries.isEmpty()) {
        return;
      }

      if (server.loadAdapter(ServerBehaviourDelegate.class, monitor) instanceof ServerBehaviourDelegate behaviour) {
        /*
         * this is required because the tomcat-juli/bootstrap.jar are not yet registered.
         *
         * see org.eclipse.jst.server.tomcat.core.internal.Tomcat110Handler.getRuntimeClasspath(IPath, IPath)
         */
        behaviour.setupLaunchConfiguration(copy, monitor);
      } else {
        warn("could not 'adapt' %s to %s ", server, ServerBehaviourDelegate.class);
      }

      var existingEntries = new ArrayList<>(copy.getAttribute(IJavaLaunchConfigurationConstants.ATTR_CLASSPATH, List.of()));

      for (var userBootstrapEntry : userBootstrapEntries) {
        var memento = JavaRuntime.newArchiveRuntimeClasspathEntry(userBootstrapEntry).getMemento();
        if (!existingEntries.contains(memento)) {
          info("adding %s to the classpath", userBootstrapEntries);
          existingEntries.add(memento);
        }
      }

      copy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_CLASSPATH, existingEntries);
      copy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_DEFAULT_CLASSPATH, false);
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

  static class UserBootstrapEntryConfigurer {
    private static final List<String> ALLOWED_PREFIX = List.of(CATALINA_HOME_PREFIX, CATALINA_BASE_PREFIX);
    private final IPath catalinaHome; // and base
    private final List<IPath> entries;

    public UserBootstrapEntryConfigurer(final IServer server) {
      this.catalinaHome = server.getRuntime().getLocation();
      this.entries = new ArrayList<>();
    }

    public List<IPath> collect(final List<ClasspathEntry> entries) throws TomcatSetupTaskException {
      if (entries != null && !entries.isEmpty()) {
        for (var entry : entries) {
          collect(entry);
        }
      }
      return this.entries;
    }

    private void collect(final ClasspathEntry entry) throws TomcatSetupTaskException {
      var root = resolveRoot(entry.getEntry().strip());
      var pattern = Objects.toString(entry.getPattern(), "*.jar");
      var sort = entry.isSort();

      if (Files.isRegularFile(root)) {
        entries.add(IPath.fromPath(root));
      } else if (Files.isDirectory(root)) {
        var matcher = root.getFileSystem().getPathMatcher("glob:" + pattern);
        try (var ss = Files.find(root, Integer.MAX_VALUE, (p, attrs) -> matcher.matches(p) && attrs.isRegularFile()).map(IPath::fromPath)) {
          if (sort) {
            entries.addAll(ss.collect(toCollection(TreeSet::new)));
          } else {
            entries.addAll(ss.toList());
          }
        } catch (IOException e) {
          throw new TomcatSetupTaskException("Could not add Tomcat bootstrap entry <" + entry.getEntry() + "> (resolved to " + root + ")", e);
        }
      } else {
        throw new TomcatSetupTaskException("Invalid Tomcat bootstrap entry <" + entry.getEntry() + "> (resolved to " + root + "): does it exists?");
      }
    }

    private java.nio.file.Path resolveRoot(final String root) {
      for (var prefix : ALLOWED_PREFIX) {
        if (root.startsWith(prefix)) {
          // catalina.base will always some junk path in workspace, so don't bother getting it.
          return catalinaHome.append(root.substring(prefix.length())).toPath();
        }
      }
      return java.nio.file.Path.of(root);
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
