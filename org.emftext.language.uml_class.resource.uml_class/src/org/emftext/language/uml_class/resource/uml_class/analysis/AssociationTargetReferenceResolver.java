package org.emftext.language.uml_class.resource.uml_class.analysis;

public class AssociationTargetReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.uml_class.Association, org.emftext.language.uml_class.Class> {
	
	private org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultResolverDelegate<org.emftext.language.uml_class.Association, org.emftext.language.uml_class.Class> delegate = new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultResolverDelegate<org.emftext.language.uml_class.Association, org.emftext.language.uml_class.Class>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.uml_class.Association container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.uml_class.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.uml_class.Class element, org.emftext.language.uml_class.Association container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
