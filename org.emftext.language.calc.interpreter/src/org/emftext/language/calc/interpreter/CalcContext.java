package org.emftext.language.calc.interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.emftext.language.calc.Variable;
import org.emftext.language.calc.interpreter.events.ICalcInterpreterEvent;

public class CalcContext {

	private Map<Variable, Object> variableMap = new LinkedHashMap<Variable, Object>();
	private Map<String, ICalcFunction> functionMap = new LinkedHashMap<String, ICalcFunction>();

	private List<ICalcInterpreterEvent> events = new ArrayList<ICalcInterpreterEvent>();

	public Object getValue(Variable variable) {
		return variableMap.get(variable);
	}

	public void setValue(Variable variable, Object newValue) {
		variableMap.put(variable, newValue);
	}

	public void addInterpretationEvent(ICalcInterpreterEvent event) {
		events.add(event);
	}

	public void addFunction(ICalcFunction function) {
		functionMap.put(function.getName(), function);
	}

	public ICalcFunction getFunction(String name) {
		return functionMap.get(name);
	}

	public List<ICalcInterpreterEvent> getEvents() {
		return events;
	}
}
