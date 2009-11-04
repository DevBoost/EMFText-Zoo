/*******************************************************************************
 * Copyright (c) 2006-2009 
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
