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
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.chess.resource.cg.mopp.CgPrinter;
import org.emftext.language.chess.resource.cg.mopp.CgResource;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichPrinter;
import org.emftext.language.custom_sandwich.resource.custom_sandwich.mopp.Custom_sandwichResource;
import org.emftext.language.customer.resource.customer.mopp.CustomerPrinter;
import org.emftext.language.customer.resource.customer.mopp.CustomerResource;
import org.emftext.language.dot.resource.dot.mopp.DotPrinter;
import org.emftext.language.dot.resource.dot.mopp.DotResource;
import org.emftext.language.ecore.resource.facade.mopp.FacadeEcorePrinter;
import org.emftext.language.ecore.resource.facade.mopp.FacadeEcoreResource;
import org.emftext.language.ecore.resource.text.mopp.TextEcorePrinter;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResource;
import org.emftext.language.feature.resource.feature.mopp.FeaturePrinter;
import org.emftext.language.feature.resource.feature.mopp.FeatureResource;
import org.emftext.language.forms.resource.forms.mopp.FormsPrinter;
import org.emftext.language.forms.resource.forms.mopp.FormsResource;
import org.emftext.language.formular.resource.formular.mopp.FormularPrinter;
import org.emftext.language.formular.resource.formular.mopp.FormularResource;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaPrinter;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorPrinter;
import org.emftext.language.java.javabehavior4uml.resource.javabehavior.mopp.JavabehaviorResource;
import org.emftext.language.java.resource.java.mopp.JavaPrinter;
import org.emftext.language.java.resource.java.mopp.JavaResource;
import org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaPrinter;
import org.emftext.language.java.reusejava.resource.reusejava.mopp.ReusejavaResource;
import org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaPrinter;
import org.emftext.language.java.treejava.resource.treejava.mopp.TreejavaResource;
import org.emftext.language.regexp.resource.regexp.mopp.RegexpPrinter;
import org.emftext.language.regexp.resource.regexp.mopp.RegexpResource;
import org.emftext.language.simple_c.resource.c.mopp.CPrinter;
import org.emftext.language.simple_c.resource.c.mopp.CResource;
import org.emftext.language.simple_gui.resource.simplegui.mopp.SimpleguiPrinter;
import org.emftext.language.simple_gui.resource.simplegui.mopp.SimpleguiResource;
import org.emftext.language.simple_math.resource.sm.mopp.SmPrinter;
import org.emftext.language.simple_math.resource.sm.mopp.SmResource;
import org.emftext.language.statemachine.resource.statemachine.mopp.StatemachinePrinter;
import org.emftext.language.statemachine.resource.statemachine.mopp.StatemachineResource;
import org.emftext.language.template_concepts.call.resource.template_call.mopp.Template_callPrinter;
import org.emftext.language.template_concepts.call.resource.template_call.mopp.Template_callResource;
import org.emftext.language.textadventure.resource.tas.mopp.TasPrinter;
import org.emftext.language.textadventure.resource.tas.mopp.TasResource;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlPrinter;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlResource;
import org.emftext.language.xml.resource.xml.mopp.XmlPrinter;
import org.emftext.language.xml.resource.xml.mopp.XmlResource;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPrinter;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsMinimalModelHelper;

public class NewFileContentCreationTest extends TestCase {

	private interface TestItem {
		public EPackage[] getAdditionalPackages();
		public EClass[] getStartClasses();
		public Object getPrinter(OutputStream stream);
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
	
	public void testMinimalModelCreation() {
		test(new TextEcoreTestItem());
		test(new FacadeEcoreTestItem());
		test(new CSTestItem());
		test(new ChessTestItem());
		test(new CustomSandwichTestItem());
		test(new CustomerTestItem());
		test(new DotTestItem());
		test(new FeatureTestItem());
		test(new FormsTestItem());
		test(new FormularTestItem());
		test(new RegexpTestItem());
		test(new SimpleCTestItem());
		test(new SimpleGuiTestItem());
		test(new SimpleMathTestItem());
		test(new StatemachineTestItem());
		test(new TemplateCallTestItem());
		test(new TextAdventureTestItem());
		test(new ThreeValuedLogicTestItem());
		test(new JavaTestItem());
		test(new EJavaTestItem());
		test(new JavaBehavior4UMLTestItem());
		test(new ReuseJavaTestItem());
		test(new TreeJavaTestItem());
		test(new XmlTestItem());

		// TODO add test items for remaining languages
		//test(org.emftext.language.c_sharp.CsharpPackage);
	}

	private void test(TestItem item) {
		CsMinimalModelHelper mmh = new CsMinimalModelHelper();
		for (EClass nextStart : item.getStartClasses()) {
			Collection<EClass> availableClasses = getContainedClasses(item.getAdditionalPackages());
			availableClasses.addAll(getContainedClasses(nextStart));
			
			EObject result = mmh.getMinimalModel(nextStart, availableClasses);
			assertNotNull(result);
			
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			Object printer = item.getPrinter(buffer);
			try {
				Class<?>[] param = new Class [] {EObject.class};
				Method printMethod = printer.getClass().getMethod("print", param);
				printMethod.invoke(printer, result);
			} catch (Exception e) {
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
