package org.emftext.language.eag.interpreter.impl;

import org.eclipse.emf.ecore.EStructuralFeature;

public interface IComplexReference extends IReference {

	public ObjectReference getReference(EStructuralFeature feature);
}
