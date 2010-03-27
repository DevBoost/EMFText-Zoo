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
 * A representation of the model object '<em><b>Optional Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.OptionalTerm#getTerm <em>Term</em>}</li>
 *   <li>{@link org.emftext.language.pl0.OptionalTerm#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getOptionalTerm()
 * @model
 * @generated
 */
public interface OptionalTerm extends EObject {
	/**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(Term)
   * @see org.emftext.language.pl0.PL0Package#getOptionalTerm_Term()
   * @model containment="true" required="true"
   * @generated
   */
	Term getTerm();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.OptionalTerm#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
	void setTerm(Term value);

	/**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.pl0.PlusMinusOperator}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.PlusMinusOperator
   * @see #setOp(PlusMinusOperator)
   * @see org.emftext.language.pl0.PL0Package#getOptionalTerm_Op()
   * @model required="true"
   * @generated
   */
	PlusMinusOperator getOp();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.OptionalTerm#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.PlusMinusOperator
   * @see #getOp()
   * @generated
   */
	void setOp(PlusMinusOperator value);

} // OptionalTerm
