/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.oomph.setup.SetupPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore
 *        schemaLocation='https://raw.githubusercontent.com/glhez/eclipse-plugins/master/com.github.glhez.eclipse.plugins.oomph.tomcat/model/Tomcat-1.0.ecore'"
 * @generated
 */
public interface TomcatServerPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNAME = "tomcat";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_URI = "urn:eclipse:oomph:tomcat";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  String eNS_PREFIX = "tomcat";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  TomcatServerPackage eINSTANCE = com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl.init();

  /**
   * The meta object id for the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl
   * <em>Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl#getTomcatServerTask()
   * @generated
   */
  int TOMCAT_SERVER_TASK = 0;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__ANNOTATIONS = SetupPackage.SETUP_TASK__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__ID = SetupPackage.SETUP_TASK__ID;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__DESCRIPTION = SetupPackage.SETUP_TASK__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Scope Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__SCOPE_TYPE = SetupPackage.SETUP_TASK__SCOPE_TYPE;

  /**
   * The feature id for the '<em><b>Excluded Triggers</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__EXCLUDED_TRIGGERS = SetupPackage.SETUP_TASK__EXCLUDED_TRIGGERS;

  /**
   * The feature id for the '<em><b>Disabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__DISABLED = SetupPackage.SETUP_TASK__DISABLED;

  /**
   * The feature id for the '<em><b>Predecessors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__PREDECESSORS = SetupPackage.SETUP_TASK__PREDECESSORS;

  /**
   * The feature id for the '<em><b>Successors</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__SUCCESSORS = SetupPackage.SETUP_TASK__SUCCESSORS;

  /**
   * The feature id for the '<em><b>Restrictions</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__RESTRICTIONS = SetupPackage.SETUP_TASK__RESTRICTIONS;

  /**
   * The feature id for the '<em><b>Filter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__FILTER = SetupPackage.SETUP_TASK__FILTER;

  /**
   * The feature id for the '<em><b>Server Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__SERVER_NAME = SetupPackage.SETUP_TASK_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Server Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__SERVER_VERSION = SetupPackage.SETUP_TASK_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__LOCATION = SetupPackage.SETUP_TASK_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Runtime Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__RUNTIME_NAME = SetupPackage.SETUP_TASK_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Hostname</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__HOSTNAME = SetupPackage.SETUP_TASK_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Jre Version</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__JRE_VERSION = SetupPackage.SETUP_TASK_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Http Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__HTTP_PORT = SetupPackage.SETUP_TASK_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Https Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__HTTPS_PORT = SetupPackage.SETUP_TASK_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Launch Program Args</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS = SetupPackage.SETUP_TASK_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Launch Vm Args</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS = SetupPackage.SETUP_TASK_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Clean Previous Runtimes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES = SetupPackage.SETUP_TASK_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Start Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__START_TIMEOUT = SetupPackage.SETUP_TASK_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Stop Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__STOP_TIMEOUT = SetupPackage.SETUP_TASK_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Auto Publish</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK__AUTO_PUBLISH = SetupPackage.SETUP_TASK_FEATURE_COUNT + 13;

  /**
   * The number of structural features of the '<em>Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  int TOMCAT_SERVER_TASK_FEATURE_COUNT = SetupPackage.SETUP_TASK_FEATURE_COUNT + 14;

  /**
   * The meta object id for the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline <em>Tomcat
   * Baseline</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl#getTomcatBaseline()
   * @generated
   */
  int TOMCAT_BASELINE = 1;

  /**
   * The meta object id for the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish <em>Auto Publish</em>}'
   * enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl#getAutoPublish()
   * @generated
   */
  int AUTO_PUBLISH = 2;

  /**
   * Returns the meta object for class '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Task</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask
   * @generated
   */
  EClass getTomcatServerTask();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerName <em>Server Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Server Name</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerName()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_ServerName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerVersion <em>Server Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Server Version</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getServerVersion()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_ServerVersion();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLocation()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_Location();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getRuntimeName <em>Runtime Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Runtime Name</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getRuntimeName()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_RuntimeName();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHostname <em>Hostname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Hostname</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHostname()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_Hostname();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getJreVersion <em>Jre Version</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Jre Version</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getJreVersion()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_JreVersion();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpPort <em>Http Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Http Port</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpPort()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_HttpPort();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpsPort <em>Https Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Https Port</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getHttpsPort()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_HttpsPort();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchProgramArgs <em>Launch Program
   * Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Launch Program Args</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchProgramArgs()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_LaunchProgramArgs();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchVmArgs <em>Launch Vm Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Launch Vm Args</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getLaunchVmArgs()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_LaunchVmArgs();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#isCleanPreviousRuntimes <em>Clean Previous
   * Runtimes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Clean Previous Runtimes</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#isCleanPreviousRuntimes()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_CleanPreviousRuntimes();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStartTimeout <em>Start Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Start Timeout</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStartTimeout()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_StartTimeout();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStopTimeout <em>Stop Timeout</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Stop Timeout</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getStopTimeout()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_StopTimeout();

  /**
   * Returns the meta object for the attribute
   * '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getAutoPublish <em>Auto Publish</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Auto Publish</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask#getAutoPublish()
   * @see #getTomcatServerTask()
   * @generated
   */
  EAttribute getTomcatServerTask_AutoPublish();

  /**
   * Returns the meta object for enum '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline <em>Tomcat
   * Baseline</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Tomcat Baseline</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline
   * @generated
   */
  EEnum getTomcatBaseline();

  /**
   * Returns the meta object for enum '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish <em>Auto
   * Publish</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for enum '<em>Auto Publish</em>'.
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish
   * @generated
   */
  EEnum getAutoPublish();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TomcatServerFactory getTomcatServerFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   *
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl
     * <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerTaskImpl
     * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl#getTomcatServerTask()
     * @generated
     */
    EClass TOMCAT_SERVER_TASK = eINSTANCE.getTomcatServerTask();

    /**
     * The meta object literal for the '<em><b>Server Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__SERVER_NAME = eINSTANCE.getTomcatServerTask_ServerName();

    /**
     * The meta object literal for the '<em><b>Server Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__SERVER_VERSION = eINSTANCE.getTomcatServerTask_ServerVersion();

    /**
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__LOCATION = eINSTANCE.getTomcatServerTask_Location();

    /**
     * The meta object literal for the '<em><b>Runtime Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__RUNTIME_NAME = eINSTANCE.getTomcatServerTask_RuntimeName();

    /**
     * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__HOSTNAME = eINSTANCE.getTomcatServerTask_Hostname();

    /**
     * The meta object literal for the '<em><b>Jre Version</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__JRE_VERSION = eINSTANCE.getTomcatServerTask_JreVersion();

    /**
     * The meta object literal for the '<em><b>Http Port</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__HTTP_PORT = eINSTANCE.getTomcatServerTask_HttpPort();

    /**
     * The meta object literal for the '<em><b>Https Port</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__HTTPS_PORT = eINSTANCE.getTomcatServerTask_HttpsPort();

    /**
     * The meta object literal for the '<em><b>Launch Program Args</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS = eINSTANCE.getTomcatServerTask_LaunchProgramArgs();

    /**
     * The meta object literal for the '<em><b>Launch Vm Args</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS = eINSTANCE.getTomcatServerTask_LaunchVmArgs();

    /**
     * The meta object literal for the '<em><b>Clean Previous Runtimes</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES = eINSTANCE.getTomcatServerTask_CleanPreviousRuntimes();

    /**
     * The meta object literal for the '<em><b>Start Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__START_TIMEOUT = eINSTANCE.getTomcatServerTask_StartTimeout();

    /**
     * The meta object literal for the '<em><b>Stop Timeout</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__STOP_TIMEOUT = eINSTANCE.getTomcatServerTask_StopTimeout();

    /**
     * The meta object literal for the '<em><b>Auto Publish</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EAttribute TOMCAT_SERVER_TASK__AUTO_PUBLISH = eINSTANCE.getTomcatServerTask_AutoPublish();

    /**
     * The meta object literal for the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline <em>Tomcat
     * Baseline</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline
     * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl#getTomcatBaseline()
     * @generated
     */
    EEnum TOMCAT_BASELINE = eINSTANCE.getTomcatBaseline();

    /**
     * The meta object literal for the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish <em>Auto Publish</em>}'
     * enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish
     * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerPackageImpl#getAutoPublish()
     * @generated
     */
    EEnum AUTO_PUBLISH = eINSTANCE.getAutoPublish();

  }

} // TomcatServerPackage
