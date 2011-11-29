/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.language.notes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.language.notes.NotesPackage
 * @generated
 */
public class NotesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NotesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotesSwitch() {
		if (modelPackage == null) {
			modelPackage = NotesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case NotesPackage.NOTE_DOCUMENT: {
				NoteDocument noteDocument = (NoteDocument)theEObject;
				T result = caseNoteDocument(noteDocument);
				if (result == null) result = caseNamedelement(noteDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.NAMEDELEMENT: {
				Namedelement namedelement = (Namedelement)theEObject;
				T result = caseNamedelement(namedelement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.SECTION: {
				Section section = (Section)theEObject;
				T result = caseSection(section);
				if (result == null) result = casePart(section);
				if (result == null) result = caseNamedelement(section);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.PART: {
				Part part = (Part)theEObject;
				T result = casePart(part);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.BULLET_POINT: {
				BulletPoint bulletPoint = (BulletPoint)theEObject;
				T result = caseBulletPoint(bulletPoint);
				if (result == null) result = casePart(bulletPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.TEXT_PART: {
				TextPart textPart = (TextPart)theEObject;
				T result = caseTextPart(textPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.SIMPLE_TEXT: {
				SimpleText simpleText = (SimpleText)theEObject;
				T result = caseSimpleText(simpleText);
				if (result == null) result = caseTextPart(simpleText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.EMPHASISED_TEXT: {
				EmphasisedText emphasisedText = (EmphasisedText)theEObject;
				T result = caseEmphasisedText(emphasisedText);
				if (result == null) result = caseTextPart(emphasisedText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.BOLD: {
				Bold bold = (Bold)theEObject;
				T result = caseBold(bold);
				if (result == null) result = caseEmphasisedText(bold);
				if (result == null) result = caseTextPart(bold);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.ITALIC: {
				Italic italic = (Italic)theEObject;
				T result = caseItalic(italic);
				if (result == null) result = caseEmphasisedText(italic);
				if (result == null) result = caseTextPart(italic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotesPackage.TYPE_WRITER: {
				TypeWriter typeWriter = (TypeWriter)theEObject;
				T result = caseTypeWriter(typeWriter);
				if (result == null) result = caseEmphasisedText(typeWriter);
				if (result == null) result = caseTextPart(typeWriter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Note Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoteDocument(NoteDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namedelement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namedelement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedelement(Namedelement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSection(Section object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePart(Part object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bullet Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bullet Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBulletPoint(BulletPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextPart(TextPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleText(SimpleText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Emphasised Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Emphasised Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmphasisedText(EmphasisedText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bold</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bold</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBold(Bold object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Italic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Italic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItalic(Italic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Writer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Writer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeWriter(TypeWriter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //NotesSwitch
