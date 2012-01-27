/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlOutlinePageTypeSortingAction extends org.emftext.language.prolog.resource.pl.ui.AbstractPlOutlinePageAction {
	
	public PlOutlinePageTypeSortingAction(org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
