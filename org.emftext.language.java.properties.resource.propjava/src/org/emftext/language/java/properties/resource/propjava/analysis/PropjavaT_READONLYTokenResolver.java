package org.emftext.language.java.properties.resource.propjava.analysis;

import java.util.Map;

import org.emftext.language.java.properties.resource.propjava.IPropjavaTokenResolveResult;

public class PropjavaT_READONLYTokenResolver implements org.emftext.language.java.properties.resource.propjava.IPropjavaTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value.equals(true)) {
			return "readonly";
		} else {
			return "";
		}
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IPropjavaTokenResolveResult result) {
		if ("readonly".equals(lexem)) {
			result.setResolvedToken(Boolean.TRUE);
		} else {
			result.setResolvedToken(Boolean.FALSE);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
