/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Tomcat Baseline</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getTomcatBaseline()
 * @model
 * @generated
 */
public enum TomcatBaseline implements Enumerator {
  /**
   * The '<em><b>TOMCAT 90</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_90_VALUE
   * @generated
   * @ordered
   */
  TOMCAT_90(1, "TOMCAT_90", "Tomcat 9.0.x"),
  /**
   * The '<em><b>TOMCAT 100</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_100_VALUE
   * @generated
   * @ordered
   */
  TOMCAT_100(2, "TOMCAT_100", "Tomcat 10.0.x"),
  /**
   * The '<em><b>TOMCAT 101</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_101_VALUE
   * @generated
   * @ordered
   */
  TOMCAT_101(3, "TOMCAT_101", "Tomcat 10.1.x"),
  /**
   * The '<em><b>TOMCAT 110</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_110_VALUE
   * @generated
   * @ordered
   */
  TOMCAT_110(4, "TOMCAT_110", "Tomcat 11.0.x");

  /**
   * The '<em><b>TOMCAT 90</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_90
   * @model literal="Tomcat 9.0.x"
   * @generated
   * @ordered
   */
  public static final int TOMCAT_90_VALUE = 1;

  /**
   * The '<em><b>TOMCAT 100</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_100
   * @model literal="Tomcat 10.0.x"
   * @generated
   * @ordered
   */
  public static final int TOMCAT_100_VALUE = 2;

  /**
   * The '<em><b>TOMCAT 101</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_101
   * @model literal="Tomcat 10.1.x"
   * @generated
   * @ordered
   */
  public static final int TOMCAT_101_VALUE = 3;

  /**
   * The '<em><b>TOMCAT 110</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #TOMCAT_110
   * @model literal="Tomcat 11.0.x"
   * @generated
   * @ordered
   */
  public static final int TOMCAT_110_VALUE = 4;

  /**
   * An array of all the '<em><b>Tomcat Baseline</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final TomcatBaseline[] VALUES_ARRAY = {
      TOMCAT_90,
      TOMCAT_100,
      TOMCAT_101,
      TOMCAT_110,
  };

  /**
   * A public read-only list of all the '<em><b>Tomcat Baseline</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<TomcatBaseline> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Tomcat Baseline</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal
   *          the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TomcatBaseline get(final String literal) {
    for (TomcatBaseline result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tomcat Baseline</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name
   *          the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TomcatBaseline getByName(final String name) {
    for (TomcatBaseline result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tomcat Baseline</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static TomcatBaseline get(final int value) {
    switch (value) {
      case TOMCAT_90_VALUE:
        return TOMCAT_90;
      case TOMCAT_100_VALUE:
        return TOMCAT_100;
      case TOMCAT_101_VALUE:
        return TOMCAT_101;
      case TOMCAT_110_VALUE:
        return TOMCAT_110;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  TomcatBaseline(final int value, final String name, final String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // TomcatBaseline
