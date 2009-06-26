package org.emftext.language.template_concepts.call.resource.template_call.post_processing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.call.TemplateCall;
import org.emftext.language.template_concepts.interpreter.ITemplateInterpreter;
import org.emftext.language.template_concepts.interpreter.TemplateInterpreterFactory;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.IProblem;
import org.emftext.runtime.resource.ITextResource;

public class InterpreterExecuter implements IOptionProvider, IResourcePostProcessorProvider, IResourcePostProcessor {

	public void process(ITextResource resource) {
		if (resource==null || resource.getContents().size() == 0) {
			return;
		}
		TemplateCall tc = (TemplateCall) resource.getContents().get(0);
		final EObject parameterModel = tc.getParameterModel();
		Template template = tc.getTarget();
		ITemplateInterpreter interpreter = TemplateInterpreterFactory.createTemplateInterpreter();
		Collection<IProblem> problems = new ArrayList<IProblem>();
		EObject templateInstanceAST = interpreter.interprete(template, parameterModel, problems);
		if (problems.size() > 0) {
			for (IProblem problem : problems) {
				resource.addProblem(problem, template);
			}
		} else {
			// pretty print templateInstanceAST
			try {
				saveTemplateInstance(resource, templateInstanceAST);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
