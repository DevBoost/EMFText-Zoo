/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.runtime.ANTLRInputStream;
import org.emftext.language.java.resource.java.util.JavaUnicodeConverter;
import org.junit.Test;

public class UnicodeConverterTest {
	
	@Test
	public void testUnsignedByteToInt() {
		assertEquals(255, JavaUnicodeConverter.unsignedByteToInt((byte) 0xFF));
		assertEquals(1, JavaUnicodeConverter.unsignedByteToInt((byte) 0x01));
	}
	
	@Test
	public void testConversion() throws IOException {
		assertConversion("\uabcd", "\\uuuuuuuuuuabcd");
		assertConversion("\u0001\u0101", "\\u0001\\u0101");
		assertConversion("\u0001\uFfFf", "\\u0001\\uFfFf");
		assertConversion("\\\\u0000\\\\uFfFf", "\\\\u0000\\\\uFfFf");
		assertConversion("\\377\\388", "\\377\\388");
		assertConversion("\u202a", "\\u202a");
	}

	private void assertConversion(String expectedOutput, String input) throws IOException {
		JavaUnicodeConverter converter = new JavaUnicodeConverter(new ByteArrayInputStream(input.getBytes()));
		byte[] bytes = new byte[100];
		int next;
		int i = 0;
		while ((next = converter.read()) >= 0) {
			System.out.println("UnicodeConverterTest.assertConversion() next = " + next);
			bytes[i++] = (byte) next;
		}
		byte[] usedBytes = new byte[i];
		for (i = 0; i < usedBytes.length; i++) {
			usedBytes[i] = bytes[i];
		}
		assertArrayEquals(expectedOutput.getBytes("UTF-8"), usedBytes);
	}


	@Test
	public void testStreaming() {
		try {
			byte[] bs = JavaUnicodeConverter.encode(new int[] {0x202a});
			InputStream stream = new ByteArrayInputStream(bs);

			InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
			assertEquals(0x202a, reader.read());
			assertEquals(-1, reader.read());

			bs = JavaUnicodeConverter.encode(new int[] {0x40, 0x202a});
			stream = new ByteArrayInputStream(bs);
			ANTLRInputStream antlrStream = new ANTLRInputStream(stream, "UTF-8");
			int byte1 = antlrStream.LT(2);
			assertEquals(0x202a, byte1);
			
			System.out.println("ANTLRStreamTest.testStreaming()");
			stream = new JavaUnicodeConverter(new ByteArrayInputStream("a\\u202a".getBytes()));
			antlrStream = new ANTLRInputStream(stream, "UTF-8");
			byte1 = antlrStream.LT(2);
			assertEquals(0x202a, byte1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
	}
}
