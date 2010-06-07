package org.emftext.language.simple_math.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.simple_math.Expression;
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
		TreeIterator<EObject> allContents = resource.getAllContents();
		SimpleMathInterpreter interpreter = new SimpleMathInterpreter();
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			if (eObject instanceof Expression) {
				Expression expression = (Expression) eObject;
				interpreter.addObjectToInterprete(expression);
			}
		}
		SimpleMathContext context = new SimpleMathContext();
		interpreter.interprete(context);
	}
}
