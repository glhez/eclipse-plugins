package com.github.glhez.eclipse.plugins.sonarquickfix;

import static java.util.stream.Collectors.joining;

import java.lang.annotation.ElementType;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.LambdaExpression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.ModuleDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.RecordDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

class SuppressWarningCandidates {
  private static final String FIELDS_TEXT = "fields";
  private static final String FIELD_TEXT = "field";
  private static final String VARIABLES_TEXT = "variables";
  private static final String VARIABLE_TEXT = "variable";

  sealed interface SuppressWarningsCandidate<T extends ASTNode> {
    T target();

    ChildListPropertyDescriptor property();

    ElementType elementType();

    @Override
    String toString();

    boolean match(final ASTNode target);

    boolean alreadySuppressed(final String ruleKey);
  }

  private static String toVariableDeclarationString(final String singular, final String plural, final List<VariableDeclarationFragment> fragments) {
    var prefix = fragments.size() == 1 ? singular : plural;
    return fragments.stream()
                    .map(item -> item.getName().getIdentifier())
                    .collect(joining(", ", prefix, ""));
  }

  abstract static sealed class AbstractSuppressWarningsCandidate<T extends ASTNode> implements SuppressWarningsCandidate<T> {
    protected T target;
    protected ElementType elementType;

    protected AbstractSuppressWarningsCandidate(final T target, final ElementType elementType) {
      this.target = target;
      this.elementType = elementType;
    }

    @Override
    public final T target() {
      return target;
    }

    @Override
    public final ElementType elementType() {
      return elementType;
    }

    @Override
    public final boolean match(final ASTNode target) {
      return this.target == target;
    }

    @Override
    public boolean alreadySuppressed(final String ruleKey) {
      var value = target().getStructuralProperty(property());
      if (!(value instanceof List<?> list)) {
        return false;
      }
      for (Object item : list) {
        if (item instanceof Annotation annotation && annotation.getTypeName().getFullyQualifiedName().endsWith("SuppressWarnings")
            && annotation.toString().contains(ruleKey)) {
          return true;
        }
      }
      return false;
    }

    @Override
    public final String toString() {
      return toString0();
    }

    protected abstract String toString0();
  }

  abstract static sealed class AbstractSuppressWarningsCandidateWithProperties<T extends ASTNode> extends AbstractSuppressWarningsCandidate<T> {
    protected ChildListPropertyDescriptor property;

    protected AbstractSuppressWarningsCandidateWithProperties(final T target, final ElementType elementType,
        final ChildListPropertyDescriptor property) {
      super(target, elementType);
      this.property = property;
    }

    @Override
    public ChildListPropertyDescriptor property() {
      return property;
    }
  }

  static final class SingleVariableDeclarationSuppressWarningsCandidate
      extends AbstractSuppressWarningsCandidateWithProperties<SingleVariableDeclaration> {

    public SingleVariableDeclarationSuppressWarningsCandidate(final SingleVariableDeclaration target) {
      super(target, resolveElementType(target), SingleVariableDeclaration.MODIFIERS2_PROPERTY);
    }

    @Override
    public String toString0() {
      var prefix = switch (elementType) {
        case LOCAL_VARIABLE -> SuppressWarningCandidates.VARIABLE_TEXT;
        case PARAMETER -> "parameter";
        case RECORD_COMPONENT -> "record component";
        case null, default -> throw new IllegalStateException("should not be %s".formatted(elementType));
      };
      return prefix + " " + target.getName().getIdentifier();
    }

    private static ElementType resolveElementType(final SingleVariableDeclaration svd) {
      return switch (svd.getParent()) {
        case MethodDeclaration _ -> ElementType.PARAMETER;
        case LambdaExpression _ -> ElementType.PARAMETER;
        case RecordDeclaration _ -> ElementType.RECORD_COMPONENT;
        default -> ElementType.LOCAL_VARIABLE;
      };
    }

  }

  static final class VariableExpressionSuppressWarningsCandidate
      extends AbstractSuppressWarningsCandidateWithProperties<VariableDeclarationExpression> {

    public VariableExpressionSuppressWarningsCandidate(final VariableDeclarationExpression target) {
      super(target, ElementType.LOCAL_VARIABLE, VariableDeclarationExpression.MODIFIERS2_PROPERTY);
    }

    @Override
    public String toString0() {
      return toVariableDeclarationString(VARIABLE_TEXT, VARIABLES_TEXT, target.fragments());
    }
  }

