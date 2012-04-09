/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BinaryOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;

public class FloatOperationProvider implements IOperationProvider<BinaryOperator> {

	public boolean canHandle(
			BinaryOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (leftType != Float.class) {
			return false;
		}
		if (rightType != Float.class) {
			return false;
		}
		return true;
	}

	public Object interpret(BinaryOperator operator, Object leftObject, Object rightObject) {
		Float left = (Float) leftObject; 
		Float right = (Float) rightObject;
		if (operator == BinaryOperator.PLUS) {
			return new Float(left.floatValue() + right.floatValue());
		}
		if (operator == BinaryOperator.TIMES) {
			return new Float(left.floatValue() * right.floatValue());
		}
		if (operator == BinaryOperator.DIV) {
			return new Float(left.floatValue() / right.floatValue());
		}
		if (operator == BinaryOperator.MINUS) {
			return new Float(left.floatValue() - right.floatValue());
		}
		return null;
	}

}
