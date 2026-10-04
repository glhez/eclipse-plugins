/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classpath Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry#getEntry <em>Entry</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry#getPattern <em>Pattern</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry#isSort <em>Sort</em>}</li>
 * </ul>
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getClasspathEntry()
 * @model
 * @generated
 */
public interface ClasspathEntry extends EObject {
  /**
   * Returns the value of the '<em><b>Entry</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Entry</em>' attribute.
   * @see #setEntry(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getClasspathEntry_Entry()
   * @model required="true"
   * @generated
   */
  String getEntry();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry#getEntry <em>Entry</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Entry</em>' attribute.
   * @see #getEntry()
   * @generated
   */
  void setEntry(String value);

  /**
   * Returns the value of the '<em><b>Pattern</b></em>' attribute.
   * The default value is <code>"*.jar"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Pattern</em>' attribute.
   * @see #setPattern(String)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getClasspathEntry_Pattern()
   * @model default="*.jar"
   * @generated
   */
  String getPattern();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry#getPattern <em>Pattern</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Pattern</em>' attribute.
   * @see #getPattern()
   * @generated
   */
  void setPattern(String value);

  /**
   * Returns the value of the '<em><b>Sort</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Sort</em>' attribute.
   * @see #setSort(boolean)
   * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getClasspathEntry_Sort()
   * @model default="false"
   * @generated
   */
  boolean isSort();

  /**
   * Sets the value of the '{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry#isSort <em>Sort</em>}'
   * attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Sort</em>' attribute.
   * @see #isSort()
   * @generated
   */
  void setSort(boolean value);

} // ClasspathEntry
