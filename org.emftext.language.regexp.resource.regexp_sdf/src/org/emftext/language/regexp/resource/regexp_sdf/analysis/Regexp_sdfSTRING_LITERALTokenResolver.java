package org.emftext.language.regexp.resource.regexp_sdf.analysis;

public class Regexp_sdfSTRING_LITERALTokenResolver implements org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTokenResolver {
	
	private org.emftext.language.regexp.resource.regexp_sdf.analysis.Regexp_sdfDefaultTokenResolver defaultTokenResolver = new org.emftext.language.regexp.resource.regexp_sdf.analysis.Regexp_sdfDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
