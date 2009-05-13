/**
 * 
 */
package org.emftext.language.template_concepts.interpreter.exceptions;

/**
 * Thrown if there is an error with the metamodel
 * @author Marcel Boehme
 * Comment created on: 14.04.2009
 */
public class TemplateMetamodelException extends InterpreterException {
	private static final long serialVersionUID = -1047069050859593341L;

	public TemplateMetamodelException(Exception e) {
		super(e);
	}
	public TemplateMetamodelException(String message) {
		super(message);
	}
	public TemplateMetamodelException(String message, Exception e){
		super(message,e);
	}

}
