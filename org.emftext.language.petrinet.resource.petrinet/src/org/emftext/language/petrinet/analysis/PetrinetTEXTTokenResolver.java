package org.emftext.language.petrinet.analysis;

public class PetrinetTEXTTokenResolver implements org.emftext.language.petrinet.IPetrinetTokenResolver {
	
	private org.emftext.language.petrinet.analysis.PetrinetDefaultTokenResolver defaultTokenResolver = new org.emftext.language.petrinet.analysis.PetrinetDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.petrinet.IPetrinetTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
