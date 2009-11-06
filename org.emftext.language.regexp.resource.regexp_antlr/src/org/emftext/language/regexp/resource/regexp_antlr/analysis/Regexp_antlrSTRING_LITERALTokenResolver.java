package org.emftext.language.regexp.resource.regexp_antlr.analysis;

public class Regexp_antlrSTRING_LITERALTokenResolver implements org.emftext.language.regexp.resource.regexp_antlr.IRegexp_antlrTokenResolver {
	
	private org.emftext.language.regexp.resource.regexp_antlr.analysis.Regexp_antlrDefaultTokenResolver defaultTokenResolver = new org.emftext.language.regexp.resource.regexp_antlr.analysis.Regexp_antlrDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.regexp.resource.regexp_antlr.IRegexp_antlrTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
