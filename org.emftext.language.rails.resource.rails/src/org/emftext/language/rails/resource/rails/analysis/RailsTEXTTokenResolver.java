package org.emftext.language.rails.resource.rails.analysis;

public class RailsTEXTTokenResolver implements org.emftext.language.rails.resource.rails.IRailsTokenResolver {
	
	private org.emftext.language.rails.resource.rails.analysis.RailsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rails.resource.rails.analysis.RailsDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rails.resource.rails.IRailsTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
