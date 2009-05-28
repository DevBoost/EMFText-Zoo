/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.util.types;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.commons.Commentable;
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
import org.emftext.language.java.util.classifiers.ClassifierUtil;

/**
 * A utility class that provides methods that belong to class 
 * PrimitiveType, but can not go there, because PrimitiveType
 * is generated.
 */
public class PrimitiveTypeUtil {

	/**
	 * @param _this
	 * @param context to check protected visibility
	 * @return all members (including super type members)
	 */
	public static EList<Member> getAllMembers(PrimitiveType _this, Commentable context) {
		Class javaClass = wrapPrimitiveType(_this);	
		return ClassifierUtil.getAllMembers(javaClass, context);
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
