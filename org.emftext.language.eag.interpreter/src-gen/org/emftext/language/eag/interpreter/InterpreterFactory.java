/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.eag.interpreter;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.eag.interpreter.InterpreterPackage
 * @generated
 */
public interface InterpreterFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InterpreterFactory eINSTANCE = org.emftext.language.eag.interpreter.impl.InterpreterFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Interpreter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interpreter</em>'.
	 * @generated
	 */
	Interpreter createInterpreter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InterpreterPackage getInterpreterPackage();

} //InterpreterFactory
