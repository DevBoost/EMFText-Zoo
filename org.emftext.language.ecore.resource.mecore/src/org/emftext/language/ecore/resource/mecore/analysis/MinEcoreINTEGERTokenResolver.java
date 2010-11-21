/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.mecore.analysis;

public class MinEcoreINTEGERTokenResolver implements org.emftext.language.ecore.resource.mecore.IMinEcoreTokenResolver {
	
	private org.emftext.language.ecore.resource.mecore.analysis.MinEcoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.ecore.resource.mecore.analysis.MinEcoreDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.ecore.resource.mecore.IMinEcoreTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
