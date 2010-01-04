/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.java.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Factory for <code>JavaSourceOrClassFileResources</code>.
 */
public class JavaSourceOrClassFileResourceFactoryImpl implements Resource.Factory {

	public JavaSourceOrClassFileResourceFactoryImpl() {
	}

	public Resource createResource(URI uri){
		return new JavaSourceOrClassFileResource(uri);
	}
}
