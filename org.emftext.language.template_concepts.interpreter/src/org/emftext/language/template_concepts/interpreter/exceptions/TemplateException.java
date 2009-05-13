/**
 * 
 */
package org.emftext.language.template_concepts.interpreter.exceptions;

/**
 * Thrown on user error in template
 * @author Marcel Boehme
 * Comment created on: 14.04.2009
 */
public class TemplateException extends InterpreterException{
	private static final long serialVersionUID = 8746948627637314078L;

	public TemplateException(Exception e) {
		super(e);
	}
	public TemplateException(String message) {
		super(message);
	}
	public TemplateException(String message, Exception e){
		super(message,e);
	}
}
