
package org.emftext.language.pacad.resource.pacad.analysis;

public class PacadQUOTED_34_34TokenResolver implements org.emftext.language.pacad.resource.pacad.IPacadTokenResolver {
	
	private org.emftext.language.pacad.resource.pacad.analysis.PacadDefaultTokenResolver defaultTokenResolver = new org.emftext.language.pacad.resource.pacad.analysis.PacadDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.pacad.resource.pacad.IPacadTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
