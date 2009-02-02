package org.emftext.language.java.test.analysis;

import org.emftext.language.java.resource.java.analysis.JavaDECIMAL_DOUBLE_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaDECIMAL_FLOAT_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaDECIMAL_INTEGER_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaDECIMAL_LONG_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaHEX_DOUBLE_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaHEX_FLOAT_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaHEX_INTEGER_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaHEX_LONG_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaOCTAL_INTEGER_LITERALTokenResolver;
import org.emftext.language.java.resource.java.analysis.JavaOCTAL_LONG_LITERALTokenResolver;
import org.emftext.runtime.resource.ITokenResolver;

import junit.framework.TestCase;

public class NumberLiteralResolverTest extends TestCase {

	JavaDECIMAL_INTEGER_LITERALTokenResolver decInt = new JavaDECIMAL_INTEGER_LITERALTokenResolver();
	JavaDECIMAL_LONG_LITERALTokenResolver decLong = new JavaDECIMAL_LONG_LITERALTokenResolver();
	JavaDECIMAL_FLOAT_LITERALTokenResolver decFloat = new JavaDECIMAL_FLOAT_LITERALTokenResolver();
	JavaDECIMAL_DOUBLE_LITERALTokenResolver decDouble = new JavaDECIMAL_DOUBLE_LITERALTokenResolver();
	
	JavaHEX_INTEGER_LITERALTokenResolver hexInt = new JavaHEX_INTEGER_LITERALTokenResolver();
	JavaHEX_LONG_LITERALTokenResolver hexLong = new JavaHEX_LONG_LITERALTokenResolver();
	JavaHEX_FLOAT_LITERALTokenResolver hexFloat = new JavaHEX_FLOAT_LITERALTokenResolver();
	JavaHEX_DOUBLE_LITERALTokenResolver hexDouble = new JavaHEX_DOUBLE_LITERALTokenResolver();
	
	JavaOCTAL_INTEGER_LITERALTokenResolver octInt = new JavaOCTAL_INTEGER_LITERALTokenResolver();
	JavaOCTAL_LONG_LITERALTokenResolver octLong = new JavaOCTAL_LONG_LITERALTokenResolver();
	
	public void testResolving() {
		assertEquals(new Integer(1), resolveDecInt("1"));
		assertEquals(new Integer(1), resolveHexInt("0x000001"));
		assertEquals(new Integer(1), resolveOctInt("001"));

		assertEquals(new Long(1), resolveDecLong("1L"));
		assertEquals(new Long(1), resolveHexLong("0x000001L"));

		assertEquals(new Float(1.0f), resolveDecFloat("1.0f"));
		assertEquals(new Float(0x1.0p0f), resolveHexFloat("0x1.0p0f"));
		assertEquals(new Float(0x1.1p0f), resolveHexFloat("0x1.1p0f"));

		assertEquals(new Double(1.0), resolveDecDouble("1.0"));
		assertEquals(new Double(1.0), resolveDecDouble("1.0d"));
		assertEquals(new Double(0x1.0p0d), resolveHexDouble("0x1.0p0d"));
		assertEquals(new Double(0x1.1p0d), resolveHexDouble("0x1.1p0d"));
		assertEquals(new Double(0x1.1p0), resolveHexDouble("0x1.1p0"));
	}

	private Object resolveDecInt(String lexem) {
		return resolve(decInt, lexem);
	}

	private Object resolveDecLong(String lexem) {
		return resolve(decLong, lexem);
	}

	private Object resolveDecFloat(String lexem) {
		return resolve(decFloat, lexem);
	}

	private Object resolveDecDouble(String lexem) {
		return resolve(decDouble, lexem);
	}

	private Object resolveHexInt(String lexem) {
		return resolve(hexInt, lexem);
	}

	private Object resolveHexLong(String lexem) {
		return resolve(hexLong, lexem);
	}

	private Object resolveHexFloat(String lexem) {
		return resolve(hexFloat, lexem);
	}

	private Object resolveHexDouble(String lexem) {
		return resolve(hexDouble, lexem);
	}

	private Object resolveOctInt(String lexem) {
		return resolve(octInt, lexem);
	}

	private Object resolveOctLong(String lexem) {
		return resolve(octLong, lexem);
	}

	private Object resolve(ITokenResolver resolver, String lexem) {
		Object result = resolver.resolve(lexem, null, null, null);
		assertNotNull(result);

		boolean isInteger = result instanceof Integer;
		boolean isLong = result instanceof Long;
		boolean isFloat = result instanceof Float;
		boolean isDouble = result instanceof Double;
		boolean isNumber = isInteger || isLong || isFloat || isDouble;
		assertTrue(isNumber);
		
		return result;
	}
}
