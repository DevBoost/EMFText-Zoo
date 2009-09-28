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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java_templates.resource.java_template.IJava_templateReferenceResolveResult;
import org.emftext.language.java_templates.resource.java_template.IJava_templateReferenceResolver;
import org.emftext.language.template_concepts.InputMetaClassReferenceResolver;
import org.emftext.language.template_concepts.Template;

public class TemplateInputMetaClassReferenceResolver implements IJava_templateReferenceResolver<org.emftext.language.template_concepts.Template, EClass> {
	
	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();

	public java.lang.String deResolve(EClass element, org.emftext.language.template_concepts.Template container, EReference reference) {
		return resolverDelegate.deResolve(element, container, reference);
	}
	
	public void resolve(String identifier, Template container, EReference reference, int position, boolean resolveFuzzy, IJava_templateReferenceResolveResult<EClass> result) {
		EClass resolved = resolverDelegate.resolve(identifier, container, reference, position, resolveFuzzy);
		if (resolved != null) {
			result.addMapping(identifier, resolved);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
