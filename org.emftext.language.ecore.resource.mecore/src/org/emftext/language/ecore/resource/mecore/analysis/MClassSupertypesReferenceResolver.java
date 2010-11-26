/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.mecore.analysis;

public class MClassSupertypesReferenceResolver implements org.emftext.language.ecore.resource.mecore.IMinEcoreReferenceResolver<org.emftext.language.mecore.MClass, org.emftext.language.mecore.MClass> {
	
	private org.emftext.language.ecore.resource.mecore.analysis.MinEcoreDefaultResolverDelegate<org.emftext.language.mecore.MClass, org.emftext.language.mecore.MClass> delegate = new org.emftext.language.ecore.resource.mecore.analysis.MinEcoreDefaultResolverDelegate<org.emftext.language.mecore.MClass, org.emftext.language.mecore.MClass>();
	
	public void resolve(String identifier, org.emftext.language.mecore.MClass container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.ecore.resource.mecore.IMinEcoreReferenceResolveResult<org.emftext.language.mecore.MClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.mecore.MClass element, org.emftext.language.mecore.MClass container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
