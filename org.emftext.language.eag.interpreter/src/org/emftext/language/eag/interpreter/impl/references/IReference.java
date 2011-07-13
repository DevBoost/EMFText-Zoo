/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
