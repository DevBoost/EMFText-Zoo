/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.Assignment#getLeft <em>Left</em>}</li>
 *   <li>{@link org.emftext.language.pl0.Assignment#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends Statement {
	/**
   * Returns the value of the '<em><b>Left</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' reference.
   * @see #setLeft(VarDeclaration)
   * @see org.emftext.language.pl0.PL0Package#getAssignment_Left()
   * @model required="true"
   * @generated
   */
	VarDeclaration getLeft();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.Assignment#getLeft <em>Left</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' reference.
   * @see #getLeft()
   * @generated
   */
	void setLeft(VarDeclaration value);

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
   * @see org.emftext.language.pl0.PL0Package#getAssignment_Right()
   * @model containment="true" required="true"
   * @generated
   */
	Expression getRight();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.Assignment#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
	void setRight(Expression value);

} // Assignment
