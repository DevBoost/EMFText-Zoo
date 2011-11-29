/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public class NotesOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.language.notes.resource.notes.ui.NotesOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.notes.resource.notes.ui.NotesOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.notes.resource.notes.ui.NotesOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.notes.resource.notes.ui.NotesOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.notes.resource.notes.ui.NotesOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
