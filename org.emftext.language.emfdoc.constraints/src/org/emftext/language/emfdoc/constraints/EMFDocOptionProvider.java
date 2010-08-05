package org.emftext.language.emfdoc.constraints;

import java.util.Collections;
import java.util.Map;

import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocOptionProvider;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocOptions;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocResourcePostProcessor;
import org.emftext.language.emfdoc.resource.emfdoc.IEmfdocResourcePostProcessorProvider;

public class EMFDocOptionProvider implements IEmfdocOptionProvider, IEmfdocResourcePostProcessorProvider {

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IEmfdocOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public IEmfdocResourcePostProcessor getResourcePostProcessor() {
		return new EMFDocConstraintChecker();
	}
}
