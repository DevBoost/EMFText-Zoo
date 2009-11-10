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
		".*/org.emftext.test.code_completion.test/input/cs/.*"
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

	/*
	private abstract class AbstractTestItem implements TestItem {
		public EPackage[] getAdditionalPackages() {
			return new EPackage[0];
		}
	}
	
	private class TextEcoreTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				EcorePackage.eINSTANCE.getEPackage()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new TextEcorePrinter(stream, new TextEcoreResource());
		}
	}
	
	private class FacadeEcoreTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				EcorePackage.eINSTANCE.getEPackage()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new FacadeEcorePrinter(stream, new FacadeEcoreResource());
		}
	}
	
	private class CSTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new CsPrinter(stream, new CsResource());
		}
	}
	
	private class ChessTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.chess.ChessPackage.eINSTANCE.getChessGame()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new CgPrinter(stream, new CgResource());
		}
	}
	
	private class CustomSandwichTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.custom_sandwich.Custom_sandwichPackage.eINSTANCE.getRecipeTemplate()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new Custom_sandwichPrinter(stream, new Custom_sandwichResource());
		}
	}
	
	private class CustomerTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.customer.CustomerPackage.eINSTANCE.getCustomer()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new CustomerPrinter(stream, new CustomerResource());
		}
	}
	
	private class DotTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.dot.DotPackage.eINSTANCE.getGraph()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new DotPrinter(stream, new DotResource());
		}
	}
	
	private class XmlTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.exml.ExmlPackage.eINSTANCE.getDocument()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new XmlPrinter(stream, new XmlResource());
		}
	}
	
	private class FeatureTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.featuremapper.models.feature.FeaturePackage.eINSTANCE.getFeatureModel()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new FeaturePrinter(stream, new FeatureResource());
		}
	}
	
	private class FormsTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.forms.FormsPackage.eINSTANCE.getForm()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new FormsPrinter(stream, new FormsResource());
		}
	}
	
	private class FormularTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.formular.FormularPackage.eINSTANCE.getFormular()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new FormularPrinter(stream, new FormularResource());
		}
	}
	
	private class RegexpTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.regexp.RegexpPackage.eINSTANCE.getRegularExpression()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new RegexpPrinter(stream, new RegexpResource());
		}
	}
	
	private class SimpleCTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_c.CPackage.eINSTANCE.getCompilationUnit()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new CPrinter(stream, new CResource());
		}
	}
	
	private class SimpleGuiTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_gui.Simple_guiPackage.eINSTANCE.getFrame()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new SimpleguiPrinter(stream, new SimpleguiResource());
		}
	}
	
	private class SimpleMathTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_math.Simple_mathPackage.eINSTANCE.getAdditive()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new SmPrinter(stream, new SmResource());
		}
	}
	
	private class StatemachineTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getStateMachine()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new StatemachinePrinter(stream, new StatemachineResource());
		}
	}
	
	private class TemplateCallTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.template_concepts.call.CallPackage.eINSTANCE.getTemplateCall()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new Template_callPrinter(stream, new Template_callResource());
		}
	}
	
	private class TextAdventureTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.textadventure.TextadventurePackage.eINSTANCE.getAdventure()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new TasPrinter(stream, new TasResource());
		}
	}
	
	private class ThreeValuedLogicTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.threevaluedlogic.ThreevaluedlogicPackage.eINSTANCE.getFormula()
			};
		}

		public Object getPrinter(OutputStream stream) {
			return new TvlPrinter(stream, new TvlResource());
		}
	}
	
	private class JavaTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
			};
		}
		
		@Override
		public EPackage[] getAdditionalPackages() {
			return new EPackage[] {org.emftext.language.java.JavaPackage.eINSTANCE};
		}

		public Object getPrinter(OutputStream stream) {
			return new JavaPrinter(stream, new JavaResource());
		}
	}
	
	private class EJavaTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.java.ejava.EjavaPackage.eINSTANCE.getEPackageWrapper()
			};
		}
		
		public Object getPrinter(OutputStream stream) {
			return new EjavaPrinter(stream, new EjavaResource());
		}
	}
	
	private class JavaBehavior4UMLTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
			};
		}
		
		@Override
		public EPackage[] getAdditionalPackages() {
			return new EPackage[] {org.emftext.language.java.JavaPackage.eINSTANCE,
					org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.eINSTANCE};
		}

		public Object getPrinter(OutputStream stream) {
			return new JavabehaviorPrinter(stream, new JavabehaviorResource());
		}
	}
	
	private class ReuseJavaTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.java.reusejava.ReusejavaPackage.eINSTANCE.getStatementUnit(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
			};
		}
		
		@Override
		public EPackage[] getAdditionalPackages() {
			return new EPackage[] {org.emftext.language.java.JavaPackage.eINSTANCE,
					org.emftext.language.java.reusejava.ReusejavaPackage.eINSTANCE};
		}

		public Object getPrinter(OutputStream stream) {
			return new ReusejavaPrinter(stream, new ReusejavaResource());
		}
	}
	
	private class TreeJavaTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
					org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
			};
		}
		
		@Override
		public EPackage[] getAdditionalPackages() {
			return new EPackage[] {org.emftext.language.java.treejava.TreejavaPackage.eINSTANCE,
					org.emftext.language.java.reusejava.ReusejavaPackage.eINSTANCE};
		}

		public Object getPrinter(OutputStream stream) {
			return new TreejavaPrinter(stream, new TreejavaResource());
		}
	}
	*/
	
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
