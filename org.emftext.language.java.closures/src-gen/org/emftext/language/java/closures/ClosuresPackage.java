/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.java.closures;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.java.parameters.ParametersPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.java.closures.ClosuresFactory
 * @model kind="package"
 * @generated
 */
public interface ClosuresPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "closures";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://emftext.org/language/closures";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "closures";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	ClosuresPackage eINSTANCE = org.emftext.language.java.closures.impl.ClosuresPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.java.closures.impl.ClosureImpl <em>Closure</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.java.closures.impl.ClosureImpl
   * @see org.emftext.language.java.closures.impl.ClosuresPackageImpl#getClosure()
   * @generated
   */
	int CLOSURE = 0;

	/**
   * The feature id for the '<em><b>Comments</b></em>' attribute list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLOSURE__COMMENTS = ParametersPackage.PARAMETRIZABLE__COMMENTS;

	/**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLOSURE__PARAMETERS = ParametersPackage.PARAMETRIZABLE__PARAMETERS;

	/**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLOSURE__STATEMENTS = ParametersPackage.PARAMETRIZABLE_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSURE__TYPE_ARGUMENTS = ParametersPackage.PARAMETRIZABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Next</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSURE__NEXT = ParametersPackage.PARAMETRIZABLE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Array Selectors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSURE__ARRAY_SELECTORS = ParametersPackage.PARAMETRIZABLE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Previous</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOSURE__PREVIOUS = ParametersPackage.PARAMETRIZABLE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Closure</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CLOSURE_FEATURE_COUNT = ParametersPackage.PARAMETRIZABLE_FEATURE_COUNT + 5;


	/**
   * Returns the meta object for class '{@link org.emftext.language.java.closures.Closure <em>Closure</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Closure</em>'.
   * @see org.emftext.language.java.closures.Closure
   * @generated
   */
	EClass getClosure();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	ClosuresFactory getClosuresFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.language.java.closures.impl.ClosureImpl <em>Closure</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.java.closures.impl.ClosureImpl
     * @see org.emftext.language.java.closures.impl.ClosuresPackageImpl#getClosure()
     * @generated
     */
		EClass CLOSURE = eINSTANCE.getClosure();

	}

} //ClosuresPackage
