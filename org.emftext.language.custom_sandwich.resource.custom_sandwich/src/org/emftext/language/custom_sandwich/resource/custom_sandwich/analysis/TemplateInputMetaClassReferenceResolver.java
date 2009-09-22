package org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis;

public class TemplateInputMetaClassReferenceResolver implements org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EClass> {
	
	private org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis.Custom_sandwichDefaultResolverDelegate<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis.Custom_sandwichDefaultResolverDelegate<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
