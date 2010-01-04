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
package org.emftext.language.ecore.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.ecore.resource.EcoreResourceFactoryDelegator;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.junit.Before;
import org.junit.Test;

public class EcoreTest extends AbstractEcoreTestCase {
	
	@Before
	public void setUp() {
		EcoreResourceFactoryDelegator factoryDelegator = new EcoreResourceFactoryDelegator();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", factoryDelegator);
		factoryDelegator.getResourceFactoriesMap().put(
				"text", new TextEcoreResourceFactory());
		factoryDelegator.getResourceFactoriesMap().put(
				"", new EcoreResourceFactoryImpl());
	}

	@Test
	public void testGenerics() {
		assertParse("TypeArguments.text.ecore");
		assertParse("TypeParameters.text.ecore");
		assertParse("SomeXMI.ecore");
	}

	@Test
	public void testImport() {
		assertParse("import.text.ecore");
	}
	
	private void assertParse(String fileName) {
		try {
			EPackage ePackage = loadResource("input" + File.separator + fileName, fileName);
			assertNotNull(ePackage);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
