package org.emftext.language.km3.resource.km3.analysis.helper;

import java.util.Map;

import org.emftext.language.km3.resource.km3.IKm3TokenResolveResult;
import org.emftext.language.km3.resource.km3.IKm3TokenResolver;

public abstract class BooleanKeywordTokenResolver implements IKm3TokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (Boolean.TRUE.equals(value)) {
			return getKeyword();
		} else {
			return "";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IKm3TokenResolveResult result) {
		if (getKeyword().equals(lexem)) {
			result.setResolvedToken(Boolean.TRUE);
		}
	}

	public abstract String getKeyword();

	public void setOptions(Map<?, ?> options) {
		// do nothing
	}
}
