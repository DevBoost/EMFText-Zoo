/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Proceedings Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getTitle <em>Title</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getBookTitle <em>Book Title</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getYear <em>Year</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getEditor <em>Editor</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getPages <em>Pages</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getNumber <em>Number</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getSeries <em>Series</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getAddress <em>Address</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getMonth <em>Month</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getOrganization <em>Organization</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getNote <em>Note</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.InProceedingsEntry#getPublisher <em>Publisher</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry()
 * @model
 * @generated
 */
public interface InProceedingsEntry extends Entry {
	/**
	 * Returns the value of the '<em><b>Author</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' containment reference.
	 * @see #setAuthor(AuthorField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Author()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AuthorField getAuthor();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getAuthor <em>Author</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' containment reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(AuthorField value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' containment reference.
	 * @see #setTitle(TitleField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Title()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TitleField getTitle();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getTitle <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' containment reference.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(TitleField value);

	/**
	 * Returns the value of the '<em><b>Book Title</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Book Title</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Book Title</em>' containment reference.
	 * @see #setBookTitle(BookTitleField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_BookTitle()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BookTitleField getBookTitle();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getBookTitle <em>Book Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Book Title</em>' containment reference.
	 * @see #getBookTitle()
	 * @generated
	 */
	void setBookTitle(BookTitleField value);

	/**
	 * Returns the value of the '<em><b>Year</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' containment reference.
	 * @see #setYear(YearField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Year()
	 * @model containment="true" required="true"
	 * @generated
	 */
	YearField getYear();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getYear <em>Year</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' containment reference.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(YearField value);

	/**
	 * Returns the value of the '<em><b>Editor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor</em>' containment reference.
	 * @see #setEditor(EditorField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Editor()
	 * @model containment="true"
	 * @generated
	 */
	EditorField getEditor();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getEditor <em>Editor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor</em>' containment reference.
	 * @see #getEditor()
	 * @generated
	 */
	void setEditor(EditorField value);

	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference.
	 * @see #setPages(PageField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Pages()
	 * @model containment="true"
	 * @generated
	 */
	PageField getPages();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getPages <em>Pages</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pages</em>' containment reference.
	 * @see #getPages()
	 * @generated
	 */
	void setPages(PageField value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' containment reference.
	 * @see #setVolume(VolumeField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Volume()
	 * @model containment="true"
	 * @generated
	 */
	VolumeField getVolume();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getVolume <em>Volume</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' containment reference.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(VolumeField value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' containment reference.
	 * @see #setNumber(NumberField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Number()
	 * @model containment="true"
	 * @generated
	 */
	NumberField getNumber();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getNumber <em>Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' containment reference.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(NumberField value);

	/**
	 * Returns the value of the '<em><b>Series</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Series</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Series</em>' containment reference.
	 * @see #setSeries(SeriesField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Series()
	 * @model containment="true"
	 * @generated
	 */
	SeriesField getSeries();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getSeries <em>Series</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Series</em>' containment reference.
	 * @see #getSeries()
	 * @generated
	 */
	void setSeries(SeriesField value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(AddressField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Address()
	 * @model containment="true"
	 * @generated
	 */
	AddressField getAddress();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(AddressField value);

	/**
	 * Returns the value of the '<em><b>Month</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' containment reference.
	 * @see #setMonth(MonthField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Month()
	 * @model containment="true"
	 * @generated
	 */
	MonthField getMonth();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getMonth <em>Month</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' containment reference.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(MonthField value);

	/**
	 * Returns the value of the '<em><b>Organization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization</em>' containment reference.
	 * @see #setOrganization(OrganizationField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Organization()
	 * @model containment="true"
	 * @generated
	 */
	OrganizationField getOrganization();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getOrganization <em>Organization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization</em>' containment reference.
	 * @see #getOrganization()
	 * @generated
	 */
	void setOrganization(OrganizationField value);

	/**
	 * Returns the value of the '<em><b>Note</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Note</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Note</em>' containment reference.
	 * @see #setNote(NoteField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Note()
	 * @model containment="true"
	 * @generated
	 */
	NoteField getNote();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getNote <em>Note</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' containment reference.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(NoteField value);

	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publisher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publisher</em>' containment reference.
	 * @see #setPublisher(PublisherField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getInProceedingsEntry_Publisher()
	 * @model containment="true"
	 * @generated
	 */
	PublisherField getPublisher();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.InProceedingsEntry#getPublisher <em>Publisher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' containment reference.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(PublisherField value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.language.bibtex.Field> result = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.bibtex.Field>();\r\n\r\n\t\t\r\n\t\t org.emftext.language.bibtex.TitleField titleField = getTitle();\r\n\r\n\t\t org.emftext.language.bibtex.AuthorField authorField = getAuthor();\r\n\r\n\t\t org.emftext.language.bibtex.YearField yearField = getYear();\r\n\r\n\t\t org.emftext.language.bibtex.BookTitleField bookTitleField = getBookTitle();\r\n\r\n\t\t\r\n\t\tresult.add(titleField);\r\n\r\n\t\tresult.add(authorField);\r\n\r\n\t\tresult.add(yearField);\r\n\r\n\t\tresult.add(bookTitleField);\r\n\r\n\t\t\r\n\t\treturn result;\r\n'"
	 * @generated
	 */
	EList<Field> getFields();

} // InProceedingsEntry
