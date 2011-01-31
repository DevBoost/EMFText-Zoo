/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.emftext.language.bibtex.*;

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
 * @see org.emftext.language.bibtex.BibtexPackage
 * @generated
 */
public class BibtexSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BibtexPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexSwitch() {
		if (modelPackage == null) {
			modelPackage = BibtexPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BibtexPackage.PERSON: {
				Person person = (Person)theEObject;
				T result = casePerson(person);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.AUTHOR: {
				Author author = (Author)theEObject;
				T result = caseAuthor(author);
				if (result == null) result = casePerson(author);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.EDITOR: {
				Editor editor = (Editor)theEObject;
				T result = caseEditor(editor);
				if (result == null) result = casePerson(editor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.STRING_VALUE: {
				StringValue stringValue = (StringValue)theEObject;
				T result = caseStringValue(stringValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.YEAR_VALUE: {
				YearValue yearValue = (YearValue)theEObject;
				T result = caseYearValue(yearValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.INT_VALUE: {
				IntValue intValue = (IntValue)theEObject;
				T result = caseIntValue(intValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.PAGE: {
				Page page = (Page)theEObject;
				T result = casePage(page);
				if (result == null) result = caseIntValue(page);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.FIELD: {
				Field field = (Field)theEObject;
				T result = caseField(field);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.AUTHOR_FIELD: {
				AuthorField authorField = (AuthorField)theEObject;
				T result = caseAuthorField(authorField);
				if (result == null) result = caseField(authorField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.EDITOR_FIELD: {
				EditorField editorField = (EditorField)theEObject;
				T result = caseEditorField(editorField);
				if (result == null) result = caseField(editorField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.TITLE_FIELD: {
				TitleField titleField = (TitleField)theEObject;
				T result = caseTitleField(titleField);
				if (result == null) result = caseField(titleField);
				if (result == null) result = caseStringValue(titleField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.BOOK_TITLE_FIELD: {
				BookTitleField bookTitleField = (BookTitleField)theEObject;
				T result = caseBookTitleField(bookTitleField);
				if (result == null) result = caseField(bookTitleField);
				if (result == null) result = caseStringValue(bookTitleField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.NUMBER_FIELD: {
				NumberField numberField = (NumberField)theEObject;
				T result = caseNumberField(numberField);
				if (result == null) result = caseIntValue(numberField);
				if (result == null) result = caseField(numberField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.YEAR_FIELD: {
				YearField yearField = (YearField)theEObject;
				T result = caseYearField(yearField);
				if (result == null) result = caseField(yearField);
				if (result == null) result = caseYearValue(yearField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.BIBTEX_KEY_FIELD: {
				BibtexKeyField bibtexKeyField = (BibtexKeyField)theEObject;
				T result = caseBibtexKeyField(bibtexKeyField);
				if (result == null) result = caseField(bibtexKeyField);
				if (result == null) result = caseStringValue(bibtexKeyField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.JOURNAL_FIELD: {
				JournalField journalField = (JournalField)theEObject;
				T result = caseJournalField(journalField);
				if (result == null) result = caseField(journalField);
				if (result == null) result = caseStringValue(journalField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.VOLUME_FIELD: {
				VolumeField volumeField = (VolumeField)theEObject;
				T result = caseVolumeField(volumeField);
				if (result == null) result = caseField(volumeField);
				if (result == null) result = caseIntValue(volumeField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.PAGE_FIELD: {
				PageField pageField = (PageField)theEObject;
				T result = casePageField(pageField);
				if (result == null) result = caseField(pageField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.SERIES_FIELD: {
				SeriesField seriesField = (SeriesField)theEObject;
				T result = caseSeriesField(seriesField);
				if (result == null) result = caseStringValue(seriesField);
				if (result == null) result = caseField(seriesField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.ADDRESS_FIELD: {
				AddressField addressField = (AddressField)theEObject;
				T result = caseAddressField(addressField);
				if (result == null) result = caseField(addressField);
				if (result == null) result = caseStringValue(addressField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.MONTH_FIELD: {
				MonthField monthField = (MonthField)theEObject;
				T result = caseMonthField(monthField);
				if (result == null) result = caseField(monthField);
				if (result == null) result = caseStringValue(monthField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.ORGANIZATION_FIELD: {
				OrganizationField organizationField = (OrganizationField)theEObject;
				T result = caseOrganizationField(organizationField);
				if (result == null) result = caseField(organizationField);
				if (result == null) result = caseStringValue(organizationField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.NOTE_FIELD: {
				NoteField noteField = (NoteField)theEObject;
				T result = caseNoteField(noteField);
				if (result == null) result = caseField(noteField);
				if (result == null) result = caseStringValue(noteField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.PUBLISHER_FIELD: {
				PublisherField publisherField = (PublisherField)theEObject;
				T result = casePublisherField(publisherField);
				if (result == null) result = caseField(publisherField);
				if (result == null) result = caseStringValue(publisherField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.PART_FIELD: {
				PartField partField = (PartField)theEObject;
				T result = casePartField(partField);
				if (result == null) result = caseIntValue(partField);
				if (result == null) result = caseField(partField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.EID_FIELD: {
				EidField eidField = (EidField)theEObject;
				T result = caseEidField(eidField);
				if (result == null) result = caseField(eidField);
				if (result == null) result = caseStringValue(eidField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.ENTRY: {
				Entry entry = (Entry)theEObject;
				T result = caseEntry(entry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.IN_PROCEEDINGS_ENTRY: {
				InProceedingsEntry inProceedingsEntry = (InProceedingsEntry)theEObject;
				T result = caseInProceedingsEntry(inProceedingsEntry);
				if (result == null) result = caseEntry(inProceedingsEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.ARTICLE_ENTRY: {
				ArticleEntry articleEntry = (ArticleEntry)theEObject;
				T result = caseArticleEntry(articleEntry);
				if (result == null) result = caseEntry(articleEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BibtexPackage.BIBLIOGRAPHY: {
				Bibliography bibliography = (Bibliography)theEObject;
				T result = caseBibliography(bibliography);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Person</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Person</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePerson(Person object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Author</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Author</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuthor(Author object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditor(Editor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValue(StringValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Year Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Year Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseYearValue(YearValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntValue(IntValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePage(Page object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseField(Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Author Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Author Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuthorField(AuthorField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditorField(EditorField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Title Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Title Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTitleField(TitleField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Book Title Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Book Title Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBookTitleField(BookTitleField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberField(NumberField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Year Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Year Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseYearField(YearField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBibtexKeyField(BibtexKeyField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Journal Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Journal Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJournalField(JournalField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Volume Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Volume Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVolumeField(VolumeField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageField(PageField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Series Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Series Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeriesField(SeriesField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddressField(AddressField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Month Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Month Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMonthField(MonthField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganizationField(OrganizationField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Note Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Note Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoteField(NoteField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publisher Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publisher Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublisherField(PublisherField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartField(PartField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Eid Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Eid Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEidField(EidField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntry(Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Proceedings Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Proceedings Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInProceedingsEntry(InProceedingsEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Article Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Article Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArticleEntry(ArticleEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bibliography</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bibliography</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBibliography(Bibliography object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //BibtexSwitch
