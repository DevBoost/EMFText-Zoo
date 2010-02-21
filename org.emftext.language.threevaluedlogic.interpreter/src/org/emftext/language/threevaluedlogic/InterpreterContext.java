package org.emftext.language.threevaluedlogic;

import java.util.Stack;

public class InterpreterContext {

	private Stack<Constants> stack = new Stack<Constants>();
	
	public void push(Constants constant) {
		stack.push(constant);
	}

	public Constants pop() {
		return stack.pop();
	}
}
