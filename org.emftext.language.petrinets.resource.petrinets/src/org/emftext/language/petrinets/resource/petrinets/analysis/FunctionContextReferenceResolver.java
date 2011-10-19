/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.analysis;

public class FunctionContextReferenceResolver implements org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolver<org.emftext.language.petrinets.Function, org.eclipse.emf.ecore.EClassifier> {
	
	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.Function, org.eclipse.emf.ecore.EClassifier> delegate = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.Function, org.eclipse.emf.ecore.EClassifier>();
	
	public void resolve(String identifier, org.emftext.language.petrinets.Function container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		TypeResolver.getInstance().resolve(identifier, container, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClassifier element, org.emftext.language.petrinets.Function container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
