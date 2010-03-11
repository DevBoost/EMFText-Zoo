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
package org.emftext.language.templateconcepts.call.resource.templatecall.analysis;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.templateconcepts.call.TemplateCall;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallReferenceResolveResult;
import org.emftext.language.templateconcepts.call.resource.templatecall.ITemplatecallReferenceResolver;

public class TemplateCallParameterModelReferenceResolver implements ITemplatecallReferenceResolver<TemplateCall, EObject> {
	
	public java.lang.String deResolve(EObject element, TemplateCall container, EReference reference) {
		// TODO
		return null;
	}
	
	public void resolve(String identifier, TemplateCall container, EReference reference, int position, boolean resolveFuzzy, ITemplatecallReferenceResolveResult<EObject> result) {
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
		if (!(root instanceof EObject)) {
			return;
		}
		EObject target = (EObject) root;
		result.addMapping(identifier, target);
	}

	public void setOptions(Map<?, ?> options) {
	}
}