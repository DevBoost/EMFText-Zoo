package org.emftext.language.parametercheck.resource.pcheck.analysis;

public class DeclaredParameterParameterReferenceResolver implements org.emftext.language.parametercheck.resource.pcheck.IPcheckReferenceResolver<parametercheck.DeclaredParameter, parametercheck.ParameterDecl> {
	
	private org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultResolverDelegate<parametercheck.DeclaredParameter, parametercheck.ParameterDecl> delegate = new org.emftext.language.parametercheck.resource.pcheck.analysis.PcheckDefaultResolverDelegate<parametercheck.DeclaredParameter, parametercheck.ParameterDecl>();
	
	public void resolve(java.lang.String identifier, parametercheck.DeclaredParameter container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.parametercheck.resource.pcheck.IPcheckReferenceResolveResult<parametercheck.ParameterDecl> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(parametercheck.ParameterDecl element, parametercheck.DeclaredParameter container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
