/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecoredoc.resource.ecoredoc.analysis;

public class EcoredocIDTokenResolver implements org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocTokenResolver {
	
	private org.emftext.language.ecoredoc.resource.ecoredoc.analysis.EcoredocDefaultTokenResolver defaultTokenResolver = new org.emftext.language.ecoredoc.resource.ecoredoc.analysis.EcoredocDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
