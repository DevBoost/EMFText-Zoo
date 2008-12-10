package org.emftext.language.java.test.resolving;

import org.junit.Test;

public class ReferenceToInheritedMethodTest extends AbstractResolverTest {
	
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "MethodCallsWithoutInheritance";
		String filename =  "resolving/" + typename + ".java";
		parseAndReprint(filename);
		
		typename = "ReferenceToInheritedMethod";
		filename =  "resolving/" + typename + ".java";
		parseAndReprint(filename);
	}

}
