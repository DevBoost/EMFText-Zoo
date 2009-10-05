package org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.template_concepts.InputMetaClassReferenceResolver;

public class TemplateInputMetaClassReferenceResolver implements org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EClass> {
	
	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EClass resolved = resolverDelegate.resolve(identifier, container, reference, position, resolveFuzzy);
		if (resolved != null) {
			result.addMapping(identifier, resolved);
		}
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return resolverDelegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {}
	
}
