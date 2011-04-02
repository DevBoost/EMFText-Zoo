package org.emftext.language.mecore.postprocessing;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MecorePackage;
import org.emftext.language.mecore.resource.mecore.IMecoreOptionProvider;
import org.emftext.language.mecore.resource.mecore.IMecoreOptions;
import org.emftext.language.mecore.resource.mecore.IMecoreProblem;
import org.emftext.language.mecore.resource.mecore.IMecoreResourcePostProcessor;
import org.emftext.language.mecore.resource.mecore.IMecoreResourcePostProcessorProvider;
import org.emftext.language.mecore.resource.mecore.MecoreEProblemSeverity;
import org.emftext.language.mecore.resource.mecore.MecoreEProblemType;
import org.emftext.language.mecore.resource.mecore.mopp.MecoreProblem;
import org.emftext.language.mecore.resource.mecore.mopp.MecoreResource;
import org.emftext.language.mecore.resource.mecore.util.MecoreEObjectUtil;

public class MEcoreValidator implements IMecoreOptionProvider, IMecoreResourcePostProcessorProvider, IMecoreResourcePostProcessor {

	public void process(MecoreResource resource) {
		List<EObject> internalContents = resource.getContentsInternal();
		for (EObject eObject : internalContents) {
			validate(resource, eObject);
		}
	}

	private void validate(MecoreResource resource, EObject eObject) {
		Collection<MFeature> features = MecoreEObjectUtil.getObjectsByType(eObject.eAllContents(), MecorePackage.eINSTANCE.getMFeature());
		for (MFeature feature : features) {
			if (feature.getType() instanceof MDataType &&
				feature.isReference()) {
				IMecoreProblem problem = new MecoreProblem(
						"Attributes cannot be tagged as non-containment. Remove the tilde.", 
						MecoreEProblemType.ANALYSIS_PROBLEM, 
						MecoreEProblemSeverity.ERROR
				);
				resource.addProblem(problem, feature);
			}
		}
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IMecoreOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public IMecoreResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
