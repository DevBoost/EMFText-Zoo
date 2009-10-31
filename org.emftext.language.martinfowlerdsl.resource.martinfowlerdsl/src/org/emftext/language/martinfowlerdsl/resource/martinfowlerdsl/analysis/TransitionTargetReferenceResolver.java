package org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis;

public class TransitionTargetReferenceResolver implements org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolver<org.emftext.language.martinfowlerdsl.Transition, org.emftext.language.martinfowlerdsl.State> {
	
	private org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.Transition, org.emftext.language.martinfowlerdsl.State> delegate = new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.Transition, org.emftext.language.martinfowlerdsl.State>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.martinfowlerdsl.Transition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolveResult<org.emftext.language.martinfowlerdsl.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.martinfowlerdsl.State element, org.emftext.language.martinfowlerdsl.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
