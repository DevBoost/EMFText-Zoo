/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.language.bibtex.AddressField;
import org.emftext.language.bibtex.AbstractField;
import org.emftext.language.bibtex.ArticleEntry;
import org.emftext.language.bibtex.Author;
import org.emftext.language.bibtex.AuthorField;
import org.emftext.language.bibtex.Bibliography;
import org.emftext.language.bibtex.BibtexFactory;
import org.emftext.language.bibtex.BibtexKeyField;
import org.emftext.language.bibtex.BibtexPackage;
import org.emftext.language.bibtex.BookTitleField;
import org.emftext.language.bibtex.Editor;
import org.emftext.language.bibtex.EditorField;
import org.emftext.language.bibtex.EidField;
import org.emftext.language.bibtex.Entry;
import org.emftext.language.bibtex.Field;
import org.emftext.language.bibtex.InProceedingsEntry;
import org.emftext.language.bibtex.IntValue;
import org.emftext.language.bibtex.JournalField;
import org.emftext.language.bibtex.MonthField;
import org.emftext.language.bibtex.NoteField;
import org.emftext.language.bibtex.NumberField;
import org.emftext.language.bibtex.OrganizationField;
import org.emftext.language.bibtex.Page;
import org.emftext.language.bibtex.PageField;
import org.emftext.language.bibtex.PartField;
import org.emftext.language.bibtex.Person;
import org.emftext.language.bibtex.PublisherField;
import org.emftext.language.bibtex.SeriesField;
import org.emftext.language.bibtex.StringValue;
import org.emftext.language.bibtex.TitleField;
import org.emftext.language.bibtex.VolumeField;
import org.emftext.language.bibtex.YearField;
import org.emftext.language.bibtex.YearValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BibtexPackageImpl extends EPackageImpl implements BibtexPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass yearValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass authorFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass titleFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bookTitleFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass yearFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bibtexKeyFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass journalFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass volumeFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seriesFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass monthFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass organizationFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noteFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publisherFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eidFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inProceedingsEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass articleEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bibliographyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emftext.language.bibtex.BibtexPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BibtexPackageImpl() {
		super(eNS_URI, BibtexFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BibtexPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BibtexPackage init() {
		if (isInited) return (BibtexPackage)EPackage.Registry.INSTANCE.getEPackage(BibtexPackage.eNS_URI);

		// Obtain or create and register package
		BibtexPackageImpl theBibtexPackage = (BibtexPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BibtexPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BibtexPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBibtexPackage.createPackageContents();

		// Initialize created meta-data
		theBibtexPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBibtexPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BibtexPackage.eNS_URI, theBibtexPackage);
		return theBibtexPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FirstName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_SecondName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuthor() {
		return authorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditor() {
		return editorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringValue() {
		return stringValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringValue_Value() {
		return (EAttribute)stringValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getYearValue() {
		return yearValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getYearValue_Value() {
		return (EAttribute)yearValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntValue() {
		return intValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntValue_Value() {
		return (EAttribute)intValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPage() {
		return pageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getField() {
		return fieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAuthorField() {
		return authorFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAuthorField_Authors() {
		return (EReference)authorFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditorField() {
		return editorFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditorField_Editors() {
		return (EReference)editorFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTitleField() {
		return titleFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBookTitleField() {
		return bookTitleFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberField() {
		return numberFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getYearField() {
		return yearFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBibtexKeyField() {
		return bibtexKeyFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJournalField() {
		return journalFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVolumeField() {
		return volumeFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageField() {
		return pageFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageField_FromPage() {
		return (EReference)pageFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageField_ToPage() {
		return (EReference)pageFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeriesField() {
		return seriesFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddressField() {
		return addressFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMonthField() {
		return monthFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrganizationField() {
		return organizationFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNoteField() {
		return noteFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublisherField() {
		return publisherFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartField() {
		return partFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEidField() {
		return eidFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntry() {
		return entryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntry_BibtexKey() {
		return (EReference)entryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInProceedingsEntry() {
		return inProceedingsEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Author() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Title() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_BookTitle() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Year() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Editor() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Pages() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Volume() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Number() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Series() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Address() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Month() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Organization() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Note() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInProceedingsEntry_Publisher() {
		return (EReference)inProceedingsEntryEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArticleEntry() {
		return articleEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Author() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Title() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Year() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Journal() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Pages() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Volume() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Number() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Month() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Note() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Part() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArticleEntry_Eid() {
		return (EReference)articleEntryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBibliography() {
		return bibliographyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBibliography_Entries() {
		return (EReference)bibliographyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexFactory getBibtexFactory() {
		return (BibtexFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__FIRST_NAME);
		createEAttribute(personEClass, PERSON__SECOND_NAME);
		createEAttribute(personEClass, PERSON__LAST_NAME);

		authorEClass = createEClass(AUTHOR);

		editorEClass = createEClass(EDITOR);

		stringValueEClass = createEClass(STRING_VALUE);
		createEAttribute(stringValueEClass, STRING_VALUE__VALUE);

		yearValueEClass = createEClass(YEAR_VALUE);
		createEAttribute(yearValueEClass, YEAR_VALUE__VALUE);

		intValueEClass = createEClass(INT_VALUE);
		createEAttribute(intValueEClass, INT_VALUE__VALUE);

		pageEClass = createEClass(PAGE);

		fieldEClass = createEClass(FIELD);

		authorFieldEClass = createEClass(AUTHOR_FIELD);
		createEReference(authorFieldEClass, AUTHOR_FIELD__AUTHORS);

		editorFieldEClass = createEClass(EDITOR_FIELD);
		createEReference(editorFieldEClass, EDITOR_FIELD__EDITORS);

		titleFieldEClass = createEClass(TITLE_FIELD);

		bookTitleFieldEClass = createEClass(BOOK_TITLE_FIELD);

		numberFieldEClass = createEClass(NUMBER_FIELD);

		yearFieldEClass = createEClass(YEAR_FIELD);

		bibtexKeyFieldEClass = createEClass(BIBTEX_KEY_FIELD);

		journalFieldEClass = createEClass(JOURNAL_FIELD);

		volumeFieldEClass = createEClass(VOLUME_FIELD);

		pageFieldEClass = createEClass(PAGE_FIELD);
		createEReference(pageFieldEClass, PAGE_FIELD__FROM_PAGE);
		createEReference(pageFieldEClass, PAGE_FIELD__TO_PAGE);

		seriesFieldEClass = createEClass(SERIES_FIELD);

		addressFieldEClass = createEClass(ADDRESS_FIELD);

		monthFieldEClass = createEClass(MONTH_FIELD);

		organizationFieldEClass = createEClass(ORGANIZATION_FIELD);

		noteFieldEClass = createEClass(NOTE_FIELD);

		publisherFieldEClass = createEClass(PUBLISHER_FIELD);

		partFieldEClass = createEClass(PART_FIELD);

		eidFieldEClass = createEClass(EID_FIELD);

		entryEClass = createEClass(ENTRY);
		createEReference(entryEClass, ENTRY__BIBTEX_KEY);

		inProceedingsEntryEClass = createEClass(IN_PROCEEDINGS_ENTRY);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__AUTHOR);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__TITLE);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__BOOK_TITLE);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__YEAR);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__EDITOR);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__PAGES);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__VOLUME);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__NUMBER);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__SERIES);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__ADDRESS);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__MONTH);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__ORGANIZATION);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__NOTE);
		createEReference(inProceedingsEntryEClass, IN_PROCEEDINGS_ENTRY__PUBLISHER);

		articleEntryEClass = createEClass(ARTICLE_ENTRY);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__AUTHOR);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__TITLE);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__YEAR);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__JOURNAL);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__PAGES);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__VOLUME);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__NUMBER);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__MONTH);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__NOTE);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__PART);
		createEReference(articleEntryEClass, ARTICLE_ENTRY__EID);

		bibliographyEClass = createEClass(BIBLIOGRAPHY);
		createEReference(bibliographyEClass, BIBLIOGRAPHY__ENTRIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		authorEClass.getESuperTypes().add(this.getPerson());
		editorEClass.getESuperTypes().add(this.getPerson());
		pageEClass.getESuperTypes().add(this.getIntValue());
		authorFieldEClass.getESuperTypes().add(this.getField());
		editorFieldEClass.getESuperTypes().add(this.getField());
		titleFieldEClass.getESuperTypes().add(this.getField());
		titleFieldEClass.getESuperTypes().add(this.getStringValue());
		bookTitleFieldEClass.getESuperTypes().add(this.getField());
		bookTitleFieldEClass.getESuperTypes().add(this.getStringValue());
		numberFieldEClass.getESuperTypes().add(this.getIntValue());
		numberFieldEClass.getESuperTypes().add(this.getField());
		yearFieldEClass.getESuperTypes().add(this.getField());
		yearFieldEClass.getESuperTypes().add(this.getYearValue());
		bibtexKeyFieldEClass.getESuperTypes().add(this.getField());
		bibtexKeyFieldEClass.getESuperTypes().add(this.getStringValue());
		journalFieldEClass.getESuperTypes().add(this.getField());
		journalFieldEClass.getESuperTypes().add(this.getStringValue());
		volumeFieldEClass.getESuperTypes().add(this.getField());
		volumeFieldEClass.getESuperTypes().add(this.getIntValue());
		pageFieldEClass.getESuperTypes().add(this.getField());
		seriesFieldEClass.getESuperTypes().add(this.getStringValue());
		seriesFieldEClass.getESuperTypes().add(this.getField());
		addressFieldEClass.getESuperTypes().add(this.getField());
		addressFieldEClass.getESuperTypes().add(this.getStringValue());
		monthFieldEClass.getESuperTypes().add(this.getField());
		monthFieldEClass.getESuperTypes().add(this.getStringValue());
		organizationFieldEClass.getESuperTypes().add(this.getField());
		organizationFieldEClass.getESuperTypes().add(this.getStringValue());
		noteFieldEClass.getESuperTypes().add(this.getField());
		noteFieldEClass.getESuperTypes().add(this.getStringValue());
		publisherFieldEClass.getESuperTypes().add(this.getField());
		publisherFieldEClass.getESuperTypes().add(this.getStringValue());
		partFieldEClass.getESuperTypes().add(this.getIntValue());
		partFieldEClass.getESuperTypes().add(this.getField());
		eidFieldEClass.getESuperTypes().add(this.getField());
		eidFieldEClass.getESuperTypes().add(this.getStringValue());
		inProceedingsEntryEClass.getESuperTypes().add(this.getEntry());
		articleEntryEClass.getESuperTypes().add(this.getEntry());

		// Initialize classes and features; add operations and parameters
		initEClass(personEClass, Person.class, "Person", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_FirstName(), ecorePackage.getEString(), "firstName", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_SecondName(), ecorePackage.getEString(), "secondName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastName(), ecorePackage.getEString(), "lastName", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(authorEClass, Author.class, "Author", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(editorEClass, Editor.class, "Editor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringValueEClass, StringValue.class, "StringValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringValue_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(yearValueEClass, YearValue.class, "YearValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getYearValue_Value(), ecorePackage.getEInt(), "value", null, 1, 1, YearValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intValueEClass, IntValue.class, "IntValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntValue_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageEClass, Page.class, "Page", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fieldEClass, Field.class, "Field", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(authorFieldEClass, AuthorField.class, "AuthorField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAuthorField_Authors(), this.getAuthor(), null, "authors", null, 1, -1, AuthorField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorFieldEClass, EditorField.class, "EditorField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditorField_Editors(), this.getEditor(), null, "editors", null, 1, -1, EditorField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(titleFieldEClass, TitleField.class, "TitleField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bookTitleFieldEClass, BookTitleField.class, "BookTitleField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numberFieldEClass, NumberField.class, "NumberField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(yearFieldEClass, YearField.class, "YearField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bibtexKeyFieldEClass, BibtexKeyField.class, "BibtexKeyField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(journalFieldEClass, JournalField.class, "JournalField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(volumeFieldEClass, VolumeField.class, "VolumeField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageFieldEClass, PageField.class, "PageField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageField_FromPage(), this.getPage(), null, "fromPage", null, 1, 1, PageField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageField_ToPage(), this.getPage(), null, "toPage", null, 0, 1, PageField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seriesFieldEClass, SeriesField.class, "SeriesField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addressFieldEClass, AddressField.class, "AddressField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(monthFieldEClass, MonthField.class, "MonthField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(organizationFieldEClass, OrganizationField.class, "OrganizationField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(noteFieldEClass, NoteField.class, "NoteField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(publisherFieldEClass, PublisherField.class, "PublisherField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(partFieldEClass, PartField.class, "PartField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eidFieldEClass, EidField.class, "EidField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entryEClass, Entry.class, "Entry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntry_BibtexKey(), this.getBibtexKeyField(), null, "bibtexKey", null, 1, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(entryEClass, this.getField(), "getGeneralFields", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(entryEClass, this.getField(), "getFields", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(inProceedingsEntryEClass, InProceedingsEntry.class, "InProceedingsEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInProceedingsEntry_Author(), this.getAuthorField(), null, "author", null, 1, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Title(), this.getTitleField(), null, "title", null, 1, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_BookTitle(), this.getBookTitleField(), null, "bookTitle", null, 1, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Year(), this.getYearField(), null, "year", null, 1, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Editor(), this.getEditorField(), null, "editor", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Pages(), this.getPageField(), null, "pages", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Volume(), this.getVolumeField(), null, "volume", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Number(), this.getNumberField(), null, "number", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Series(), this.getSeriesField(), null, "series", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Address(), this.getAddressField(), null, "address", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Month(), this.getMonthField(), null, "month", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Organization(), this.getOrganizationField(), null, "organization", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Note(), this.getNoteField(), null, "note", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInProceedingsEntry_Publisher(), this.getPublisherField(), null, "publisher", null, 0, 1, InProceedingsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(inProceedingsEntryEClass, this.getField(), "getFields", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(articleEntryEClass, ArticleEntry.class, "ArticleEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArticleEntry_Author(), this.getAuthorField(), null, "author", null, 1, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Title(), this.getTitleField(), null, "title", null, 1, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Year(), this.getYearField(), null, "year", null, 1, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Journal(), this.getJournalField(), null, "journal", null, 1, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Pages(), this.getPageField(), null, "pages", null, 1, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Volume(), this.getVolumeField(), null, "volume", null, 1, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Number(), this.getNumberField(), null, "number", null, 0, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Month(), this.getMonthField(), null, "month", null, 0, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Note(), this.getNoteField(), null, "note", null, 0, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Part(), this.getPartField(), null, "part", null, 0, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArticleEntry_Eid(), this.getEidField(), null, "eid", null, 0, 1, ArticleEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(articleEntryEClass, this.getField(), "getFields", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(bibliographyEClass, Bibliography.class, "Bibliography", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBibliography_Entries(), this.getEntry(), null, "entries", null, 0, -1, Bibliography.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BibtexPackageImpl
