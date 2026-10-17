package com.github.glhez.eclipse.plugins.sonarquickfix;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.ui.IMarkerResolution;

import com.github.glhez.eclipse.plugins.sonarquickfix.SonarQuickFixResolutionGenerator.Candidate;

final class AddSuppressWarningsResolution
    implements IMarkerResolution {
  private static final String VALUE_ATTRIBUTE = "value";
  private static final String SUPPRESS_WARNINGS_ANNOTATION_NAME = "SuppressWarnings";

  private final ICompilationUnit unit;
  private final Candidate candidate;
  private final String ruleKey;

  AddSuppressWarningsResolution(
      final ICompilationUnit unit, final Candidate candidate, final String ruleKey) {
    this.unit = unit;
    this.candidate = candidate;
    this.ruleKey = ruleKey;
  }

  @Override
  public String getLabel() {
    return "Add @SuppressWarnings(\"" + ruleKey + "\") to " + candidate.description();
  }

  @Override
  public void run(final IMarker marker) {
    try {
      applyAnnotation(candidate.target(), candidate.property());
    } catch (Exception e) {
      SonarQuickFixResolutionGenerator.log("Could not add @SuppressWarnings", e);
    }
  }

  private void applyAnnotation(final ASTNode target, final ChildListPropertyDescriptor property)
      throws JavaModelException, MalformedTreeException {

    var compilationUnit = (CompilationUnit) target.getRoot();
    var ast = compilationUnit.getAST();
    var rewrite = ASTRewrite.create(ast);

    var existing = findExistingAnnotation(target, property);
    if (existing == null) {
      createAnnotation(target, property, ast, rewrite);
    } else {
      var values = getSuppressWarningsValues(existing);
      for (Expression value : values) {
        if (value instanceof StringLiteral x && ruleKey.equals(x.getLiteralValue())) {
          return;
        }
      }
      updateAnnotations(ast, rewrite, existing, values);
    }

    var document = new Document(unit.getSource());
    var edits = rewrite.rewriteAST(document, unit.getJavaProject().getOptions(true));

    unit.applyTextEdit(edits, null);
    unit.save(null, true);
  }

  private void createAnnotation(final ASTNode target, final ChildListPropertyDescriptor property, final AST ast, final ASTRewrite rewrite) {
    var annotation = ast.newNormalAnnotation();
    annotation.setTypeName(ast.newSimpleName(SUPPRESS_WARNINGS_ANNOTATION_NAME));

    var valuePair = ast.newMemberValuePair();
    valuePair.setName(ast.newSimpleName(VALUE_ATTRIBUTE));

    var value = ast.newStringLiteral();
    value.setLiteralValue(ruleKey);
    annotation.values().add(value);

    rewrite.getListRewrite(target, property).insertFirst(annotation, null);
  }

  private void updateAnnotations(
      final AST ast,
      final ASTRewrite rewrite,
      final Annotation existing,
      final List<Expression> values) {

    var array = ast.newArrayInitializer();
    for (Expression value : values) {
      array.expressions().add(ASTNode.copySubtree(ast, value));
    }
    array.expressions().add(newStringLiteral(ast, ruleKey));

    /*
     * try to keep value = {...} if present, otherwise do not add it (Sonar will keep
     * making warning otherwise (@SupressWarnings(value = {...}) does not disable the
     * marker.
     */
    switch (existing) {
      case SingleMemberAnnotation _ -> {
        var replacement = ast.newSingleMemberAnnotation();
        replacement.setTypeName((Name) ASTNode.copySubtree(ast, existing.getTypeName()));
        replacement.setValue(array);
        rewrite.replace(existing, replacement, null);
      }
      case NormalAnnotation normal -> {
        var replacement = ast.newNormalAnnotation();
        replacement.setTypeName(
                                (Name) ASTNode.copySubtree(ast, existing.getTypeName()));

        for (Object item : normal.values()) {
          var oldPair = (MemberValuePair) item;
          var pair = ast.newMemberValuePair();
          pair.setName((SimpleName) ASTNode.copySubtree(ast, oldPair.getName()));

          if (VALUE_ATTRIBUTE.equals(oldPair.getName().getIdentifier())) {
            pair.setValue(array);
          } else {
            pair.setValue((Expression) ASTNode.copySubtree(ast, oldPair.getValue()));
          }

          replacement.values().add(pair);
        }

        rewrite.replace(existing, replacement, null);
      }
      default -> {
        // noop
      }
    }
  }

  private @Nullable Annotation findExistingAnnotation(final ASTNode target, final ChildListPropertyDescriptor property) {
    for (Object modifier : (List<?>) target.getStructuralProperty(property)) {
      if (modifier instanceof Annotation annotation && SUPPRESS_WARNINGS_ANNOTATION_NAME.equals(annotation.getTypeName().getFullyQualifiedName())) {
        return annotation;
      }

    }
    return null;
  }

  private static StringLiteral newStringLiteral(final AST ast, final String value) {
    var literal = ast.newStringLiteral();
    literal.setLiteralValue(value);
    return literal;
  }

  private static List<Expression> getSuppressWarningsValues(final Annotation annotation) {
    if (annotation instanceof SingleMemberAnnotation sma) {
      return appendSuppressWarningsValues(sma.getValue());
    } else if (annotation instanceof NormalAnnotation na) {
      for (Object item : na.values()) {
        var pair = (MemberValuePair) item;
        if (VALUE_ATTRIBUTE.equals(pair.getName().getIdentifier())) {
          return appendSuppressWarningsValues(pair.getValue());
        }
      }
    }
    return List.of();
  }

  private static List<Expression> appendSuppressWarningsValues(final Expression value) {
    if (value instanceof ArrayInitializer ai) {
      return ai.expressions().stream().map(o -> (Expression) o).toList();
    }
    return List.of(value);
  }

}