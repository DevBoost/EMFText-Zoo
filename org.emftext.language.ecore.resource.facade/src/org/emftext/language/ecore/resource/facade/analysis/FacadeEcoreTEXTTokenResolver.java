package org.emftext.language.ecore.resource.facade.analysis;

import java.util.Map;

import org.emftext.language.ecore.resource.facade.IFacadeEcoreTokenResolveResult;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreTokenResolver;

public class FacadeEcoreTEXTTokenResolver implements IFacadeEcoreTokenResolver {
	
	private FacadeEcoreDefaultTokenResolver defaultResolver = new FacadeEcoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IFacadeEcoreTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
