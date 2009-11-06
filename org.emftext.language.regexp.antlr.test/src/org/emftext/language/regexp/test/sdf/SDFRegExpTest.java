package org.emftext.language.regexp.test.sdf;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfResourceFactory;
import org.junit.Before;

public class SDFRegExpTest extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new Regexp_sdfMetaInformation().getSyntaxName(),
				new Regexp_sdfResourceFactory());
	}
	
	public void testSimpleExpressions() {
		parse("[abc]");
		parse("[a-z]");
		parse("[a-z0-9]");
		parse("[a-z]*");
		parse("[\\ \\t\\12\\r\\n]");
		parse("[btnfr\\\"\\'\\\\]");
		parse("~[\\\"\\\\\\n\\r]");
		parse("~([a-z]*)");
		parse("\"keyword\"");
		parse("\"keyword\"|\"anotherKeyword\"");
	}

	// TODO this method was copied from RegExpTest
	private void parse(String nextRegexp) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp." + new Regexp_sdfMetaInformation().getSyntaxName()));
		try {
			System.out.println("parse(): " + nextRegexp);
			r.load(new ByteArrayInputStream(nextRegexp.getBytes()), null);
			EList<Diagnostic> errors = r.getErrors();
			for (Diagnostic error : errors) {
				System.out.println("Error: " + error.getMessage() + "(" + error.getColumn() + ")");
			}
			assertTrue("Errors are found.", errors.size() == 0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
