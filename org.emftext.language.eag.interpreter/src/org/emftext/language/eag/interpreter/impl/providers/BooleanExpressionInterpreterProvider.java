package org.emftext.language.eag.interpreter.impl.providers;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.language.eag.BooleanExpression;
import org.emftext.language.eag.BooleanOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;
import org.emftext.language.eag.interpreter.impl.references.IReference;
import org.emftext.language.eag.interpreter.numbers.IntegerEqualsProvider;
import org.emftext.language.eag.interpreter.numbers.StringEqualsProvider;

public class BooleanExpressionInterpreterProvider extends AbstractInterpreterProvider {

	public static final BooleanExpressionInterpreterProvider INSTANCE = new BooleanExpressionInterpreterProvider();
	
	public static Collection<IOperationProvider<BooleanOperator>> operationProviders;
	
	static {
		operationProviders = new ArrayList<IOperationProvider<BooleanOperator>>();
		operationProviders.add(new IntegerEqualsProvider());
		operationProviders.add(new StringEqualsProvider());
	};

	public IReference interpret(BooleanExpression expression, IReference leftRef, IReference rightRef) {
		Object left = leftRef.getTarget();
		Object right = rightRef.getTarget();
		log("BooleanExpressionInterpreterProvider.interpret(" + left + ", " + right + ")");
		BooleanOperator operator = expression.getOperator();
		return interpretWithConversion(operationProviders, operator, left, right);
	}
}
