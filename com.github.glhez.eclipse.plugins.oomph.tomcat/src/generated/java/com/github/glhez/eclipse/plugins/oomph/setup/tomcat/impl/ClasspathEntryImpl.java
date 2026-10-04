/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classpath Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.ClasspathEntryImpl#getEntry <em>Entry</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.ClasspathEntryImpl#getPattern <em>Pattern</em>}</li>
 * <li>{@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.impl.ClasspathEntryImpl#isSort <em>Sort</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClasspathEntryImpl extends MinimalEObjectImpl.Container implements ClasspathEntry {
  /**
   * The default value of the '{@link #getEntry() <em>Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntry()
   * @generated
   * @ordered
   */
  protected static final String ENTRY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEntry() <em>Entry</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getEntry()
   * @generated
   * @ordered
   */
  protected String entry = ENTRY_EDEFAULT;

  /**
   * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected static final String PATTERN_EDEFAULT = "*.jar";

  /**
   * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getPattern()
   * @generated
   * @ordered
   */
  protected String pattern = PATTERN_EDEFAULT;

  /**
   * The default value of the '{@link #isSort() <em>Sort</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isSort()
   * @generated
   * @ordered
   */
  protected static final boolean SORT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSort() <em>Sort</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #isSort()
   * @generated
   * @ordered
   */
  protected boolean sort = SORT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ClasspathEntryImpl() {
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TomcatServerPackage.Literals.CLASSPATH_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getEntry() {
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setEntry(final String newEntry) {
    var oldEntry = entry;
    entry = newEntry;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.CLASSPATH_ENTRY__ENTRY, oldEntry, entry));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getPattern() {
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setPattern(final String newPattern) {
    var oldPattern = pattern;
    pattern = newPattern;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.CLASSPATH_ENTRY__PATTERN, oldPattern, pattern));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isSort() {
    return sort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSort(final boolean newSort) {
    var oldSort = sort;
    sort = newSort;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, TomcatServerPackage.CLASSPATH_ENTRY__SORT, oldSort, sort));
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
      case TomcatServerPackage.CLASSPATH_ENTRY__ENTRY:
        return getEntry();
      case TomcatServerPackage.CLASSPATH_ENTRY__PATTERN:
        return getPattern();
      case TomcatServerPackage.CLASSPATH_ENTRY__SORT:
        return isSort();
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
      case TomcatServerPackage.CLASSPATH_ENTRY__ENTRY:
        setEntry((String) newValue);
        return;
      case TomcatServerPackage.CLASSPATH_ENTRY__PATTERN:
        setPattern((String) newValue);
        return;
      case TomcatServerPackage.CLASSPATH_ENTRY__SORT:
        setSort((Boolean) newValue);
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
      case TomcatServerPackage.CLASSPATH_ENTRY__ENTRY:
        setEntry(ENTRY_EDEFAULT);
        return;
      case TomcatServerPackage.CLASSPATH_ENTRY__PATTERN:
        setPattern(PATTERN_EDEFAULT);
        return;
      case TomcatServerPackage.CLASSPATH_ENTRY__SORT:
        setSort(SORT_EDEFAULT);
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
      case TomcatServerPackage.CLASSPATH_ENTRY__ENTRY:
        return ENTRY_EDEFAULT == null ? entry != null : !ENTRY_EDEFAULT.equals(entry);
      case TomcatServerPackage.CLASSPATH_ENTRY__PATTERN:
        return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
      case TomcatServerPackage.CLASSPATH_ENTRY__SORT:
        return sort != SORT_EDEFAULT;
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
    result.append(" (entry: ");
    result.append(entry);
    result.append(", pattern: ");
    result.append(pattern);
    result.append(", sort: ");
    result.append(sort);
    result.append(')');
    return result.toString();
  }

} // ClasspathEntryImpl
