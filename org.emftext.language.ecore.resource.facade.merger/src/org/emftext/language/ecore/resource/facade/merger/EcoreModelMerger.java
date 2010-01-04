/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.ecore.resource.facade.merger;

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
import org.emftext.language.ecore.resource.facade.FacadeEcoreEProblemType;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreOptionProvider;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreOptions;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreProblem;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreResourcePostProcessor;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreResourcePostProcessorProvider;
import org.emftext.language.ecore.resource.facade.IFacadeEcoreTextResource;
import org.emftext.language.ecore.resource.facade.mopp.FacadeEcoreResource;

public class EcoreModelMerger implements IFacadeEcoreResourcePostProcessor,
	IFacadeEcoreResourcePostProcessorProvider, IFacadeEcoreOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IFacadeEcoreOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new EcoreModelMerger());
		return options;
	}

	public void process(FacadeEcoreResource resource) {
		FacadeEcoreResource facadeResource = (FacadeEcoreResource) resource;
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
			addError(facadeResource, "The model can not be a facade for itself. Change the URI.", ePackage);
			return;
		}
		
		ResourceSet rs = new ResourceSetImpl();
		Resource annotatedResource = null;
		try {	
			annotatedResource = rs.getResource(uri, true);
		} catch (Exception e ) {}
		
		if (annotatedResource == null) {
			addError(facadeResource, "Ecore model not found: " + uri.toString(), ePackage);
			return;
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
					addError(facadeResource, "Element '" + element.getName() + "' not decalred", element);
				}
			}
		}
		
		resource.getContents().clear();
		resource.getContents().addAll(EcoreUtil.copyAll(annotatedResource.getContents()));
	}

	private void addError(IFacadeEcoreTextResource resource, final String message,
			EObject cause) {
		resource.addProblem(new IFacadeEcoreProblem() {
			
			public FacadeEcoreEProblemType getType() {
				return FacadeEcoreEProblemType.ERROR;
			}
			
			public String getMessage() {
				return message;
			}
		}, cause);
	}

	public IFacadeEcoreResourcePostProcessor getResourcePostProcessor() {
		return new EcoreModelMerger();
	}


}
