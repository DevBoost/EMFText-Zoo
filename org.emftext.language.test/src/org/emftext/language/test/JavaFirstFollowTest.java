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

public class JavaFirstFollowTest extends TestCase {

	private ConcreteSyntax syntax;
	private ExpectationComputer computer;

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		String pathName = "../org.emftext.language.java/metamodel/java.cs";
		// we need to use the absolute path because the resolution of
		// the Ecore model does not work when the relative one is used
		File csFile = new File(pathName).getAbsoluteFile();
		Resource r = ConcreteSyntaxTestHelper.getConcreteSyntaxResource(URI.createFileURI(csFile.getAbsolutePath()));
		EList<EObject> contents = r.getContents();
		EcoreUtil.resolveAll(r);
		assertTrue(!contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue(root instanceof ConcreteSyntax);
		syntax = (ConcreteSyntax) root;

		computer = new ExpectationComputer();
	}
	
	public void testFirstAndFollowComputation() {
		EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			int i = 0;
			System.out.println("testing " + rule.getMetaclass().getName());
			TreeIterator<EObject> ruleContents = rule.eAllContents();
			while (ruleContents.hasNext()) {
				System.out.println("element " + i);
				EObject next = ruleContents.next();
				computer.computeFollowExpectations(syntax, next);
				i++;
			}
		}
	}
}
