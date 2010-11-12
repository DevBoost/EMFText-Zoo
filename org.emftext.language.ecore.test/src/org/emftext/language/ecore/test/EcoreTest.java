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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.ecore.resource.EcoreResourceFactoryDelegator;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.ecore.resource.text.util.TextEcoreStreamUtil;
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
	public void testOwl() {
		assertParse("owl.text.ecore");
	}

	@Test
	public void testRePrint() {
		// this is a test for bug 1602
		assertRePrint("reprint.text.ecore");
	}

	@Test
	public void testImport() {
		assertParse("import.text.ecore");
	}
	
	private void assertRePrint(String fileName) {
		String content = null;
		try {
			content = TextEcoreStreamUtil.getContent(new FileInputStream(getPath(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EPackage ePackage = assertParse(fileName);
		String printResult = print(ePackage);
		System.out.println("EcoreTest.assertRePrint() result is ==>" + printResult + "<==");
		assertEquals(content, printResult);
	}

	private EPackage assertParse(String fileName) {
		try {
			EPackage ePackage = loadResource(getPath(fileName), fileName);
			assertNotNull(ePackage);
			return ePackage;
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return null;
	}

	private String getPath(String fileName) {
		return "input" + File.separator + fileName;
	}

	private String print(EObject object) {
		Resource resource = createTempResource();
		resource.getContents().add(object);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = outputStream.toString();
		return printResult;
	}

	private Resource createTempResource() {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp.text.ecore"));
		return resource;
	}
}
