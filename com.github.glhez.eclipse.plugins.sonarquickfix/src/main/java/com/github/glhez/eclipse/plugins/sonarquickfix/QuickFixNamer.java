package com.github.glhez.eclipse.plugins.sonarquickfix;

import static java.util.stream.Collectors.joining;

import java.util.List;

import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.ModuleDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

class QuickFixNamer {
  private QuickFixNamer() {
    /* This utility class should not be instantiated */
  }

  private static String variable(final List<VariableDeclarationFragment> fragments) {
    return "variable " + fragments.stream()
                                  .map(item -> item.getName().getIdentifier())
                                  .collect(joining(", "));
  }

  static String name(final VariableDeclarationStatement v) {
    return variable(v.fragments()); // List<VariableDeclarationFragment>
  }

  static String name(final FieldDeclaration v) {
    return variable(v.fragments()); // List<VariableDeclarationFragment>
  }

  static String name(final VariableDeclarationExpression v) {
    return variable(v.fragments()); // List<VariableDeclarationFragment>
  }

  static String name(final SingleVariableDeclaration svd) {
    return "variable/parameter " + svd.getName();
  }

  static String name(final MethodDeclaration method) {
    return (method.isConstructor() ? "constructor" : "method") + " " + method.getName().getIdentifier();
  }

  static String name(final TypeDeclaration type) {
    return "class " + type.getName();
  }

  static String name(final PackageDeclaration pkg) {
    return "package " + pkg.getName().getFullyQualifiedName();
  }

  static String name(final ModuleDeclaration module) {
    return "module " + module.getName().getFullyQualifiedName();
  }
}
