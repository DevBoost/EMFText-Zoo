package org.emftext.language.uml_class.resource.uml_class.analysis;

public class ParameterTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.Classifier> {
	
	private org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultResolverDelegate<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.Classifier> delegate = new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultResolverDelegate<org.emftext.language.uml_class.Parameter, org.emftext.language.uml_class.Classifier>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.uml_class.Parameter container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.uml_class.Classifier> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.uml_class.Classifier element, org.emftext.language.uml_class.Parameter container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
