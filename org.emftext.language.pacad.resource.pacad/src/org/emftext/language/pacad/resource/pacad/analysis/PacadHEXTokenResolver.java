
package org.emftext.language.pacad.resource.pacad.analysis;

public class PacadHEXTokenResolver implements org.emftext.language.pacad.resource.pacad.IPacadTokenResolver {
	
	private org.emftext.language.pacad.resource.pacad.analysis.PacadDefaultTokenResolver defaultTokenResolver = new org.emftext.language.pacad.resource.pacad.analysis.PacadDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.pacad.resource.pacad.IPacadTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
