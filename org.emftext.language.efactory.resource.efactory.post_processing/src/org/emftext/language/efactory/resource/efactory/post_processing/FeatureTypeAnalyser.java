package org.emftext.language.efactory.resource.efactory.post_processing;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.efactory.EfactoryPackage;
import org.emftext.language.efactory.Feature;
import org.emftext.language.efactory.resource.efactory.IEfactoryResourcePostProcessor;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResource;
import org.emftext.language.efactory.resource.efactory.util.EfactoryEObjectUtil;

public class FeatureTypeAnalyser implements IEfactoryResourcePostProcessor {

	public void process(EfactoryResource resource) {
		Collection<Feature> features = EfactoryEObjectUtil.getObjectsByType(resource.getAllContents(), EfactoryPackage.eINSTANCE.getFeature());
		for (Feature feature : features) {
			EStructuralFeature eFeature = feature.getEFeature();
			String errorMessage = null;
			if (eFeature != null) {
				if (eFeature.isDerived()) {
					errorMessage = "Feature " + eFeature.getName() + " is derived and can not be set.";
				}
				if (!eFeature.isChangeable()) {
					errorMessage = "Feature " + eFeature.getName() + " is unchangeable and can not be set.";
				}
			}
			if (errorMessage != null) {
				resource.addError(errorMessage, feature);
			}
		}
	}

}
