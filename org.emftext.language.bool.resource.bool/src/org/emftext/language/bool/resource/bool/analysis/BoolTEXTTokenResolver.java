package org.emftext.language.bool.resource.bool.analysis;

import java.util.Map;

import org.emftext.language.bool.resource.bool.IBoolTokenResolveResult;
import org.emftext.language.bool.resource.bool.IBoolTokenResolver;

public class BoolTEXTTokenResolver implements IBoolTokenResolver {
	
	private BoolDefaultTokenResolver defaultResolver = new BoolDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IBoolTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
