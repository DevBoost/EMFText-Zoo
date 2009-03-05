package org.emftext.language.ecore.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;

public class EcoreTest extends AbstractEcoreTestCase {

	@Test
	public void testTypeParameters() {
		String fileName = "TypeParameters.ecore";
		try {
			InputStream inputStream = new FileInputStream("input" + File.separator + fileName);
			EPackage ePackage = loadResource(inputStream, fileName);
			assertNotNull(ePackage);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
