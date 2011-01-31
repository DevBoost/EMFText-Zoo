/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.Entry#getBibtexKey <em>Bibtex Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.bibtex.BibtexPackage#getEntry()
 * @model abstract="true"
 * @generated
 */
public interface Entry extends EObject {
	/**
	 * Returns the value of the '<em><b>Bibtex Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bibtex Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bibtex Key</em>' containment reference.
	 * @see #setBibtexKey(BibtexKeyField)
	 * @see org.emftext.language.bibtex.BibtexPackage#getEntry_BibtexKey()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BibtexKeyField getBibtexKey();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.Entry#getBibtexKey <em>Bibtex Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bibtex Key</em>' containment reference.
	 * @see #getBibtexKey()
	 * @generated
	 */
	void setBibtexKey(BibtexKeyField value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.language.bibtex.Field> result = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.bibtex.Field>();\r\n\r\n\t\t org.emftext.language.bibtex.BibtexKeyField bibtexKeyField = getBibtexKey();\r\n\r\n\t\tresult.add(bibtexKeyField);\r\n\r\n\t\treturn result;\r\n'"
	 * @generated
	 */
	EList<Field> getGeneralFields();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.language.bibtex.Field> result = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.bibtex.Field>();\r\n\r\n\t\tresult.addAll(getGeneralFields());\r\n\r\n\t\t\r\n\t\t org.emftext.language.bibtex.TitleField titleField = getTitle();\r\n\r\n\t\t org.emftext.language.bibtex.AuthorField authorField = getAuthor();\r\n\r\n\t\t org.emftext.language.bibtex.YearField yearField = getYear();\r\n\r\n\t\t org.emftext.language.bibtex.BookTitleField bookTitleField = getBookTitle();\r\n\r\n\t\t\r\n\t\tresult.add(titleField);\r\n\r\n\t\tresult.add(authorField);\r\n\r\n\t\tresult.add(yearField);\r\n\r\n\t\tresult.add(bookTitleField);\r\n\r\n\t\t\r\n\t\treturn result;\r\n'"
	 * @generated
	 */
	EList<Field> getFields();

} // Entry
