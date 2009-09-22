package org.emftext.language.forms.resource.forms.analysis.helper;

import org.emftext.language.forms.resource.forms.IFormsTokenResolveResult;

public class BooleanAttributeResolver {

	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return feature.getName().substring(0, 1).toLowerCase()
					+ feature.getName().substring(1);
		} else {
			return "";
		}
	}

	public void resolve(java.lang.String lexem,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			IFormsTokenResolveResult result) {
		if (feature.getName().equalsIgnoreCase(lexem)) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}

}
