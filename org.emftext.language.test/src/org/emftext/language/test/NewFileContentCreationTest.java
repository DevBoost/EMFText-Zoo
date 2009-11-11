/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.language.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.access.resource.IMetaInformation;
import org.emftext.access.resource.IPrinter;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper;
import org.emftext.test.ConcreteSyntaxTestHelper;

/**
 * A test that checks whether the creation of minimal models
 * that is used by the NewFileWizards is working correctly.
 */
public class NewFileContentCreationTest extends TestCase {

	private static final String[] excludedFiles = new String[] {
		".*/CheckCSSyntax.cs", 
		".*/ecore.cs", 
		".*/standardSyntax/forms.cs", 
		".*/rev6618/java_templates.cs",
		".*/org/emftext/test/.*",
		".*/org.emftext.test.ant/metamodel/simple.cs",
		".*/org.emftext.test.atl/model/example.cs",
		".*/org.emftext.test.code_completion.test/input/cs/.*",
		".*/concretesyntax.newfile.cs"
	};
	
	public static final class MinimalModelTestCase extends TestCase {
		private final IMetaInformation metaInformation;

		private MinimalModelTestCase(IMetaInformation metaInformation) {
			super("Test " + metaInformation.getSyntaxName());
			this.metaInformation = metaInformation;
		}

		public void runTest() {
			test(new TestItem() {

				public EPackage[] getAdditionalPackages() {
					return new EPackage[0];
				}

				public IPrinter getPrinter(OutputStream stream) {
					return metaInformation.createPrinter(stream, null);
				}

				public EClass[] getStartClasses() {
					return metaInformation.getStartSymbols();
				}
			});
		}
		
		private void test(TestItem item) {
			CsMinimalModelHelper mmh = new CsMinimalModelHelper();
			for (EClass nextStart : item.getStartClasses()) {
				Collection<EClass> availableClasses = getContainedClasses(item.getAdditionalPackages());
				availableClasses.addAll(getContainedClasses(nextStart));
				
				EObject result = mmh.getMinimalModel(nextStart, availableClasses);
				assertNotNull(result);
				
				ByteArrayOutputStream buffer = new ByteArrayOutputStream();
				IPrinter printer = item.getPrinter(buffer);
				assertNotNull(printer);
				try {
					printer.print(result);
				} catch (IOException e) {
					fail(e.getMessage());
				}
			}
		}

		private Collection<EClass> getContainedClasses(EClass... classes) {
			Set<EClass> result = new LinkedHashSet<EClass>();
			for (EClass nextClass : classes) {
				result.addAll(getContainedClasses(nextClass.getEPackage()));
			}
			return result;
		}

		private Collection<EClass> getContainedClasses(EPackage... ePackages) {
			Set<EClass> result = new LinkedHashSet<EClass>();
			for (EPackage nextPackage : ePackages) {
				// recursively add EClasses in subpackages
				for (EPackage nextSubpackage : nextPackage.getESubpackages()) {
					result.addAll(getContainedClasses(nextSubpackage));
				}
				// add EClasses in the package itself
				for (EClassifier nextClassifier : nextPackage.getEClassifiers()) {
					if (nextClassifier instanceof EClass) {
						result.add((EClass) nextClassifier);
					}
				}
			}
			return result;
		}
	}

	private interface TestItem {
		public EPackage[] getAdditionalPackages();
		public EClass[] getStartClasses();
		public IPrinter getPrinter(OutputStream stream);
	}

	public static class MetaTest extends TestCase {
		
		private List<IMetaInformation> metaInformations;
		
		public MetaTest(List<IMetaInformation> metaInformations) {
			super("Check that all .cs files are tested.");
			this.metaInformations = metaInformations;
		}

		public void runTest() {
			Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars(new File(".."));
			for (String grammar : grammars) {
				boolean foundTest = false;
				for (IMetaInformation metaInformation : metaInformations) {
					String pathToCSDefinition = metaInformation.getPathToCSDefinition();
					grammar = grammar.replace(File.separator, "/");
					for (String excludedFile : excludedFiles) {
						if (grammar.matches(excludedFile)) {
							// found test
							foundTest = true;
						}
					}
					if (grammar.endsWith(pathToCSDefinition)) {
						// found test
						foundTest = true;
					}
				}
				assertTrue("Can't find test for " + grammar, foundTest);
			}
		}
	}
	
	public static Test suite() {
		new TestLanguageRegistry().registerAllLanguages();
		TestSuite suite = new TestSuite("All tests");
		List<IMetaInformation> metaInformations = EMFTextAccessPlugin.getConcreteSyntaxRegistry();
		for (final IMetaInformation metaInformation : metaInformations) {
			suite.addTest(new MinimalModelTestCase(metaInformation));
		}
		suite.addTest(new MetaTest(metaInformations));
		return suite;
	}
}
