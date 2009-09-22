package org.emftext.language.km3.resource.km3.analysis;

import java.util.Map;

import org.emftext.language.km3.resource.km3.IKm3TokenResolveResult;
import org.emftext.language.km3.resource.km3.IKm3TokenResolver;

public class Km3QUOTED_34_34TokenResolver implements IKm3TokenResolver {
	
	private Km3DefaultTokenResolver defaultResolver = new Km3DefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultResolver.deResolve(value, feature, container);
		result = result.replaceAll(java.util.regex.Pattern.quote("\""),"\\\\\"");
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IKm3TokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		lexem = lexem.replaceAll("\\\\"+java.util.regex.Pattern.quote("\""),"\"");
		defaultResolver.resolve(lexem, feature, result);
	}


	public void setOptions(Map<?, ?> options) {
	}
}
