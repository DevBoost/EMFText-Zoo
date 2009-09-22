package org.emftext.language.km3.resource.km3.analysis;

import java.util.Map;

import org.emftext.language.km3.resource.km3.IKm3TokenResolveResult;
import org.emftext.language.km3.resource.km3.IKm3TokenResolver;

public class Km3CARDINALITYTokenResolver implements IKm3TokenResolver {
	
	private Km3DefaultTokenResolver defaultResolver = new Km3DefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert value instanceof Integer;
		if (((Integer) value).intValue() < 0) {
			return "*";
		} else {
			java.lang.String result = defaultResolver.deResolve(value, feature, container);
			return result;
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IKm3TokenResolveResult result) {
		if ("*".equals(lexem)) {
			result.setResolvedToken(new Integer(-1));
		} else {
			defaultResolver.resolve(lexem, feature, result);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
