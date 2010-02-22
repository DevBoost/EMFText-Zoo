package org.emftext.language.threevaluedlogic;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptionProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptions;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlResourcePostProcessor;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlResourcePostProcessorProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlResource;

public class InterpreterProvider implements ITvlOptionProvider, ITvlResourcePostProcessorProvider, ITvlResourcePostProcessor {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ITvlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public ITvlResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(TvlResource resource) {
		TVLInterpreter interpreter = new TVLInterpreter();
		InterpreterContext context = new InterpreterContext();
		
		TreeIterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof Formula) {
				interpreter.addObjectToInterprete(next);
			}
		}
		interpreter.interprete(context);
	}

//	private void interprete(Formula formula) {
//		
//		
//		TreeIterator<EObject> allContents = formula.eAllContents();
//		while (allContents.hasNext()) {
//			interpreter.addObjectToInterprete(allContents.next());
//		}
//		
//		formula.setComputedValue(context.pop());
//	}
}
