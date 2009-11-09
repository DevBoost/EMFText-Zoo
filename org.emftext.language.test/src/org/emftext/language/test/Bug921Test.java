package org.emftext.language.test;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import junit.framework.TestCase;

// This test needs to run as JUnit Plug-in test and fails currently
public class Bug921Test extends TestCase {

	public void testBug921() {
		URI uri = URI.createURI("platform:/plugin/org.emftext.test.grammar_features/metamodel/grammar_features.genmodel");
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(uri);
		try {
			r.load(null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
