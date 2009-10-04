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
package org.emftext.language.java_templates.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;
import org.emftext.language.java_templates.resource.java_template.IJava_templateOptionProvider;
import org.emftext.language.java_templates.resource.java_template.IJava_templateOptions;
import org.emftext.language.java_templates.resource.java_template.IJava_templateResourcePostProcessor;
import org.emftext.language.java_templates.resource.java_template.IJava_templateResourcePostProcessorProvider;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateContextDependentURIFragmentFactory;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateReferenceResolverSwitch;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateResource;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class Java_templatePostProcessor implements IJava_templateOptionProvider, IJava_templateResourcePostProcessor, IJava_templateResourcePostProcessorProvider {
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJava_templateOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(Java_templateResource resource) {
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				((Java_templateResource)resource).registerContextDependentProxy(
						new Java_templateContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new Java_templateReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy);
			}
		}.repair(resource);
		
		JavaModelCompletion.complete(resource);
	}

	public IJava_templateResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
