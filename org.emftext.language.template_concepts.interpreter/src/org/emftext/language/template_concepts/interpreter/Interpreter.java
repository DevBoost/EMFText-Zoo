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
package org.emftext.language.template_concepts.interpreter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.call.TemplateCall;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterWrapperException;
import org.emftext.language.template_concepts.interpreter.exceptions.TemplateException;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

public class Interpreter implements IOptionProvider, IResourcePostProcessorProvider, IResourcePostProcessor {

	public void process(ITextResource resource) {
		try {
			if (resource==null || resource.getContents().size() == 0) { 
				throw new InterpreterWrapperException(new TemplateException("textResource is null or empty"));
			}
			TemplateCall tc = (TemplateCall) resource.getContents().get(0);
			EObject paramModel = tc.getParameterModel();
			Template template = tc.getTarget();

			// TODO why is inputMetaClass an EObject and not an EClass?
			EClass inputMetaClass = (EClass) template.getInputMetaClass();
			
			// the interpreter must check whether the loaded input model
			// really confirms to the type expected by the template
			boolean parameterModelFits = inputMetaClass.isInstance(paramModel);
			if (!parameterModelFits) {
				resource.addError("Input model has wrong type (expected: " + inputMetaClass.getName() + ", but was: " + paramModel.eClass().getName() + ")", template);
				return;
			}
			InterpreterWithState interpreterWithState = new InterpreterWithState(template, paramModel);
			EObject templateInstanceAST = interpreterWithState.getTemplateInstanceRoot();
			
			// pretty print templateInstanceAST
			saveTemplateInstance(resource, templateInstanceAST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveTemplateInstance(ITextResource resource,
			EObject templateInstanceAST) throws IOException {
		
		if (templateInstanceAST == null) {
			System.out.println("Interpreter.saveTemplateInstance() AST is null.");
			return;
		}
		// figure out the correct file extension for the template instance
		String fileExtension = "unknown";
		// TODO Find different way to resolve object language metamodel (Put into template itself)
		String targetNamespace = templateInstanceAST.eClass().getEPackage().getNsURI();
		Map<String, URI> syntaxes = EMFTextRuntimePlugin.getURIToConcreteSyntaxLocationMap();
		for (String syntaxName : syntaxes.keySet()) {
			if (syntaxName.startsWith(targetNamespace + "%%")) {
				fileExtension = syntaxName.split("%%")[1];
			}
		}
		// save it
		Resource instance = new ResourceSetImpl().createResource(resource.getURI().trimFileExtension().appendFileExtension(fileExtension));
		instance.getContents().add(templateInstanceAST);
		instance.save(null);
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}
}
