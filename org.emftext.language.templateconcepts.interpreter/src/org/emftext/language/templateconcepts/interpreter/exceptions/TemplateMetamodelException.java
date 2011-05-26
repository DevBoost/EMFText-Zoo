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
/**
 *
 */
package org.emftext.language.templateconcepts.interpreter.exceptions;

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
