package org.emftext.language.featherweight_java.resource.fj.analysis;

//TODO this resolver needs customization
public class ParameterAccessParameterReferenceResolver implements org.emftext.language.featherweight_java.resource.fj.IFjReferenceResolver<org.emftext.language.featherweight_java.ParameterAccess, org.emftext.language.featherweight_java.Parameter> {
	
	private org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweight_java.ParameterAccess, org.emftext.language.featherweight_java.Parameter> delegate = new org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweight_java.ParameterAccess, org.emftext.language.featherweight_java.Parameter>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.featherweight_java.ParameterAccess container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweight_java.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweight_java.Parameter> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.featherweight_java.Parameter element, org.emftext.language.featherweight_java.ParameterAccess container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		
	}
	
}
