package org.emftext.language.simple_math.interpreter;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.simple_math.Additive;
import org.emftext.language.simple_math.BracketExp;
import org.emftext.language.simple_math.IntegerLiteralExp;
import org.emftext.language.simple_math.Multiplicative;
import org.emftext.language.simple_math.Negation;
import org.emftext.language.simple_math.RealLiteralExp;
import org.emftext.language.simple_math.Root;
import org.emftext.language.simple_math.resource.sm.util.AbstractSmInterpreter;

/**
 * A simple example interpreter that computes the value of the math expression.
 */
public class SimpleMathInterpreter extends AbstractSmInterpreter<SimpleMathContext> {

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Additive(
			Additive object, SimpleMathContext context) {
		if ("+".equals(object.getOperator())) {
			context.push(context.pop() + context.pop());
		} else {
			context.push(context.pop() - context.pop());
		}
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_BracketExp(
			BracketExp object, SimpleMathContext context) {

		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Multiplicative(
			Multiplicative object, SimpleMathContext context) {
		
		if ("*".equals(object.getOperator())) {
			context.push(context.pop() * context.pop());
		} else {
			context.push(context.pop() / context.pop());
		}
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Negation(
			Negation object, SimpleMathContext context) {
		context.push(-context.pop());
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_IntegerLiteralExp(
			IntegerLiteralExp object, SimpleMathContext context) {
		context.push(object.getIntValue());
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_RealLiteralExp(
			RealLiteralExp object, SimpleMathContext context) {
		context.push(object.getFloatValue());
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_simple_005Fmath_Root(
			Root object, SimpleMathContext context) {
		TreeIterator<EObject> contents = object.eAllContents();
		while (contents.hasNext()) {
			addObjectToInterprete(contents.next());
		}
		return true;
	}
}
