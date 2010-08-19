package org.emftext.language.eag.interpreter;

/**
 * An IOperationProvider can compute the value of expressions of a certain
 * operator type. Depending on the result of calls to canHandle(), the
 * provider will be asked to interpret binary expressions.
 *
 * @param <OperatorType> the type of operator that can be handled
 */
public interface IOperationProvider<OperatorType> {

	public boolean canHandle(OperatorType operator, Class<?> leftType, Class<?> rightType);

	public Object interpret(OperatorType operator, Object left, Object right);
}
