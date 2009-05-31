/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.EnumLiteral#getEnum <em>Enum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getEnumLiteral()
 * @model
 * @generated
 */
public interface EnumLiteral extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Enum</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmt.am3.dsls.KM3.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum</em>' container reference.
	 * @see #setEnum(Enumeration)
	 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Package#getEnumLiteral_Enum()
	 * @see org.eclipse.gmt.am3.dsls.KM3.Enumeration#getLiterals
	 * @model opposite="literals" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Enumeration getEnum();

	/**
	 * Sets the value of the '{@link org.eclipse.gmt.am3.dsls.KM3.EnumLiteral#getEnum <em>Enum</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum</em>' container reference.
	 * @see #getEnum()
	 * @generated
	 */
	void setEnum(Enumeration value);

} // EnumLiteral
