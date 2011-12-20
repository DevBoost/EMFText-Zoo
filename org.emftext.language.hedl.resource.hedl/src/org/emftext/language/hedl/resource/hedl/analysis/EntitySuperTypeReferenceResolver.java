/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.analysis;

public class EntitySuperTypeReferenceResolver implements org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver<org.emftext.language.hedl.Entity, org.emftext.language.hedl.Entity> {
	
	private org.emftext.language.hedl.resource.hedl.analysis.HedlDefaultResolverDelegate<org.emftext.language.hedl.Entity, org.emftext.language.hedl.Entity> delegate = new org.emftext.language.hedl.resource.hedl.analysis.HedlDefaultResolverDelegate<org.emftext.language.hedl.Entity, org.emftext.language.hedl.Entity>();
	
	public void resolve(String identifier, org.emftext.language.hedl.Entity container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult<org.emftext.language.hedl.Entity> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.hedl.Entity element, org.emftext.language.hedl.Entity container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
