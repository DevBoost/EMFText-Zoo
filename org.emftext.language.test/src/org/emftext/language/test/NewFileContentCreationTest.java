package org.emftext.language.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.chess.resource.cg.CgPrinter;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.Custom_sandwichPrinter;
import org.emftext.language.customer.resource.customer.CustomerPrinter;
import org.emftext.language.ecore.resource.ecore.EcorePrinter;
import org.emftext.language.emfxml.resource.xml.XmlPrinter;
import org.emftext.language.feature.resource.feature.FeaturePrinter;
import org.emftext.language.formular.resource.formular.FormularPrinter;
import org.emftext.language.java.resource.java.JavaPrinter;
import org.emftext.language.regexp.resource.regexp.RegexpPrinter;
import org.emftext.language.simple_c.resource.c.CPrinter;
import org.emftext.language.simple_gui.resource.simplegui.SimpleguiPrinter;
import org.emftext.language.simple_math.resource.sm.SmPrinter;
import org.emftext.language.simple_template.resource.simpletemplate.SimpletemplatePrinter;
import org.emftext.language.statemachine.resource.statemachine.StatemachinePrinter;
import org.emftext.language.template_concepts.call.resource.template_call.Template_callPrinter;
import org.emftext.language.textadventure.resource.tas.TasPrinter;
import org.emftext.language.threevaluedlogic.resource.tvl.TvlPrinter;
import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.util.MinimalModelHelper;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.CsPrinter;

public class NewFileContentCreationTest extends TestCase {

	private interface TestItem {
		public EPackage[] getAdditionalPackages();
		public EClass[] getStartClasses();
		public ITextPrinter getPrinter(OutputStream stream);
	}
	
	private abstract class AbstractTestItem implements TestItem {
		public EPackage[] getAdditionalPackages() {
			return new EPackage[0];
		}
	}
	
	private class EcoreTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				EcorePackage.eINSTANCE.getEPackage()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new EcorePrinter(stream, null);
		}
	}
	
	private class CSTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CsPrinter(stream, null);
		}
	}
	
	private class ChessTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.chess.ChessPackage.eINSTANCE.getChessGame()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CgPrinter(stream, null);
		}
	}
	
	private class CustomSandwichTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.custom_sandwich.Custom_sandwichPackage.eINSTANCE.getRecipeTemplate()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new Custom_sandwichPrinter(stream, null);
		}
	}
	
	private class CustomerTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.customer.CustomerPackage.eINSTANCE.getCustomer()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CustomerPrinter(stream, null);
		}
	}
	
	private class EmfXmlTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.emfxml.EmfxmlPackage.eINSTANCE.getCompactElement(),
					org.emftext.language.emfxml.EmfxmlPackage.eINSTANCE.getOpeningElement()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new XmlPrinter(stream, null);
		}
	}
	
	private class FeatureTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.featuremapper.models.feature.FeaturePackage.eINSTANCE.getFeatureModel()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new FeaturePrinter(stream, null);
		}
	}
	
	private class FormularTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.formular.FormularPackage.eINSTANCE.getFormular()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new FormularPrinter(stream, null);
		}
	}
	
	private class RegexpTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.regexp.RegexpPackage.eINSTANCE.getRegularExpression()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new RegexpPrinter(stream, null);
		}
	}
	
	private class SimpleCTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_c.CPackage.eINSTANCE.getCompilationUnit()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CPrinter(stream, null);
		}
	}
	
	private class SimpleGuiTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_gui.Simple_guiPackage.eINSTANCE.getFrame()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new SimpleguiPrinter(stream, null);
		}
	}
	
	private class SimpleMathTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_math.Simple_mathPackage.eINSTANCE.getAdditive()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new SmPrinter(stream, null);
		}
	}
	
	private class SimpleTemplateTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_template.Simple_templatePackage.eINSTANCE.getTemplate()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new SimpletemplatePrinter(stream, null);
		}
	}
	
	private class StatemachineTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getStateMachine()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new StatemachinePrinter(stream, null);
		}
	}
	
	private class TemplateCallTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.template_concepts.call.CallPackage.eINSTANCE.getTemplateCall()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new Template_callPrinter(stream, null);
		}
	}
	
	private class TextAdventureTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.textadventure.TextadventurePackage.eINSTANCE.getAdventure()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new TasPrinter(stream, null);
		}
	}
	
	private class ThreeValuedLogicTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.threevaluedlogic.ThreevaluedlogicPackage.eINSTANCE.getFormula()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new TvlPrinter(stream, null);
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

		public ITextPrinter getPrinter(OutputStream stream) {
			return new JavaPrinter(stream, null);
		}
	}
	
	public void testMinimalModelCreation() {
		test(new EcoreTestItem());
		test(new CSTestItem());
		test(new ChessTestItem());
		test(new CustomSandwichTestItem());
		test(new CustomerTestItem());
		test(new EmfXmlTestItem());
		test(new FeatureTestItem());
		test(new FormularTestItem());
		test(new RegexpTestItem());
		test(new SimpleCTestItem());
		test(new SimpleGuiTestItem());
		test(new SimpleMathTestItem());
		test(new SimpleTemplateTestItem());
		test(new StatemachineTestItem());
		test(new TemplateCallTestItem());
		test(new TextAdventureTestItem());
		test(new ThreeValuedLogicTestItem());
		test(new JavaTestItem());
		/*
		test(
				new EPackage[] {org.emftext.language.java.JavaPackage.eINSTANCE,
						org.emftext.language.java.javabehavior4uml.Javabehavior4umlPackage.eINSTANCE
				},
				org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
				org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
				org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
			);

		test(new EPackage[] {org.emftext.language.java.JavaPackage.eINSTANCE},
			org.emftext.language.java.reusejava.ReusejavaPackage.eINSTANCE.getStatementUnit(),
			org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
			org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
			org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
		);

		test(new EPackage[] {
				org.emftext.language.java.JavaPackage.eINSTANCE,
				org.emftext.language.java.treejava.TreejavaPackage.eINSTANCE
			},
				org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getCompilationUnit(),
				org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getEmptyModel(),
				org.emftext.language.java.containers.ContainersPackage.eINSTANCE.getPackage()
		);
		*/
		// TODO
		//test(org.emftext.language.c_sharp.CsharpPackage);
	}

	private void test(TestItem item) {
		MinimalModelHelper mmh = new MinimalModelHelper();
		for (EClass nextStart : item.getStartClasses()) {
			Collection<EClass> availableClasses = getContainedClasses(item.getAdditionalPackages());
			availableClasses.addAll(getContainedClasses(nextStart));
			
			EObject result = mmh.getMinimalModel(nextStart, availableClasses);
			assertNotNull(result);
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			ITextPrinter printer = item.getPrinter(buffer);
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
