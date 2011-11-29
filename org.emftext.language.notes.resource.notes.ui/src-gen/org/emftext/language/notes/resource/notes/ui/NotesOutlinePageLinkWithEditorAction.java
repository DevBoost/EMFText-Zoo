/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.ui;

public class NotesOutlinePageLinkWithEditorAction extends org.emftext.language.notes.resource.notes.ui.AbstractNotesOutlinePageAction {
	
	public NotesOutlinePageLinkWithEditorAction(org.emftext.language.notes.resource.notes.ui.NotesOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
