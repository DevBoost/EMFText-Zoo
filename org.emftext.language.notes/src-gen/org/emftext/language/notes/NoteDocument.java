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
 * A representation of the model object '<em><b>Note Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.notes.NoteDocument#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.notes.NotesPackage#getNoteDocument()
 * @model
 * @generated
 */
public interface NoteDocument extends Namedelement {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.notes.Part}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.emftext.language.notes.NotesPackage#getNoteDocument_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Part> getParts();

} // NoteDocument
