package com.github.glhez.eclipse.plugins.sonarquickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.IMarkerResolution;

class AddNoSonarResolution implements IMarkerResolution {
  private final ICompilationUnit unit;
  private final IMarker marker;

  AddNoSonarResolution(final ICompilationUnit unit, final IMarker marker) {
    this.unit = unit;
    this.marker = marker;
  }

  @Override
  public String getLabel() {
    return "Add // NOSONAR to this line";
  }

  @Override
  public void run(final IMarker ignored) {
    try {
      var source = unit.getSource();
      var offset = SonarQuickFixResolutionGenerator.markerOffset(marker, source);
      var document = new Document(source);
      var line = document.getLineOfOffset(offset);
      var start = document.getLineOffset(line);
      var end = document.getLineOffset(line)
          + document.getLineLength(line);
      while (end > start && (document.getChar(end - 1) == '\n' || document.getChar(end - 1) == '\r')) {
        end--;
      }

      var lineText = document.get(start, end - start);
      if (lineText.contains("NOSONAR")) {
        return;
      }

      document.replace(end, 0,
                       lineText.isBlank() ? "// NOSONAR" : " // NOSONAR");
      unit.getBuffer().setContents(document.get());
      unit.save(null, true);
    } catch (Exception e) {
      SonarQuickFixResolutionGenerator.log("Could not add // NOSONAR", e);
    }
  }
}