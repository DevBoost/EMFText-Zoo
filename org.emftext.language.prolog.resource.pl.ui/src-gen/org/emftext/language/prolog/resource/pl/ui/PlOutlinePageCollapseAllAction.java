/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlOutlinePageCollapseAllAction extends org.emftext.language.prolog.resource.pl.ui.AbstractPlOutlinePageAction {
	
	public PlOutlinePageCollapseAllAction(org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer) {
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
