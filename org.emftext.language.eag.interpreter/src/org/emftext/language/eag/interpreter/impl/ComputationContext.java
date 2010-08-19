package org.emftext.language.eag.interpreter.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.eag.Variable;

public class ComputationContext {

	private EObject object;
	private AttributeGrammar grammar;
	private Object result;
	private Map<Variable, Object> variableMap = new LinkedHashMap<Variable, Object>();

	public ComputationContext(AttributeGrammar grammar, EObject object, EObject result) {
		super();
		this.grammar = grammar;
		this.object = object;
		this.result = result;
	}

	public EObject getObject() {
		return object;
	}

	public AttributeGrammar getGrammar() {
		return grammar;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object newValue) {
		result = newValue;
	}

	public void addVariable(Variable variable, Object next) {
		variableMap.put(variable, next);
	}

	public void removeVariable(Variable variable) {
		variableMap.remove(variable);
	}

	public Object getVariableValue(Variable variable) {
		return variableMap.get(variable);
	}
}
