/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Small Atom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.SmallAtom#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.prolog.PrologPackage#getSmallAtom()
 * @model
 * @generated
 */
public interface SmallAtom extends Atom {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.emftext.language.prolog.PrologPackage#getSmallAtom_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.SmallAtom#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // SmallAtom
