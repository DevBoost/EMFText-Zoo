package org.emftext.language.simplemath.interpreter;

import java.util.Stack;

public class SimpleMathContext {

	private Stack<Double> stack = new Stack<Double>();

	public double pop() {
		Double value = stack.pop();
		return value;
	}

	public void push(double value) {
		stack.push(value);
	}
}
