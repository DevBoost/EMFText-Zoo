/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.appflow.resource.appflow.analysis;

public class AppflowTEXTTokenResolver implements org.emftext.language.appflow.resource.appflow.IAppflowTokenResolver {
	
	private org.emftext.language.appflow.resource.appflow.analysis.AppflowDefaultTokenResolver defaultTokenResolver = new org.emftext.language.appflow.resource.appflow.analysis.AppflowDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.appflow.resource.appflow.IAppflowTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
