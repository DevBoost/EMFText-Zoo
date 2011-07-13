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
package org.emftext.language.simplemath.interpreter;

import java.util.Stack;

public class SimpleMathContext {

	private Stack<Double> stack = new Stack<Double>();

	public double pop() {
		Double value = stack.pop();
		return value;
	}

	public void push(double value) {
		stack.push(value);
	}
}
