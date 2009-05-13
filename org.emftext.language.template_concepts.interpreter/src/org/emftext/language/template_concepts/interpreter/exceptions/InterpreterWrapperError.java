/**
 * 
 */
package org.emftext.language.template_concepts.interpreter.exceptions;

/**
 * Just wraps the {@link InterpreterException} in case 
 * the surrounding method cannot be marked as throwing it (throws ..)
 * @author Marcel Böhme
 * Comment created on: 15.04.2009
 */
public class InterpreterWrapperError extends Error{
	private static final long serialVersionUID = -5145531545251140139L;
	
	public InterpreterWrapperError(InterpreterException e) {
		super(e);
	}
}
