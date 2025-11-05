/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerFactory;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TomcatServerFactoryImpl extends EFactoryImpl implements TomcatServerFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static TomcatServerFactory init() {
    try {
      var theTomcatServerFactory = (TomcatServerFactory) EPackage.Registry.INSTANCE.getEFactory(TomcatServerPackage.eNS_URI);
      if (theTomcatServerFactory != null) {
        return theTomcatServerFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TomcatServerFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public TomcatServerFactoryImpl() {
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(final EClass eClass) {
    return switch (eClass.getClassifierID()) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK -> createTomcatServerTask();
      default -> throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(final EDataType eDataType, final String initialValue) {
    return switch (eDataType.getClassifierID()) {
      case TomcatServerPackage.TOMCAT_BASELINE -> createTomcatBaselineFromString(eDataType, initialValue);
      case TomcatServerPackage.AUTO_PUBLISH -> createAutoPublishFromString(eDataType, initialValue);
      default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(final EDataType eDataType, final Object instanceValue) {
    return switch (eDataType.getClassifierID()) {
      case TomcatServerPackage.TOMCAT_BASELINE -> convertTomcatBaselineToString(eDataType, instanceValue);
      case TomcatServerPackage.AUTO_PUBLISH -> convertAutoPublishToString(eDataType, instanceValue);
      default -> throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TomcatServerTask createTomcatServerTask() {
    return new TomcatServerTaskImpl();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public TomcatBaseline createTomcatBaselineFromString(final EDataType eDataType, final String initialValue) {
    var result = TomcatBaseline.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertTomcatBaselineToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public AutoPublish createAutoPublishFromString(final EDataType eDataType, final String initialValue) {
    var result = AutoPublish.get(initialValue);
    if (result == null) {
      throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    }
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertAutoPublishToString(final EDataType eDataType, final Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public TomcatServerPackage getTomcatServerPackage() {
    return (TomcatServerPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TomcatServerPackage getPackage() {
    return TomcatServerPackage.eINSTANCE;
  }

} // TomcatServerFactoryImpl
