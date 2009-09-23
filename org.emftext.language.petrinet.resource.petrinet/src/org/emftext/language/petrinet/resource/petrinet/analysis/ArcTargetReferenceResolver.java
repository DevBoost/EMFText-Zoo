package org.emftext.language.petrinet.resource.petrinet.analysis;

public class ArcTargetReferenceResolver implements org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolver<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.XNode> {
	
	private org.emftext.language.petrinet.resource.petrinet.analysis.PetrinetDefaultResolverDelegate<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.XNode> delegate = new org.emftext.language.petrinet.resource.petrinet.analysis.PetrinetDefaultResolverDelegate<org.emftext.language.petrinet.Arc, org.emftext.language.petrinet.XNode>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolveResult<org.emftext.language.petrinet.XNode> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.petrinet.XNode element, org.emftext.language.petrinet.Arc container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
