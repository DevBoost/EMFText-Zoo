/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.ecore.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.ecore.resource.EcoreResourceFactoryDelegator;
import org.emftext.language.ecore.resource.text.extension.ExtendedTextEcoreResourceFactory;
import org.junit.Before;
import org.junit.Test;

public class EcoreTest extends AbstractEcoreTestCase {
	
	@Before
	public void setUp() {
		EcoreResourceFactoryDelegator factoryDelegator = new EcoreResourceFactoryDelegator();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", factoryDelegator);
		factoryDelegator.getEcoreResourceFactoriesMap().put(
				"text", new ExtendedTextEcoreResourceFactory());
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
