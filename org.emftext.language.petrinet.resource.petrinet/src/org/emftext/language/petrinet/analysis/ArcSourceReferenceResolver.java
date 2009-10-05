package org.emftext.language.petrinet.analysis;

public class ArcSourceReferenceResolver implements org.emftext.language.petrinet.IPetrinetReferenceResolver<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes> {
	
	private org.emftext.language.petrinet.analysis.PetrinetDefaultResolverDelegate<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes> delegate = new org.emftext.language.petrinet.analysis.PetrinetDefaultResolverDelegate<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.RefNodes>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.petrinet.IPetrinetReferenceResolveResult<org.emftext.language.petrinet.RefNodes> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.petrinet.RefNodes element, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
