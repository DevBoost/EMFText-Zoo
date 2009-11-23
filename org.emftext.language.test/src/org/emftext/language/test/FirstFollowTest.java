package org.emftext.language.test;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.codegen.generators.code_completion.helpers.ExpectationComputer;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.test.ConcreteSyntaxTestHelper;

import junit.framework.TestCase;

public class FirstFollowTest extends TestCase {

	private ExpectationComputer computer;

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		computer = new ExpectationComputer();
	}

	public void testFirstAndFollowComputations() {
		// TODO add test for all languages (take paths for TestLanguageRegistry
		testFirstAndFollowComputation("../org.emftext.language.dot/metamodel/dot.cs");
		testFirstAndFollowComputation("../org.emftext.language.java/metamodel/java.cs");
	}
	
	public void testFirstAndFollowComputation(String syntaxPath) {
		ConcreteSyntax syntax = loadSyntax(syntaxPath);
		EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			int i = 0;
			System.out.println("----> testing " + rule.getMetaclass().getName());
			computer.computeFollowExpectations(syntax, rule);
			System.out.println("----> testing contents");
			TreeIterator<EObject> ruleContents = rule.eAllContents();
			while (ruleContents.hasNext()) {
				EObject next = ruleContents.next();
				System.out.println("-> element " + i + " = " + next);
				computer.computeFollowExpectations(syntax, next);
				i++;
			}
		}
	}

	private ConcreteSyntax loadSyntax(String syntaxPath) {
		String pathName = syntaxPath;
		// we need to use the absolute path because the resolution of
		// the Ecore model does not work when the relative one is used
		File csFile = new File(pathName).getAbsoluteFile();
		Resource r = ConcreteSyntaxTestHelper.getConcreteSyntaxResource(URI.createFileURI(csFile.getAbsolutePath()));
		EList<EObject> contents = r.getContents();
		EcoreUtil.resolveAll(r);
		assertTrue(!contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue(root instanceof ConcreteSyntax);
		return (ConcreteSyntax) root;
	}
}
