package org.emftext.language.eag.interpreter.impl.providers;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.language.eag.BinaryExpression;
import org.emftext.language.eag.BinaryOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;
import org.emftext.language.eag.interpreter.impl.references.AbstractObjectReference;
import org.emftext.language.eag.interpreter.impl.references.IReference;
import org.emftext.language.eag.interpreter.numbers.FloatOperationProvider;
import org.emftext.language.eag.interpreter.numbers.IntegerOperationProvider;

public class BinaryExpressionInterpreterProvider extends AbstractBinaryInterpreterProvider {

	public static final BinaryExpressionInterpreterProvider INSTANCE = new BinaryExpressionInterpreterProvider();
	
	public static Collection<IOperationProvider<BinaryOperator>> operationProviders;
	
	static {
		operationProviders = new ArrayList<IOperationProvider<BinaryOperator>>();
		operationProviders.add(new IntegerOperationProvider());
		operationProviders.add(new FloatOperationProvider());
	};

	public IReference interpret(BinaryExpression expression, AbstractObjectReference leftRef, AbstractObjectReference rightRef) {
		Object left = leftRef.getTarget();
		Object right = rightRef.getTarget();
		log("BinaryExpressionInterpreterProvider.interpret(" + left + ", " + right + ")");
		BinaryOperator operator = expression.getOperator();
		return interpretWithConversion(operationProviders, operator, left, right);
	}
}
