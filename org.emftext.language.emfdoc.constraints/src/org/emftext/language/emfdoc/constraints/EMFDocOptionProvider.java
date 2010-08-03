package org.emftext.language.emfdoc.constraints;

import java.util.Collections;
import java.util.Map;

import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocOptionProvider;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocOptions;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocResourcePostProcessor;
import org.emftext.language.ecoredoc.resource.ecoredoc.IEcoredocResourcePostProcessorProvider;

public class EMFDocOptionProvider implements IEcoredocOptionProvider, IEcoredocResourcePostProcessorProvider {

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IEcoredocOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public IEcoredocResourcePostProcessor getResourcePostProcessor() {
		return new EMFDocConstraintChecker();
	}
}
