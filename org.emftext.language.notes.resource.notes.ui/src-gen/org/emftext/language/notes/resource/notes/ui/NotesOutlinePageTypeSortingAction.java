/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public class NotesOutlinePageTypeSortingAction extends org.emftext.language.notes.resource.notes.ui.AbstractNotesOutlinePageAction {
	
	public NotesOutlinePageTypeSortingAction(org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
