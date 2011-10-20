package org.emftext.language.calc.types;

import org.emftext.language.calc.CalcFactory;
import org.emftext.language.calc.Type;

public class CalcBuiltinTypes {

	public static final Type DOUBLE = CalcFactory.eINSTANCE.createType();
	public static final Type STRING = CalcFactory.eINSTANCE.createType();

	public final static Type[] ALL_BUILT_IN_TYPES = new Type[] {
		DOUBLE, STRING
	};

	static {
		DOUBLE.setName("double");
		STRING.setName("string");
	}
}
