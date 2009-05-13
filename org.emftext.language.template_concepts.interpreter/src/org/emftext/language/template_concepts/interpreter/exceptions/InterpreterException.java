package org.emftext.language.template_concepts.interpreter.exceptions;

/**
 * @author Marcel Boehme
 * Comment created on: 14.04.2009
 */
public class InterpreterException extends Exception{
	private static final long serialVersionUID = -5115362185634310688L;

	public InterpreterException(String message){
		super(message);
	}
	public InterpreterException(Exception e){
		super(e);
	}
	public InterpreterException(String message, Exception e){
		super(message,e);
	}
}
