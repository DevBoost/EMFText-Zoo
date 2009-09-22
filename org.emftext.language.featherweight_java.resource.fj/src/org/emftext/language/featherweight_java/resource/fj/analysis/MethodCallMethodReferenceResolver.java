package org.emftext.language.featherweight_java.resource.fj.analysis;

//TODO this resolver needs customization
public class MethodCallMethodReferenceResolver implements org.emftext.language.featherweight_java.resource.fj.IFjReferenceResolver<org.emftext.language.featherweight_java.MethodCall, org.emftext.language.featherweight_java.Method> {
	
	private org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweight_java.MethodCall, org.emftext.language.featherweight_java.Method> delegate = new org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweight_java.MethodCall, org.emftext.language.featherweight_java.Method>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.featherweight_java.MethodCall container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.featherweight_java.resource.fj.IFjReferenceResolveResult<org.emftext.language.featherweight_java.Method> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.featherweight_java.Method element, org.emftext.language.featherweight_java.MethodCall container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		
	}
	
}
