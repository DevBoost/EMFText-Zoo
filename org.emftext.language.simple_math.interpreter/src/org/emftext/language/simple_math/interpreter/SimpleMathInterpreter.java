package org.emftext.language.simple_math.interpreter;

import org.emftext.language.simple_math.Additive;
import org.emftext.language.simple_math.BracketExp;
import org.emftext.language.simple_math.IntegerLiteralExp;
import org.emftext.language.simple_math.Multiplicative;
import org.emftext.language.simple_math.Negation;
import org.emftext.language.simple_math.RealLiteralExp;
import org.emftext.language.simple_math.resource.sm.util.AbstractSmInterpreter;

/**
 * A simple example interpreter that computes the value of the math expression.
 */
public class SimpleMathInterpreter extends AbstractSmInterpreter<SimpleMathContext> {

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Additive(
			Additive object, SimpleMathContext context) {
		double result;
		if ("+".equals(object.getOperator())) {
			result = context.pop() + context.pop();
			context.push(result);
		} else {
			result = context.pop() - context.pop();
			context.push(result);
		}
		object.setValue(result);
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_BracketExp(
			BracketExp object, SimpleMathContext context) {
		double result = context.pop();
		context.push(result);
		object.setValue(result);
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Multiplicative(
			Multiplicative object, SimpleMathContext context) {
		double result;
		if ("*".equals(object.getOperator())) {
			result = context.pop() * context.pop();
			context.push(result);
		} else {
			result = context.pop() / context.pop();
			context.push(result);
		}
		object.setValue(result);
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Negation(
			Negation object, SimpleMathContext context) {
		double result = -context.pop();
		context.push(result);
		object.setValue(result);
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_IntegerLiteralExp(
			IntegerLiteralExp object, SimpleMathContext context) {
		context.push(object.getIntValue());
		object.setValue(object.getIntValue());
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_RealLiteralExp(
			RealLiteralExp object, SimpleMathContext context) {
		context.push(object.getFloatValue());
		object.setValue(object.getFloatValue());
		return true;
	}
}
