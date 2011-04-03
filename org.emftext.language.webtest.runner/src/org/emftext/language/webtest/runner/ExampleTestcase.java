package org.emftext.language.webtest.runner;

import org.junit.Test;

public class ExampleTestcase {
	
	@Test
	public void testExample() {
		new WebtestRunner().runTest("examples/emftext.org.webtest");
	}
}
