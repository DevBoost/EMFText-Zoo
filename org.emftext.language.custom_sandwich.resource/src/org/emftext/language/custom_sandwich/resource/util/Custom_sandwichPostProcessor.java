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
package org.emftext.language.custom_sandwich.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.Custom_sandwichEProblemType;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichOptionProvider;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichOptions;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichResourcePostProcessor;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.ICustom_sandwichResourcePostProcessorProvider;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichProblem;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichResource;
import org.emftext.language.template_concepts.ExpressionChecker;

/**
 * Post processor that performs 
 * <i>cast repair</i>,
 * <i>expression simplification</i> and 
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class Custom_sandwichPostProcessor implements ICustom_sandwichOptionProvider, ICustom_sandwichResourcePostProcessor, ICustom_sandwichResourcePostProcessorProvider {
	
	private ExpressionChecker expressionChecker = new ExpressionChecker();
	
	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ICustom_sandwichOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(final Custom_sandwichResource resource) {
		expressionChecker.process(resource, new ExpressionChecker.ErrorReporter() {
			
			public void report(EObject element, String message) {
				resource.addProblem(new Custom_sandwichProblem(message, Custom_sandwichEProblemType.ERROR), element);			
			}
		});
	}

	public ICustom_sandwichResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
