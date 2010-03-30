package org.emftext.language.pl0.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.pl0.resource.pl0.IPl0TextPrinter;
import org.emftext.language.pl0.resource.pl0.IPl0TextResource;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0Printer2;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.emftext.language.pl0.resource.pl0.util.Pl0StreamUtil;

public class Pl0LayoutPreservationTest extends TestCase {
	
	private static final String PL0_SYNTAX_EXTENSION = new Pl0MetaInformation().getSyntaxName();

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				PL0_SYNTAX_EXTENSION,
				new Pl0ResourceFactory());
	}
	
	public void testLayout() {
		File inputFolder = new File("." + File.separator + "input");
		File[] inputFiles = inputFolder.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(".pl0");
			}
		});
		for (File file : inputFiles) {
			assertParseAndPrint(file);
		}
	}

	private void assertParseAndPrint(File file) {
		EObject root = parse(file);
		try {
			assertPrinting(root, Pl0StreamUtil.getContent(new FileInputStream(file)));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private EObject parse(File file) {
		IPl0TextResource tempResource = createTempResource();
		try {
			tempResource.load(new FileInputStream(file), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EcoreUtil.resolveAll(tempResource);
		EList<EObject> contents = tempResource.getContents();
		assertNotNull("Resource must have content.", contents);
		assertEquals(1, contents.size());
		assertEquals("Resource should have no errors", 0, tempResource.getErrors().size());
		EObject root = contents.get(0);
		return root;
	}

	protected IPl0TextResource createTempResource() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI tempURI = URI.createURI("temp." + PL0_SYNTAX_EXTENSION);
		return (IPl0TextResource) resourceSet.createResource(tempURI);
	}

	protected void assertPrinting(EObject object, String expected) {
		IPl0TextResource resource = createTempResource();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Pl0Printer2 printer2 = new Pl0Printer2(outputStream, resource);
		String printer2result = getPrintResult(object, printer2, outputStream);
		System.out.println("PRINTER2 returns: ==>" + printer2result + "<== (" + Arrays.toString(printer2result.getBytes()) + ")");
		System.out.println("Expected is:      ==>" + expected + "<== (" + Arrays.toString(expected.getBytes()) + ")");
		
		assertEquals("Wrong result from printer2.", expected, printer2result);
	}

	private String getPrintResult(EObject object, IPl0TextPrinter printer, OutputStream outputStream) {
		try {
			printer.print(object);
			String result = outputStream.toString();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return null;
	}
}
