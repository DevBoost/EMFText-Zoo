/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.WhileStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.emftext.language.pl0.WhileStatement#getDo <em>Do</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getWhileStatement()
 * @model
 * @generated
 */
public interface WhileStatement extends Statement {
	/**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see org.emftext.language.pl0.PL0Package#getWhileStatement_Condition()
   * @model containment="true" required="true"
   * @generated
   */
	Condition getCondition();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.WhileStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
	void setCondition(Condition value);

	/**
   * Returns the value of the '<em><b>Do</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Do</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Do</em>' containment reference.
   * @see #setDo(Body)
   * @see org.emftext.language.pl0.PL0Package#getWhileStatement_Do()
   * @model containment="true" required="true"
   * @generated
   */
	Body getDo();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.WhileStatement#getDo <em>Do</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Do</em>' containment reference.
   * @see #getDo()
   * @generated
   */
	void setDo(Body value);

} // WhileStatement