  static final class VariableStatementSuppressWarningsCandidate
      extends AbstractSuppressWarningsCandidateWithProperties<VariableDeclarationStatement> {
    public VariableStatementSuppressWarningsCandidate(final VariableDeclarationStatement target) {
      super(target, ElementType.LOCAL_VARIABLE, VariableDeclarationStatement.MODIFIERS2_PROPERTY);
    }

    @Override
    public String toString0() {
      return toVariableDeclarationString(VARIABLE_TEXT, VARIABLES_TEXT, target.fragments());
    }
  }

  abstract static sealed class AbstractBodyDeclarationSuppressWarningsCandidate<T extends BodyDeclaration>
      extends AbstractSuppressWarningsCandidate<T> {

    protected AbstractBodyDeclarationSuppressWarningsCandidate(final T target, final ElementType elementType) {
      super(target, elementType);
    }

    @Override
    public final ChildListPropertyDescriptor property() {
      return target.getModifiersProperty();
    }

  }

  static final class FieldSuppressWarningsCandidate extends AbstractBodyDeclarationSuppressWarningsCandidate<FieldDeclaration> {

    public FieldSuppressWarningsCandidate(final FieldDeclaration target) {
      super(target, ElementType.FIELD);
    }

    @Override
    public String toString0() {
      return toVariableDeclarationString(FIELD_TEXT, FIELDS_TEXT, target.fragments());
    }
  }

  abstract static sealed class AbstractTypeDeclarationSuppressWarningsCandidate<T extends AbstractTypeDeclaration>
      extends AbstractBodyDeclarationSuppressWarningsCandidate<T> {
    private final String prefix;

    protected AbstractTypeDeclarationSuppressWarningsCandidate(final T target, final ElementType elementType, final String prefix) {
      super(target, elementType);
      this.prefix = prefix;
    }

    @Override
    public final String toString0() {
      return prefix + " " + target.toString();
    }
  }

  static final class MethodSuppressWarningsCandidate extends AbstractBodyDeclarationSuppressWarningsCandidate<MethodDeclaration> {
    public MethodSuppressWarningsCandidate(final MethodDeclaration target) {
      super(target, ElementType.METHOD);
    }

    @Override
    public String toString0() {
      return (target.isConstructor() ? "constructor" : "method") + " " + target.getName();
    }
  }

  static final class RecordSuppressWarningsCandidate extends AbstractTypeDeclarationSuppressWarningsCandidate<RecordDeclaration> {
    public RecordSuppressWarningsCandidate(final RecordDeclaration target) {
      super(target, ElementType.TYPE, "record");
    }
  }

  static final class EnumSuppressWarningsCandidate extends AbstractTypeDeclarationSuppressWarningsCandidate<EnumDeclaration> {
    public EnumSuppressWarningsCandidate(final EnumDeclaration target) {
      super(target, ElementType.TYPE, "enum");
    }
  }

  static final class AnnotationTypeSuppressWarningsCandidate extends AbstractTypeDeclarationSuppressWarningsCandidate<AnnotationTypeDeclaration> {
    public AnnotationTypeSuppressWarningsCandidate(final AnnotationTypeDeclaration target) {
      super(target, ElementType.ANNOTATION_TYPE, "@interface");
    }
  }

  static final class TypeSuppressWarningsCandidate extends AbstractTypeDeclarationSuppressWarningsCandidate<TypeDeclaration> {
    public TypeSuppressWarningsCandidate(final TypeDeclaration target) {
      super(target, ElementType.TYPE, target.isInterface() ? "interface" : "class");
    }
  }

  static final class PackageSuppressWarningsCandidate extends AbstractSuppressWarningsCandidateWithProperties<PackageDeclaration> {

    public PackageSuppressWarningsCandidate(final PackageDeclaration target) {
      super(target, ElementType.PACKAGE, PackageDeclaration.ANNOTATIONS_PROPERTY);
    }

    @Override
    public String toString0() {
      return "package " + target.getName().getFullyQualifiedName();
    }

  }

  static final class ModuleSuppressWarningsCandidate extends AbstractSuppressWarningsCandidateWithProperties<ModuleDeclaration> {

    protected ModuleSuppressWarningsCandidate(final ModuleDeclaration target) {
      super(target, ElementType.PACKAGE, ModuleDeclaration.ANNOTATIONS_PROPERTY);
    }

    @Override
    public String toString0() {
      return "module " + target.getName().getFullyQualifiedName();
    }

  }
}
