package org.emftext.language.regexp.test.translation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_sdf.IRegexp_sdfTextPrinter;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.language.regexp.test.AbstractTest;

public class ANTLR2SDFTranslationTest extends AbstractTest {
	
	public void testTranslation() {
		translate("'a'..'z'", "[a-z]");
	}

	private void translate(String antlrRegexp, String expectedSDFRegexp) {
		EObject root = parse(antlrRegexp, new Regexp_antlrMetaInformation().getSyntaxName());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		IRegexp_sdfTextPrinter printer = new Regexp_sdfMetaInformation().createPrinter(out, null);
		try {
			printer.print(root);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		String result = out.toString();
		System.out.println("ANTLR2SDFTranslationTest.testTranslation() " + result);
		assertEquals(expectedSDFRegexp, result);
	}
}
