/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlOutlinePageLinkWithEditorAction extends org.emftext.language.prolog.resource.pl.ui.AbstractPlOutlinePageAction {
	
	public PlOutlinePageLinkWithEditorAction(org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
