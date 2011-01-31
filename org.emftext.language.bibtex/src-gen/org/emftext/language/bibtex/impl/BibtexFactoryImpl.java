/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.bibtex.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BibtexFactoryImpl extends EFactoryImpl implements BibtexFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BibtexFactory init() {
		try {
			BibtexFactory theBibtexFactory = (BibtexFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/language/bibtex"); 
			if (theBibtexFactory != null) {
				return theBibtexFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BibtexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexFactoryImpl() {
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
			case BibtexPackage.AUTHOR: return createAuthor();
			case BibtexPackage.EDITOR: return createEditor();
			case BibtexPackage.YEAR_VALUE: return createYearValue();
			case BibtexPackage.INT_VALUE: return createIntValue();
			case BibtexPackage.PAGE: return createPage();
			case BibtexPackage.AUTHOR_FIELD: return createAuthorField();
			case BibtexPackage.EDITOR_FIELD: return createEditorField();
			case BibtexPackage.TITLE_FIELD: return createTitleField();
			case BibtexPackage.BOOK_TITLE_FIELD: return createBookTitleField();
			case BibtexPackage.NUMBER_FIELD: return createNumberField();
			case BibtexPackage.YEAR_FIELD: return createYearField();
			case BibtexPackage.BIBTEX_KEY_FIELD: return createBibtexKeyField();
			case BibtexPackage.JOURNAL_FIELD: return createJournalField();
			case BibtexPackage.VOLUME_FIELD: return createVolumeField();
			case BibtexPackage.PAGE_FIELD: return createPageField();
			case BibtexPackage.SERIES_FIELD: return createSeriesField();
			case BibtexPackage.ADDRESS_FIELD: return createAddressField();
			case BibtexPackage.MONTH_FIELD: return createMonthField();
			case BibtexPackage.ORGANIZATION_FIELD: return createOrganizationField();
			case BibtexPackage.NOTE_FIELD: return createNoteField();
			case BibtexPackage.PUBLISHER_FIELD: return createPublisherField();
			case BibtexPackage.PART_FIELD: return createPartField();
			case BibtexPackage.EID_FIELD: return createEidField();
			case BibtexPackage.IN_PROCEEDINGS_ENTRY: return createInProceedingsEntry();
			case BibtexPackage.ARTICLE_ENTRY: return createArticleEntry();
			case BibtexPackage.BIBLIOGRAPHY: return createBibliography();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Author createAuthor() {
		AuthorImpl author = new AuthorImpl();
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YearValue createYearValue() {
		YearValueImpl yearValue = new YearValueImpl();
		return yearValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntValue createIntValue() {
		IntValueImpl intValue = new IntValueImpl();
		return intValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page createPage() {
		PageImpl page = new PageImpl();
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorField createAuthorField() {
		AuthorFieldImpl authorField = new AuthorFieldImpl();
		return authorField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorField createEditorField() {
		EditorFieldImpl editorField = new EditorFieldImpl();
		return editorField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TitleField createTitleField() {
		TitleFieldImpl titleField = new TitleFieldImpl();
		return titleField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BookTitleField createBookTitleField() {
		BookTitleFieldImpl bookTitleField = new BookTitleFieldImpl();
		return bookTitleField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberField createNumberField() {
		NumberFieldImpl numberField = new NumberFieldImpl();
		return numberField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YearField createYearField() {
		YearFieldImpl yearField = new YearFieldImpl();
		return yearField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexKeyField createBibtexKeyField() {
		BibtexKeyFieldImpl bibtexKeyField = new BibtexKeyFieldImpl();
		return bibtexKeyField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JournalField createJournalField() {
		JournalFieldImpl journalField = new JournalFieldImpl();
		return journalField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VolumeField createVolumeField() {
		VolumeFieldImpl volumeField = new VolumeFieldImpl();
		return volumeField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageField createPageField() {
		PageFieldImpl pageField = new PageFieldImpl();
		return pageField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeriesField createSeriesField() {
		SeriesFieldImpl seriesField = new SeriesFieldImpl();
		return seriesField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddressField createAddressField() {
		AddressFieldImpl addressField = new AddressFieldImpl();
		return addressField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MonthField createMonthField() {
		MonthFieldImpl monthField = new MonthFieldImpl();
		return monthField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrganizationField createOrganizationField() {
		OrganizationFieldImpl organizationField = new OrganizationFieldImpl();
		return organizationField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NoteField createNoteField() {
		NoteFieldImpl noteField = new NoteFieldImpl();
		return noteField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublisherField createPublisherField() {
		PublisherFieldImpl publisherField = new PublisherFieldImpl();
		return publisherField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartField createPartField() {
		PartFieldImpl partField = new PartFieldImpl();
		return partField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EidField createEidField() {
		EidFieldImpl eidField = new EidFieldImpl();
		return eidField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InProceedingsEntry createInProceedingsEntry() {
		InProceedingsEntryImpl inProceedingsEntry = new InProceedingsEntryImpl();
		return inProceedingsEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArticleEntry createArticleEntry() {
		ArticleEntryImpl articleEntry = new ArticleEntryImpl();
		return articleEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bibliography createBibliography() {
		BibliographyImpl bibliography = new BibliographyImpl();
		return bibliography;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexPackage getBibtexPackage() {
		return (BibtexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BibtexPackage getPackage() {
		return BibtexPackage.eINSTANCE;
	}

} //BibtexFactoryImpl
