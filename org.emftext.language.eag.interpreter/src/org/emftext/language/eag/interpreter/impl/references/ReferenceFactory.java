package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EObject;

public class ReferenceFactory {
	
	public final static ReferenceFactory INSTANCE = new ReferenceFactory();

	public IReference createReference(Object object) {
		if (object instanceof EObject) {
			return new EObjectReference((EObject) object);
		} else {
			return new PlainObjectReference(object);
		}
	}
}
