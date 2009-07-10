package org.emftext.language.parametercheck.resource.pcheck.analysis;

public class CheckOriginOfCheckReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<parametercheck.Check, parametercheck.OriginOfCheck> {
	
	private org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultResolverDelegate<parametercheck.Check, parametercheck.OriginOfCheck> delegate = new org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultResolverDelegate<parametercheck.Check, parametercheck.OriginOfCheck>();
	
	public void resolve(java.lang.String identifier, parametercheck.Check container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<parametercheck.OriginOfCheck> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(parametercheck.OriginOfCheck element, parametercheck.Check container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
