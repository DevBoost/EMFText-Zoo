package org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis;

public class StateActionsReferenceResolver implements org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolver<org.emftext.language.martinfowlerdsl.State, org.emftext.language.martinfowlerdsl.Command> {
	
	private org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.State, org.emftext.language.martinfowlerdsl.Command> delegate = new org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.analysis.MartinfowlerdslDefaultResolverDelegate<org.emftext.language.martinfowlerdsl.State, org.emftext.language.martinfowlerdsl.Command>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.martinfowlerdsl.State container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.martinfowlerdsl.resource.martinfowlerdsl.IMartinfowlerdslReferenceResolveResult<org.emftext.language.martinfowlerdsl.Command> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.martinfowlerdsl.Command element, org.emftext.language.martinfowlerdsl.State container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
