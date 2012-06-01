/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.mecore.resource.mecore.analysis;

public class MTypeParameterLowerBoundReferenceResolver implements org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolver<org.emftext.language.mecore.MTypeParameter, org.emftext.language.mecore.MType> {
	
	private org.emftext.language.mecore.resource.mecore.analysis.MecoreDefaultResolverDelegate<org.emftext.language.mecore.MTypeParameter, org.emftext.language.mecore.MType> delegate = new org.emftext.language.mecore.resource.mecore.analysis.MecoreDefaultResolverDelegate<org.emftext.language.mecore.MTypeParameter, org.emftext.language.mecore.MType>();
	
	public void resolve(String identifier, org.emftext.language.mecore.MTypeParameter container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolveResult<org.emftext.language.mecore.MType> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.mecore.MType element, org.emftext.language.mecore.MTypeParameter container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
