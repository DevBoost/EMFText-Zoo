package org.emftext.language.forms.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.emftext.language.forms.Decision;
import org.emftext.language.forms.FormsFactory;
import org.emftext.language.forms.Item;
import org.emftext.language.forms.Option;
import org.emftext.language.forms.resource.forms.mopp.FormsPrinter2;

public class FormsPrintingTest extends TestCase {

	private static final FormsFactory FACTORY = FormsFactory.eINSTANCE;

	public void testPrinting() {
		
		Item item = FACTORY.createItem();
		item.setText("D");
		
		Option option1 = FACTORY.createOption();
		option1.setText("e");
		Option option2 = FACTORY.createOption();
		option2.setText("f");

		Decision decision = FACTORY.createDecision();
		decision.getOptions().add(option1);
		decision.getOptions().add(option2);
		item.setItemType(decision);
		
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		FormsPrinter2 printer = new FormsPrinter2(outStream, null);
		try {
			printer.print(item);
			String result = outStream.toString();
			assertEquals("Unexpected result from printer", "ITEM\"d\":DECISION(\"e\",\"f\")", result);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
