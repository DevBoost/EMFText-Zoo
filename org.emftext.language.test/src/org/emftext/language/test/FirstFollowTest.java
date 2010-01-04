package org.emftext.language.test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

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

	// the generator models for these syntax contain references to Ecore or UML
	// which is not available when this test runs as JUnit test.
	// some of them refer to meta models that use textual syntax which is not
	// available either.
	private String[] excludedFiles = {
			".*/custom_sandwich.cs",
			".*/facade.ecore.cs",
			".*/text.ecore.cs",
			".*/efactory.cs",
			".*/eJava.cs",
			".*/JavaBehavior4UML.cs",
			".*/java_templates.cs",
			".*/owl.cs",
			".*/plugin.cs",
			".*/quickuml.cs",
			".*/statemachine.cs",
			".*/tbool.cs",
			".*/template_call.cs",
			".*/valueflow.cs",
			".*/concretesyntax.cs",
			".*/fragment.cs",
			".*/rex.cs"
	};
	private ExpectationComputer computer;

	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		computer = new ExpectationComputer();
	}

	public void testFirstAndFollowComputations() {
		Collection<String> grammars = ConcreteSyntaxTestHelper.findAllGrammars(new File(".."), new String[] {
			//".*/org/emftext/test/bug674/.*"
		});
		for (String grammar : grammars) {
			if (isExcluded(grammar)) {
				continue;
			}
			File grammarFile = new File(grammar);
			try {
				grammarFile = grammarFile.getCanonicalFile();
			} catch (IOException e) {
				fail(e.getMessage());
			}
			testFirstAndFollowComputation(grammarFile.getAbsolutePath());
		}
	}

	private boolean isExcluded(String grammar) {
		for (String excludedFile : excludedFiles) {
			String normlizedPath = grammar.replace(File.separator, "/");
			if (normlizedPath.matches(excludedFile)) {
				System.out.println("Excluded: " + grammar);
				return true;
			}
		}
		return false;
	}
	
	private void testFirstAndFollowComputation(String syntaxPath) {
		//System.out.println("--> testing " + syntaxPath);
		ConcreteSyntax syntax = loadSyntax(syntaxPath);
		EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			int i = 0;
			//System.out.println("----> testing " + rule.getMetaclass().getName());
			computer.computeFollowSet(syntax, rule);
			TreeIterator<EObject> ruleContents = rule.eAllContents();
			while (ruleContents.hasNext()) {
				EObject next = ruleContents.next();
				computer.computeFollowSet(syntax, next);
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
