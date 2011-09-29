/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.analysis;

public class PetrinetsPLISTTokenResolver implements org.emftext.language.petrinets.resource.petrinets.IPetrinetsTokenResolver {
	
	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.petrinets.resource.petrinets.IPetrinetsTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
