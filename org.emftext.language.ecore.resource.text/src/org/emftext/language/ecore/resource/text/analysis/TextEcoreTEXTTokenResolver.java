package org.emftext.language.ecore.resource.text.analysis;

import java.util.Map;

import org.emftext.language.ecore.resource.text.ITextEcoreTokenResolveResult;
import org.emftext.language.ecore.resource.text.ITextEcoreTokenResolver;

public class TextEcoreTEXTTokenResolver implements ITextEcoreTokenResolver {
	
	private TextEcoreDefaultTokenResolver defaultResolver = new TextEcoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ITextEcoreTokenResolveResult result) {
		defaultResolver.resolve(lexem, feature, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
