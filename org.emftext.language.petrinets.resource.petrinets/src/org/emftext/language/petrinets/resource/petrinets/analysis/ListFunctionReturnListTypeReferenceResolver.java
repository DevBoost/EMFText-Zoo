/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.petrinets.resource.petrinets.analysis;

public class ListFunctionReturnListTypeReferenceResolver implements org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolver<org.emftext.language.petrinets.ListFunction, org.emftext.language.petrinets.PGenericType> {
	
	private org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.ListFunction, org.emftext.language.petrinets.PGenericType> delegate = new org.emftext.language.petrinets.resource.petrinets.analysis.PetrinetsDefaultResolverDelegate<org.emftext.language.petrinets.ListFunction, org.emftext.language.petrinets.PGenericType>();
	
	public void resolve(String identifier, org.emftext.language.petrinets.ListFunction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.petrinets.resource.petrinets.IPetrinetsReferenceResolveResult<org.emftext.language.petrinets.PGenericType> result) {
		TypeResolver.getInstance().resolve(identifier, container, result);
	}
	
	public String deResolve(org.emftext.language.petrinets.PGenericType element, org.emftext.language.petrinets.ListFunction container, org.eclipse.emf.ecore.EReference reference) {
		return TypeResolver.getInstance().deResolve(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
