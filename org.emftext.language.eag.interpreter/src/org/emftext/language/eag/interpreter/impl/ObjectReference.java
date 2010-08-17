package org.emftext.language.eag.interpreter.impl;

import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class ObjectReference implements IComplexReference {

	private Object object;

	public ObjectReference(Object object) {
		super();
		this.object = object;
	}

	public Object getTarget() {
		return object;
	}

	public void setTarget(Object newValue) {
		throw new UnsupportedOperationException();
	}

	public abstract Object get(EStructuralFeature feature);
	public abstract void set(EStructuralFeature feature, Object value);

	public abstract ObjectReference getReference(EStructuralFeature feature);
}
