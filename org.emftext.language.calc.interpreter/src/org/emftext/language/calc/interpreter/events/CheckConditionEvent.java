package org.emftext.language.calc.interpreter.events;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.calc.Expression;
import org.emftext.language.calc.resource.calc.ICalcTextPrinter;
import org.emftext.language.calc.resource.calc.ICalcTextResource;
import org.emftext.language.calc.resource.calc.mopp.CalcMetaInformation;
import org.emftext.language.calc.resource.calc.mopp.CalcResource;

public class CheckConditionEvent implements ICalcInterpreterEvent {

	private Expression condition;
	private boolean value;

	public CheckConditionEvent(Expression condition, boolean value) {
		super();
		this.condition = condition;
		this.value = value;
	}
	
	public String toString() {
		String conditionText = getText(condition);
		return "Condition '" + conditionText.trim() + "' is " + value;
	}

	private String getText(EObject eObject) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ICalcTextResource resource = new CalcResource();
		ICalcTextPrinter printer = new CalcMetaInformation().createPrinter(outputStream , resource);
		try {
			printer.print(eObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputStream.toString();
	}
}
