/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ident Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.IdentReference#getIdent <em>Ident</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getIdentReference()
 * @model
 * @generated
 */
public interface IdentReference extends Factor {
	/**
   * Returns the value of the '<em><b>Ident</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ident</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Ident</em>' reference.
   * @see #setIdent(Declaration)
   * @see org.emftext.language.pl0.PL0Package#getIdentReference_Ident()
   * @model required="true"
   * @generated
   */
	Declaration getIdent();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.IdentReference#getIdent <em>Ident</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ident</em>' reference.
   * @see #getIdent()
   * @generated
   */
	void setIdent(Declaration value);

} // IdentReference
