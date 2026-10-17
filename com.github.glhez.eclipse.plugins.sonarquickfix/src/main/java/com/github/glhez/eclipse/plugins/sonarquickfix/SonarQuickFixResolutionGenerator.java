package com.github.glhez.eclipse.plugins.sonarquickfix;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.RecordDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;

import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.AnnotationTypeSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.EnumSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.FieldSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.MethodSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.ModuleSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.PackageSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.RecordSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.SingleVariableDeclarationSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.SuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.TypeSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.VariableExpressionSuppressWarningsCandidate;
import com.github.glhez.eclipse.plugins.sonarquickfix.SuppressWarningCandidates.VariableStatementSuppressWarningsCandidate;

public final class SonarQuickFixResolutionGenerator implements IMarkerResolutionGenerator2 {

  private static final IMarkerResolution[] NO_MARKERS = new IMarkerResolution[0];
  private static final String PLUGIN_ID = "com.github.glhez.eclipse.plugins.sonarquickfix";

  @Override
  public boolean hasResolutions(final IMarker marker) {
    return sonarMarker(marker) && ruleKey(marker) != null;
  }

  @Override
  public IMarkerResolution[] getResolutions(final IMarker marker) {
    try {
      return findCompilationUnitIfMarkerHasResolutions(marker).map(unit -> newResolutionsBuilder(unit, marker))
                                                              .map(ResolutionsBuilder::build)
                                                              .orElse(NO_MARKERS);
    } catch (SuperPrivateRuntimeExceptionAgainstCheckedException e) {
      log("could not create marker " + marker + " quickfixes", e.getCause());
      return NO_MARKERS;
    }
  }

  private Optional<ICompilationUnit> findCompilationUnitIfMarkerHasResolutions(final IMarker marker) {
    return hasResolutions(marker) ? findCompilationUnit(marker) : Optional.empty();
  }

  static Optional<ICompilationUnit> findCompilationUnit(final IMarker marker) {
    if (!(marker.getResource() instanceof IFile file)) {
      return Optional.empty();
    }

    var unit = JavaCore.createCompilationUnitFrom(file);
    if (unit == null || !unit.exists()) {
      return Optional.empty();
    }
    return Optional.of(unit);
  }

  private static boolean sonarMarker(final IMarker marker) {
    try {
      return marker != null && marker.exists() && marker.getType().startsWith("org.sonarlint.eclipse.");
    } catch (CoreException _) {
      return false;
    }
  }

  private static String ruleKey(final IMarker marker) {
    for (String attribute : List.of("ruleKey", "rulekey", "sonarRuleKey")) {
      var value = marker.getAttribute(attribute, "");
      if (!value.isBlank()) {
        return value;
      }
    }
    return null;
  }

  static CompilationUnit parse(final ICompilationUnit unit) {
    var parser = ASTParser.newParser(AST.getJLSLatest());
    parser.setSource(unit);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setResolveBindings(true);
    return (CompilationUnit) parser.createAST(null);
  }

  static int markerOffset(final IMarker marker, final String source) throws BadLocationException {
    var offset = marker.getAttribute(IMarker.CHAR_START, -1);
    if (offset >= 0) {
      return Math.min(offset, source.length());
    }

    var line = marker.getAttribute(IMarker.LINE_NUMBER, -1);
    if (line < 1) {
      return 0;
    }

    var document = new Document(source);
    return document.getLineOffset(Math.min(line - 1, document.getNumberOfLines() - 1));
  }

  private static ResolutionsBuilder newResolutionsBuilder(final ICompilationUnit unit, final IMarker marker) {
    try {
      return new ResolutionsBuilder(unit, marker);
    } catch (BadLocationException | JavaModelException e) {
      throw new SuperPrivateRuntimeExceptionAgainstCheckedException(e);
    }
  }

  static class ResolutionsBuilder {
    private final ICompilationUnit unit;
    private final List<IMarkerResolution> resolutions;
    private final CompilationUnit ast;
    private final int offset;
    private final String ruleKey;

