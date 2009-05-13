package org.emftext.language.template_concepts.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.call.TemplateCall;
import org.emftext.language.template_concepts.call.impl.TemplateCallImpl;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterException;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterWrapperError;
import org.emftext.language.template_concepts.interpreter.exceptions.TemplateException;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;

public class Interpreter implements IOptionProvider, IResourcePostProcessorProvider, IResourcePostProcessor {

	public void process(ITextResource resource) {
		if(resource==null||resource.getContents().size()==0) 
				throw new InterpreterWrapperError(
						new TemplateException("textResource is null or empty"));
		TemplateCall tc = (TemplateCall)resource.getContents().get(0);
		EObject paramModel = tc.getParameterModel();
		Template template = tc.getTarget();
		
		InterpreterWState interpreterWithState;
		try {
			interpreterWithState = new InterpreterWState(template,paramModel);
		} catch (InterpreterException e) {
			throw new InterpreterWrapperError(e);
		}
		EObject templateInstanceAST = interpreterWithState.getTemplateInstanceRoot();
		
		// TODO mseifert pritty print templateInstanceAST 
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
