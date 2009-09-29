package org.emftext.language.project.resource.project.analysis;

public class ConnectionTargetReferenceResolver implements org.emftext.language.project.resource.project.IProjectReferenceResolver<org.emftext.language.project.Connection, org.emftext.language.project.In> {
	
	private org.emftext.language.project.resource.project.analysis.ProjectDefaultResolverDelegate<org.emftext.language.project.Connection, org.emftext.language.project.In> delegate = new org.emftext.language.project.resource.project.analysis.ProjectDefaultResolverDelegate<org.emftext.language.project.Connection, org.emftext.language.project.In>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.project.Connection container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.project.resource.project.IProjectReferenceResolveResult<org.emftext.language.project.In> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.project.In element, org.emftext.language.project.Connection container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
