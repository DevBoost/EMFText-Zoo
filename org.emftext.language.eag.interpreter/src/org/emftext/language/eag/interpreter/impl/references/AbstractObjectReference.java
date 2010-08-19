package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class AbstractObjectReference implements IReference {

	private Object object;

	public AbstractObjectReference(Object object) {
		super();
		this.object = object;
	}

	public Object getTarget() {
		return object;
	}

	public void setTarget(Object newValue) {
		throw new UnsupportedOperationException();
	}

	public abstract IReference getReference(EStructuralFeature feature);
}
