/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.eag.resource.eag.analysis;

public class EagIDENTIFIERTokenResolver implements org.emftext.language.eag.resource.eag.IEagTokenResolver {
	
	private org.emftext.language.eag.resource.eag.analysis.EagDefaultTokenResolver defaultTokenResolver = new org.emftext.language.eag.resource.eag.analysis.EagDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.eag.resource.eag.IEagTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
