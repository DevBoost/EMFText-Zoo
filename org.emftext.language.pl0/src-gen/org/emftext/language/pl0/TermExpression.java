/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.TermExpression#getObligatory <em>Obligatory</em>}</li>
 *   <li>{@link org.emftext.language.pl0.TermExpression#getOptional <em>Optional</em>}</li>
 *   <li>{@link org.emftext.language.pl0.TermExpression#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getTermExpression()
 * @model
 * @generated
 */
public interface TermExpression extends Expression {
	/**
   * Returns the value of the '<em><b>Obligatory</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obligatory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Obligatory</em>' containment reference.
   * @see #setObligatory(Term)
   * @see org.emftext.language.pl0.PL0Package#getTermExpression_Obligatory()
   * @model containment="true" required="true"
   * @generated
   */
	Term getObligatory();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.TermExpression#getObligatory <em>Obligatory</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obligatory</em>' containment reference.
   * @see #getObligatory()
   * @generated
   */
	void setObligatory(Term value);

	/**
   * Returns the value of the '<em><b>Optional</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.pl0.OptionalTerm}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' containment reference list.
   * @see org.emftext.language.pl0.PL0Package#getTermExpression_Optional()
   * @model containment="true"
   * @generated
   */
	EList<OptionalTerm> getOptional();

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
   * @see org.emftext.language.pl0.PL0Package#getTermExpression_Op()
   * @model
   * @generated
   */
	PlusMinusOperator getOp();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.TermExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.PlusMinusOperator
   * @see #getOp()
   * @generated
   */
	void setOp(PlusMinusOperator value);

} // TermExpression
