/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.RelationalCondition#getLeft <em>Left</em>}</li>
 *   <li>{@link org.emftext.language.pl0.RelationalCondition#getRight <em>Right</em>}</li>
 *   <li>{@link org.emftext.language.pl0.RelationalCondition#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getRelationalCondition()
 * @model
 * @generated
 */
public interface RelationalCondition extends Condition {
	/**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see org.emftext.language.pl0.PL0Package#getRelationalCondition_Left()
   * @model containment="true" required="true"
   * @generated
   */
	Expression getLeft();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.RelationalCondition#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
	void setLeft(Expression value);

	/**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see org.emftext.language.pl0.PL0Package#getRelationalCondition_Right()
   * @model containment="true" required="true"
   * @generated
   */
	Expression getRight();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.RelationalCondition#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
	void setRight(Expression value);

	/**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.pl0.RelationalOperator}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.RelationalOperator
   * @see #setOp(RelationalOperator)
   * @see org.emftext.language.pl0.PL0Package#getRelationalCondition_Op()
   * @model required="true"
   * @generated
   */
	RelationalOperator getOp();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.RelationalCondition#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see org.emftext.language.pl0.RelationalOperator
   * @see #getOp()
   * @generated
   */
	void setOp(RelationalOperator value);

} // RelationalCondition
