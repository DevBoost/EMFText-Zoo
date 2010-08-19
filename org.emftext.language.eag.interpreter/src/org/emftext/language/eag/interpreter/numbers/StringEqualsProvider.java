package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BooleanOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;

public class StringEqualsProvider implements IOperationProvider<BooleanOperator> {

	public boolean canHandle(
			BooleanOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (operator != BooleanOperator.EQUALS) {
			return false;
		}
		return leftType == String.class && rightType == String.class;
	}

	public Object interpret(BooleanOperator operator, Object left, Object right) {
		String leftString = (String) left;
		String rightString = (String) right;
		if (leftString == null && rightString == null) {
			return true;
		}
		return leftString.equals(rightString);
	}
}
