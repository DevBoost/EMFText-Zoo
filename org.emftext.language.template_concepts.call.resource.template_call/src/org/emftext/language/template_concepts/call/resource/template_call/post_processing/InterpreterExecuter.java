package org.emftext.language.template_concepts.call.resource.template_call.post_processing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.template_concepts.Template;
import org.emftext.language.template_concepts.call.TemplateCall;
import org.emftext.language.template_concepts.call.resource.template_call.ITemplate_callOptionProvider;
import org.emftext.language.template_concepts.call.resource.template_call.ITemplate_callOptions;
import org.emftext.language.template_concepts.call.resource.template_call.ITemplate_callResourcePostProcessor;
import org.emftext.language.template_concepts.call.resource.template_call.ITemplate_callResourcePostProcessorProvider;
import org.emftext.language.template_concepts.call.resource.template_call.ITemplate_callTextResource;
import org.emftext.language.template_concepts.call.resource.template_call.mopp.Template_callResource;
import org.emftext.language.template_concepts.interpreter.ITemplateInterpreter;
import org.emftext.language.template_concepts.interpreter.TemplateInterpreterFactory;

public class InterpreterExecuter implements ITemplate_callOptionProvider, ITemplate_callResourcePostProcessorProvider, ITemplate_callResourcePostProcessor {

	public void process(Template_callResource resource) {
		if (resource==null || resource.getContents().size() == 0) {
			return;
		}
		TemplateCall tc = (TemplateCall) resource.getContents().get(0);
		final EObject parameterModel = tc.getParameterModel();
		Template template = tc.getTarget();
		ITemplateInterpreter interpreter = TemplateInterpreterFactory.createTemplateInterpreter();
		Collection<Diagnostic> problems = new ArrayList<Diagnostic>();
		EObject templateInstanceAST = interpreter.interprete(template, parameterModel, problems);
		if (problems.size() > 0) {
			for (Diagnostic problem : problems) {
				resource.getErrors().add(problem);
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

	private void saveTemplateInstance(ITemplate_callTextResource resource,
			EObject templateInstanceAST) throws IOException {
		
		if (templateInstanceAST == null) {
			System.out.println("Interpreter.saveTemplateInstance() AST is null.");
			return;
		}
		// figure out the correct file extension for the template instance
		String fileExtension = "unknown";
		// TODO Find different way to resolve object language metamodel (Put into template itself)
		/*String targetNamespace = templateInstanceAST.eClass().getEPackage().getNsURI();
		Map<String, URI> syntaxes = EMFTextRuntimePlugin.getURIToConcreteSyntaxLocationMap();
		for (String syntaxName : syntaxes.keySet()) {
			if (syntaxName.startsWith(targetNamespace + "%%")) {
				fileExtension = syntaxName.split("%%")[1];
			}
		}*/
		// save it
		Resource instance = new ResourceSetImpl().createResource(resource.getURI().trimFileExtension().appendFileExtension(fileExtension));
		instance.getContents().add(templateInstanceAST);
		instance.save(null);
	}

	public ITemplate_callResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(ITemplate_callOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}
}
