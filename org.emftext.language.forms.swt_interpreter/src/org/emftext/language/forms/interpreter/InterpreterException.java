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
