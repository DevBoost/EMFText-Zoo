/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.analysis;

public class UniqueConstraintPropertiesReferenceResolver implements org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver<org.emftext.language.hedl.UniqueConstraint, org.emftext.language.hedl.Property> {
	
	private org.emftext.language.hedl.resource.hedl.analysis.HedlDefaultResolverDelegate<org.emftext.language.hedl.UniqueConstraint, org.emftext.language.hedl.Property> delegate = new org.emftext.language.hedl.resource.hedl.analysis.HedlDefaultResolverDelegate<org.emftext.language.hedl.UniqueConstraint, org.emftext.language.hedl.Property>();
	
	public void resolve(String identifier, org.emftext.language.hedl.UniqueConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult<org.emftext.language.hedl.Property> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.hedl.Property element, org.emftext.language.hedl.UniqueConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
