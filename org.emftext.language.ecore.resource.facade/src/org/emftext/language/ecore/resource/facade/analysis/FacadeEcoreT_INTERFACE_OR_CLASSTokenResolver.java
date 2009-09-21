package org.emftext.language.ecore.resource.facade.analysis;

import java.util.Map;

import org.emftext.language.ecore.resource.facade.IFacadeEcoreTokenResolveResult;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreTokenResolver;

public class FacadeEcoreT_INTERFACE_OR_CLASSTokenResolver implements IFacadeEcoreTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			org.eclipse.emf.ecore.EObject container) {
		if ((Boolean) value) {
			return "interface";
		} else {
			return "class";
		}
	}

	public void resolve(java.lang.String lexem,
			org.eclipse.emf.ecore.EStructuralFeature feature,
			IFacadeEcoreTokenResolveResult result) {
		if (feature.getName().equalsIgnoreCase(lexem)) {
			result.setResolvedToken(true);
		} else {
			result.setResolvedToken(false);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