    public ResolutionsBuilder(final ICompilationUnit unit, final IMarker marker) throws BadLocationException, JavaModelException {
      this.unit = unit;
      this.resolutions = new ArrayList<>(10);

      var source = unit.getSource();
      this.ast = parse(unit);
      this.offset = markerOffset(marker, source);
      this.ruleKey = ruleKey(marker);
    }

    public IMarkerResolution[] build() {
      resolutions.add(new AddNoSonarResolution());
      appendCandidates().map(candidate -> new AddSuppressWarningsResolution(unit, candidate, ruleKey)).forEach(resolutions::add);
      return resolutions.toArray(IMarkerResolution[]::new);
    }

    private CandidateList appendCandidates() {
      var candidates = new CandidateList(ruleKey);
      var node = findSmallestNode(ast, offset);
      for (var n = node; n != null; n = n.getParent()) {
        switch (n) {
          case SingleVariableDeclaration v -> candidates.add(new SingleVariableDeclarationSuppressWarningsCandidate(v));

          case VariableDeclarationStatement decl -> candidates.add(new VariableStatementSuppressWarningsCandidate(decl));
          case VariableDeclarationExpression decl -> candidates.add(new VariableExpressionSuppressWarningsCandidate(decl));
          case FieldDeclaration decl -> candidates.add(new FieldSuppressWarningsCandidate(decl));

          case MethodDeclaration decl -> candidates.add(new MethodSuppressWarningsCandidate(decl));
          case EnumDeclaration decl -> candidates.add(new EnumSuppressWarningsCandidate(decl));
          case RecordDeclaration decl -> candidates.add(new RecordSuppressWarningsCandidate(decl));
          case AnnotationTypeDeclaration decl -> candidates.add(new AnnotationTypeSuppressWarningsCandidate(decl));
          case TypeDeclaration decl -> candidates.add(new TypeSuppressWarningsCandidate(decl));
          default -> {
            // not supported
          }
        }
      }

      var pkg = ast.getPackage();
      if (pkg != null && !pkg.getName().getFullyQualifiedName().isBlank()) {
        candidates.add(new PackageSuppressWarningsCandidate(pkg));
      }

      var module = ast.getModule();
      if (module != null) {
        candidates.add(new ModuleSuppressWarningsCandidate(module));
      }
      return candidates;
    }

    private static ASTNode findSmallestNode(final CompilationUnit ast, final int offset) {
      final ASTNode[] best = { ast };

      ast.accept(new org.eclipse.jdt.core.dom.ASTVisitor() {
        @Override
        public void preVisit(final ASTNode node) {
          var start = node.getStartPosition();
          var end = start + node.getLength();
          if (start >= 0 && offset >= start && offset <= end
              && node.getLength() <= best[0].getLength()) {
            best[0] = node;
          }
        }
      });
      return best[0];
    }
  }

  static class CandidateList {
    private final List<SuppressWarningsCandidate<? extends ASTNode>> candidates;
    private final String ruleKey;

    public CandidateList(final String ruleKey) {
      this.candidates = new ArrayList<>();
      this.ruleKey = ruleKey;
    }

    public <T extends ASTNode> void add(final SuppressWarningsCandidate<T> swc) {
      if (swc.alreadySuppressed(ruleKey)) {
        return;
      }

      // Avoid duplicate choices for the same AST target.
      for (var existing : candidates) {
        if (existing.match(swc.target())) {
          return;
        }
      }
      candidates.add(swc);
    }

    public <U> Stream<U> map(final Function<SuppressWarningsCandidate<? extends ASTNode>, U> mapper) {
      return candidates.stream().map(mapper);
    }

  }

  static void log(final String message, final Throwable e) {
    org.eclipse.core.runtime.Platform.getLog(org.eclipse.core.runtime.Platform.getBundle(PLUGIN_ID))
                                     .log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
  }

  static class SuperPrivateRuntimeExceptionAgainstCheckedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SuperPrivateRuntimeExceptionAgainstCheckedException(final Throwable cause) {
      super(cause);
    }

  }
}
