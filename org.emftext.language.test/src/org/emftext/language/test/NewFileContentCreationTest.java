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
import org.emftext.language.chess.resource.cg.CgResource;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.Custom_sandwichPrinter;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.Custom_sandwichResource;
import org.emftext.language.customer.resource.customer.CustomerPrinter;
import org.emftext.language.customer.resource.customer.CustomerResource;
import org.emftext.language.ecore.resource.facade.FacadeEcorePrinter;
import org.emftext.language.ecore.resource.facade.FacadeEcoreResource;
import org.emftext.language.ecore.resource.text.TextEcorePrinter;
import org.emftext.language.ecore.resource.text.TextEcoreResource;
import org.emftext.language.emfxml.resource.xml.XmlPrinter;
import org.emftext.language.emfxml.resource.xml.XmlResource;
import org.emftext.language.feature.resource.feature.FeaturePrinter;
import org.emftext.language.feature.resource.feature.FeatureResource;
import org.emftext.language.formular.resource.formular.FormularPrinter;
import org.emftext.language.formular.resource.formular.FormularResource;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorPrinter;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.JavabehaviorResource;
import org.emftext.language.java.resource.java.JavaPrinter;
import org.emftext.language.java.resource.java.JavaResource;
import org.emftext.language.java.reusejava.resource.reusejava.ReusejavaPrinter;
import org.emftext.language.java.reusejava.resource.reusejava.ReusejavaResource;
import org.emftext.language.java.treejava.resource.treejava.TreejavaPrinter;
import org.emftext.language.java.treejava.resource.treejava.TreejavaResource;
import org.emftext.language.regexp.resource.regexp.RegexpPrinter;
import org.emftext.language.regexp.resource.regexp.RegexpResource;
import org.emftext.language.simple_c.resource.c.CPrinter;
import org.emftext.language.simple_c.resource.c.CResource;
import org.emftext.language.simple_gui.resource.simplegui.SimpleguiPrinter;
import org.emftext.language.simple_gui.resource.simplegui.SimpleguiResource;
import org.emftext.language.simple_math.resource.sm.SmPrinter;
import org.emftext.language.simple_math.resource.sm.SmResource;
import org.emftext.language.simple_template.resource.simpletemplate.SimpletemplatePrinter;
import org.emftext.language.simple_template.resource.simpletemplate.SimpletemplateResource;
import org.emftext.language.statemachine.resource.statemachine.StatemachinePrinter;
import org.emftext.language.statemachine.resource.statemachine.StatemachineResource;
import org.emftext.language.template_concepts.call.resource.template_call.Template_callPrinter;
import org.emftext.language.template_concepts.call.resource.template_call.Template_callResource;
import org.emftext.language.textadventure.resource.tas.TasPrinter;
import org.emftext.language.textadventure.resource.tas.TasResource;
import org.emftext.language.threevaluedlogic.resource.tvl.TvlPrinter;
import org.emftext.language.threevaluedlogic.resource.tvl.TvlResource;
import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.util.MinimalModelHelper;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.CsPrinter;
import org.emftext.sdk.concretesyntax.resource.cs.CsResource;

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
	
	private class TextEcoreTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				EcorePackage.eINSTANCE.getEPackage()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new TextEcorePrinter(stream, new TextEcoreResource());
		}
	}
	
	private class FacadeEcoreTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				EcorePackage.eINSTANCE.getEPackage()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new FacadeEcorePrinter(stream, new FacadeEcoreResource());
		}
	}
	
	private class CSTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CsPrinter(stream, new CsResource());
		}
	}
	
	private class ChessTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.chess.ChessPackage.eINSTANCE.getChessGame()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CgPrinter(stream, new CgResource());
		}
	}
	
	private class CustomSandwichTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.custom_sandwich.Custom_sandwichPackage.eINSTANCE.getRecipeTemplate()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new Custom_sandwichPrinter(stream, new Custom_sandwichResource());
		}
	}
	
	private class CustomerTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
				org.emftext.language.customer.CustomerPackage.eINSTANCE.getCustomer()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CustomerPrinter(stream, new CustomerResource());
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
			return new XmlPrinter(stream, new XmlResource());
		}
	}
	
	private class FeatureTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.featuremapper.models.feature.FeaturePackage.eINSTANCE.getFeatureModel()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new FeaturePrinter(stream, new FeatureResource());
		}
	}
	
	private class FormularTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.formular.FormularPackage.eINSTANCE.getFormular()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new FormularPrinter(stream, new FormularResource());
		}
	}
	
	private class RegexpTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.regexp.RegexpPackage.eINSTANCE.getRegularExpression()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new RegexpPrinter(stream, new RegexpResource());
		}
	}
	
	private class SimpleCTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_c.CPackage.eINSTANCE.getCompilationUnit()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new CPrinter(stream, new CResource());
		}
	}
	
	private class SimpleGuiTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_gui.Simple_guiPackage.eINSTANCE.getFrame()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new SimpleguiPrinter(stream, new SimpleguiResource());
		}
	}
	
	private class SimpleMathTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_math.Simple_mathPackage.eINSTANCE.getAdditive()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new SmPrinter(stream, new SmResource());
		}
	}
	
	private class SimpleTemplateTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.simple_template.Simple_templatePackage.eINSTANCE.getTemplate()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new SimpletemplatePrinter(stream, new SimpletemplateResource());
		}
	}
	
	private class StatemachineTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getStateMachine()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new StatemachinePrinter(stream, new StatemachineResource());
		}
	}
	
	private class TemplateCallTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.template_concepts.call.CallPackage.eINSTANCE.getTemplateCall()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new Template_callPrinter(stream, new Template_callResource());
		}
	}
	
	private class TextAdventureTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.textadventure.TextadventurePackage.eINSTANCE.getAdventure()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
			return new TasPrinter(stream, new TasResource());
		}
	}
	
	private class ThreeValuedLogicTestItem extends AbstractTestItem {

		public EClass[] getStartClasses() {
			return new EClass[] {
					org.emftext.language.threevaluedlogic.ThreevaluedlogicPackage.eINSTANCE.getFormula()
			};
		}

		public ITextPrinter getPrinter(OutputStream stream) {
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

		public ITextPrinter getPrinter(OutputStream stream) {
			return new JavaPrinter(stream, new JavaResource());
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

		public ITextPrinter getPrinter(OutputStream stream) {
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

		public ITextPrinter getPrinter(OutputStream stream) {
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

		public ITextPrinter getPrinter(OutputStream stream) {
			return new TreejavaPrinter(stream, new TreejavaResource());
		}
	}
	
	public void testMinimalModelCreation() {
		test(new TextEcoreTestItem());
		test(new FacadeEcoreTestItem());
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
		test(new JavaBehavior4UMLTestItem());
		test(new ReuseJavaTestItem());
		test(new TreeJavaTestItem());

		// TODO add test items for remaining languages
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
