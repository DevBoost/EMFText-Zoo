package org.emftext.language.regexp.resource.regexp_sdf.analysis;

public class Regexp_sdfSTRING_LITERALTokenResolver implements org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		return "\"" + value + "\"";
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTokenResolveResult result) {
		result.setResolvedToken(lexem.substring(1, lexem.length() - 1));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
