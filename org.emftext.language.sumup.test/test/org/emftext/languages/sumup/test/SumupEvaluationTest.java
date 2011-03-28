package org.emftext.languages.sumup.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.sumup.Assignment;
import org.emftext.language.sumup.Float;
import org.emftext.language.sumup.Result;
import org.emftext.language.sumup.Sheet;
import org.emftext.language.sumup.SumupSemanticsEvaluation;
import org.emftext.language.sumup.resource.sumup.mopp.SumupResource;
import org.emftext.language.sumup.resource.sumup.mopp.SumupResourceFactory;
import org.junit.Test;

public class SumupEvaluationTest {

	static {
		SumupResourceFactory s = new SumupResourceFactory();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"sumup", s);
	}

	@Test
	public void testAdditionResults() {
		File f = new File("./test/addition.sumup");
		SumupResource resource = load(f);
		SumupSemanticsEvaluation sse = new SumupSemanticsEvaluation();
		Sheet sheet = (Sheet) resource.getContents().get(0);
		sse.intialisePlaces(sheet);
		sse.evaluateSemantics();
		EList<Assignment> computations = sheet.getComputations();
		for (Assignment assignment : computations) {
			Result result = assignment.getResult();
			assertNotNull(result);
			assertTrue(result.getValue() instanceof org.emftext.language.sumup.Float);
			org.emftext.language.sumup.Float floatLiteral = (Float) result.getValue();
			assertEquals(floatLiteral.getValue(), 9f, 0.0f);
		}
	}

	private SumupResource load(File f) {
		ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		SumupResource sumupResource = (SumupResource) rs.getResource(
				URI.createFileURI(f.getAbsolutePath()), true);
		assertEquals(1, sumupResource.getContents().size());
		return sumupResource;
	}
}
