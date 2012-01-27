/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.ui;

public class PlOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.language.prolog.resource.pl.ui.PlOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.prolog.resource.pl.ui.PlOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.prolog.resource.pl.ui.PlOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.prolog.resource.pl.ui.PlOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.prolog.resource.pl.ui.PlOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.prolog.resource.pl.ui.PlOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
