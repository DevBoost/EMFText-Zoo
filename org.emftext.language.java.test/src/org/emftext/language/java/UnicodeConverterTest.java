package org.emftext.language.java;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

public class UnicodeConverterTest {
	
	@Test
	public void testConversion() throws IOException {
		assertConversion("\\u0000\\uFfFf", "\\\\u0000\\\\uFfFf");
	}

	private void assertConversion(String expectedOutput, String input) throws IOException {
		UnicodeConverter converter = new UnicodeConverter(new ByteArrayInputStream(input.getBytes()));
		String result = "";
		int next;
		while ((next = converter.read()) >= 0) {
			result += (char) next;
		}
		assertEquals(expectedOutput, result);
	}
}
