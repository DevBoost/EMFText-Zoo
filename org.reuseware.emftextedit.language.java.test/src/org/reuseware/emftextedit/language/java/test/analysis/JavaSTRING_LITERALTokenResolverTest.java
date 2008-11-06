package org.reuseware.emftextedit.language.java.test.analysis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.reuseware.emftextedit.language.java.resource.java.analysis.JavaSTRING_LITERALTokenResolver;

public class JavaSTRING_LITERALTokenResolverTest {

	@Test
	public void testUnicodeEscaping() {
		JavaSTRING_LITERALTokenResolver resolver = new JavaSTRING_LITERALTokenResolver();
		assertEquals("\0\07\007\0007", resolve(resolver, "\\0\\07\\007\\0007"));
		assertEquals("\07", resolve(resolver, "\\07"));
		assertEquals("\007", resolve(resolver, "\\007"));
		assertEquals("\0007", resolve(resolver, "\\0007"));

		// test ordinary unicode escape sequence
		assertEquals("\u0020", resolve(resolver, "\\u0020"));
		// test escaped backslash (not a unicode sequence)
		assertEquals("\\u0020", resolve(resolver, "\\\\u0020"));

		assertEquals("\\", resolve(resolver, "\\\\"));
		assertEquals("\n", resolve(resolver, "\\n"));
		assertEquals("\b", resolve(resolver, "\\b"));
		assertEquals("\f", resolve(resolver, "\\f"));
		assertEquals("\t", resolve(resolver, "\\t"));
		assertEquals("\r", resolve(resolver, "\\r"));
		assertEquals("\"", resolve(resolver, "\\\""));
		assertEquals("\'", resolve(resolver, "\\\'"));
		
		assertEquals("\0", resolve(resolver, "\\0"));
		assertEquals("\10", resolve(resolver, "\\10"));
		assertEquals("\377", resolve(resolver, "\\377"));
	}

	private String resolve(JavaSTRING_LITERALTokenResolver resolver, String lexem) {
		return (String) resolver.resolve("\"" + lexem + "\"", null, null, null);
	}
}
