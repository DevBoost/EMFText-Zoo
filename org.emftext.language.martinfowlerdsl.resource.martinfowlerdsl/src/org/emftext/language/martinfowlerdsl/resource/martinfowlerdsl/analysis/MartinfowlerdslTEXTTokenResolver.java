package org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis;

public class MartinfowlerdslTEXTTokenResolver implements org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslTokenResolver {
	
	private org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultTokenResolver defaultTokenResolver = new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
