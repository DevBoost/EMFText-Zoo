package org.emftext.language.threevaluedlogic;

import org.emftext.language.threevaluedlogic.resource.tvl.util.AbstractTvlInterpreter;

public class TVLInterpreter extends AbstractTvlInterpreter<InterpreterContext> {

	private Constants and(Constants arg1, Constants arg2) {
		if (arg1 == Constants.TRUE && arg2 == Constants.TRUE) {
			return Constants.TRUE;
		} else if (arg1 == Constants.FALSE || arg2 == Constants.FALSE) {
			return Constants.FALSE;
		} else {
			return Constants.UNKNOWN;
		}
	}

	private Constants or(Constants arg1, Constants arg2) {
		if (arg1 == Constants.TRUE || arg2 == Constants.TRUE) {
			return Constants.TRUE;
		} else if (arg1 == Constants.UNKNOWN || arg2 == Constants.UNKNOWN) {
			return Constants.UNKNOWN;
		} else {
			return Constants.FALSE;
		}
	}

	private Constants negate(Constants arg) {
		if (arg == Constants.FALSE) {
			return Constants.TRUE;
		} else if (arg == Constants.TRUE) {
			return Constants.FALSE;
		} else {
			return Constants.UNKNOWN;
		}
	}

	@Override
	public boolean interprete_org_emftext_language_threevaluedlogic_And(
			And object, InterpreterContext context) {
		context.push(and(context.pop(), context.pop()));
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_threevaluedlogic_Negation(
			Negation object, InterpreterContext context) {
		context.push(negate(context.pop()));
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_threevaluedlogic_Nested(
			Nested object, InterpreterContext context) {
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_threevaluedlogic_Or(
			Or object, InterpreterContext context) {

		context.push(or(context.pop(), context.pop()));
		return true;
	}

	@Override
	public boolean interprete_org_emftext_language_threevaluedlogic_Constant(
			Constant object, InterpreterContext context) {
		context.push(object.getValue());
		return true;
	}
}
