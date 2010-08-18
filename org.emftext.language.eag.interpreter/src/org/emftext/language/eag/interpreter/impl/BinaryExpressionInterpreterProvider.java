package org.emftext.language.eag.interpreter.impl;

import org.emftext.language.eag.BinaryExpression;
import org.emftext.language.eag.BinaryOperator;
import org.emftext.language.eag.interpreter.IBinaryOperationProvider;
import org.emftext.language.eag.interpreter.IOperationProvider;
import org.emftext.language.eag.interpreter.numbers.FloatOperationProvider;
import org.emftext.language.eag.interpreter.numbers.IntegerOperationProvider;

public class BinaryExpressionInterpreterProvider extends AbstractBinaryInterpreterProvider {

	public static final BinaryExpressionInterpreterProvider INSTANCE = new BinaryExpressionInterpreterProvider();
	
	@SuppressWarnings("rawtypes")
	public IOperationProvider[] operationProviders = new IBinaryOperationProvider[] {
		new IntegerOperationProvider(),
		new FloatOperationProvider()
	};

	@SuppressWarnings("unchecked")
	public IReference interpret(BinaryExpression expression, ObjectReference leftRef, ObjectReference rightRef) {
		Object left = leftRef.getTarget();
		Object right = rightRef.getTarget();
		System.out.println("BinaryExpressionInterpreterProvider.interpret(" + left + ", " + right + ")");
		BinaryOperator operator = expression.getOperator();
		return interpretWithConversion(operationProviders, operator, left, right);
	}
}
