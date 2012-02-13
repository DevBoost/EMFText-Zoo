/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.language.java.ejava.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.ejava.resource.ejava.IEjavaOptions;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation;
import org.emftext.language.java.ejava.resource.util.EJavaPostProcessor;
import org.emftext.test.ConcreteSyntaxTestHelper;

/**
 * A test that loads all EJava files and checks that they do not contain errors.
 */
public class LoadAllEJavaFilesTest extends TestCase {
	
	private static final String GENMODEL_GENMODEL_URI = "platform:/plugin/org.eclipse.emf.codegen.ecore/";
	private static final String ECORE_GENMODEL_URI = "platform:/plugin/org.eclipse.emf.ecore/";
	private ResourceSet rs;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// register resource factories
		ConcreteSyntaxTestHelper.registerResourceFactories();
		new EjavaMetaInformation().registerResourceFactory();
		// initialize packages
		EcorePackage.eINSTANCE.getEClass();
		GenModelPackage.eINSTANCE.getGenClass();
		// register generator models
		ConcreteSyntaxTestHelper.registerEcoreGenModel();
		ConcreteSyntaxTestHelper.registerGenModelGenModel();
		// create and configure resource set
		rs = new ResourceSetImpl();
		rs.getLoadOptions().put(IEjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new EJavaPostProcessor());
		rs.getLoadOptions().put(IEjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new org.emftext.language.java.ejava.resource.EJavaPostProcessor());
		// configure URI map
		Map<URI, URI> uriMap = rs.getURIConverter().getURIMap();
		map(uriMap, ECORE_GENMODEL_URI, EClass.class);
		map(uriMap, GENMODEL_GENMODEL_URI, GenClass.class);
		// configure classpath
		JavaClasspath javaClasspath = JavaClasspath.get(rs);
		javaClasspath.registerClassifierJar(URI.createURI(getJarPath(EClass.class)));
		javaClasspath.registerStdLib();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// clear generator model locations
		EcorePlugin.getEPackageNsURIToGenModelLocationMap().clear();
	}

	private String getJarPath(Class<?> clazz) {
		String path = getClassFileLocation(clazz);
		path = path.replace("!/", "");
		return path;
	}

	private void map(Map<URI, URI> uriMap, String baseURI, Class<?> clazz) {
		URI from = URI.createURI(baseURI);
		URI to = getURI(clazz);
		uriMap.put(from, to);
	}

	private URI getURI(Class<?> clazz) {
		String path = getClassFileLocation(clazz);
		path = path.replace("file:/", "archive:file:/");
		URI uri = URI.createURI(path);
		return uri;
	}

	private String getClassFileLocation(Class<?> clazz) {
		String path = clazz.getResource("").getFile();
		path = path.replaceAll("!.*", "!/");
		return path;
	}

	public void testLoadAllEJavaFiles() throws IOException {
		List<File> files = findEJavaFiles(new File("..").getAbsoluteFile());
		System.out.println("Found files: " + files.size());
		assertFalse("No EJava files found.", files.isEmpty());
		
		for (File file : files) {
			URI uri = URI.createFileURI(file.getCanonicalPath());
			
			Resource resource = rs.getResource(uri, true);
			EcoreUtil.resolveAll(resource);
			List<Diagnostic> errors = resource.getErrors();
			for (Diagnostic error : errors) {
				System.out.println("Found error in " + uri.toString() + ": " + error);
			}
			// TODO enable this assertion!
			//assertTrue("Resource must not have errors.", errors.isEmpty());
		}
	}

	public void testURIMapping() {
		testLoading(ECORE_GENMODEL_URI + "model/Ecore.ecore");
		testLoading(ECORE_GENMODEL_URI + "model/Ecore.genmodel");
		testLoading(GENMODEL_GENMODEL_URI + "model/GenModel.ecore");
		testLoading(GENMODEL_GENMODEL_URI + "model/GenModel.genmodel");
	}

	private void testLoading(String path) {
		URI uri = URI.createURI(path);
		Resource resource = rs.getResource(uri, true);
		System.out.println("testLoading() uri = " + resource.getURI());
		System.out.println("testLoading() contents = " + resource.getContents());
	}

	private List<File> findEJavaFiles(File dir) {
		List<File> foundFiles = new ArrayList<File>();
		File[] eJavaFiles = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && 
						file.getName().endsWith(".ejava");
			}
		});
		if (eJavaFiles != null) {
			for (File file : eJavaFiles) {
				foundFiles.add(file);
			}
		}
		File[] subDirs = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isDirectory() && 
						!".".equals(file.getName()) &&
						!"..".equals(file.getName()) &&
						!".sven".equals(file.getName());
			}
		});
		if (subDirs == null) {
			return foundFiles;
		}
		for (File subDir : subDirs) {
			foundFiles.addAll(findEJavaFiles(subDir));
		}
		return foundFiles;
	}
}
