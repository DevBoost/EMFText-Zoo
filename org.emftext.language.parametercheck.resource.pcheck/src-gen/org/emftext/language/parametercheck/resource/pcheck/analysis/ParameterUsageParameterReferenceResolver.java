package org.emftext.language.parametercheck.resource.pcheck.analysis;

public class ParameterUsageParameterReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<parametercheck.ParameterUsage, parametercheck.Parameter> {
	
	private org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultResolverDelegate<parametercheck.ParameterUsage, parametercheck.Parameter> delegate = new org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultResolverDelegate<parametercheck.ParameterUsage, parametercheck.Parameter>();
	
	public void resolve(java.lang.String identifier, parametercheck.ParameterUsage container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<parametercheck.Parameter> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(parametercheck.Parameter element, parametercheck.ParameterUsage container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
