/*
 * 
 */
package org.emftext.language.secprop.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.emftext.language.secprop.diagram.part.SecpropVisualIDRegistry;

/**
 * @generated
 */
public class SecpropNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 7002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof SecpropNavigatorItem) {
			SecpropNavigatorItem item = (SecpropNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return SecpropVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
