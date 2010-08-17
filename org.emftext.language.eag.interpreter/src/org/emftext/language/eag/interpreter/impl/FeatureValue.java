package org.emftext.language.eag.interpreter.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FeatureValue implements IReference {

	private EObject object;
	private EStructuralFeature feature;
	
	public FeatureValue(EObject object, EStructuralFeature feature) {
		super();
		assert object != null;
		assert feature != null;
		this.object = object;
		this.feature = feature;
	}

	public Object getTarget() {
		return object.eGet(feature);
	}

	public void setTarget(Object newValue) {
		System.out.println("FeatureValue.setValue(" + newValue +") on " + object);
		object.eSet(feature, newValue);
	}
}
