/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat;

import org.eclipse.oomph.setup.SetupTask;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerName <em>Server Name</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerVersion <em>Server Version</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLocation <em>Location</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getRuntimeName <em>Runtime Name</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHostname <em>Hostname</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getJreVersion <em>Jre Version</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpPort <em>Http Port</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpsPort <em>Https Port</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchProgramArgs <em>Launch Program
 * Args</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchVmArgs <em>Launch Vm Args</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#isCleanPreviousRuntimes <em>Clean Previous
 * Runtimes</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStartTimeout <em>Start Timeout</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStopTimeout <em>Stop Timeout</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getAutoPublish <em>Auto Publish</em>}</li>
 * </ul>
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask()
 * @model annotation="http://www.eclipse.org/oomph/setup/Enablement variableName='p2.tomcat'
 *        repository='https://glhez.github.io/eclipse-plugins'
 *        installableUnits='com.github.glhez.eclipse.features.oomph.feature.group'"
 *        annotation="http://www.eclipse.org/oomph/setup/ValidTriggers triggers='STARTUP MANUAL'"
 * @generated
 */
public interface TomcatServerTask extends SetupTask {
  /**
   * Returns the value of the '<em><b>Server Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Server Name</em>' attribute.
   * @see #setServerName(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_ServerName()
   * @model required="true"
   * @generated
   */
  String getServerName();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerName <em>Server
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Server Name</em>' attribute.
   * @see #getServerName()
   * @generated
   */
  void setServerName(String value);

  /**
   * Returns the value of the '<em><b>Server Version</b></em>' attribute.
   * The literals are from the enumeration {@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Server Version</em>' attribute.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline
   * @see #setServerVersion(TomcatBaseline)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_ServerVersion()
   * @model required="true"
   * @generated
   */
  TomcatBaseline getServerVersion();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerVersion <em>Server
   * Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Server Version</em>' attribute.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline
   * @see #getServerVersion()
   * @generated
   */
  void setServerVersion(TomcatBaseline value);

  /**
   * Returns the value of the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Location</em>' attribute.
   * @see #setLocation(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_Location()
   * @model required="true"
   * @generated
   */
  String getLocation();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLocation
   * <em>Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Location</em>' attribute.
   * @see #getLocation()
   * @generated
   */
  void setLocation(String value);

  /**
   * Returns the value of the '<em><b>Runtime Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Runtime Name</em>' attribute.
   * @see #setRuntimeName(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_RuntimeName()
   * @model required="true"
   * @generated
   */
  String getRuntimeName();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getRuntimeName <em>Runtime
   * Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Runtime Name</em>' attribute.
   * @see #getRuntimeName()
   * @generated
   */
  void setRuntimeName(String value);

  /**
   * Returns the value of the '<em><b>Hostname</b></em>' attribute.
   * The default value is <code>"localhost"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Hostname</em>' attribute.
   * @see #setHostname(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_Hostname()
   * @model default="localhost" required="true"
   * @generated
   */
  String getHostname();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHostname
   * <em>Hostname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Hostname</em>' attribute.
   * @see #getHostname()
   * @generated
   */
  void setHostname(String value);

  /**
   * Returns the value of the '<em><b>Jre Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Jre Version</em>' attribute.
   * @see #setJreVersion(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_JreVersion()
   * @model required="true"
   * @generated
   */
  String getJreVersion();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getJreVersion <em>Jre
   * Version</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Jre Version</em>' attribute.
   * @see #getJreVersion()
   * @generated
   */
  void setJreVersion(String value);

  /**
   * Returns the value of the '<em><b>Http Port</b></em>' attribute.
   * The default value is <code>"8080"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Http Port</em>' attribute.
   * @see #setHttpPort(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_HttpPort()
   * @model default="8080" required="true"
   * @generated
   */
  String getHttpPort();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpPort <em>Http
   * Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Http Port</em>' attribute.
   * @see #getHttpPort()
   * @generated
   */
  void setHttpPort(String value);

  /**
   * Returns the value of the '<em><b>Https Port</b></em>' attribute.
   * The default value is <code>"8443"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Https Port</em>' attribute.
   * @see #setHttpsPort(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_HttpsPort()
   * @model default="8443" required="true"
   * @generated
   */
  String getHttpsPort();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpsPort <em>Https
   * Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Https Port</em>' attribute.
   * @see #getHttpsPort()
   * @generated
   */
  void setHttpsPort(String value);

  /**
   * Returns the value of the '<em><b>Launch Program Args</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Launch Program Args</em>' attribute.
   * @see #setLaunchProgramArgs(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_LaunchProgramArgs()
   * @model default=""
   * @generated
   */
  String getLaunchProgramArgs();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchProgramArgs
   * <em>Launch Program Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Launch Program Args</em>' attribute.
   * @see #getLaunchProgramArgs()
   * @generated
   */
  void setLaunchProgramArgs(String value);

  /**
   * Returns the value of the '<em><b>Launch Vm Args</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Launch Vm Args</em>' attribute.
   * @see #setLaunchVmArgs(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_LaunchVmArgs()
   * @model default=""
   * @generated
   */
  String getLaunchVmArgs();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchVmArgs <em>Launch
   * Vm Args</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Launch Vm Args</em>' attribute.
   * @see #getLaunchVmArgs()
   * @generated
   */
  void setLaunchVmArgs(String value);

  /**
   * Returns the value of the '<em><b>Clean Previous Runtimes</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Clean Previous Runtimes</em>' attribute.
   * @see #setCleanPreviousRuntimes(boolean)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_CleanPreviousRuntimes()
   * @model default="false"
   * @generated
   */
  boolean isCleanPreviousRuntimes();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#isCleanPreviousRuntimes
   * <em>Clean Previous Runtimes</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Clean Previous Runtimes</em>' attribute.
   * @see #isCleanPreviousRuntimes()
   * @generated
   */
  void setCleanPreviousRuntimes(boolean value);

  /**
   * Returns the value of the '<em><b>Start Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Start Timeout</em>' attribute.
   * @see #setStartTimeout(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_StartTimeout()
   * @model
   * @generated
   */
  String getStartTimeout();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStartTimeout <em>Start
   * Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Start Timeout</em>' attribute.
   * @see #getStartTimeout()
   * @generated
   */
  void setStartTimeout(String value);

  /**
   * Returns the value of the '<em><b>Stop Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Stop Timeout</em>' attribute.
   * @see #setStopTimeout(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_StopTimeout()
   * @model
   * @generated
   */
  String getStopTimeout();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStopTimeout <em>Stop
   * Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Stop Timeout</em>' attribute.
   * @see #getStopTimeout()
   * @generated
   */
  void setStopTimeout(String value);

  /**
   * Returns the value of the '<em><b>Auto Publish</b></em>' attribute.
   * The literals are from the enumeration {@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Auto Publish</em>' attribute.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish
   * @see #setAutoPublish(AutoPublish)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatServerTask_AutoPublish()
   * @model
   * @generated
   */
  AutoPublish getAutoPublish();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getAutoPublish <em>Auto
   * Publish</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Auto Publish</em>' attribute.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish
   * @see #getAutoPublish()
   * @generated
   */
  void setAutoPublish(AutoPublish value);

} // TomcatServerTask
