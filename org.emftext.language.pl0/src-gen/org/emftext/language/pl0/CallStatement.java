/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.CallStatement#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getCallStatement()
 * @model
 * @generated
 */
public interface CallStatement extends Statement {
	/**
   * Returns the value of the '<em><b>Procedure</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Procedure</em>' reference.
   * @see #setProcedure(ProcedureDeclaration)
   * @see org.emftext.language.pl0.PL0Package#getCallStatement_Procedure()
   * @model required="true"
   * @generated
   */
	ProcedureDeclaration getProcedure();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.CallStatement#getProcedure <em>Procedure</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Procedure</em>' reference.
   * @see #getProcedure()
   * @generated
   */
	void setProcedure(ProcedureDeclaration value);

} // CallStatement
