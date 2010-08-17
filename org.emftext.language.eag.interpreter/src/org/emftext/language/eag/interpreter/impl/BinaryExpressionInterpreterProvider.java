package org.emftext.language.eag.interpreter.impl;

import org.emftext.language.eag.BinaryExpression;
import org.emftext.language.eag.BinaryOperator;

public class BinaryExpressionInterpreterProvider {

	public static final BinaryExpressionInterpreterProvider INSTANCE = new BinaryExpressionInterpreterProvider();

	public IReference interpret(BinaryExpression expression, ObjectReference leftRef, ObjectReference rightRef) {
		Object left = leftRef.getTarget();
		Object right = rightRef.getTarget();
		System.out.println("BinaryExpressionInterpreterProvider.interpret(" + left + ", " + right + ")");
		if (expression.getOperator() == BinaryOperator.PLUS &&
			left instanceof Integer &&
			right instanceof Integer) {
			Integer leftInt = (Integer) left;
			Integer rightInt = (Integer) right;
			return ReferenceFactory.INSTANCE.createReference(new Integer(leftInt.intValue() + rightInt.intValue()));
		}
		if (expression.getOperator() == BinaryOperator.TIMES &&
			left instanceof Integer &&
			right instanceof Integer) {
			Integer leftInt = (Integer) left;
			Integer rightInt = (Integer) right;
			return ReferenceFactory.INSTANCE.createReference(new Integer(leftInt.intValue() * rightInt.intValue()));
		}
		throw new RuntimeException("Can't find provider to handle binary expression " + expression.getOperator() + " on " + left + ", " + right);
	}
}
