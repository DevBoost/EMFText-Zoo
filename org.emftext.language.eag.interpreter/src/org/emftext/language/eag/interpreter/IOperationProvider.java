package org.emftext.language.eag.interpreter;

public interface IOperationProvider<OperatorType> {

	public boolean canHandle(OperatorType operator, Class<?> leftType, Class<?> rightType);

	public Object interpret(OperatorType operator, Object left, Object right);
}
