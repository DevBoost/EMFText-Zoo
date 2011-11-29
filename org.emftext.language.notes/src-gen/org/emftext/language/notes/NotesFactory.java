/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.notes.NotesPackage
 * @generated
 */
public interface NotesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NotesFactory eINSTANCE = org.emftext.language.notes.impl.NotesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Note Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Note Document</em>'.
	 * @generated
	 */
	NoteDocument createNoteDocument();

	/**
	 * Returns a new object of class '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Section</em>'.
	 * @generated
	 */
	Section createSection();

	/**
	 * Returns a new object of class '<em>Bullet Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bullet Point</em>'.
	 * @generated
	 */
	BulletPoint createBulletPoint();

	/**
	 * Returns a new object of class '<em>Simple Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Text</em>'.
	 * @generated
	 */
	SimpleText createSimpleText();

	/**
	 * Returns a new object of class '<em>Bold</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bold</em>'.
	 * @generated
	 */
	Bold createBold();

	/**
	 * Returns a new object of class '<em>Italic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Italic</em>'.
	 * @generated
	 */
	Italic createItalic();

	/**
	 * Returns a new object of class '<em>Type Writer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Writer</em>'.
	 * @generated
	 */
	TypeWriter createTypeWriter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NotesPackage getNotesPackage();

} //NotesFactory
