package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BinaryOperator;
import org.emftext.language.eag.interpreter.IBinaryOperationProvider;

public class IntegerOperationProvider implements IBinaryOperationProvider {

	public boolean canHandle(
			BinaryOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (leftType != Integer.class) {
			return false;
		}
		if (rightType != Integer.class) {
			return false;
		}
		return true;
	}

	public Object interpret(BinaryOperator operator, Object leftObject, Object rightObject) {
		Integer left = (Integer) leftObject;
		Integer right = (Integer) rightObject;
		if (operator == BinaryOperator.PLUS) {
			return new Integer(left.intValue() + right.intValue());
		}
		if (operator == BinaryOperator.TIMES) {
			return new Integer(left.intValue() * right.intValue());
		}
		if (operator == BinaryOperator.DIV) {
			return new Integer(left.intValue() / right.intValue());
		}
		if (operator == BinaryOperator.MINUS) {
			return new Integer(left.intValue() - right.intValue());
		}
		return null;
	}

}
