package org.emftext.language.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.junit.Test;

public class ANTLRStreamTest {

	@Test
	public void testANTLRStream() throws IOException {
		InputStream in = new ByteArrayInputStream("\u0001".getBytes("UTF-16"));
		ANTLRInputStream antlrInputStream = new ANTLRInputStream(in, "UTF-8");
		int x = antlrInputStream.LA(1);
		System.out.println(x);
		x = antlrInputStream.LA(2);
		System.out.println(x);
	}
}
