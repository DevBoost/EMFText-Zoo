package org.emftext.language.calc.interpreter;

public interface ICalcFunction {

	public String getName();
	public Object evaluate(Object... arguments);
}
