package org.emftext.language.tbool.resource.tbool.analysis;

public class TemplateInputMetaClassReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.language.tbool.resource.tbool.analysis.TboolDefaultResolverDelegate<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.language.tbool.resource.tbool.analysis.TboolDefaultResolverDelegate<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
