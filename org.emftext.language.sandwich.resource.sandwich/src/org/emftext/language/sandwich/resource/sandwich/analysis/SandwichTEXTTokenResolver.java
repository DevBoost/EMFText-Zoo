package org.emftext.language.sandwich.resource.sandwich.analysis;

public class SandwichTEXTTokenResolver implements org.emftext.language.sandwich.resource.sandwich.ISandwichTokenResolver {
	
	private org.emftext.language.sandwich.resource.sandwich.analysis.SandwichDefaultTokenResolver defaultTokenResolver = new org.emftext.language.sandwich.resource.sandwich.analysis.SandwichDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.sandwich.resource.sandwich.ISandwichTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
