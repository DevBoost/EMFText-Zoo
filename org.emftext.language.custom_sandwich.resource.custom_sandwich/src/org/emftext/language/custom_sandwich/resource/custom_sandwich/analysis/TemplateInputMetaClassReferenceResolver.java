package org.emftext.language.custom_sandwich.resource.custom_sandwich.analysis;

import org.emftext.language.template_concepts.InputMetaClassReferenceResolver;

public class TemplateInputMetaClassReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EObject> {
	
	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return resolverDelegate.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		resolverDelegate.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
