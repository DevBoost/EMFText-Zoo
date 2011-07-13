/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.BooleanOperator;
import org.emftext.language.eag.interpreter.IOperationProvider;

public class IntegerEqualsProvider implements IOperationProvider<BooleanOperator> {

	public boolean canHandle(
			BooleanOperator operator, 
			Class<?> leftType,
			Class<?> rightType) {
		if (operator != BooleanOperator.EQUALS) {
			return false;
		}
		return leftType == Integer.class && rightType == Integer.class;
	}

	public Object interpret(BooleanOperator operator, Object left, Object right) {
		Integer leftInteger = (Integer) left;
		Integer rightInteger = (Integer) right;
		return leftInteger.intValue() == rightInteger.intValue();
	}
}
