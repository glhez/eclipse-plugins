/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.util;

import java.nio.file.FileSystems;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.AutoPublish;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatBaseline;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 *
 * @see com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage
 * @generated
 */
public class TomcatServerValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public static final TomcatServerValidator INSTANCE = new TomcatServerValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic
   * {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "com.github.glhez.eclipse.plugins.oomph.setup.tomcat";

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public TomcatServerValidator() {
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return TomcatServerPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected boolean validate(final int classifierID, final Object value, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    return switch (classifierID) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK -> validateTomcatServerTask((TomcatServerTask) value, diagnostics, context);
      case TomcatServerPackage.CLASSPATH_ENTRY -> validateClasspathEntry((ClasspathEntry) value, diagnostics, context);
      case TomcatServerPackage.TOMCAT_BASELINE -> validateTomcatBaseline((TomcatBaseline) value, diagnostics, context);
      case TomcatServerPackage.AUTO_PUBLISH -> validateAutoPublish((AutoPublish) value, diagnostics, context);
      default -> true;
    };
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public boolean validateTomcatServerTask(final TomcatServerTask tomcatServerTask, final DiagnosticChain diagnostics,
      final Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(tomcatServerTask, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public boolean validateClasspathEntry(final ClasspathEntry classpathEntry, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    if (!validate_NoCircularContainment(classpathEntry, diagnostics, context)) {
      return false;
    }
    var result = validate_EveryMultiplicityConforms(classpathEntry, diagnostics, context);
    if (result || diagnostics != null) {
      result &= validate_EveryDataValueConforms(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryReferenceIsContained(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryBidirectionalReferenceIsPaired(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryProxyResolves(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_UniqueID(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryKeyUnique(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryMapEntryUnique(classpathEntry, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateClasspathEntry_validPattern(classpathEntry, diagnostics, context);
    }
    return result;
  }

  /**
   * Validates the validPattern constraint of '<em>Classpath Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated NOT
   */
  public boolean validateClasspathEntry_validPattern(final ClasspathEntry classpathEntry, final DiagnosticChain diagnostics,
      final Map<Object, Object> context) {
    final var value = Objects.toString(classpathEntry.getPattern(), "").strip();
    if (value.isEmpty()) {
      return true;
    }

    try {
      FileSystems.getDefault().getPathMatcher(value);
      return true;
    } catch (final IllegalArgumentException | UnsupportedOperationException exception) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(
                                         Diagnostic.ERROR,
                                         DIAGNOSTIC_SOURCE,
                                         0,
                                         "_UI_InvalidPattern_diagnostic",
                                         new Object[] { value, exception.getMessage() },
                                         new Object[] { classpathEntry },
                                         context));
      }

      return false;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public boolean validateTomcatBaseline(final TomcatBaseline tomcatBaseline, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public boolean validateAutoPublish(final AutoPublish autoPublish, final DiagnosticChain diagnostics, final Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    // TODO
    // Specialize this to return a resource locator for messages specific to this validator.
    // Ensure that you remove @generated or mark it @generated NOT
    return super.getResourceLocator();
  }

} // TomcatServerValidator
