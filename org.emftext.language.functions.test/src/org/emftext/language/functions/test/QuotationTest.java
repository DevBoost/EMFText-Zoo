package org.emftext.language.functions.test;

import junit.framework.TestCase;

import org.emftext.language.functions.Function;
import org.emftext.language.functions.FunctionsFactory;

public class QuotationTest extends TestCase {

	public void testQuotation() {
		
		Function function = FunctionsFactory.eINSTANCE.createFunction();
		function.setName("abc'def'geh");
		
		assertEquals("abc\\inquotes{def}geh", function.getReadableName());
	}
}
