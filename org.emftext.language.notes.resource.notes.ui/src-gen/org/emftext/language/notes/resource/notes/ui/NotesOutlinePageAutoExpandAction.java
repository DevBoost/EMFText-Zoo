/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public class NotesOutlinePageAutoExpandAction extends org.emftext.language.notes.resource.notes.ui.AbstractNotesOutlinePageAction {
	
	public NotesOutlinePageAutoExpandAction(org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
