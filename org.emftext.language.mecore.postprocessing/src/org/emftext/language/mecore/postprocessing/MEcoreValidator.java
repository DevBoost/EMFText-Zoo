package org.emftext.language.mecore.postprocessing;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.ecore.resource.mecore.IMinEcoreOptionProvider;
import org.emftext.language.ecore.resource.mecore.IMinEcoreOptions;
import org.emftext.language.ecore.resource.mecore.IMinEcoreProblem;
import org.emftext.language.ecore.resource.mecore.IMinEcoreResourcePostProcessor;
import org.emftext.language.ecore.resource.mecore.IMinEcoreResourcePostProcessorProvider;
import org.emftext.language.ecore.resource.mecore.MinEcoreEProblemSeverity;
import org.emftext.language.ecore.resource.mecore.MinEcoreEProblemType;
import org.emftext.language.ecore.resource.mecore.mopp.MinEcoreProblem;
import org.emftext.language.ecore.resource.mecore.mopp.MinEcoreResource;
import org.emftext.language.ecore.resource.mecore.util.MinEcoreEObjectUtil;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MecorePackage;

public class MEcoreValidator implements IMinEcoreOptionProvider, IMinEcoreResourcePostProcessorProvider, IMinEcoreResourcePostProcessor {

	public void process(MinEcoreResource resource) {
		List<EObject> internalContents = resource.getContentsInternal();
		for (EObject eObject : internalContents) {
			validate(resource, eObject);
		}
	}

	private void validate(MinEcoreResource resource, EObject eObject) {
		Collection<MFeature> features = MinEcoreEObjectUtil.getObjectsByType(eObject.eAllContents(), MecorePackage.eINSTANCE.getMFeature());
		for (MFeature feature : features) {
			if (feature.getType() instanceof MDataType &&
				feature.isReference()) {
				IMinEcoreProblem problem = new MinEcoreProblem(
						"Attributes cannot be tagged as non-containment. Remove the tilde.", 
						MinEcoreEProblemType.ANALYSIS_PROBLEM, 
						MinEcoreEProblemSeverity.ERROR
				);
				resource.addProblem(problem, feature);
			}
		}
	}

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IMinEcoreOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public IMinEcoreResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
