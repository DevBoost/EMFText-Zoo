package org.emftext.language.customer.resource.customer.analysis;

public class CustomerTEXTTokenResolver implements org.emftext.language.customer.resource.customer.ICustomerTokenResolver {
	
	private org.emftext.language.customer.resource.customer.analysis.CustomerDefaultTokenResolver defaultTokenResolver = new org.emftext.language.customer.resource.customer.analysis.CustomerDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.customer.resource.customer.ICustomerTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
