package org.emftext.language.calc.interpreter.events;

import org.emftext.language.calc.Variable;

public class SetVariableValueEvent implements ICalcInterpreterEvent {

	private Variable variable;
	private Object value;

	public SetVariableValueEvent(Variable variable, Object value) {
		super();
		this.variable = variable;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Setting variable '" + variable.getName() + "' to " + value;
	}
}
