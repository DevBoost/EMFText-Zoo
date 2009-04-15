package org.emftext.language.java.util.types;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.types.Boolean;
import org.emftext.language.java.types.Byte;
import org.emftext.language.java.types.Char;
import org.emftext.language.java.types.Double;
import org.emftext.language.java.types.Float;
import org.emftext.language.java.types.Int;
import org.emftext.language.java.types.Long;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Short;
import org.emftext.language.java.types.Void;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;

public class PrimitiveTypeUtil {

	/**
	 * @param primitiveType
	 * @return all members (including super type members)
	 */
	public static EList<Member> getAllMembers(PrimitiveType primitiveType) {
		Class javaClass = wrapPrimitiveType(primitiveType);	
		return ConcreteClassifierUtil.getAllMembers(javaClass);
	}
	
	/**
	 * @param _this
	 * @return primitive type as a class representation
	 */
	public static Class wrapPrimitiveType(PrimitiveType _this) {
		Class javaClass = null;
		
		if (_this instanceof Boolean) {
			javaClass = JavaClasspathUtil.getClass("Boolean", _this);
		}
		if (_this instanceof Byte) {
			javaClass = JavaClasspathUtil.getClass("Byte", _this);
		}
		if (_this instanceof Char) {
			javaClass = JavaClasspathUtil.getClass("Character", _this);
		}
		if (_this instanceof Double) {
			javaClass = JavaClasspathUtil.getClass("Double", _this);
		}
		if (_this instanceof Float) {
			javaClass = JavaClasspathUtil.getClass("Float", _this);
		}
		if (_this instanceof Int) {
			javaClass = JavaClasspathUtil.getClass("Integer", _this);
		}
		if (_this instanceof Long) {
			javaClass = JavaClasspathUtil.getClass("Long", _this);
		}
		if (_this instanceof Short) {
			javaClass = JavaClasspathUtil.getClass("Short", _this);
		}
		if (_this instanceof Void) {
			javaClass = JavaClasspathUtil.getClass("Void", _this);
		}
		return javaClass;
	}
}
