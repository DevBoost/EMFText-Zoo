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
package org.emftext.language.java.test;

import java.io.File;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.CoreException;
import org.emftext.language.java.test.util.ThreadedTestSuite;

/**
 * A test that read all Java files from the input directory and parses and
 * prints them.
 */
public class AutomatedJavaLanguageFeatureTest extends AbstractJavaParserTestCase {
	
	protected static final String TEST_INPUT_FOLDER_NAME = "src-input";
	protected static final String TEST_OUTPUT_FOLDER_NAME = "output";
	
	public static Test suite() throws CoreException {
		final AutomatedJavaLanguageFeatureTest test = new AutomatedJavaLanguageFeatureTest();
		
		TestSuite suite = new ThreadedTestSuite(
		"Suite testing all files in the input directory automatically", 1000, 100);
		File inputFolder = new File("./" + TEST_INPUT_FOLDER_NAME);
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder, "java");
		for (final File file : allTestFiles) {
			addParseTest(test, suite, file);
			addParseAndReprintTest(test, suite, file);
		}
		
		return suite;
	}

	private static void addParseTest(final AutomatedJavaLanguageFeatureTest test,
			TestSuite suite, final File file) {
		suite.addTest(new TestCase("Parse " + file.getName()) {
			public void runTest() {
				try {
					test.parseResource(file, "./");
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
					test.parseAndReprint(file.getName(), TEST_INPUT_FOLDER_NAME, TEST_OUTPUT_FOLDER_NAME);
				}
				catch (Exception e) {
					fail(e.getClass() +  ": " + e.getMessage());
					e.printStackTrace();
				}
				
			}
		});
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
