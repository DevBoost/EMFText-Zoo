/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public class NotesOutlinePageCollapseAllAction extends org.emftext.language.notes.resource.notes.ui.AbstractNotesOutlinePageAction {
	
	public NotesOutlinePageCollapseAllAction(org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
