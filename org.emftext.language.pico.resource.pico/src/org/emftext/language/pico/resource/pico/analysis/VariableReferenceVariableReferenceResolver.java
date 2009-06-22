package org.emftext.language.pico.resource.pico.analysis;

public class VariableReferenceVariableReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.pico.VariableReference, org.emftext.language.pico.IDType> {
	
	private org.emftext.language.pico.resource.pico.analysis.PicoDefaultResolverDelegate<org.emftext.language.pico.VariableReference, org.emftext.language.pico.IDType> delegate = new org.emftext.language.pico.resource.pico.analysis.PicoDefaultResolverDelegate<org.emftext.language.pico.VariableReference, org.emftext.language.pico.IDType>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.pico.VariableReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.pico.IDType> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.pico.IDType element, org.emftext.language.pico.VariableReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
