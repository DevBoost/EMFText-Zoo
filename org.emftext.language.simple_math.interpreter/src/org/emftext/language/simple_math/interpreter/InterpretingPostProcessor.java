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
		while (allContents.hasNext()) {
			EObject eObject = allContents.next();
			// interprete eObject
			if (eObject instanceof Expression) {
				Expression expression = (Expression) eObject;
				SimpleMathInterpreter interpreter = new SimpleMathInterpreter();
				
				interpreter.addObjectToInterprete(expression);
				TreeIterator<EObject> children = expression.eAllContents();
				while (children.hasNext()) {
					EObject child = (EObject) children.next();
					interpreter.addObjectToInterprete(child);
				}

				SimpleMathContext context = new SimpleMathContext();
				interpreter.interprete(context);
				expression.setValue(context.pop());
			}
		}
	}
}