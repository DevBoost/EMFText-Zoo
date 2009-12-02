/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.sparql.resource.sparql.analysis;

public class RqDEF_PNAME_NSTokenResolver implements org.emftext.language.sparql.resource.sparql.IRqTokenResolver {
	
	private org.emftext.language.sparql.resource.sparql.analysis.RqDefaultTokenResolver defaultTokenResolver = new org.emftext.language.sparql.resource.sparql.analysis.RqDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.sparql.resource.sparql.IRqTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
