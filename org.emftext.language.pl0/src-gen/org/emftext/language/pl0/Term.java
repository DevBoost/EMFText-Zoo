/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.Term#getObligatory <em>Obligatory</em>}</li>
 *   <li>{@link org.emftext.language.pl0.Term#getOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getTerm()
 * @model
 * @generated
 */
public interface Term extends EObject {
	/**
   * Returns the value of the '<em><b>Obligatory</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obligatory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Obligatory</em>' containment reference.
   * @see #setObligatory(Factor)
   * @see org.emftext.language.pl0.PL0Package#getTerm_Obligatory()
   * @model containment="true" required="true"
   * @generated
   */
	Factor getObligatory();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.Term#getObligatory <em>Obligatory</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obligatory</em>' containment reference.
   * @see #getObligatory()
   * @generated
   */
	void setObligatory(Factor value);

	/**
   * Returns the value of the '<em><b>Optional</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.pl0.OptionalFactor}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' containment reference list.
   * @see org.emftext.language.pl0.PL0Package#getTerm_Optional()
   * @model containment="true"
   * @generated
   */
	EList<OptionalFactor> getOptional();

} // Term
