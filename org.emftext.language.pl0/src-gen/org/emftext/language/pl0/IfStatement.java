/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.emftext.language.pl0.IfStatement#getThen <em>Then</em>}</li>
 *   <li>{@link org.emftext.language.pl0.IfStatement#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement {
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
   * @see org.emftext.language.pl0.PL0Package#getIfStatement_Condition()
   * @model containment="true" required="true"
   * @generated
   */
	Condition getCondition();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.IfStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
	void setCondition(Condition value);

	/**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Body)
   * @see org.emftext.language.pl0.PL0Package#getIfStatement_Then()
   * @model containment="true" required="true"
   * @generated
   */
	Body getThen();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.IfStatement#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
	void setThen(Body value);

	/**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Body)
   * @see org.emftext.language.pl0.PL0Package#getIfStatement_Else()
   * @model containment="true"
   * @generated
   */
	Body getElse();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.IfStatement#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
	void setElse(Body value);

} // IfStatement
