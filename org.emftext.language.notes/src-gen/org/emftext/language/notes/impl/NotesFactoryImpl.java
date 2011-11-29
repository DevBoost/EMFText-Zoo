/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.notes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NotesFactoryImpl extends EFactoryImpl implements NotesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NotesFactory init() {
		try {
			NotesFactory theNotesFactory = (NotesFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.emftext/notes"); 
			if (theNotesFactory != null) {
				return theNotesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NotesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NotesPackage.NOTE_DOCUMENT: return createNoteDocument();
			case NotesPackage.SECTION: return createSection();
			case NotesPackage.BULLET_POINT: return createBulletPoint();
			case NotesPackage.SIMPLE_TEXT: return createSimpleText();
			case NotesPackage.BOLD: return createBold();
			case NotesPackage.ITALIC: return createItalic();
			case NotesPackage.TYPE_WRITER: return createTypeWriter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoteDocument createNoteDocument() {
		NoteDocumentImpl noteDocument = new NoteDocumentImpl();
		return noteDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section createSection() {
		SectionImpl section = new SectionImpl();
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BulletPoint createBulletPoint() {
		BulletPointImpl bulletPoint = new BulletPointImpl();
		return bulletPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleText createSimpleText() {
		SimpleTextImpl simpleText = new SimpleTextImpl();
		return simpleText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bold createBold() {
		BoldImpl bold = new BoldImpl();
		return bold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Italic createItalic() {
		ItalicImpl italic = new ItalicImpl();
		return italic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeWriter createTypeWriter() {
		TypeWriterImpl typeWriter = new TypeWriterImpl();
		return typeWriter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotesPackage getNotesPackage() {
		return (NotesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NotesPackage getPackage() {
		return NotesPackage.eINSTANCE;
	}

} //NotesFactoryImpl
