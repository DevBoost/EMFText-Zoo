/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.Enumeration#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Classifier {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmt.am3.dsls.KM3.EnumLiteral}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.EnumLiteral#getEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getEnumeration_Literals()
	 * @see org.eclipse.gmt.am3.dsls.KM3.EnumLiteral#getEnum
	 * @model opposite="enum" containment="true"
	 * @generated
	 */
	EList<EnumLiteral> getLiterals();

} // Enumeration
