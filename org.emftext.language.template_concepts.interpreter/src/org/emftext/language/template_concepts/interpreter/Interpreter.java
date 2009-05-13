package org.emftext.language.template_concepts.interpreter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.call.TemplateCall;
import org.emftext.language.template_concepts.interpreter.exceptions.InterpreterException;
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
			if(resource==null||resource.getContents().size()==0) 
					throw new InterpreterWrapperException(
							new TemplateException("textResource is null or empty"));
			TemplateCall tc = (TemplateCall)resource.getContents().get(0);
			EObject paramModel = tc.getParameterModel();
			Template template = tc.getTarget();
			InterpreterWState interpreterWithState;
			try {
				interpreterWithState = new InterpreterWState(template,paramModel);
			} catch (InterpreterException e) {
				throw new InterpreterWrapperException(e);
			}
			EObject templateInstanceAST = interpreterWithState.getTemplateInstanceRoot();
			
			// pretty print templateInstanceAST
			saveTemplateInstance(resource, templateInstanceAST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void saveTemplateInstance(ITextResource resource,
			EObject templateInstanceAST) throws IOException {
		
		// figure out the correct file extension for the template instance
		String fileExtension = "unknown";
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
