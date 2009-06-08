package org.emftext.language.valueflow.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.emftext.language.valueflow.diagram.part.ValueflowVisualIDRegistry;

/**
 * @generated
 */
public class ValueflowNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5003;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 5002;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof ValueflowNavigatorItem) {
			ValueflowNavigatorItem item = (ValueflowNavigatorItem) element;
			if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return ValueflowVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
