/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.bibtex.BibtexPackage
 * @generated
 */
public interface BibtexFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BibtexFactory eINSTANCE = org.emftext.language.bibtex.impl.BibtexFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Author</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Author</em>'.
	 * @generated
	 */
	Author createAuthor();

	/**
	 * Returns a new object of class '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Editor</em>'.
	 * @generated
	 */
	Editor createEditor();

	/**
	 * Returns a new object of class '<em>Year Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Year Value</em>'.
	 * @generated
	 */
	YearValue createYearValue();

	/**
	 * Returns a new object of class '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Value</em>'.
	 * @generated
	 */
	IntValue createIntValue();

	/**
	 * Returns a new object of class '<em>Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page</em>'.
	 * @generated
	 */
	Page createPage();

	/**
	 * Returns a new object of class '<em>Author Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Author Field</em>'.
	 * @generated
	 */
	AuthorField createAuthorField();

	/**
	 * Returns a new object of class '<em>Editor Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Editor Field</em>'.
	 * @generated
	 */
	EditorField createEditorField();

	/**
	 * Returns a new object of class '<em>Title Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Title Field</em>'.
	 * @generated
	 */
	TitleField createTitleField();

	/**
	 * Returns a new object of class '<em>Book Title Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Book Title Field</em>'.
	 * @generated
	 */
	BookTitleField createBookTitleField();

	/**
	 * Returns a new object of class '<em>Number Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Field</em>'.
	 * @generated
	 */
	NumberField createNumberField();

	/**
	 * Returns a new object of class '<em>Year Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Year Field</em>'.
	 * @generated
	 */
	YearField createYearField();

	/**
	 * Returns a new object of class '<em>Key Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Field</em>'.
	 * @generated
	 */
	BibtexKeyField createBibtexKeyField();

	/**
	 * Returns a new object of class '<em>Journal Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Journal Field</em>'.
	 * @generated
	 */
	JournalField createJournalField();

	/**
	 * Returns a new object of class '<em>Volume Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Volume Field</em>'.
	 * @generated
	 */
	VolumeField createVolumeField();

	/**
	 * Returns a new object of class '<em>Page Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Field</em>'.
	 * @generated
	 */
	PageField createPageField();

	/**
	 * Returns a new object of class '<em>Series Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Series Field</em>'.
	 * @generated
	 */
	SeriesField createSeriesField();

	/**
	 * Returns a new object of class '<em>Address Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Address Field</em>'.
	 * @generated
	 */
	AddressField createAddressField();

	/**
	 * Returns a new object of class '<em>Month Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Month Field</em>'.
	 * @generated
	 */
	MonthField createMonthField();

	/**
	 * Returns a new object of class '<em>Organization Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Organization Field</em>'.
	 * @generated
	 */
	OrganizationField createOrganizationField();

	/**
	 * Returns a new object of class '<em>Note Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Note Field</em>'.
	 * @generated
	 */
	NoteField createNoteField();

	/**
	 * Returns a new object of class '<em>Publisher Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publisher Field</em>'.
	 * @generated
	 */
	PublisherField createPublisherField();

	/**
	 * Returns a new object of class '<em>Part Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Part Field</em>'.
	 * @generated
	 */
	PartField createPartField();

	/**
	 * Returns a new object of class '<em>Eid Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eid Field</em>'.
	 * @generated
	 */
	EidField createEidField();

	/**
	 * Returns a new object of class '<em>In Proceedings Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Proceedings Entry</em>'.
	 * @generated
	 */
	InProceedingsEntry createInProceedingsEntry();

	/**
	 * Returns a new object of class '<em>Article Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Article Entry</em>'.
	 * @generated
	 */
	ArticleEntry createArticleEntry();

	/**
	 * Returns a new object of class '<em>Bibliography</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bibliography</em>'.
	 * @generated
	 */
	Bibliography createBibliography();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BibtexPackage getBibtexPackage();

} //BibtexFactory
