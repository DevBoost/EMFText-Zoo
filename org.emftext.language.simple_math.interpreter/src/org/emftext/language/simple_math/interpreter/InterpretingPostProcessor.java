package org.emftext.language.simple_math.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.simple_math.Root;
import org.emftext.language.simple_math.resource.sm.ISmOptionProvider;
import org.emftext.language.simple_math.resource.sm.ISmOptions;
import org.emftext.language.simple_math.resource.sm.ISmResourcePostProcessor;
import org.emftext.language.simple_math.resource.sm.ISmResourcePostProcessorProvider;
import org.emftext.language.simple_math.resource.sm.mopp.SmResource;

public class InterpretingPostProcessor implements ISmOptionProvider, ISmResourcePostProcessorProvider, ISmResourcePostProcessor {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ISmOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public ISmResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(SmResource resource) {
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Root) {
				Root root = (Root) eObject;
				SimpleMathInterpreter interpreter = new SimpleMathInterpreter();
				SimpleMathContext context = new SimpleMathContext();

				interpreter.addObjectToInterprete(root);
				interpreter.interprete(context);
				root.setValue(context.pop());
			}
		}
	}
}
