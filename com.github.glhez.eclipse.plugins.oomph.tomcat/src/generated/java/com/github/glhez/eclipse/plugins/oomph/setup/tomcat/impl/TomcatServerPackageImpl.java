/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.oomph.base.BasePackage;
import org.eclipse.oomph.setup.SetupPackage;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerFactory;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TomcatServerPackageImpl extends EPackageImpl implements TomcatServerPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass tomcatServerTaskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum tomcatBaselineEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private EEnum autoPublishEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>
   * Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TomcatServerPackageImpl() {
    super(eNS_URI, TomcatServerFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>
   * This method is used to initialize {@link TomcatServerPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TomcatServerPackage init() {
    if (isInited) {
      return (TomcatServerPackage) EPackage.Registry.INSTANCE.getEPackage(TomcatServerPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredTomcatServerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    var theTomcatServerPackage = registeredTomcatServerPackage instanceof TomcatServerPackageImpl t
        ? t
        : new TomcatServerPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    BasePackage.eINSTANCE.eClass();
    SetupPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theTomcatServerPackage.createPackageContents();

    // Initialize created meta-data
    theTomcatServerPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTomcatServerPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TomcatServerPackage.eNS_URI, theTomcatServerPackage);
    return theTomcatServerPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getTomcatServerTask() {
    return tomcatServerTaskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_ServerName() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_ServerVersion() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_Location() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_RuntimeName() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_Hostname() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_JreVersion() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_HttpPort() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_HttpsPort() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_LaunchProgramArgs() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_LaunchVmArgs() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_CleanPreviousRuntimes() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_StartTimeout() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_StopTimeout() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EAttribute getTomcatServerTask_AutoPublish() {
    return (EAttribute) tomcatServerTaskEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getTomcatBaseline() {
    return tomcatBaselineEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EEnum getAutoPublish() {
    return autoPublishEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TomcatServerFactory getTomcatServerFactory() {
    return (TomcatServerFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) {
      return;
    }
    isCreated = true;

    // Create classes and their features
    tomcatServerTaskEClass = createEClass(TOMCAT_SERVER_TASK);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__SERVER_NAME);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__SERVER_VERSION);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__LOCATION);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__RUNTIME_NAME);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__HOSTNAME);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__JRE_VERSION);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__HTTP_PORT);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__HTTPS_PORT);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__START_TIMEOUT);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__STOP_TIMEOUT);
    createEAttribute(tomcatServerTaskEClass, TOMCAT_SERVER_TASK__AUTO_PUBLISH);

    // Create enums
    tomcatBaselineEEnum = createEEnum(TOMCAT_BASELINE);
    autoPublishEEnum = createEEnum(AUTO_PUBLISH);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) {
      return;
    }
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    var theSetupPackage = (SetupPackage) EPackage.Registry.INSTANCE.getEPackage(SetupPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    tomcatServerTaskEClass.getESuperTypes().add(theSetupPackage.getSetupTask());

    // Initialize classes and features; add operations and parameters
    initEClass(tomcatServerTaskEClass, TomcatServerTask.class, "TomcatServerTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTomcatServerTask_ServerName(), ecorePackage.getEString(), "serverName", null, 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_ServerVersion(), this.getTomcatBaseline(), "serverVersion", null, 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_Location(), ecorePackage.getEString(), "location", null, 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_RuntimeName(), ecorePackage.getEString(), "runtimeName", null, 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_Hostname(), ecorePackage.getEString(), "hostname", "localhost", 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_JreVersion(), ecorePackage.getEString(), "jreVersion", null, 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_HttpPort(), ecorePackage.getEString(), "httpPort", "8080", 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_HttpsPort(), ecorePackage.getEString(), "httpsPort", "8443", 1, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_LaunchProgramArgs(), ecorePackage.getEString(), "launchProgramArgs", "", 0, 1, TomcatServerTask.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_LaunchVmArgs(), ecorePackage.getEString(), "launchVmArgs", "", 0, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_CleanPreviousRuntimes(), ecorePackage.getEBoolean(), "cleanPreviousRuntimes", "false", 0, 1,
                   TomcatServerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_StartTimeout(), ecorePackage.getEString(), "startTimeout", null, 0, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_StopTimeout(), ecorePackage.getEString(), "stopTimeout", null, 0, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTomcatServerTask_AutoPublish(), this.getAutoPublish(), "autoPublish", null, 0, 1, TomcatServerTask.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(tomcatBaselineEEnum, TomcatBaseline.class, "TomcatBaseline");
    addEEnumLiteral(tomcatBaselineEEnum, TomcatBaseline.TOMCAT_90);
    addEEnumLiteral(tomcatBaselineEEnum, TomcatBaseline.TOMCAT_100);
    addEEnumLiteral(tomcatBaselineEEnum, TomcatBaseline.TOMCAT_101);
    addEEnumLiteral(tomcatBaselineEEnum, TomcatBaseline.TOMCAT_110);

    initEEnum(autoPublishEEnum, AutoPublish.class, "AutoPublish");
    addEEnumLiteral(autoPublishEEnum, AutoPublish.DISABLE);
    addEEnumLiteral(autoPublishEEnum, AutoPublish.RESOURCE);
    addEEnumLiteral(autoPublishEEnum, AutoPublish.BUILD);

    // Create resource
    createResource("https://raw.githubusercontent.com/glhez/eclipse-plugins/master/com.github.glhez.eclipse.plugins.oomph.tomcat/model/Tomcat-1.0.ecore");

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // http://www.eclipse.org/oomph/base/LabelProvider
    createLabelProviderAnnotations();
    // http://www.eclipse.org/oomph/setup/Enablement
    createEnablementAnnotations();
    // http://www.eclipse.org/oomph/setup/ValidTriggers
    createValidTriggersAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createEcoreAnnotations() {
    var source = "http://www.eclipse.org/emf/2002/Ecore";
    addAnnotation(this,
                  source,
                  new String[] {
                      "schemaLocation",
                      "https://raw.githubusercontent.com/glhez/eclipse-plugins/master/com.github.glhez.eclipse.plugins.oomph.tomcat/model/Tomcat-1.0.ecore"
                  });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/oomph/base/LabelProvider</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createLabelProviderAnnotations() {
    var source = "http://www.eclipse.org/oomph/base/LabelProvider";
    addAnnotation(this,
                  source,
                  new String[] {
                      "imageBaseURI",
                      "https://raw.githubusercontent.com/glhez/eclipse-plugins/master/com.github.glhez.eclipse.plugins.oomph.tomcat.edit/icons/full/obj16"
                  });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/oomph/setup/Enablement</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createEnablementAnnotations() {
    var source = "http://www.eclipse.org/oomph/setup/Enablement";
    addAnnotation(tomcatServerTaskEClass,
                  source,
                  new String[] {
                      "variableName", "p2.tomcat",
                      "repository", "https://glhez.github.io/eclipse-plugins",
                      "installableUnits", "com.github.glhez.eclipse.features.oomph.feature.group"
                  });
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/oomph/setup/ValidTriggers</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createValidTriggersAnnotations() {
    var source = "http://www.eclipse.org/oomph/setup/ValidTriggers";
    addAnnotation(tomcatServerTaskEClass,
                  source,
                  new String[] {
                      "triggers", "STARTUP MANUAL"
                  });
  }

} // TomcatServerPackageImpl
