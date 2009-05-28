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
	
	protected static final String TEST_INPUT_FOLDER_NAME = "input";
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
