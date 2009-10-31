package org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis;

public class TransitionTriggerReferenceResolver implements org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolver<org.emftext.language.martinfowlerdsl.Transition, org.emftext.language.martinfowlerdsl.Event> {
	
	private org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.Transition, org.emftext.language.martinfowlerdsl.Event> delegate = new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.Transition, org.emftext.language.martinfowlerdsl.Event>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.martinfowlerdsl.Transition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolveResult<org.emftext.language.martinfowlerdsl.Event> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.martinfowlerdsl.Event element, org.emftext.language.martinfowlerdsl.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
