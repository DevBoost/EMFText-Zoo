/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Odd Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.OddCondition#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getOddCondition()
 * @model
 * @generated
 */
public interface OddCondition extends Condition {
	/**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.emftext.language.pl0.PL0Package#getOddCondition_Expression()
   * @model containment="true" required="true"
   * @generated
   */
	Expression getExpression();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.OddCondition#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
	void setExpression(Expression value);

} // OddCondition
