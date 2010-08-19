package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EObjectReference extends AbstractObjectReference {

	private EObject object;

	public EObjectReference(EObject object) {
		super(object);
		this.object = object;
	}

	@Override
	public IReference getReference(EStructuralFeature feature) {
		return ReferenceFactory.INSTANCE.createReference(object.eGet(feature));
	}
}
