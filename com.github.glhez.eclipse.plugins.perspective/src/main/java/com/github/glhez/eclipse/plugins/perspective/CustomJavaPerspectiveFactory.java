package com.github.glhez.eclipse.plugins.perspective;

import static com.github.glhez.eclipse.plugins.perspective.ViewIds.ID_ERROR_LOG_VIEW;
import static com.github.glhez.eclipse.plugins.perspective.ViewIds.ID_TEST_RESULT_VIEW;
import static com.github.glhez.eclipse.plugins.perspective.ViewIds.ID_WST_SERVER_VIEW;
import static org.eclipse.ui.IPageLayout.BOTTOM;
import static org.eclipse.ui.IPageLayout.LEFT;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.progress.IProgressConstants;

public class CustomJavaPerspectiveFactory implements IPerspectiveFactory {
  private static final String ID_LEFT_TOP_FOLDER = "com.github.glhez.eclipse.plugins.perspective.java.folder.leftTop";
  private static final String ID_LEFT_BOTTOM_FOLDER = "com.github.glhez.eclipse.plugins.perspective.java.folder.leftBottom";
  private static final String ID_RIGHT_BOTTOM_FOLDER = "com.github.glhez.eclipse.plugins.perspective.java.folder.rightBottom";

  @Override
  public void createInitialLayout(final IPageLayout layout) {
    configureFolder(layout);
    configureActionSet(layout);
    configureShowViewShortcut(layout);
    configureNewWizardShortcut(layout);
  }

  private static void configureFolder(final IPageLayout layout) {
    final IFolderLayout lt = layout.createFolder(ID_LEFT_TOP_FOLDER, LEFT, 0.25f, layout.getEditorArea());
    lt.addView(JavaUI.ID_PACKAGES);
    lt.addPlaceholder(IPageLayout.ID_PROJECT_EXPLORER);

    final IFolderLayout lb = layout.createFolder(ID_LEFT_BOTTOM_FOLDER, BOTTOM, 0.75f, ID_LEFT_TOP_FOLDER);
    lb.addView(IPageLayout.ID_OUTLINE);
    lb.addPlaceholder(ID_TEST_RESULT_VIEW);
    lb.addPlaceholder(ID_WST_SERVER_VIEW);

    final IFolderLayout bottom = layout.createFolder(ID_RIGHT_BOTTOM_FOLDER, BOTTOM, 0.75f, layout.getEditorArea());
    bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
    bottom.addView(JavaUI.ID_JAVADOC_VIEW);
    bottom.addPlaceholder(NewSearchUI.SEARCH_VIEW_ID);
    bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
    bottom.addView(ID_ERROR_LOG_VIEW);
    bottom.addView("notepad4e.views.NotepadView");
    // ensure that other view get where they should
    bottom.addPlaceholder("*");
  }

  static void configureActionSet(final IPageLayout layout) {
    layout.addActionSet("org.eclipse.debug.ui.breakpointActionSet");
    layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
    layout.addActionSet(JavaUI.ID_ACTION_SET);
    layout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
    layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
    layout.addActionSet("org.eclipse.eclemma.ui.CoverageActionSet");
  }

  static void configureShowViewShortcut(final IPageLayout layout) {
    // a copy of those found in Java perspective
    // views - java
    layout.addShowViewShortcut(JavaUI.ID_PACKAGES);
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut(JavaUI.ID_TYPE_HIERARCHY);
    layout.addShowViewShortcut(JavaUI.ID_SOURCE_VIEW);
    layout.addShowViewShortcut(JavaUI.ID_JAVADOC_VIEW);

    // views - search
    layout.addShowViewShortcut(NewSearchUI.SEARCH_VIEW_ID);

    // views - debugging
    layout.addShowViewShortcut(IConsoleConstants.ID_CONSOLE_VIEW);

    // views - standard workbench
    layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
    layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
    layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
    layout.addShowViewShortcut(IProgressConstants.PROGRESS_VIEW_ID);
    layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
    layout.addShowViewShortcut(ID_ERROR_LOG_VIEW);
  }

  private static void configureNewWizardShortcut(final IPageLayout layout) {
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewEnumCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewAnnotationCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSnippetFileCreationWizard"); //$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
    layout.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");//$NON-NLS-1$
  }
}
