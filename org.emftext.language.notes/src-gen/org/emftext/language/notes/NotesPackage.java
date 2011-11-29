/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.notes.NotesFactory
 * @model kind="package"
 * @generated
 */
public interface NotesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "notes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.emftext/notes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "notes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NotesPackage eINSTANCE = org.emftext.language.notes.impl.NotesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.NamedelementImpl <em>Namedelement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.NamedelementImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getNamedelement()
	 * @generated
	 */
	int NAMEDELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEDELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Namedelement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEDELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.NoteDocumentImpl <em>Note Document</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.NoteDocumentImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getNoteDocument()
	 * @generated
	 */
	int NOTE_DOCUMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_DOCUMENT__NAME = NAMEDELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_DOCUMENT__PARTS = NAMEDELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Note Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_DOCUMENT_FEATURE_COUNT = NAMEDELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.PartImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getPart()
	 * @generated
	 */
	int PART = 3;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.SectionImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__NAME = PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ID = PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__SUPER_SECTION = PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bullets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__BULLETS = PART_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = PART_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.BulletPointImpl <em>Bullet Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.BulletPointImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getBulletPoint()
	 * @generated
	 */
	int BULLET_POINT = 4;

	/**
	 * The feature id for the '<em><b>Text Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BULLET_POINT__TEXT_PARTS = PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BULLET_POINT__SUB_POINTS = PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bullet Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BULLET_POINT_FEATURE_COUNT = PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.TextPartImpl <em>Text Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.TextPartImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getTextPart()
	 * @generated
	 */
	int TEXT_PART = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_PART__TEXT = 0;

	/**
	 * The number of structural features of the '<em>Text Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.SimpleTextImpl <em>Simple Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.SimpleTextImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getSimpleText()
	 * @generated
	 */
	int SIMPLE_TEXT = 6;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT__TEXT = TEXT_PART__TEXT;

	/**
	 * The number of structural features of the '<em>Simple Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TEXT_FEATURE_COUNT = TEXT_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.EmphasisedTextImpl <em>Emphasised Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.EmphasisedTextImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getEmphasisedText()
	 * @generated
	 */
	int EMPHASISED_TEXT = 7;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPHASISED_TEXT__TEXT = TEXT_PART__TEXT;

	/**
	 * The number of structural features of the '<em>Emphasised Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPHASISED_TEXT_FEATURE_COUNT = TEXT_PART_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.BoldImpl <em>Bold</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.BoldImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getBold()
	 * @generated
	 */
	int BOLD = 8;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOLD__TEXT = EMPHASISED_TEXT__TEXT;

	/**
	 * The number of structural features of the '<em>Bold</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOLD_FEATURE_COUNT = EMPHASISED_TEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.ItalicImpl <em>Italic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.ItalicImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getItalic()
	 * @generated
	 */
	int ITALIC = 9;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITALIC__TEXT = EMPHASISED_TEXT__TEXT;

	/**
	 * The number of structural features of the '<em>Italic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITALIC_FEATURE_COUNT = EMPHASISED_TEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.notes.impl.TypeWriterImpl <em>Type Writer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.notes.impl.TypeWriterImpl
	 * @see org.emftext.language.notes.impl.NotesPackageImpl#getTypeWriter()
	 * @generated
	 */
	int TYPE_WRITER = 10;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_WRITER__TEXT = EMPHASISED_TEXT__TEXT;

	/**
	 * The number of structural features of the '<em>Type Writer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_WRITER_FEATURE_COUNT = EMPHASISED_TEXT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.NoteDocument <em>Note Document</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note Document</em>'.
	 * @see org.emftext.language.notes.NoteDocument
	 * @generated
	 */
	EClass getNoteDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.notes.NoteDocument#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.emftext.language.notes.NoteDocument#getParts()
	 * @see #getNoteDocument()
	 * @generated
	 */
	EReference getNoteDocument_Parts();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.Namedelement <em>Namedelement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namedelement</em>'.
	 * @see org.emftext.language.notes.Namedelement
	 * @generated
	 */
	EClass getNamedelement();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.notes.Namedelement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.language.notes.Namedelement#getName()
	 * @see #getNamedelement()
	 * @generated
	 */
	EAttribute getNamedelement_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see org.emftext.language.notes.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.notes.Section#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.emftext.language.notes.Section#getId()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Id();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.language.notes.Section#getSuperSection <em>Super Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Section</em>'.
	 * @see org.emftext.language.notes.Section#getSuperSection()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_SuperSection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.notes.Section#getBullets <em>Bullets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bullets</em>'.
	 * @see org.emftext.language.notes.Section#getBullets()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Bullets();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see org.emftext.language.notes.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.BulletPoint <em>Bullet Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bullet Point</em>'.
	 * @see org.emftext.language.notes.BulletPoint
	 * @generated
	 */
	EClass getBulletPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.notes.BulletPoint#getTextParts <em>Text Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Text Parts</em>'.
	 * @see org.emftext.language.notes.BulletPoint#getTextParts()
	 * @see #getBulletPoint()
	 * @generated
	 */
	EReference getBulletPoint_TextParts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.notes.BulletPoint#getSubPoints <em>Sub Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Points</em>'.
	 * @see org.emftext.language.notes.BulletPoint#getSubPoints()
	 * @see #getBulletPoint()
	 * @generated
	 */
	EReference getBulletPoint_SubPoints();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.TextPart <em>Text Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Part</em>'.
	 * @see org.emftext.language.notes.TextPart
	 * @generated
	 */
	EClass getTextPart();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.notes.TextPart#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.emftext.language.notes.TextPart#getText()
	 * @see #getTextPart()
	 * @generated
	 */
	EAttribute getTextPart_Text();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.SimpleText <em>Simple Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Text</em>'.
	 * @see org.emftext.language.notes.SimpleText
	 * @generated
	 */
	EClass getSimpleText();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.EmphasisedText <em>Emphasised Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Emphasised Text</em>'.
	 * @see org.emftext.language.notes.EmphasisedText
	 * @generated
	 */
	EClass getEmphasisedText();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.Bold <em>Bold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bold</em>'.
	 * @see org.emftext.language.notes.Bold
	 * @generated
	 */
	EClass getBold();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.Italic <em>Italic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Italic</em>'.
	 * @see org.emftext.language.notes.Italic
	 * @generated
	 */
	EClass getItalic();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.notes.TypeWriter <em>Type Writer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Writer</em>'.
	 * @see org.emftext.language.notes.TypeWriter
	 * @generated
	 */
	EClass getTypeWriter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NotesFactory getNotesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.NoteDocumentImpl <em>Note Document</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.NoteDocumentImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getNoteDocument()
		 * @generated
		 */
		EClass NOTE_DOCUMENT = eINSTANCE.getNoteDocument();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTE_DOCUMENT__PARTS = eINSTANCE.getNoteDocument_Parts();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.NamedelementImpl <em>Namedelement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.NamedelementImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getNamedelement()
		 * @generated
		 */
		EClass NAMEDELEMENT = eINSTANCE.getNamedelement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMEDELEMENT__NAME = eINSTANCE.getNamedelement_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.SectionImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__ID = eINSTANCE.getSection_Id();

		/**
		 * The meta object literal for the '<em><b>Super Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__SUPER_SECTION = eINSTANCE.getSection_SuperSection();

		/**
		 * The meta object literal for the '<em><b>Bullets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__BULLETS = eINSTANCE.getSection_Bullets();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.PartImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.BulletPointImpl <em>Bullet Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.BulletPointImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getBulletPoint()
		 * @generated
		 */
		EClass BULLET_POINT = eINSTANCE.getBulletPoint();

		/**
		 * The meta object literal for the '<em><b>Text Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BULLET_POINT__TEXT_PARTS = eINSTANCE.getBulletPoint_TextParts();

		/**
		 * The meta object literal for the '<em><b>Sub Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BULLET_POINT__SUB_POINTS = eINSTANCE.getBulletPoint_SubPoints();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.TextPartImpl <em>Text Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.TextPartImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getTextPart()
		 * @generated
		 */
		EClass TEXT_PART = eINSTANCE.getTextPart();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_PART__TEXT = eINSTANCE.getTextPart_Text();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.SimpleTextImpl <em>Simple Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.SimpleTextImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getSimpleText()
		 * @generated
		 */
		EClass SIMPLE_TEXT = eINSTANCE.getSimpleText();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.EmphasisedTextImpl <em>Emphasised Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.EmphasisedTextImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getEmphasisedText()
		 * @generated
		 */
		EClass EMPHASISED_TEXT = eINSTANCE.getEmphasisedText();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.BoldImpl <em>Bold</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.BoldImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getBold()
		 * @generated
		 */
		EClass BOLD = eINSTANCE.getBold();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.ItalicImpl <em>Italic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.ItalicImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getItalic()
		 * @generated
		 */
		EClass ITALIC = eINSTANCE.getItalic();

		/**
		 * The meta object literal for the '{@link org.emftext.language.notes.impl.TypeWriterImpl <em>Type Writer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.notes.impl.TypeWriterImpl
		 * @see org.emftext.language.notes.impl.NotesPackageImpl#getTypeWriter()
		 * @generated
		 */
		EClass TYPE_WRITER = eINSTANCE.getTypeWriter();

	}

} //NotesPackage
