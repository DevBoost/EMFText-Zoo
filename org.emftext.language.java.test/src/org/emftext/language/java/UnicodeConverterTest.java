package org.emftext.language.java;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class UnicodeConverterTest {
	
	@Test
	public void testConversion() throws IOException {
		assertConversion("\u0001\u0101", "\\u0001\\u0101");
		assertConversion("\u0001\uFfFf", "\\u0001\\uFfFf");
		assertConversion("\\\\u0000\\\\uFfFf", "\\\\u0000\\\\uFfFf");
		assertConversion("\\377\\388", "\\377\\388");
	}

	private void assertConversion(String expectedOutput, String input) throws IOException {
		UnicodeConverter converter = new UnicodeConverter(new ByteArrayInputStream(input.getBytes()));
		String result = "";
		int next;
		while ((next = converter.read()) >= 0) {
			char nextChar = (char) next;
			System.out.println("assertConversion() " + next);
			result += nextChar;
		}
		assertEquals(expectedOutput, result);
	}
}
