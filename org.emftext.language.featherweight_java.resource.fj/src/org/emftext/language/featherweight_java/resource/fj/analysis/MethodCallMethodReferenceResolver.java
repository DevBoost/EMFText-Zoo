package org.emftext.language.featherweight_java.resource.fj.analysis;

public class MethodCallMethodReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.featherweight_java.MethodCall, org.emftext.language.featherweight_java.Method> {
	
	private org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweight_java.MethodCall, org.emftext.language.featherweight_java.Method> delegate = new org.emftext.language.featherweight_java.resource.fj.analysis.FjDefaultResolverDelegate<org.emftext.language.featherweight_java.MethodCall, org.emftext.language.featherweight_java.Method>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.featherweight_java.MethodCall container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.featherweight_java.Method> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.featherweight_java.Method element, org.emftext.language.featherweight_java.MethodCall container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
