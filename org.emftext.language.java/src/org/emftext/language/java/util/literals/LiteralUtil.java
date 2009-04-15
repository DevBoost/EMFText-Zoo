package org.emftext.language.java.util.literals;

import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.literals.BooleanLiteral;
import org.emftext.language.java.literals.CharacterLiteral;
import org.emftext.language.java.literals.DoubleLiteral;
import org.emftext.language.java.literals.FloatLiteral;
import org.emftext.language.java.literals.IntegerLiteral;
import org.emftext.language.java.literals.Literal;
import org.emftext.language.java.literals.LongLiteral;
import org.emftext.language.java.literals.NullLiteral;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaClasspathUtil;

public class LiteralUtil {
	
	/**
	 * @param _this
	 * @return type of the literal
	 */
	public static Type getType(Literal _this) {
		Class javaClass = null;
		
		if (_this instanceof NullLiteral) {
			javaClass = JavaClasspathUtil.getClass("Void", _this);
		}
		else if (_this instanceof BooleanLiteral) {
			javaClass = JavaClasspathUtil.getClass("Boolean", _this);
		}
		else if (_this instanceof DoubleLiteral) {
			javaClass = JavaClasspathUtil.getClass("Double", _this);
		}
		else if (_this instanceof FloatLiteral) {
			javaClass = JavaClasspathUtil.getClass("Float", _this);
		}
		else if (_this instanceof IntegerLiteral) {
			javaClass = JavaClasspathUtil.getClass("Integer", _this);
		}
		else if (_this instanceof LongLiteral) {
			javaClass = JavaClasspathUtil.getClass("Long", _this);
		}
		else if (_this instanceof CharacterLiteral) {
			javaClass = JavaClasspathUtil.getClass("Character", _this);
		}

		return javaClass;
	}
}
