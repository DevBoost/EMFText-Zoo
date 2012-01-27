/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlOutlinePageExpandAllAction extends org.emftext.language.prolog.resource.pl.ui.AbstractPlOutlinePageAction {
	
	public PlOutlinePageExpandAllAction(org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
