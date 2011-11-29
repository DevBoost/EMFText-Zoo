/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.notes.Section#getId <em>Id</em>}</li>
 *   <li>{@link org.emftext.language.notes.Section#getSuperSection <em>Super Section</em>}</li>
 *   <li>{@link org.emftext.language.notes.Section#getBullets <em>Bullets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.notes.NotesPackage#getSection()
 * @model
 * @generated
 */
public interface Section extends Part, Namedelement {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.emftext.language.notes.NotesPackage#getSection_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.emftext.language.notes.Section#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Super Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Section</em>' reference.
	 * @see #setSuperSection(Section)
	 * @see org.emftext.language.notes.NotesPackage#getSection_SuperSection()
	 * @model keys="id"
	 * @generated
	 */
	Section getSuperSection();

	/**
	 * Sets the value of the '{@link org.emftext.language.notes.Section#getSuperSection <em>Super Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Section</em>' reference.
	 * @see #getSuperSection()
	 * @generated
	 */
	void setSuperSection(Section value);

	/**
	 * Returns the value of the '<em><b>Bullets</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.notes.BulletPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bullets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bullets</em>' containment reference list.
	 * @see org.emftext.language.notes.NotesPackage#getSection_Bullets()
	 * @model containment="true"
	 * @generated
	 */
	EList<BulletPoint> getBullets();

} // Section
