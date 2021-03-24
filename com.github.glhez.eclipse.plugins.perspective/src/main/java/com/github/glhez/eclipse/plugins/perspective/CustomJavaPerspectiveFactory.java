package com.github.glhez.eclipse.plugins.perspective;

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

  private static final String ID_ERROR_LOG_VIEW = "org.eclipse.pde.runtime.LogView";

  private static final String ID_TEST_RESULT_VIEW = "org.eclipse.jdt.junit.ResultView";

  private static final String ID_LEFT_TOP_FOLDER = "left";
  private static final String ID_LEFT_BOTTOM_FOLDER = "left-bottom-folder";
  private static final String ID_RIGHT_BOTTOM_FOLDER = "bottom";

  @Override
  public void createInitialLayout(final IPageLayout layout) {
    addTopLeftFolder(layout);
    addBottomLeftFolder(layout);
    addBottomRightFolder(layout);
    addActionSet(layout);
    addShowViewShortcut(layout);
    addNewWizardShortcut(layout);
  }

  private void addActionSet(final IPageLayout layout) {
    layout.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
    layout.addActionSet(JavaUI.ID_ACTION_SET);
    layout.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
    layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
    layout.addActionSet("org.eclipse.eclemma.ui.CoverageActionSet");
  }

  private void addShowViewShortcut(final IPageLayout layout) {
    // a copy of those found in Java perspective
    // views - java
    layout.addShowViewShortcut(JavaUI.ID_PACKAGES);
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

  private void addNewWizardShortcut(final IPageLayout layout) {
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

  private void addBottomRightFolder(final IPageLayout layout) {
    final String id = ID_RIGHT_BOTTOM_FOLDER;
    final IFolderLayout folder = layout.createFolder(id, BOTTOM, (float) 0.75, layout.getEditorArea());
    folder.addView(IPageLayout.ID_PROBLEM_VIEW);
    folder.addView(JavaUI.ID_JAVADOC_VIEW);
    folder.addPlaceholder(NewSearchUI.SEARCH_VIEW_ID);
    folder.addView(IConsoleConstants.ID_CONSOLE_VIEW);
    folder.addView(ID_ERROR_LOG_VIEW);
  }

  private IFolderLayout addBottomLeftFolder(final IPageLayout layout) {
    final String id = ID_LEFT_BOTTOM_FOLDER;
    final IFolderLayout folder = layout.createFolder(id, BOTTOM, (float) 0.75, ID_LEFT_TOP_FOLDER);
    folder.addView(IPageLayout.ID_OUTLINE);
    folder.addPlaceholder(ID_TEST_RESULT_VIEW);
    return folder;
  }

  private IFolderLayout addTopLeftFolder(final IPageLayout layout) {
    final String id = ID_LEFT_TOP_FOLDER;
    final IFolderLayout folder = layout.createFolder(id, LEFT, (float) 0.25, layout.getEditorArea());
    folder.addView(JavaUI.ID_PACKAGES);
    folder.addPlaceholder(IPageLayout.ID_PROJECT_EXPLORER);
    folder.addPlaceholder("org.eclipse.eclemma.ui.CoverageView");
    return folder;
  }
}
