package org.emftext.language.test.code_completion;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.Expectation;
import org.emftext.sdk.codegen.resource.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.util.EObjectUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;

public class ExpectationComputerTest extends TestCase {

	private ConcreteSyntax cct2Syntax;
	private ConcreteSyntax cct3Syntax;
	private ConcreteSyntax anonymousFeatureSyntax;
	private ExpectationComputer computer;

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		// we need to use the absolute path because the resolution of
		// the Ecore model does not work when the relative one is used
		cct2Syntax = loadSyntax("../org.emftext.test.cct2/metamodel/cct2.cs");
		cct3Syntax = loadSyntax("../org.emftext.test.cct3/metamodel/cct3.cs");
		anonymousFeatureSyntax = loadSyntax("../org.emftext.test/src/org/emftext/test/anonymous_features/anonymous_feature1.cs");

		computer = new ExpectationComputer();
	}

	private ConcreteSyntax loadSyntax(String pathName) {
		File csFile = new File(pathName).getAbsoluteFile();
		Resource r = ConcreteSyntaxTestHelper.getConcreteSyntaxResource(URI.createFileURI(csFile.getAbsolutePath()));
		EList<EObject> contents = r.getContents();
		EcoreUtil.resolveAll(r);
		assertTrue(!contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue(root instanceof ConcreteSyntax);
		return (ConcreteSyntax) root;
	}
	
	public void testComputeCct2FirstSets() {
		assertFirstSet(
				findKeyword(cct2Syntax, "a"),
				findKeyword(cct2Syntax, "a")
			);
		assertFirstSet(
				findCompounds(cct2Syntax, "StarSequence").get(0),
				findKeyword(cct2Syntax, "a")
			);
		assertFirstSet(
				findCompounds(cct2Syntax, "OptionalSequence").get(0),
				findKeyword(cct2Syntax, "c")
			);
		assertFirstSet(
				findCompounds(cct2Syntax, "PlusSequence").get(0),
				findKeyword(cct2Syntax, "g")
			);
		assertFirstSet(
				findTerminals(cct2Syntax).get(0),
				findKeyword(cct2Syntax, "CA"),
				findKeyword(cct2Syntax, "CB")
			);
		assertFirstSet(
				cct2Syntax.getRules().get(0),
				findKeyword(cct2Syntax, "SS")
			);
	}

	public void testComputeCct3FirstSets() {
		assertFirstSet(
				cct3Syntax.getRules().get(0),
				findKeyword(cct3Syntax, "a"),
				findKeyword(cct3Syntax, "b")
			);
		assertFirstSet(
				cct3Syntax.getRules().get(1),
				findKeyword(cct3Syntax, "c"),
				findKeyword(cct3Syntax, "d"),
				findKeyword(cct3Syntax, "e")
			);
		assertFirstSet(
				cct3Syntax.getRules().get(2),
				findKeyword(cct3Syntax, "f"),
				findKeyword(cct3Syntax, "g")
			);
		assertFirstSet(
				cct3Syntax.getRules().get(3),
				findKeyword(cct3Syntax, "h"),
				findKeyword(cct3Syntax, "i")
			);
		assertFirstSet(
				findContainments(cct3Syntax).get(0),
				findKeyword(cct3Syntax, "k")
			);
		assertFirstSet(
				cct3Syntax.getRules().get(4),
				findKeyword(cct3Syntax, "k"),
				findKeyword(cct3Syntax, "j")
			);
		assertFollowSet(
				findContainments(cct3Syntax).get(3), // m11
				findKeyword(cct3Syntax, "v"),
				findKeyword(cct3Syntax, "u")
			);
	}

	public void testComputeCct2FollowSets() {
		assertFollowSet(
				findKeyword(cct2Syntax, "b"),
				findKeyword(cct2Syntax, "a"),
				findKeyword(cct2Syntax, "end1")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "OS"),
				findKeyword(cct2Syntax, "c"),
				findKeyword(cct2Syntax, "end2")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "d"),
				findKeyword(cct2Syntax, "end2")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "h"),
				findKeyword(cct2Syntax, "g"),
				findKeyword(cct2Syntax, "end4")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "a"),
				findKeyword(cct2Syntax, "b")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "SS"),
				findKeyword(cct2Syntax, "a"),
				findKeyword(cct2Syntax, "end1")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "end3")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "PS"),
				findKeyword(cct2Syntax, "g")
			);
		assertFollowSet(
				findKeyword(cct2Syntax, "CM"),
				findKeyword(cct2Syntax, "CA"),
				findKeyword(cct2Syntax, "CB")
			);
	}
	
	public void testComputeCct3FollowSets() {
		assertFollowSet(
				findKeyword(cct3Syntax, "a")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "l"),
				findKeyword(cct3Syntax, "m"),
				findKeyword(cct3Syntax, "l"),
				findKeyword(cct3Syntax, "n")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "o"),
				findKeyword(cct3Syntax, "p")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "s"),
				findKeyword(cct3Syntax, "t"),
				findKeyword(cct3Syntax, "r")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "u"),
				findKeyword(cct3Syntax, "v"),
				findKeyword(cct3Syntax, "u")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "v"),
				findKeyword(cct3Syntax, "u"),
				findKeyword(cct3Syntax, "v")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "h"),
				findKeyword(cct3Syntax, "h"),
				findKeyword(cct3Syntax, "i")
			);
		assertFollowSet(
				findContainments(cct3Syntax).get(5),
				findKeyword(cct3Syntax, "z"),
				findKeyword(cct3Syntax, "y")
			);
		assertFollowSet(
				findKeyword(cct3Syntax, "z"),
				findKeyword(cct3Syntax, "z"),
				findKeyword(cct3Syntax, "y")
			);
	}
	
	public void assertFollowSet(SyntaxElement syntaxElement, EObject... expectedFollow) {
		ConcreteSyntax syntax = syntaxElement.getContainingRule().getSyntax();
		Set<Expectation> followSet = computer.computeFollowSet(syntax, syntaxElement);
		printAndCompareSets("follow", syntaxElement, followSet, expectedFollow);
	}

	public void assertFirstSet(SyntaxElement syntaxElement, EObject... expectedFirst) {
		ConcreteSyntax syntax = syntaxElement.getContainingRule().getSyntax();
		Set<Expectation> firstSet = computer.computeFirstSet(syntax, syntaxElement);
		firstSet.remove(ExpectationComputer.EPSILON);
		printAndCompareSets("first", syntaxElement, firstSet, expectedFirst);
	}

	private void printAndCompareSets(String typeOfSet, EObject element, Set<Expectation> actualSet,
			EObject... expectedSet) {
		System.out.println("-> Comparing " + typeOfSet + " for " + element);
		for (Expectation nextExp : actualSet) {
			EObject next = nextExp.getExpectedElement();
			System.out.println("Actual " + typeOfSet + ":   " + next);
		}
		for (EObject next : expectedSet) {
			System.out.println("Expected " + typeOfSet + ": " + next);
		}
		assertEquals(expectedSet.length, actualSet.size());
		int i = 0;
		for (Expectation nextExp : actualSet) {
			EObject next = nextExp.getExpectedElement();
			assertEquals(next, expectedSet[i]);
			i++;
		}
	}
	
	public void testExpectations() {
		assertExpectations(
				findKeyword(cct2Syntax, "a"),
				"b"
			);
		assertExpectations(
				findKeyword(cct2Syntax, "c"),
				"d"
			);
		assertExpectations(
				findKeyword(cct2Syntax, "SS"),
				"a", "end1"
			);
		assertExpectations(
				findKeyword(cct2Syntax, "b"),
				"a", "end1"
			);
		assertExpectations(
				findKeyword(cct2Syntax, "d"),
				"end2"
			);
		assertExpectations(
				findKeyword(cct2Syntax, "OS"),
				"c", "end2"
			);
	}

	public void testAnonymousFeatureFirstSets() {
		assertFirstSet(
				findTerminals(anonymousFeatureSyntax).get(0)
		);
	}
	
	public void testAnonymousFeatureFollowSets() {
		assertFollowSet(
				findTerminals(anonymousFeatureSyntax).get(0),
				findKeyword(anonymousFeatureSyntax, "End")
		);
		assertFollowSet(
				findKeyword(anonymousFeatureSyntax, "Main"),
				findKeyword(anonymousFeatureSyntax, "End")
		);
	}
	
	/**
	 * Computes the list of elements that can follow 'syntaxElement'
	 * according to the given syntax definition.
	 * 
	 * @param syntax
	 * @param syntaxElement
	 * @return
	 */
	private Set<IExpectedElement> computeFollowExpectations(ConcreteSyntax syntax, SyntaxElement syntaxElement) {
		ExpectationComputer computer = new ExpectationComputer();
		Set<Expectation> followSet = computer.computeFollowSet(syntax, syntaxElement);
		// convert 'followSet' to expectations
		Set<IExpectedElement> expectations = new LinkedHashSet<IExpectedElement>();
		for (Expectation nextExp : followSet) {
			EObject next = nextExp.getExpectedElement();
			expectations.add(createExpectedElement(next));
		}
		return expectations;
	}

	/**
	 * Converts the given syntax definition element to an instance of
	 * IExpectedElement. The element must be a terminal symbol (i.e.,
	 * either a CsString or a Placeholder).
	 * 
	 * @param syntaxElement the element to convert
	 * @return
	 */
	private IExpectedElement createExpectedElement(EObject syntaxElement) {
		if (syntaxElement instanceof CsString) {
			CsString keyword = (CsString) syntaxElement;
			return new ExpectedKeyword(keyword.getValue());
		} else if (syntaxElement instanceof Placeholder) {
			Placeholder placeholder = (Placeholder) syntaxElement;
			GenFeature genFeature = placeholder.getFeature();
			return new ExpectedFeature(genFeature, placeholder.getContainingRule().getMetaclass(), placeholder.getToken().getName());
		} else {
			throw new IllegalArgumentException(syntaxElement.toString());
		}
	}

	private void assertExpectations(SyntaxElement syntaxElement, String... expectedExpectations) {

		Set<IExpectedElement> expectations = computeFollowExpectations(cct2Syntax, syntaxElement);
		for (IExpectedElement iExpectedElement : expectations) {
			System.out.println("Actual expectation:                      " + iExpectedElement);
		}
		removeDuplicates(expectations);
		for (IExpectedElement iExpectedElement : expectations) {
			System.out.println("Actual expectation (without duplicates): " + iExpectedElement);
		}
		for (String iExpectedElement : expectedExpectations) {
			System.out.println("Expected expectation:                    " + iExpectedElement);
		}
		assertEquals(expectations.size(), expectedExpectations.length);
		int i = 0;
		for (IExpectedElement next : expectations) {
			assertEquals(next.toString(), expectedExpectations[i]);
			i++;
		}
	}

	private void removeDuplicates(Set<IExpectedElement> expectations) {
		List<IExpectedElement> expectationsList = new ArrayList<IExpectedElement>();
		expectationsList.addAll(expectations);
		
		List<IExpectedElement> toRemove = new ArrayList<IExpectedElement>();
		for (int i = 0; i < expectationsList.size() - 1; i++) {
			IExpectedElement elementI = expectationsList.get(i);
			IExpectedElement elementJ = expectationsList.get(i + 1);
			if (elementI.toString().equals(elementJ.toString())) {
				toRemove.add(elementJ);
			}
		}
		for (IExpectedElement iExpectedElement : toRemove) {
			expectations.remove(iExpectedElement);
		}
	}

	public List<CompoundDefinition> findCompounds(ConcreteSyntax syntax, String metaClassName) {
		List<CompoundDefinition> compoundsInRule = new ArrayList<CompoundDefinition>();
		Collection<CompoundDefinition> allCompounds = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition());
		for (CompoundDefinition compoundDefinition : allCompounds) {
			if (metaClassName.equals(compoundDefinition.getContainingRule().getMetaclass().getName())) {
				compoundsInRule.add(compoundDefinition);
			}
		}
		return compoundsInRule;
	}

	public CsString findKeyword(ConcreteSyntax syntax, String keyword) {
		Collection<CsString> keywords = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
		for (CsString nextKeyword : keywords) {
			if (keyword.equals(nextKeyword.getValue())) {
				return nextKeyword;
			}
		}
		return null;
	}

	public List<Terminal> findTerminals(ConcreteSyntax syntax) {
		Collection<Terminal> terminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getTerminal());
		return new ArrayList<Terminal>(terminals);
	}

	public List<Containment> findContainments(ConcreteSyntax syntax) {
		Collection<Containment> containments = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getContainment());
		return new ArrayList<Containment>(containments);
	}
}
