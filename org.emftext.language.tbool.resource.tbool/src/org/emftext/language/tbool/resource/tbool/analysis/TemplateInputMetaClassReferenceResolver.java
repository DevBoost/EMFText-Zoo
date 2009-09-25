package org.emftext.language.tbool.resource.tbool.analysis;

import org.emftext.language.tbool.resource.tbool.ITboolReferenceResolveResult;
import org.emftext.language.tbool.resource.tbool.ITboolReferenceResolver;
import org.emftext.language.template_concepts.InputMetaClassReferenceResolver;

public class TemplateInputMetaClassReferenceResolver implements ITboolReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EClass> {
	
	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ITboolReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		resolverDelegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return resolverDelegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
