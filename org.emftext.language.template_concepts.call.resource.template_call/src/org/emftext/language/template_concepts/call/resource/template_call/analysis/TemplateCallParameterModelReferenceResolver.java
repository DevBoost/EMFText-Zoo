/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.template_concepts.call.resource.template_call.analysis;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class TemplateCallParameterModelReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.template_concepts.call.TemplateCall, org.eclipse.emf.ecore.EObject> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.template_concepts.call.TemplateCall container, org.eclipse.emf.ecore.EReference reference) {
		// TODO
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.template_concepts.call.TemplateCall container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
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
}
