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
package org.emftext.language.forms.interpreter;

/**
 * An exception that indicates that something went wrong
 * while interpreting a form.
 */
public class InterpreterException extends RuntimeException {

	private static final long serialVersionUID = 2383183116347168871L;

	public InterpreterException(String message) {
		super(message);
	}
}
