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
import org.emftext.language.java_templates.resource.java_template.Java_templateEProblemType;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateContextDependentURIFragmentFactory;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateProblem;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateReferenceResolverSwitch;
import org.emftext.language.java_templates.resource.java_template.mopp.Java_templateResource;
import org.emftext.language.template_concepts.ExpressionChecker;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class Java_templatePostProcessor implements IJava_templateOptionProvider, IJava_templateResourcePostProcessor, IJava_templateResourcePostProcessorProvider {
	
	private ExpressionChecker expressionChecker = new ExpressionChecker();
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJava_templateOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(final Java_templateResource resource) {
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
		expressionChecker.process(resource, new ExpressionChecker.ErrorReporter() {
			
			public void report(EObject element, String message) {
				resource.addProblem(new Java_templateProblem(message, Java_templateEProblemType.ERROR), element);			
			}
		});
	}

	public IJava_templateResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
