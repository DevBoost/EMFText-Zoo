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
package org.emftext.language.java.test;

import java.io.File;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.util.JavaPostProcessor;
import org.emftext.language.java.resource.util.UnicodeConverterProvider;
import org.emftext.language.java.test.util.ThreadedTestSuite;

/**
 * A test that read all Java files from the input directory and parses and
 * prints them.
 */
public class AutomatedJavaLanguageFeatureTest extends AbstractJavaParserTestCase {

	protected static final String TEST_INPUT_FOLDER_NAME = "src-input";
	protected static final String TEST_OUTPUT_FOLDER_NAME = "output";

	public static Test suite() throws Exception {
		final AutomatedJavaLanguageFeatureTest test = new AutomatedJavaLanguageFeatureTest();

		TestSuite suite = new ThreadedTestSuite(
		"Suite testing all files in the input directory automatically", 30 * 1000, 1);
		File inputFolder = new File("./" + TEST_INPUT_FOLDER_NAME);
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder, "java");
		suiteResourceSet = new ResourceSetImpl();
		suiteResourceSet.getLoadOptions().put(IJavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		suiteResourceSet.getLoadOptions().put(IJavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new JavaPostProcessor());
		suiteResourceSet.getLoadOptions().put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, Boolean.TRUE);
		for (final File file : allTestFiles) {
			addParseTest(test, suite, file);
			addParseAndReprintTest(test, suite, file);
			addFileToClasspath(file);
		}

		return suite;
	}

	private static void addParseTest(final AutomatedJavaLanguageFeatureTest test,
			TestSuite suite, final File file) {
		suite.addTest(new TestCase("Parse " + file.getName()) {
			public void runTest() {
				try {
					test.parseResource(file.getPath(), "./");
				}
				catch (Exception e) {
					fail(e.getClass() +  ": " + e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	private static void addParseAndReprintTest(
			final AutomatedJavaLanguageFeatureTest test, TestSuite suite, final File file) {
		suite.addTest(new TestCase("Parse and Reprint " + file.getName()) {
			public void runTest() {
				try {
					test.parseAndReprint(file, TEST_INPUT_FOLDER_NAME, TEST_OUTPUT_FOLDER_NAME);
				}
				catch (Exception e) {
					fail(e.getClass() +  ": " + e.getMessage());
					e.printStackTrace();
				}

			}
		});
	}
	
	private static void addFileToClasspath(File file) throws Exception {
		JavaClasspath cp = JavaClasspath.get(suiteResourceSet);
		String fullName = file.getPath().substring(TEST_INPUT_FOLDER_NAME.length() + 3, file.getPath().length() - 5);
		fullName = fullName.replaceAll(File.separator, ".");
		int idx = fullName.lastIndexOf(".");
		String packageName;
		String classifierName;
		if (idx == -1) {
			packageName = "";
			classifierName = fullName;
		} else {
			packageName = fullName.substring(0, idx);
			classifierName = fullName.substring(idx + 1);			
		}
		cp.registerClassifier(packageName, classifierName, URI.createFileURI(file.getCanonicalPath()));
	}
	
	private static ResourceSet suiteResourceSet = null;
	
	@Override
	protected ResourceSet getResourceSet() {
		return suiteResourceSet;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return false;
	}

	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER_NAME;
	}
}
