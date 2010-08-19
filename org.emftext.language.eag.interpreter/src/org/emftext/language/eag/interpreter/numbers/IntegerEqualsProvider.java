package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BooleanOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;

public class IntegerEqualsProvider implements IOperationProvider<BooleanOperator> {

	public boolean canHandle(
			BooleanOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (operator != BooleanOperator.EQUALS) {
			return false;
		}
		return leftType == Integer.class && rightType == Integer.class;
	}

	public Object interpret(BooleanOperator operator, Object left, Object right) {
		Integer leftInteger = (Integer) left;
		Integer rightInteger = (Integer) right;
		return leftInteger.intValue() == rightInteger.intValue();
	}
}
