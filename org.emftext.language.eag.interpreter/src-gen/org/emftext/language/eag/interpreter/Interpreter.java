/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.eag.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.eag.Attribute;
import org.emftext.language.eag.AttributeGrammar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interpreter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.language.eag.interpreter.InterpreterPackage#getInterpreter()
 * @model
 * @generated
 */
public interface Interpreter extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectRequired="true" grammarRequired="true" attributeRequired="true"
	 * @generated
	 */
	Object interpret(EObject object, AttributeGrammar grammar, Attribute attribute);

} // Interpreter
