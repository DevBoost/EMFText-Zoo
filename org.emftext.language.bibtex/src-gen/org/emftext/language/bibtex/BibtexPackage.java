/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex;

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
 * @see org.emftext.language.bibtex.BibtexFactory
 * @model kind="package"
 * @generated
 */
public interface BibtexPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bibtex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/language/bibtex";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bibtex";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BibtexPackage eINSTANCE = org.emftext.language.bibtex.impl.BibtexPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.PersonImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Second Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SECOND_NAME = 1;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = 2;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.AuthorImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 1;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__FIRST_NAME = PERSON__FIRST_NAME;

	/**
	 * The feature id for the '<em><b>Second Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__SECOND_NAME = PERSON__SECOND_NAME;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__LAST_NAME = PERSON__LAST_NAME;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.EditorImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 2;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__FIRST_NAME = PERSON__FIRST_NAME;

	/**
	 * The feature id for the '<em><b>Second Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__SECOND_NAME = PERSON__SECOND_NAME;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__LAST_NAME = PERSON__LAST_NAME;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.StringValueImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.YearValueImpl <em>Year Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.YearValueImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getYearValue()
	 * @generated
	 */
	int YEAR_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAR_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Year Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAR_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.IntValueImpl <em>Int Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.IntValueImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getIntValue()
	 * @generated
	 */
	int INT_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Int Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.PageImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__VALUE = INT_VALUE__VALUE;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = INT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.FieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 7;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.AuthorFieldImpl <em>Author Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.AuthorFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getAuthorField()
	 * @generated
	 */
	int AUTHOR_FIELD = 8;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FIELD__AUTHORS = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Author Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.EditorFieldImpl <em>Editor Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.EditorFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEditorField()
	 * @generated
	 */
	int EDITOR_FIELD = 9;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FIELD__EDITORS = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Editor Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.TitleFieldImpl <em>Title Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.TitleFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getTitleField()
	 * @generated
	 */
	int TITLE_FIELD = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Title Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.BookTitleFieldImpl <em>Book Title Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.BookTitleFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getBookTitleField()
	 * @generated
	 */
	int BOOK_TITLE_FIELD = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_TITLE_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Book Title Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_TITLE_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.NumberFieldImpl <em>Number Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.NumberFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getNumberField()
	 * @generated
	 */
	int NUMBER_FIELD = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FIELD__VALUE = INT_VALUE__VALUE;

	/**
	 * The number of structural features of the '<em>Number Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FIELD_FEATURE_COUNT = INT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.YearFieldImpl <em>Year Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.YearFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getYearField()
	 * @generated
	 */
	int YEAR_FIELD = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAR_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Year Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YEAR_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.BibtexKeyFieldImpl <em>Key Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.BibtexKeyFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getBibtexKeyField()
	 * @generated
	 */
	int BIBTEX_KEY_FIELD = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_KEY_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Key Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBTEX_KEY_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.JournalFieldImpl <em>Journal Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.JournalFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getJournalField()
	 * @generated
	 */
	int JOURNAL_FIELD = 15;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Journal Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.VolumeFieldImpl <em>Volume Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.VolumeFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getVolumeField()
	 * @generated
	 */
	int VOLUME_FIELD = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Volume Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.PageFieldImpl <em>Page Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.PageFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPageField()
	 * @generated
	 */
	int PAGE_FIELD = 17;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FIELD__FROM_PAGE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FIELD__TO_PAGE = FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Page Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.SeriesFieldImpl <em>Series Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.SeriesFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getSeriesField()
	 * @generated
	 */
	int SERIES_FIELD = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES_FIELD__VALUE = STRING_VALUE__VALUE;

	/**
	 * The number of structural features of the '<em>Series Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIES_FIELD_FEATURE_COUNT = STRING_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.AddressFieldImpl <em>Address Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.AddressFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getAddressField()
	 * @generated
	 */
	int ADDRESS_FIELD = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Address Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.MonthFieldImpl <em>Month Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.MonthFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getMonthField()
	 * @generated
	 */
	int MONTH_FIELD = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONTH_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Month Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONTH_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.OrganizationFieldImpl <em>Organization Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.OrganizationFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getOrganizationField()
	 * @generated
	 */
	int ORGANIZATION_FIELD = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Organization Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.NoteFieldImpl <em>Note Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.NoteFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getNoteField()
	 * @generated
	 */
	int NOTE_FIELD = 22;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Note Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTE_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.PublisherFieldImpl <em>Publisher Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.PublisherFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPublisherField()
	 * @generated
	 */
	int PUBLISHER_FIELD = 23;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Publisher Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.PartFieldImpl <em>Part Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.PartFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPartField()
	 * @generated
	 */
	int PART_FIELD = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FIELD__VALUE = INT_VALUE__VALUE;

	/**
	 * The number of structural features of the '<em>Part Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FIELD_FEATURE_COUNT = INT_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.EidFieldImpl <em>Eid Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.EidFieldImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEidField()
	 * @generated
	 */
	int EID_FIELD = 25;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_FIELD__VALUE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Eid Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EID_FIELD_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.EntryImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 26;

	/**
	 * The feature id for the '<em><b>Bibtex Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY__BIBTEX_KEY = 0;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl <em>In Proceedings Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.InProceedingsEntryImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getInProceedingsEntry()
	 * @generated
	 */
	int IN_PROCEEDINGS_ENTRY = 27;

	/**
	 * The feature id for the '<em><b>Bibtex Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__BIBTEX_KEY = ENTRY__BIBTEX_KEY;

	/**
	 * The feature id for the '<em><b>Author</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__AUTHOR = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__TITLE = ENTRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Book Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__BOOK_TITLE = ENTRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Year</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__YEAR = ENTRY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Editor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__EDITOR = ENTRY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__PAGES = ENTRY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__VOLUME = ENTRY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__NUMBER = ENTRY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Series</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__SERIES = ENTRY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__ADDRESS = ENTRY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Month</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__MONTH = ENTRY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__ORGANIZATION = ENTRY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__NOTE = ENTRY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY__PUBLISHER = ENTRY_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>In Proceedings Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_ENTRY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.ArticleEntryImpl <em>Article Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.ArticleEntryImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getArticleEntry()
	 * @generated
	 */
	int ARTICLE_ENTRY = 28;

	/**
	 * The feature id for the '<em><b>Bibtex Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__BIBTEX_KEY = ENTRY__BIBTEX_KEY;

	/**
	 * The feature id for the '<em><b>Author</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__AUTHOR = ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__TITLE = ENTRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__YEAR = ENTRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Journal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__JOURNAL = ENTRY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__PAGES = ENTRY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__VOLUME = ENTRY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__NUMBER = ENTRY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Month</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__MONTH = ENTRY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__NOTE = ENTRY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__PART = ENTRY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Eid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY__EID = ENTRY_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Article Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_ENTRY_FEATURE_COUNT = ENTRY_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.emftext.language.bibtex.impl.BibliographyImpl <em>Bibliography</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.language.bibtex.impl.BibliographyImpl
	 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getBibliography()
	 * @generated
	 */
	int BIBLIOGRAPHY = 29;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY__ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>Bibliography</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIBLIOGRAPHY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.emftext.language.bibtex.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.bibtex.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.emftext.language.bibtex.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.bibtex.Person#getSecondName <em>Second Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Name</em>'.
	 * @see org.emftext.language.bibtex.Person#getSecondName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_SecondName();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.bibtex.Person#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see org.emftext.language.bibtex.Person#getLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_LastName();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see org.emftext.language.bibtex.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see org.emftext.language.bibtex.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.emftext.language.bibtex.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.bibtex.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.language.bibtex.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.YearValue <em>Year Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Year Value</em>'.
	 * @see org.emftext.language.bibtex.YearValue
	 * @generated
	 */
	EClass getYearValue();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.bibtex.YearValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.language.bibtex.YearValue#getValue()
	 * @see #getYearValue()
	 * @generated
	 */
	EAttribute getYearValue_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Value</em>'.
	 * @see org.emftext.language.bibtex.IntValue
	 * @generated
	 */
	EClass getIntValue();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.language.bibtex.IntValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.language.bibtex.IntValue#getValue()
	 * @see #getIntValue()
	 * @generated
	 */
	EAttribute getIntValue_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see org.emftext.language.bibtex.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see org.emftext.language.bibtex.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.AuthorField <em>Author Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author Field</em>'.
	 * @see org.emftext.language.bibtex.AuthorField
	 * @generated
	 */
	EClass getAuthorField();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.bibtex.AuthorField#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Authors</em>'.
	 * @see org.emftext.language.bibtex.AuthorField#getAuthors()
	 * @see #getAuthorField()
	 * @generated
	 */
	EReference getAuthorField_Authors();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.EditorField <em>Editor Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Field</em>'.
	 * @see org.emftext.language.bibtex.EditorField
	 * @generated
	 */
	EClass getEditorField();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.bibtex.EditorField#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see org.emftext.language.bibtex.EditorField#getEditors()
	 * @see #getEditorField()
	 * @generated
	 */
	EReference getEditorField_Editors();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.TitleField <em>Title Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Title Field</em>'.
	 * @see org.emftext.language.bibtex.TitleField
	 * @generated
	 */
	EClass getTitleField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.BookTitleField <em>Book Title Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book Title Field</em>'.
	 * @see org.emftext.language.bibtex.BookTitleField
	 * @generated
	 */
	EClass getBookTitleField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.NumberField <em>Number Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Field</em>'.
	 * @see org.emftext.language.bibtex.NumberField
	 * @generated
	 */
	EClass getNumberField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.YearField <em>Year Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Year Field</em>'.
	 * @see org.emftext.language.bibtex.YearField
	 * @generated
	 */
	EClass getYearField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.BibtexKeyField <em>Key Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Field</em>'.
	 * @see org.emftext.language.bibtex.BibtexKeyField
	 * @generated
	 */
	EClass getBibtexKeyField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.JournalField <em>Journal Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Journal Field</em>'.
	 * @see org.emftext.language.bibtex.JournalField
	 * @generated
	 */
	EClass getJournalField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.VolumeField <em>Volume Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Volume Field</em>'.
	 * @see org.emftext.language.bibtex.VolumeField
	 * @generated
	 */
	EClass getVolumeField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.PageField <em>Page Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Field</em>'.
	 * @see org.emftext.language.bibtex.PageField
	 * @generated
	 */
	EClass getPageField();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.PageField#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From Page</em>'.
	 * @see org.emftext.language.bibtex.PageField#getFromPage()
	 * @see #getPageField()
	 * @generated
	 */
	EReference getPageField_FromPage();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.PageField#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>To Page</em>'.
	 * @see org.emftext.language.bibtex.PageField#getToPage()
	 * @see #getPageField()
	 * @generated
	 */
	EReference getPageField_ToPage();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.SeriesField <em>Series Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Series Field</em>'.
	 * @see org.emftext.language.bibtex.SeriesField
	 * @generated
	 */
	EClass getSeriesField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.AddressField <em>Address Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address Field</em>'.
	 * @see org.emftext.language.bibtex.AddressField
	 * @generated
	 */
	EClass getAddressField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.MonthField <em>Month Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Month Field</em>'.
	 * @see org.emftext.language.bibtex.MonthField
	 * @generated
	 */
	EClass getMonthField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.OrganizationField <em>Organization Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization Field</em>'.
	 * @see org.emftext.language.bibtex.OrganizationField
	 * @generated
	 */
	EClass getOrganizationField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.NoteField <em>Note Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Note Field</em>'.
	 * @see org.emftext.language.bibtex.NoteField
	 * @generated
	 */
	EClass getNoteField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.PublisherField <em>Publisher Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publisher Field</em>'.
	 * @see org.emftext.language.bibtex.PublisherField
	 * @generated
	 */
	EClass getPublisherField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.PartField <em>Part Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part Field</em>'.
	 * @see org.emftext.language.bibtex.PartField
	 * @generated
	 */
	EClass getPartField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.EidField <em>Eid Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Eid Field</em>'.
	 * @see org.emftext.language.bibtex.EidField
	 * @generated
	 */
	EClass getEidField();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Entry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see org.emftext.language.bibtex.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.Entry#getBibtexKey <em>Bibtex Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bibtex Key</em>'.
	 * @see org.emftext.language.bibtex.Entry#getBibtexKey()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_BibtexKey();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.InProceedingsEntry <em>In Proceedings Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Proceedings Entry</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry
	 * @generated
	 */
	EClass getInProceedingsEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Author</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getAuthor()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Author();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getTitle()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Title();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getBookTitle <em>Book Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Book Title</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getBookTitle()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_BookTitle();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Year</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getYear()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Year();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Editor</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getEditor()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Editor();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pages</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getPages()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Pages();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Volume</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getVolume()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Volume();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Number</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getNumber()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Number();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getSeries <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Series</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getSeries()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Series();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getAddress()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Address();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Month</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getMonth()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Month();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Organization</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getOrganization()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Organization();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Note</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getNote()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Note();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.InProceedingsEntry#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Publisher</em>'.
	 * @see org.emftext.language.bibtex.InProceedingsEntry#getPublisher()
	 * @see #getInProceedingsEntry()
	 * @generated
	 */
	EReference getInProceedingsEntry_Publisher();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.ArticleEntry <em>Article Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Article Entry</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry
	 * @generated
	 */
	EClass getArticleEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Author</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getAuthor()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Author();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getTitle()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Title();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Year</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getYear()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Year();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getJournal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Journal</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getJournal()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Journal();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pages</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getPages()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Pages();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Volume</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getVolume()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Volume();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Number</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getNumber()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Number();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Month</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getMonth()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Month();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getNote <em>Note</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Note</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getNote()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Note();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Part</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getPart()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Part();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.language.bibtex.ArticleEntry#getEid <em>Eid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Eid</em>'.
	 * @see org.emftext.language.bibtex.ArticleEntry#getEid()
	 * @see #getArticleEntry()
	 * @generated
	 */
	EReference getArticleEntry_Eid();

	/**
	 * Returns the meta object for class '{@link org.emftext.language.bibtex.Bibliography <em>Bibliography</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bibliography</em>'.
	 * @see org.emftext.language.bibtex.Bibliography
	 * @generated
	 */
	EClass getBibliography();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.language.bibtex.Bibliography#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.emftext.language.bibtex.Bibliography#getEntries()
	 * @see #getBibliography()
	 * @generated
	 */
	EReference getBibliography_Entries();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BibtexFactory getBibtexFactory();

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
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.PersonImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Second Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__SECOND_NAME = eINSTANCE.getPerson_SecondName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LAST_NAME = eINSTANCE.getPerson_LastName();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.AuthorImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.EditorImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.StringValueImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.YearValueImpl <em>Year Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.YearValueImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getYearValue()
		 * @generated
		 */
		EClass YEAR_VALUE = eINSTANCE.getYearValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YEAR_VALUE__VALUE = eINSTANCE.getYearValue_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.IntValueImpl <em>Int Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.IntValueImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getIntValue()
		 * @generated
		 */
		EClass INT_VALUE = eINSTANCE.getIntValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_VALUE__VALUE = eINSTANCE.getIntValue_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.PageImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.FieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.AuthorFieldImpl <em>Author Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.AuthorFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getAuthorField()
		 * @generated
		 */
		EClass AUTHOR_FIELD = eINSTANCE.getAuthorField();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR_FIELD__AUTHORS = eINSTANCE.getAuthorField_Authors();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.EditorFieldImpl <em>Editor Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.EditorFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEditorField()
		 * @generated
		 */
		EClass EDITOR_FIELD = eINSTANCE.getEditorField();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_FIELD__EDITORS = eINSTANCE.getEditorField_Editors();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.TitleFieldImpl <em>Title Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.TitleFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getTitleField()
		 * @generated
		 */
		EClass TITLE_FIELD = eINSTANCE.getTitleField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.BookTitleFieldImpl <em>Book Title Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.BookTitleFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getBookTitleField()
		 * @generated
		 */
		EClass BOOK_TITLE_FIELD = eINSTANCE.getBookTitleField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.NumberFieldImpl <em>Number Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.NumberFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getNumberField()
		 * @generated
		 */
		EClass NUMBER_FIELD = eINSTANCE.getNumberField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.YearFieldImpl <em>Year Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.YearFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getYearField()
		 * @generated
		 */
		EClass YEAR_FIELD = eINSTANCE.getYearField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.BibtexKeyFieldImpl <em>Key Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.BibtexKeyFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getBibtexKeyField()
		 * @generated
		 */
		EClass BIBTEX_KEY_FIELD = eINSTANCE.getBibtexKeyField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.JournalFieldImpl <em>Journal Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.JournalFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getJournalField()
		 * @generated
		 */
		EClass JOURNAL_FIELD = eINSTANCE.getJournalField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.VolumeFieldImpl <em>Volume Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.VolumeFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getVolumeField()
		 * @generated
		 */
		EClass VOLUME_FIELD = eINSTANCE.getVolumeField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.PageFieldImpl <em>Page Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.PageFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPageField()
		 * @generated
		 */
		EClass PAGE_FIELD = eINSTANCE.getPageField();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_FIELD__FROM_PAGE = eINSTANCE.getPageField_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_FIELD__TO_PAGE = eINSTANCE.getPageField_ToPage();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.SeriesFieldImpl <em>Series Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.SeriesFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getSeriesField()
		 * @generated
		 */
		EClass SERIES_FIELD = eINSTANCE.getSeriesField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.AddressFieldImpl <em>Address Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.AddressFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getAddressField()
		 * @generated
		 */
		EClass ADDRESS_FIELD = eINSTANCE.getAddressField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.MonthFieldImpl <em>Month Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.MonthFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getMonthField()
		 * @generated
		 */
		EClass MONTH_FIELD = eINSTANCE.getMonthField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.OrganizationFieldImpl <em>Organization Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.OrganizationFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getOrganizationField()
		 * @generated
		 */
		EClass ORGANIZATION_FIELD = eINSTANCE.getOrganizationField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.NoteFieldImpl <em>Note Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.NoteFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getNoteField()
		 * @generated
		 */
		EClass NOTE_FIELD = eINSTANCE.getNoteField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.PublisherFieldImpl <em>Publisher Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.PublisherFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPublisherField()
		 * @generated
		 */
		EClass PUBLISHER_FIELD = eINSTANCE.getPublisherField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.PartFieldImpl <em>Part Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.PartFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getPartField()
		 * @generated
		 */
		EClass PART_FIELD = eINSTANCE.getPartField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.EidFieldImpl <em>Eid Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.EidFieldImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEidField()
		 * @generated
		 */
		EClass EID_FIELD = eINSTANCE.getEidField();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.EntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.EntryImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Bibtex Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY__BIBTEX_KEY = eINSTANCE.getEntry_BibtexKey();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.InProceedingsEntryImpl <em>In Proceedings Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.InProceedingsEntryImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getInProceedingsEntry()
		 * @generated
		 */
		EClass IN_PROCEEDINGS_ENTRY = eINSTANCE.getInProceedingsEntry();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__AUTHOR = eINSTANCE.getInProceedingsEntry_Author();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__TITLE = eINSTANCE.getInProceedingsEntry_Title();

		/**
		 * The meta object literal for the '<em><b>Book Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__BOOK_TITLE = eINSTANCE.getInProceedingsEntry_BookTitle();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__YEAR = eINSTANCE.getInProceedingsEntry_Year();

		/**
		 * The meta object literal for the '<em><b>Editor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__EDITOR = eINSTANCE.getInProceedingsEntry_Editor();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__PAGES = eINSTANCE.getInProceedingsEntry_Pages();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__VOLUME = eINSTANCE.getInProceedingsEntry_Volume();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__NUMBER = eINSTANCE.getInProceedingsEntry_Number();

		/**
		 * The meta object literal for the '<em><b>Series</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__SERIES = eINSTANCE.getInProceedingsEntry_Series();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__ADDRESS = eINSTANCE.getInProceedingsEntry_Address();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__MONTH = eINSTANCE.getInProceedingsEntry_Month();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__ORGANIZATION = eINSTANCE.getInProceedingsEntry_Organization();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__NOTE = eINSTANCE.getInProceedingsEntry_Note();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS_ENTRY__PUBLISHER = eINSTANCE.getInProceedingsEntry_Publisher();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.ArticleEntryImpl <em>Article Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.ArticleEntryImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getArticleEntry()
		 * @generated
		 */
		EClass ARTICLE_ENTRY = eINSTANCE.getArticleEntry();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__AUTHOR = eINSTANCE.getArticleEntry_Author();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__TITLE = eINSTANCE.getArticleEntry_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__YEAR = eINSTANCE.getArticleEntry_Year();

		/**
		 * The meta object literal for the '<em><b>Journal</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__JOURNAL = eINSTANCE.getArticleEntry_Journal();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__PAGES = eINSTANCE.getArticleEntry_Pages();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__VOLUME = eINSTANCE.getArticleEntry_Volume();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__NUMBER = eINSTANCE.getArticleEntry_Number();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__MONTH = eINSTANCE.getArticleEntry_Month();

		/**
		 * The meta object literal for the '<em><b>Note</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__NOTE = eINSTANCE.getArticleEntry_Note();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__PART = eINSTANCE.getArticleEntry_Part();

		/**
		 * The meta object literal for the '<em><b>Eid</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE_ENTRY__EID = eINSTANCE.getArticleEntry_Eid();

		/**
		 * The meta object literal for the '{@link org.emftext.language.bibtex.impl.BibliographyImpl <em>Bibliography</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.language.bibtex.impl.BibliographyImpl
		 * @see org.emftext.language.bibtex.impl.BibtexPackageImpl#getBibliography()
		 * @generated
		 */
		EClass BIBLIOGRAPHY = eINSTANCE.getBibliography();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIBLIOGRAPHY__ENTRIES = eINSTANCE.getBibliography_Entries();

	}

} //BibtexPackage
