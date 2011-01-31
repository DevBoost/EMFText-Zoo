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
 * A representation of the model object '<em><b>Article Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getTitle <em>Title</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getYear <em>Year</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getJournal <em>Journal</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getPages <em>Pages</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getNumber <em>Number</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getMonth <em>Month</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getNote <em>Note</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getPart <em>Part</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.ArticleEntry#getEid <em>Eid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry()
 * @model
 * @generated
 */
public interface ArticleEntry extends Entry {

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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Author()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AuthorField getAuthor();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getAuthor <em>Author</em>}' containment reference.
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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Title()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TitleField getTitle();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getTitle <em>Title</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' containment reference.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(TitleField value);

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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Year()
	 * @model containment="true" required="true"
	 * @generated
	 */
	YearField getYear();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getYear <em>Year</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' containment reference.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(YearField value);

	/**
	 * Returns the value of the '<em><b>Journal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal</em>' containment reference.
	 * @see #setJournal(JournalField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Journal()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JournalField getJournal();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getJournal <em>Journal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal</em>' containment reference.
	 * @see #getJournal()
	 * @generated
	 */
	void setJournal(JournalField value);

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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Pages()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PageField getPages();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getPages <em>Pages</em>}' containment reference.
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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Volume()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VolumeField getVolume();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getVolume <em>Volume</em>}' containment reference.
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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Number()
	 * @model containment="true"
	 * @generated
	 */
	NumberField getNumber();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getNumber <em>Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' containment reference.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(NumberField value);

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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Month()
	 * @model containment="true"
	 * @generated
	 */
	MonthField getMonth();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getMonth <em>Month</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' containment reference.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(MonthField value);

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
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Note()
	 * @model containment="true"
	 * @generated
	 */
	NoteField getNote();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getNote <em>Note</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Note</em>' containment reference.
	 * @see #getNote()
	 * @generated
	 */
	void setNote(NoteField value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference.
	 * @see #setPart(PartField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Part()
	 * @model containment="true"
	 * @generated
	 */
	PartField getPart();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getPart <em>Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' containment reference.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(PartField value);

	/**
	 * Returns the value of the '<em><b>Eid</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eid</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eid</em>' containment reference.
	 * @see #setEid(EidField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getArticleEntry_Eid()
	 * @model containment="true"
	 * @generated
	 */
	EidField getEid();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.ArticleEntry#getEid <em>Eid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eid</em>' containment reference.
	 * @see #getEid()
	 * @generated
	 */
	void setEid(EidField value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.language.bibtex.Field> result = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.bibtex.Field>();\r\n\r\n\t\t\t\t\r\n\t\t org.emftext.language.bibtex.TitleField titleField = getTitle();\r\n\r\n\t\t org.emftext.language.bibtex.AuthorField authorField = getAuthor();\r\n\r\n\t\t org.emftext.language.bibtex.YearField yearField = getYear();\r\n\r\n\t\t org.emftext.language.bibtex.JournalField journalField = getJournal();\r\n\r\n\t\t org.emftext.language.bibtex.VolumeField volumeField = getVolume();\r\n\r\n\t\t org.emftext.language.bibtex.PageField pageField = getPages();\r\n\r\n\t\t\r\n\t\tresult.add(titleField);\r\n\r\n\t\tresult.add(authorField);\r\n\r\n\t\tresult.add(yearField);\r\n\r\n\t\tresult.add(journalField);\r\n\r\n\t\tresult.add(volumeField);\r\n\r\n\t\tresult.add(pageField);\r\n\r\n\t\t\r\n\t\treturn result;\r\n'"
	 * @generated
	 */
	EList<Field> getFields();
} // ArticleEntry
