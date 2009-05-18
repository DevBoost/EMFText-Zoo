package org.emftext.language.template_concepts.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

public class LoopVariablesStack {
	
	public class LoopVariable {
		private String name;
		private EObject value;
		
		public LoopVariable(String name, EObject value) {
			super();
			this.name = name;
			this.value = value;
		}
		
		public String getName() {
			return name;
		}
		
		public EObject getValue() {
			return value;
		}
	}
	
	private Stack<LoopVariable> variableStack = new Stack<LoopVariable>();

	public void push(String name, EObject value) {
		variableStack.push(new LoopVariable(name, value));
	}

	public void pop() {
		variableStack.pop();
	}

	public Map<String, EObject> getTopMostVariables() {
		Map<String, EObject> result = new HashMap<String, EObject>();
		for (LoopVariable variable : variableStack) {
			result.put(variable.getName(), variable.getValue());
		}
		return result;
	}
}
