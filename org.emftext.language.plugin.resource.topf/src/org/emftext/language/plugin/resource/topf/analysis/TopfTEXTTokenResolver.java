package org.emftext.language.plugin.resource.topf.analysis;

import java.util.Map;

import org.emftext.language.plugin.resource.topf.ITopfTokenResolveResult;
import org.emftext.language.plugin.resource.topf.ITopfTokenResolver;

public class TopfTEXTTokenResolver implements ITopfTokenResolver {
	
	private TopfDefaultTokenResolver defaultResolver = new TopfDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ITopfTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
