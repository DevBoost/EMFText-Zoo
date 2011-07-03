package org.emftext.language.javaforms.resource.javaforms;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;
import org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsContextDependentURIFragmentFactory;
import org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsReferenceResolverSwitch;
import org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsResource;

public class JavaformsPostProcessor implements IJavaformsResourcePostProcessor, IJavaformsResourcePostProcessorProvider, IJavaformsOptionProvider {

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IJavaformsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public void process(JavaformsResource resource) {
		processBasic(resource);
	}

	public void processBasic(Resource resource) {
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				assert !targetReference.isMany();

				((JavaformsResource)resource).registerContextDependentProxy(
						new JavaformsContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new JavaformsReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy,
						-1);
			}
		}.repair(resource);

		JavaModelCompletion.complete(resource);
	}

	public IJavaformsResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
