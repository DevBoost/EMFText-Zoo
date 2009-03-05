package org.eclipse.emf.ecore.resource.ecore.analysis;

import org.eclipse.emf.ecore.resource.ecore.analysis.helper.BooleanAttributeResolver;

public class EcoreT_INTERFACE_OR_CLASSTokenResolver extends BooleanAttributeResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return "interface";
		} else {
			return "class";
		}
	}
	
}