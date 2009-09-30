package org.emftext.language.uml_class.resource.uml_class.analysis;

public class ParameterTypeReferenceResolver implements org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolver<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.XClass> {
	
	private org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultResolverDelegate<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.XClass> delegate = new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultResolverDelegate<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.XClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.uml_class.Parameter container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.uml_class.resource.uml_class.IUml_classReferenceResolveResult<org.emftext.language.uml_class.XClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.uml_class.XClass element, org.emftext.language.uml_class.Parameter container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
