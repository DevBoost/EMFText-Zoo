package org.emftext.language.pico.resource.pico.analysis;

import java.util.Map;

import org.emftext.language.pico.resource.pico.IPicoTokenResolveResult;
import org.emftext.language.pico.resource.pico.IPicoTokenResolver;

public class PicoPICOIDTokenResolver implements IPicoTokenResolver {
	
	private PicoDefaultTokenResolver defaultResolver = new PicoDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IPicoTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
