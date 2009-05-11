package org.emftext.language.template_concepts.call.resource.template_call.analysis;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.template_concepts.Template;

public class TemplateCallTargetReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.template_concepts.call.TemplateCall, org.emftext.language.template_concepts.Template> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.template_concepts.Template element, org.emftext.language.template_concepts.call.TemplateCall container, org.eclipse.emf.ecore.EReference reference) {
		// TODO
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.template_concepts.call.TemplateCall container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.template_concepts.Template> result) {
		Resource resource = container.eResource();
		URI uri = resource.getURI();
		URI uriWithoutExtension = uri.trimSegments(1);
		URI fileURI = uriWithoutExtension.appendSegment(identifier);
		ResourceSet set = new ResourceSetImpl();
		Resource targetResource = set.createResource(fileURI);
		try {
			targetResource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		List<EObject> contents = targetResource.getContents();
		if (contents == null) {
			return;
		}
		if (contents.size() == 0) {
			return;
		}
		EObject root = contents.get(0);
		if (!(root instanceof Template)) {
			return;
		}
		Template targetTemplate = (Template) root;
		result.addMapping(identifier, targetTemplate);
	}
}
