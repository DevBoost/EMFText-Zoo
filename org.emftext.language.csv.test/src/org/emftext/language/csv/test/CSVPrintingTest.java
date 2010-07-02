package org.emftext.language.csv.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.csv.CSVDocument;
import org.emftext.language.csv.CsvFactory;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.resource.csv.mopp.CsvMetaInformation;
import org.emftext.language.csv.resource.csv.mopp.CsvResourceFactory;

public class CSVPrintingTest extends TestCase {

	private static final String FILE_EXTENSION = new CsvMetaInformation().getSyntaxName();
	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final CsvFactory FACTORY = CsvFactory.eINSTANCE;

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				FILE_EXTENSION,
				new CsvResourceFactory());
	}
	
	public void testBug1408() {
		testPrinting(
				"a,b,c" + NEW_LINE + "d,e,f", 
				"a,b,c,new" + NEW_LINE + "d,e,f",
				"new"
		);
		testPrinting(
				"a,b,c" + NEW_LINE + "d,e,f", 
				"a,b,c,\"ne,w\"" + NEW_LINE + "d,e,f",
				"ne,w"
		);
	}

	private void testPrinting(String input, String expectedResult, String newValueText) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("bug1408." + FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EList<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		
		// check document content
		assertTrue(root instanceof CSVDocument);
		CSVDocument document = (CSVDocument) root;
		EList<Row> rows = document.getRows();
		assertEquals(2, rows.size());
		
		// modify document
		Row firstRow = rows.get(0);
		Value newValue = FACTORY.createValue();
		newValue.setText(newValueText);
		firstRow.getValues().add(newValue);
		
		// print document
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = outputStream.toString();
		assertEquals(expectedResult, printResult);
	}
}
