package org.emftext.language.threevaluedlogic;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptionProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptions;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlResourcePostProcessor;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlResourcePostProcessorProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlResource;

public class InterpreterProvider implements ITvlOptionProvider, ITvlResourcePostProcessorProvider, ITvlResourcePostProcessor {

	private TVLInterpreter interpreter = new TVLInterpreter();

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ITvlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public ITvlResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(TvlResource resource) {

		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Formula) {
				TreeIterator<EObject> allContents = eObject.eAllContents();
				while (allContents.hasNext()) {
					EObject next = allContents.next();
					if (next instanceof Formula) {
						interprete((Formula) next);
					}
				}
			}
		}
	}

	private void interprete(Formula formula) {
		InterpreterContext context = new InterpreterContext();
		
		TreeIterator<EObject> allContents = formula.eAllContents();
		while (allContents.hasNext()) {
			interpreter.addObjectToInterprete(allContents.next());
		}
		interpreter.addObjectToInterprete(allContents.next());
		interpreter.interprete(context);
		formula.setComputedValue(context.pop());
	}
}
