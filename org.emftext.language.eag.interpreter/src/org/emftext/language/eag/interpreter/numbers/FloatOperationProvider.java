package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BinaryOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;

public class FloatOperationProvider implements IOperationProvider<BinaryOperator> {

	public boolean canHandle(
			BinaryOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (leftType != Float.class) {
			return false;
		}
		if (rightType != Float.class) {
			return false;
		}
		return true;
	}

	public Object interpret(BinaryOperator operator, Object leftObject, Object rightObject) {
		Float left = (Float) leftObject; 
		Float right = (Float) rightObject;
		if (operator == BinaryOperator.PLUS) {
			return new Float(left.floatValue() + right.floatValue());
		}
		if (operator == BinaryOperator.TIMES) {
			return new Float(left.floatValue() * right.floatValue());
		}
		if (operator == BinaryOperator.DIV) {
			return new Float(left.floatValue() / right.floatValue());
		}
		if (operator == BinaryOperator.MINUS) {
			return new Float(left.floatValue() - right.floatValue());
		}
		return null;
	}

}
