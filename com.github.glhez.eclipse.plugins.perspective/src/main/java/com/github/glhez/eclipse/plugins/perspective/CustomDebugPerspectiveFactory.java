package com.github.glhez.eclipse.plugins.perspective;

import static com.github.glhez.eclipse.plugins.perspective.ViewIds.ID_TEST_RESULT_VIEW;
import static org.eclipse.ui.IPageLayout.BOTTOM;
import static org.eclipse.ui.IPageLayout.LEFT;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

public class CustomDebugPerspectiveFactory implements IPerspectiveFactory {
  private static final String ID_BOTTOM_LEFT_FOLDER = "com.github.glhez.eclipse.plugins.perspective.debug.folder.bottomLeft";
  private static final String ID_BOTTOM_RIGHT_FOLDER = "com.github.glhez.eclipse.plugins.perspective.debug.folder.bottomRight";
  private static final String ID_TOP_LEFT_FOLDER = "com.github.glhez.eclipse.plugins.perspective.debug.folder.topLeft";

  @Override
  public void createInitialLayout(final IPageLayout layout) {
    configureFolder(layout);
    CustomJavaPerspectiveFactory.configureActionSet(layout);
    CustomJavaPerspectiveFactory.configureShowViewShortcut(layout);
  }

  private void configureFolder(final IPageLayout layout) {
    final IFolderLayout bl = layout.createFolder(ID_BOTTOM_LEFT_FOLDER, BOTTOM, 0.70f, layout.getEditorArea());
    bl.addView(IPageLayout.ID_PROBLEM_VIEW);
    bl.addView(JavaUI.ID_JAVADOC_VIEW);
    bl.addPlaceholder(NewSearchUI.SEARCH_VIEW_ID);
    bl.addView(IConsoleConstants.ID_CONSOLE_VIEW);

    final IFolderLayout br = layout.createFolder(ID_BOTTOM_RIGHT_FOLDER, LEFT, 0.50f, ID_BOTTOM_LEFT_FOLDER);
    br.addView(IDebugUIConstants.ID_VARIABLE_VIEW);
    br.addView(IDebugUIConstants.ID_BREAKPOINT_VIEW);
    br.addView(IDebugUIConstants.ID_EXPRESSION_VIEW);
    br.addView(IDebugUIConstants.ID_REGISTER_VIEW);
    br.addView(IDebugUIConstants.ID_MEMORY_VIEW);
    br.addPlaceholder("*");

    final IFolderLayout tl = layout.createFolder(ID_TOP_LEFT_FOLDER, LEFT, 0.30f, layout.getEditorArea());
    tl.addView(IDebugUIConstants.ID_DEBUG_VIEW);
    tl.addPlaceholder(JavaUI.ID_PACKAGES);
    tl.addPlaceholder(IPageLayout.ID_OUTLINE);
    tl.addPlaceholder(ID_TEST_RESULT_VIEW);
  }
}
