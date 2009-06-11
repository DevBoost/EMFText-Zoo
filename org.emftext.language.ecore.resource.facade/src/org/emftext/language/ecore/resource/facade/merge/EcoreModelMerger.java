package org.emftext.language.ecore.resource.facade.merge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

public class EcoreModelMerger  implements IResourcePostProcessor,
	IResourcePostProcessorProvider, IOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new EcoreModelMerger());
		return options;
	}

	public void process(ITextResource resource) {
		if(resource.getContents().isEmpty()) {
			return;
		}
		if(!(resource.getContents().get(0) instanceof EPackage)) {
			return;
		}
		EPackage ePackage = (EPackage) resource.getContents().get(0);
		URI uri = URI.createURI(ePackage.getNsURI());
		if(ePackage.getNsPrefix() != null) {
			return;
		}
		uri = uri.resolve(resource.getURI());
		
		if (uri.equals(resource.getURI())) {
			resource.addError("The model can not be a facade for itself. Change the URI.", ePackage);
			return;
		}
		
		ResourceSet rs = new ResourceSetImpl();
		Resource annotatedResource = null;
		try {	
			annotatedResource = rs.getResource(uri, true);
		} catch (Exception e ) {}
		
		if (annotatedResource == null) {
			resource.addError("Ecore model not found: " + uri.toString(), ePackage);
		}
		
		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if(next instanceof ENamedElement) {
				ENamedElement element = (ENamedElement) next;
				EObject realElement = annotatedResource.getEObject(resource.getURIFragment(element));
				if (realElement instanceof ENamedElement) {
					((ENamedElement) realElement).getEAnnotations().addAll(element.getEAnnotations());
				}
				else {
					resource.addError("Element '" + element.getName() + "' not decalred", element);
				}
			}
		}
		
		resource.getContents().clear();
		resource.getContents().addAll(EcoreUtil.copyAll(annotatedResource.getContents()));
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return new EcoreModelMerger();
	}


}
