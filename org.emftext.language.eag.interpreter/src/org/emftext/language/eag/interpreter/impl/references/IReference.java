package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An IReference holds a pointer to an object. This object can be obtained 
 * using getTarget(). The pointer can also be redirected to another object
 * using setTarget().
 * 
 * References to the features of the object can be obtained using 
 * getReference(). If the object is a primitive value, getReference() 
 * returns null.
 */
public interface IReference {

	public Object getTarget();
	public void setTarget(Object newTarget);
	
	public IReference getReference(EStructuralFeature feature);
}
