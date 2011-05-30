package org.emftext.language.pico.resource.pico.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class PicoInterpretationContext {

	private Map<String, Object> variableValues = new LinkedHashMap<String, Object>();
	private Stack<Object> expressionStack = new Stack<Object>();
	
	public Object getValue(String variable) {
		return variableValues.get(variable);
	}

	public void setValue(String variable, Object value) {
		variableValues.put(variable, value);
	}

	public void push(Object value) {
		expressionStack.push(value);
	}

	public int expressionStackSize() {
		return expressionStack.size();
	}

	public Object pop() {
		return expressionStack.pop();
	}
}
