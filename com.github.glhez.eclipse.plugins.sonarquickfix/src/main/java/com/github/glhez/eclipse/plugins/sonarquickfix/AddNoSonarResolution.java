package com.github.glhez.eclipse.plugins.sonarquickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.ui.IMarkerResolution;

class AddNoSonarResolution implements IMarkerResolution {
  @Override
  public String getLabel() {
    return "Add // NOSONAR to this line";
  }

  @Override
  public void run(final IMarker marker) {
    try {
      var unit = SonarQuickFixResolutionGenerator.findCompilationUnit(marker).orElse(null);
      if (unit == null) {
        return;
      }

      var source = unit.getBuffer().getContents();
      var offset = SonarQuickFixResolutionGenerator.markerOffset(marker, source);

      var document = new Document(source);
      var line = document.getLineOfOffset(offset);
      var start = document.getLineOffset(line);
      var end = document.getLineOffset(line)
          + document.getLineLength(line);
      while (end > start && isCrLf(document.getChar(end - 1))) {
        end--;
      }

      var lineText = document.get(start, end - start);
      if (lineText.contains("NOSONAR")) {
        return;
      }

      var insertion = lineText.isBlank() ? "// NOSONAR" : " // NOSONAR";
      unit.applyTextEdit(new InsertEdit(end, insertion), null);
      unit.save(null, true);

    } catch (Exception e) {
      SonarQuickFixResolutionGenerator.log("Could not add // NOSONAR", e);
    }
  }

  private boolean isCrLf(final char c) {
    return c == '\n' || c == '\r';
  }
}