/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.resource.rolecore.analysis;

public class RolecoreIDENTIFIERTokenResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolver {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rolecore.resource.rolecore.IRolecoreTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
