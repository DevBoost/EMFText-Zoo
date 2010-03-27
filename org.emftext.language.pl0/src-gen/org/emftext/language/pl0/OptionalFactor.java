/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optional Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.OptionalFactor#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.emftext.language.pl0.OptionalFactor#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getOptionalFactor()
 * @model
 * @generated
 */
public interface OptionalFactor extends EObject {
	/**
   * Returns the value of the '<em><b>Factor</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Factor</em>' containment reference.
   * @see #setFactor(Factor)
   * @see org.emftext.language.pl0.PL0Package#getOptionalFactor_Factor()
   * @model containment="true" required="true"
   * @generated
   */
	Factor getFactor();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.OptionalFactor#getFactor <em>Factor</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Factor</em>' containment reference.
   * @see #getFactor()
   * @generated
   */
	void setFactor(Factor value);

	/**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.pl0.MulDivOperator}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.MulDivOperator
   * @see #setOp(MulDivOperator)
   * @see org.emftext.language.pl0.PL0Package#getOptionalFactor_Op()
   * @model required="true"
   * @generated
   */
	MulDivOperator getOp();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.OptionalFactor#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.MulDivOperator
   * @see #getOp()
   * @generated
   */
	void setOp(MulDivOperator value);

} // OptionalFactor
