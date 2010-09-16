/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.eocl.resource.eocl.analysis;

public class EoclT_IDTokenResolver implements org.emftext.language.eocl.resource.eocl.IEoclTokenResolver {
	
	private org.emftext.language.eocl.resource.eocl.analysis.EoclDefaultTokenResolver defaultTokenResolver = new org.emftext.language.eocl.resource.eocl.analysis.EoclDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.eocl.resource.eocl.IEoclTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
