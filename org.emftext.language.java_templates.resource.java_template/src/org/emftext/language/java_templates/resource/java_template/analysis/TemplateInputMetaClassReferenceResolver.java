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
package org.emftext.language.java_templates.resource.java_template.analysis;

import java.util.Map;

import org.emftext.language.template_concepts.InputMetaClassReferenceResolver;

public class TemplateInputMetaClassReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EObject> {
	
	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();

	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return resolverDelegate.deResolve(element, container, reference);
	}
	
	public void resolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		resolverDelegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
