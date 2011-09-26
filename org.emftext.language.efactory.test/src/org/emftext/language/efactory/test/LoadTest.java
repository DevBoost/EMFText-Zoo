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
package org.emftext.language.efactory.test;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResourceFactory;

public class LoadTest extends TestCase {

	private final static String EFACTORY_EXTENSION = new EfactoryMetaInformation().getSyntaxName();
	
	private ResourceSet rs = new ResourceSetImpl();

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				EFACTORY_EXTENSION,
				new EfactoryResourceFactory());

		registerEPackages();
	}

	public void testEnumModel() {
		testLoadModel("enumtest.efactory");
		testLoadModel("enumtest2.efactory");
	}
	
	public void testLoadSmallModel() {
		testLoadModel("small.efactory");
	}
	
	public void testLoadLargeModel() {
		testLoadModel("large.efactory");
	}

	private void testLoadModel(String filename) {
		System.out.println("loading " + filename + "...");
		Resource resource = rs.getResource(URI.createFileURI("." + File.separator + "input_load" + File.separator + filename), true);
		EList<Diagnostic> errors = resource.getErrors();
		EList<Diagnostic> warnings = resource.getWarnings();
		print(errors, "Error: ");
		print(warnings, "Warning: ");
		assertEquals(0, errors.size());
		assertEquals(0, warnings.size());
		System.out.println("resolving " + filename + "...");
		EcoreUtil.resolveAll(resource);

		Builder builder = new Builder();

		System.out.println("building " + filename + "...");
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Factory) {
				Factory eFactory = (Factory) eObject;
				List<EObject> roots = builder.build(eFactory, new HashMap<EObject, String>());
				assertFalse(roots.isEmpty());
			}
		}
	}

	private void print(EList<Diagnostic> diagnostics, String string) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(string + diagnostic.getMessage());
		}
	}

	private void registerEPackages() {
		File metamodelFolder = new File("." + File.separator + "metamodels");
		File[] metamodels = metamodelFolder.listFiles(new FileFilter() {
			
			public boolean accept(File file) {
				return file.getName().endsWith(".ecore");
			}
		});
		for (File metamodel : metamodels) {
			Resource resource = rs.getResource(URI.createFileURI(metamodel.getAbsolutePath()), true);
			assertNotNull(resource);
			EcoreUtil.resolveAll(resource);
			EList<EObject> contents = resource.getContents();
			for (EObject eObject : contents) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage) eObject;
					register(ePackage);
				}
			}
		}
	}

	private void register(EPackage ePackage) {
		String nsURI = ePackage.getNsURI();
		System.out.println("LoadTest.register() " + nsURI);
		Registry registry = EPackage.Registry.INSTANCE;
		if (registry.containsKey(nsURI)) {
			//return;
		}
		registry.put(nsURI, ePackage);
		EList<EPackage> eSubpackages = ePackage.getESubpackages();
		for (EPackage subPackage : eSubpackages) {
			register(subPackage);
		}
	}
}
