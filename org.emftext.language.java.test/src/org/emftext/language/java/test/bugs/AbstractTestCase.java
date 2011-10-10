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
package org.emftext.language.java.test.bugs;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;

public abstract class AbstractTestCase extends TestCase {

	public AbstractTestCase() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
	}
	
	protected Map<?, ?> getLoadOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		return map;
	}

	protected ResourceSet getResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getLoadOptions().putAll(getLoadOptions());
		return rs;
	}
}
