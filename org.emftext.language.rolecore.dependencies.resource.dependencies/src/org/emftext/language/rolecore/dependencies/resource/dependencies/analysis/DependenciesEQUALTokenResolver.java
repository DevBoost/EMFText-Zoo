/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

public class DependenciesEQUALTokenResolver implements org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesTokenResolver {
	
	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultTokenResolver defaultTokenResolver = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value.toString().equals("true"))
			return ":=";
		return "";
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesTokenResolveResult result) {
		if (lexem.equals(":="))
			result.setResolvedToken(true);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
