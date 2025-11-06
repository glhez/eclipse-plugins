/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.oomph.setup.SetupTaskContext;
import org.eclipse.oomph.setup.impl.SetupTaskImpl;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.internal.TomcatServerCreator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getServerName <em>Server
 * Name</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getServerVersion <em>Server
 * Version</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getLocation <em>Location</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getRuntimeName <em>Runtime
 * Name</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getHostname <em>Hostname</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getJreVersion <em>Jre
 * Version</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getHttpPort <em>Http Port</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getHttpsPort <em>Https Port</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getLaunchProgramArgs <em>Launch
 * Program Args</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getLaunchVmArgs <em>Launch Vm
 * Args</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#isCleanPreviousRuntimes <em>Clean
 * Previous Runtimes</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getStartTimeout <em>Start
 * Timeout</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getStopTimeout <em>Stop
 * Timeout</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl#getAutoPublish <em>Auto
 * Publish</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TomcatServerTaskImpl extends SetupTaskImpl implements TomcatServerTask {
  /**
   * The default value of the '{@link #getServerName() <em>Server Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getServerName()
   * @generated
   * @ordered
   */
  protected static final String SERVER_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getServerName() <em>Server Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getServerName()
   * @generated
   * @ordered
   */
  protected String serverName = SERVER_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getServerVersion() <em>Server Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getServerVersion()
   * @generated
   * @ordered
   */
  protected static final TomcatBaseline SERVER_VERSION_EDEFAULT = TomcatBaseline.TOMCAT_90;

  /**
   * The cached value of the '{@link #getServerVersion() <em>Server Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getServerVersion()
   * @generated
   * @ordered
   */
  protected TomcatBaseline serverVersion = SERVER_VERSION_EDEFAULT;

  /**
   * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected static final String LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLocation()
   * @generated
   * @ordered
   */
  protected String location = LOCATION_EDEFAULT;

  /**
   * The default value of the '{@link #getRuntimeName() <em>Runtime Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getRuntimeName()
   * @generated
   * @ordered
   */
  protected static final String RUNTIME_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRuntimeName() <em>Runtime Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getRuntimeName()
   * @generated
   * @ordered
   */
  protected String runtimeName = RUNTIME_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getHostname()
   * @generated
   * @ordered
   */
  protected static final String HOSTNAME_EDEFAULT = "localhost";

  /**
   * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getHostname()
   * @generated
   * @ordered
   */
  protected String hostname = HOSTNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getJreVersion() <em>Jre Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getJreVersion()
   * @generated
   * @ordered
   */
  protected static final String JRE_VERSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getJreVersion() <em>Jre Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getJreVersion()
   * @generated
   * @ordered
   */
  protected String jreVersion = JRE_VERSION_EDEFAULT;

  /**
   * The default value of the '{@link #getHttpPort() <em>Http Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getHttpPort()
   * @generated
   * @ordered
   */
  protected static final String HTTP_PORT_EDEFAULT = "8080";

  /**
   * The cached value of the '{@link #getHttpPort() <em>Http Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getHttpPort()
   * @generated
   * @ordered
   */
  protected String httpPort = HTTP_PORT_EDEFAULT;

  /**
   * The default value of the '{@link #getHttpsPort() <em>Https Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getHttpsPort()
   * @generated
   * @ordered
   */
  protected static final String HTTPS_PORT_EDEFAULT = "8443";

  /**
   * The cached value of the '{@link #getHttpsPort() <em>Https Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getHttpsPort()
   * @generated
   * @ordered
   */
  protected String httpsPort = HTTPS_PORT_EDEFAULT;

  /**
   * The default value of the '{@link #getLaunchProgramArgs() <em>Launch Program Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLaunchProgramArgs()
   * @generated
   * @ordered
   */
  protected static final String LAUNCH_PROGRAM_ARGS_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getLaunchProgramArgs() <em>Launch Program Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLaunchProgramArgs()
   * @generated
   * @ordered
   */
  protected String launchProgramArgs = LAUNCH_PROGRAM_ARGS_EDEFAULT;

  /**
   * The default value of the '{@link #getLaunchVmArgs() <em>Launch Vm Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLaunchVmArgs()
   * @generated
   * @ordered
   */
  protected static final String LAUNCH_VM_ARGS_EDEFAULT = "";

  /**
   * The cached value of the '{@link #getLaunchVmArgs() <em>Launch Vm Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getLaunchVmArgs()
   * @generated
   * @ordered
   */
  protected String launchVmArgs = LAUNCH_VM_ARGS_EDEFAULT;

  /**
   * The default value of the '{@link #isCleanPreviousRuntimes() <em>Clean Previous Runtimes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCleanPreviousRuntimes()
   * @generated
   * @ordered
   */
  protected static final boolean CLEAN_PREVIOUS_RUNTIMES_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCleanPreviousRuntimes() <em>Clean Previous Runtimes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isCleanPreviousRuntimes()
   * @generated
   * @ordered
   */
  protected boolean cleanPreviousRuntimes = CLEAN_PREVIOUS_RUNTIMES_EDEFAULT;

  /**
   * The default value of the '{@link #getStartTimeout() <em>Start Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getStartTimeout()
   * @generated
   * @ordered
   */
  protected static final String START_TIMEOUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartTimeout() <em>Start Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getStartTimeout()
   * @generated
   * @ordered
   */
  protected String startTimeout = START_TIMEOUT_EDEFAULT;

  /**
   * The default value of the '{@link #getStopTimeout() <em>Stop Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getStopTimeout()
   * @generated
   * @ordered
   */
  protected static final String STOP_TIMEOUT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStopTimeout() <em>Stop Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getStopTimeout()
   * @generated
   * @ordered
   */
  protected String stopTimeout = STOP_TIMEOUT_EDEFAULT;

  /**
   * The default value of the '{@link #getAutoPublish() <em>Auto Publish</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAutoPublish()
   * @generated
   * @ordered
   */
  protected static final AutoPublish AUTO_PUBLISH_EDEFAULT = AutoPublish.DISABLE;

  /**
   * The cached value of the '{@link #getAutoPublish() <em>Auto Publish</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getAutoPublish()
   * @generated
   * @ordered
   */
  protected AutoPublish autoPublish = AUTO_PUBLISH_EDEFAULT;

  private final TomcatServerCreator creator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated NOT
   */
  protected TomcatServerTaskImpl() {
    this.creator = new TomcatServerCreator(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TomcatServerPackage.Literals.TOMCAT_SERVER_TASK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getServerName() {
    return serverName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setServerName(final String newServerName) {
    var oldServerName = serverName;
    serverName = newServerName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_NAME, oldServerName, serverName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TomcatBaseline getServerVersion() {
    return serverVersion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setServerVersion(final TomcatBaseline newServerVersion) {
    var oldServerVersion = serverVersion;
    serverVersion = newServerVersion == null ? SERVER_VERSION_EDEFAULT : newServerVersion;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_VERSION, oldServerVersion, serverVersion));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLocation() {
    return location;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setLocation(final String newLocation) {
    var oldLocation = location;
    location = newLocation;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__LOCATION, oldLocation, location));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getRuntimeName() {
    return runtimeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setRuntimeName(final String newRuntimeName) {
    var oldRuntimeName = runtimeName;
    runtimeName = newRuntimeName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__RUNTIME_NAME, oldRuntimeName, runtimeName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getHostname() {
    return hostname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setHostname(final String newHostname) {
    var oldHostname = hostname;
    hostname = newHostname;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__HOSTNAME, oldHostname, hostname));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getJreVersion() {
    return jreVersion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setJreVersion(final String newJreVersion) {
    var oldJreVersion = jreVersion;
    jreVersion = newJreVersion;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__JRE_VERSION, oldJreVersion, jreVersion));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getHttpPort() {
    return httpPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setHttpPort(final String newHttpPort) {
    var oldHttpPort = httpPort;
    httpPort = newHttpPort;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__HTTP_PORT, oldHttpPort, httpPort));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getHttpsPort() {
    return httpsPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setHttpsPort(final String newHttpsPort) {
    var oldHttpsPort = httpsPort;
    httpsPort = newHttpsPort;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__HTTPS_PORT, oldHttpsPort, httpsPort));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLaunchProgramArgs() {
    return launchProgramArgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setLaunchProgramArgs(final String newLaunchProgramArgs) {
    var oldLaunchProgramArgs = launchProgramArgs;
    launchProgramArgs = newLaunchProgramArgs;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS, oldLaunchProgramArgs,
          launchProgramArgs));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLaunchVmArgs() {
    return launchVmArgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setLaunchVmArgs(final String newLaunchVmArgs) {
    var oldLaunchVmArgs = launchVmArgs;
    launchVmArgs = newLaunchVmArgs;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS, oldLaunchVmArgs, launchVmArgs));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isCleanPreviousRuntimes() {
    return cleanPreviousRuntimes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setCleanPreviousRuntimes(final boolean newCleanPreviousRuntimes) {
    var oldCleanPreviousRuntimes = cleanPreviousRuntimes;
    cleanPreviousRuntimes = newCleanPreviousRuntimes;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES, oldCleanPreviousRuntimes,
          cleanPreviousRuntimes));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getStartTimeout() {
    return startTimeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setStartTimeout(final String newStartTimeout) {
    var oldStartTimeout = startTimeout;
    startTimeout = newStartTimeout;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__START_TIMEOUT, oldStartTimeout, startTimeout));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getStopTimeout() {
    return stopTimeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setStopTimeout(final String newStopTimeout) {
    var oldStopTimeout = stopTimeout;
    stopTimeout = newStopTimeout;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__STOP_TIMEOUT, oldStopTimeout, stopTimeout));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public AutoPublish getAutoPublish() {
    return autoPublish;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setAutoPublish(final AutoPublish newAutoPublish) {
    var oldAutoPublish = autoPublish;
    autoPublish = newAutoPublish == null ? AUTO_PUBLISH_EDEFAULT : newAutoPublish;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.TOMCAT_SERVER_TASK__AUTO_PUBLISH, oldAutoPublish, autoPublish));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_NAME:
        return getServerName();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_VERSION:
        return getServerVersion();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LOCATION:
        return getLocation();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__RUNTIME_NAME:
        return getRuntimeName();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HOSTNAME:
        return getHostname();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__JRE_VERSION:
        return getJreVersion();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTP_PORT:
        return getHttpPort();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTPS_PORT:
        return getHttpsPort();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS:
        return getLaunchProgramArgs();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS:
        return getLaunchVmArgs();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES:
        return isCleanPreviousRuntimes();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__START_TIMEOUT:
        return getStartTimeout();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__STOP_TIMEOUT:
        return getStopTimeout();
      case TomcatServerPackage.TOMCAT_SERVER_TASK__AUTO_PUBLISH:
        return getAutoPublish();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_NAME:
        setServerName((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_VERSION:
        setServerVersion((TomcatBaseline) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LOCATION:
        setLocation((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__RUNTIME_NAME:
        setRuntimeName((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HOSTNAME:
        setHostname((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__JRE_VERSION:
        setJreVersion((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTP_PORT:
        setHttpPort((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTPS_PORT:
        setHttpsPort((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS:
        setLaunchProgramArgs((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS:
        setLaunchVmArgs((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES:
        setCleanPreviousRuntimes((Boolean) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__START_TIMEOUT:
        setStartTimeout((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__STOP_TIMEOUT:
        setStopTimeout((String) newValue);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__AUTO_PUBLISH:
        setAutoPublish((AutoPublish) newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(final int featureID) {
    switch (featureID) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_NAME:
        setServerName(SERVER_NAME_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_VERSION:
        setServerVersion(SERVER_VERSION_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LOCATION:
        setLocation(LOCATION_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__RUNTIME_NAME:
        setRuntimeName(RUNTIME_NAME_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HOSTNAME:
        setHostname(HOSTNAME_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__JRE_VERSION:
        setJreVersion(JRE_VERSION_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTP_PORT:
        setHttpPort(HTTP_PORT_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTPS_PORT:
        setHttpsPort(HTTPS_PORT_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS:
        setLaunchProgramArgs(LAUNCH_PROGRAM_ARGS_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS:
        setLaunchVmArgs(LAUNCH_VM_ARGS_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES:
        setCleanPreviousRuntimes(CLEAN_PREVIOUS_RUNTIMES_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__START_TIMEOUT:
        setStartTimeout(START_TIMEOUT_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__STOP_TIMEOUT:
        setStopTimeout(STOP_TIMEOUT_EDEFAULT);
        return;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__AUTO_PUBLISH:
        setAutoPublish(AUTO_PUBLISH_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_NAME:
        return SERVER_NAME_EDEFAULT == null ? serverName != null : !SERVER_NAME_EDEFAULT.equals(serverName);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_VERSION:
        return serverVersion != SERVER_VERSION_EDEFAULT;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LOCATION:
        return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__RUNTIME_NAME:
        return RUNTIME_NAME_EDEFAULT == null ? runtimeName != null : !RUNTIME_NAME_EDEFAULT.equals(runtimeName);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HOSTNAME:
        return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__JRE_VERSION:
        return JRE_VERSION_EDEFAULT == null ? jreVersion != null : !JRE_VERSION_EDEFAULT.equals(jreVersion);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTP_PORT:
        return HTTP_PORT_EDEFAULT == null ? httpPort != null : !HTTP_PORT_EDEFAULT.equals(httpPort);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTPS_PORT:
        return HTTPS_PORT_EDEFAULT == null ? httpsPort != null : !HTTPS_PORT_EDEFAULT.equals(httpsPort);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS:
        return LAUNCH_PROGRAM_ARGS_EDEFAULT == null ? launchProgramArgs != null : !LAUNCH_PROGRAM_ARGS_EDEFAULT.equals(launchProgramArgs);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS:
        return LAUNCH_VM_ARGS_EDEFAULT == null ? launchVmArgs != null : !LAUNCH_VM_ARGS_EDEFAULT.equals(launchVmArgs);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES:
        return cleanPreviousRuntimes != CLEAN_PREVIOUS_RUNTIMES_EDEFAULT;
      case TomcatServerPackage.TOMCAT_SERVER_TASK__START_TIMEOUT:
        return START_TIMEOUT_EDEFAULT == null ? startTimeout != null : !START_TIMEOUT_EDEFAULT.equals(startTimeout);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__STOP_TIMEOUT:
        return STOP_TIMEOUT_EDEFAULT == null ? stopTimeout != null : !STOP_TIMEOUT_EDEFAULT.equals(stopTimeout);
      case TomcatServerPackage.TOMCAT_SERVER_TASK__AUTO_PUBLISH:
        return autoPublish != AUTO_PUBLISH_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) {
      return super.toString();
    }

    var result = new StringBuilder(super.toString());
    result.append(" (serverName: ");
    result.append(serverName);
    result.append(", serverVersion: ");
    result.append(serverVersion);
    result.append(", location: ");
    result.append(location);
    result.append(", runtimeName: ");
    result.append(runtimeName);
    result.append(", hostname: ");
    result.append(hostname);
    result.append(", jreVersion: ");
    result.append(jreVersion);
    result.append(", httpPort: ");
    result.append(httpPort);
    result.append(", httpsPort: ");
    result.append(httpsPort);
    result.append(", launchProgramArgs: ");
    result.append(launchProgramArgs);
    result.append(", launchVmArgs: ");
    result.append(launchVmArgs);
    result.append(", cleanPreviousRuntimes: ");
    result.append(cleanPreviousRuntimes);
    result.append(", startTimeout: ");
    result.append(startTimeout);
    result.append(", stopTimeout: ");
    result.append(stopTimeout);
    result.append(", autoPublish: ");
    result.append(autoPublish);
    result.append(')');
    return result.toString();
  }

  @Override
  public boolean isNeeded(final SetupTaskContext context) throws Exception {
    return creator.isNeeded(context);
  }

  @Override
  public void perform(final SetupTaskContext context) throws Exception {
    creator.perform(context);
  }

} // TomcatServerTaskImpl
