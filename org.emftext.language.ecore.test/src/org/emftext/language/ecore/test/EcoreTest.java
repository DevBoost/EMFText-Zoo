package org.emftext.language.ecore.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.ecore.resource.ecore.EcoreResourceFactory;
import org.junit.Before;
import org.junit.Test;

public class EcoreTest extends AbstractEcoreTestCase {
	
	@Before
	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactory());
	}

	@Test
	public void testGenerics() {
		assertParse("TypeArguments.ecore");
		assertParse("TypeParameters.ecore");
	}

	private void assertParse(String fileName) {
		try {
			EPackage ePackage = loadResource("input" + File.separator + fileName, fileName);
			assertNotNull(ePackage);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
