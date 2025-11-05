/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage
 * @generated
 */
public interface TomcatServerFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  TomcatServerFactory eINSTANCE = com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.TomcatServerFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Task</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return a new object of class '<em>Task</em>'.
   * @generated
   */
  TomcatServerTask createTomcatServerTask();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the package supported by this factory.
   * @generated
   */
  TomcatServerPackage getTomcatServerPackage();

} // TomcatServerFactory
