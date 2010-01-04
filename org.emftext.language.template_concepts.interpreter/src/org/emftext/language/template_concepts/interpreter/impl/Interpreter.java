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
package org.emftext.language.template_concepts.interpreter.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.interpreter.ITemplateInterpreter;

public class Interpreter implements ITemplateInterpreter {

	public EObject interprete(Template template, EObject paramModel, Collection<Diagnostic> problems) {
		try {
			final EClass inputMetaClass = template.getInputMetaClass();
			if (inputMetaClass == null) {
				//model incomplete
				return null;
			}
			
			// the interpreter must check whether the loaded input model
			// really confirms to the type expected by the template
			boolean parameterModelFits = inputMetaClass.isInstance(paramModel);
			if (!parameterModelFits) {
				addError(problems, "Input model has wrong type (expected: " + inputMetaClass.getName() + ", but was: " + paramModel.eClass().getName() + ")");
				return null;
			}
			InterpreterWithState interpreterWithState = new InterpreterWithState(template, paramModel);
			EObject templateInstanceAST = interpreterWithState.getTemplateInstanceRoot();
			return templateInstanceAST;
		} catch (Exception e) {
			e.printStackTrace();
			addError(problems, e.getMessage());
			return null;
		}
	}

	private void addError(Collection<Diagnostic> problems,
			final String message) {
		problems.add(new Diagnostic() {
			
			public String getMessage() {
				return message;
			}
			
			public String getLocation() {
				return null;
			}
			
			public int getLine() {
				return 0;
			}
			
			public int getColumn() {
				return 0;
			}
		});
	}
}
