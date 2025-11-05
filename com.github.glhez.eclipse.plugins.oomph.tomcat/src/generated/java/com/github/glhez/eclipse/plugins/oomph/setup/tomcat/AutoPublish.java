/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Auto Publish</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage#getAutoPublish()
 * @model
 * @generated
 */
public enum AutoPublish implements Enumerator {
  /**
   * The '<em><b>DISABLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #DISABLE_VALUE
   * @generated
   * @ordered
   */
  DISABLE(1, "DISABLE", "Disable auto publish"),

  /**
   * The '<em><b>RESOURCE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #RESOURCE_VALUE
   * @generated
   * @ordered
   */
  RESOURCE(2, "RESOURCE", "Publish on resource change"),

  /**
   * The '<em><b>BUILD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #BUILD_VALUE
   * @generated
   * @ordered
   */
  BUILD(3, "BUILD", "Publish on build change");

  /**
   * The '<em><b>DISABLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #DISABLE
   * @model literal="Disable auto publish"
   * @generated
   * @ordered
   */
  public static final int DISABLE_VALUE = 1;

  /**
   * The '<em><b>RESOURCE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #RESOURCE
   * @model literal="Publish on resource change"
   * @generated
   * @ordered
   */
  public static final int RESOURCE_VALUE = 2;

  /**
   * The '<em><b>BUILD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #BUILD
   * @model literal="Publish on build change"
   * @generated
   * @ordered
   */
  public static final int BUILD_VALUE = 3;

  /**
   * An array of all the '<em><b>Auto Publish</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final AutoPublish[] VALUES_ARRAY = {
      DISABLE,
      RESOURCE,
      BUILD,
  };

  /**
   * A public read-only list of all the '<em><b>Auto Publish</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final List<AutoPublish> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Auto Publish</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param literal
   *          the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AutoPublish get(final String literal) {
    for (AutoPublish result : VALUES_ARRAY) {
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Auto Publish</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param name
   *          the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AutoPublish getByName(final String name) {
    for (AutoPublish result : VALUES_ARRAY) {
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Auto Publish</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @param value
   *          the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AutoPublish get(final int value) {
    switch (value) {
      case DISABLE_VALUE:
        return DISABLE;
      case RESOURCE_VALUE:
        return RESOURCE;
      case BUILD_VALUE:
        return BUILD;
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
  AutoPublish(final int value, final String name, final String literal) {
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

} // AutoPublish
