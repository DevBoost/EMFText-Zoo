/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.analysis;

public class HedlML_COMMENTTokenResolver implements org.emftext.language.hedl.resource.hedl.IHedlTokenResolver {
	
	private org.emftext.language.hedl.resource.hedl.analysis.HedlDefaultTokenResolver defaultTokenResolver = new org.emftext.language.hedl.resource.hedl.analysis.HedlDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.hedl.resource.hedl.IHedlTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
