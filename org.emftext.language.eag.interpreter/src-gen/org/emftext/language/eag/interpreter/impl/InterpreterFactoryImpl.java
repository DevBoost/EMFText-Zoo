/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.eag.interpreter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.emftext.language.eag.interpreter.Interpreter;
import org.emftext.language.eag.interpreter.InterpreterFactory;
import org.emftext.language.eag.interpreter.InterpreterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InterpreterFactoryImpl extends EFactoryImpl implements InterpreterFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InterpreterFactory init() {
		try {
			InterpreterFactory theInterpreterFactory = (InterpreterFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/eag/interpreter"); 
			if (theInterpreterFactory != null) {
				return theInterpreterFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InterpreterFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterpreterFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InterpreterPackage.INTERPRETER: return createInterpreter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interpreter createInterpreter() {
		InterpreterImpl interpreter = new InterpreterImpl();
		return interpreter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterpreterPackage getInterpreterPackage() {
		return (InterpreterPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InterpreterPackage getPackage() {
		return InterpreterPackage.eINSTANCE;
	}

} //InterpreterFactoryImpl
