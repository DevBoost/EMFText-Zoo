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
