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
 * A representation of the model object '<em><b>Bullet Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.notes.BulletPoint#getTextParts <em>Text Parts</em>}</li>
 *   <li>{@link org.emftext.language.notes.BulletPoint#getSubPoints <em>Sub Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.notes.NotesPackage#getBulletPoint()
 * @model
 * @generated
 */
public interface BulletPoint extends Part {
	/**
	 * Returns the value of the '<em><b>Text Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.notes.TextPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Parts</em>' containment reference list.
	 * @see org.emftext.language.notes.NotesPackage#getBulletPoint_TextParts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TextPart> getTextParts();

	/**
	 * Returns the value of the '<em><b>Sub Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.notes.BulletPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Points</em>' containment reference list.
	 * @see org.emftext.language.notes.NotesPackage#getBulletPoint_SubPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<BulletPoint> getSubPoints();

} // BulletPoint
