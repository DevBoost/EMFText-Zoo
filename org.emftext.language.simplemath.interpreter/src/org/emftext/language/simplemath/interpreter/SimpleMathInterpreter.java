package org.emftext.language.simplemath.interpreter;

import org.emftext.language.simplemath.Additive;
import org.emftext.language.simplemath.BracketExp;
import org.emftext.language.simplemath.IntegerLiteralExp;
import org.emftext.language.simplemath.Multiplicative;
import org.emftext.language.simplemath.Negation;
import org.emftext.language.simplemath.Potence;
import org.emftext.language.simplemath.RealLiteralExp;
import org.emftext.language.simplemath.resource.sm.util.AbstractSmInterpreter;

/**
 * A simple example interpreter that computes the value of the math expression.
 */
public class SimpleMathInterpreter extends AbstractSmInterpreter<Boolean, SimpleMathContext> {

	@Override
	public Boolean interprete_org_emftext_language_simplemath_Additive(
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
	public Boolean interprete_org_emftext_language_simplemath_BracketExp(
			BracketExp object, SimpleMathContext context) {
		double result = context.pop();
		context.push(result);
		object.setValue(result);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_simplemath_Multiplicative(
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
	public Boolean interprete_org_emftext_language_simplemath_Negation(
			Negation object, SimpleMathContext context) {
		double result = context.pop();
		if("-".equals(object.getOperator())){
			result = - result;
		}
		context.push(result);
		object.setValue(result);
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_simplemath_IntegerLiteralExp(
			IntegerLiteralExp object, SimpleMathContext context) {
		context.push(object.getIntValue());
		object.setValue(object.getIntValue());
		return true;
	}

	@Override
	public Boolean interprete_org_emftext_language_simplemath_RealLiteralExp(
			RealLiteralExp object, SimpleMathContext context) {
		context.push(object.getFloatValue());
		object.setValue(object.getFloatValue());
		return true;
	}
	
	@Override
	public Boolean interprete_org_emftext_language_simplemath_Potence(Potence object, SimpleMathContext context) {
		double exponent = context.pop();
		double base = context.pop();
		double result = Math.pow(base,exponent);
		object.setValue(result);
		context.push(result);
		return true;
	}
}
