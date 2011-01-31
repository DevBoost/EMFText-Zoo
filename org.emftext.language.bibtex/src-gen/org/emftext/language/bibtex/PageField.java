/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.PageField#getFromPage <em>From Page</em>}</li>
 *   <li>{@link org.emftext.language.bibtex.PageField#getToPage <em>To Page</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.bibtex.BibtexPackage#getPageField()
 * @model
 * @generated
 */
public interface PageField extends Field {
	/**
	 * Returns the value of the '<em><b>From Page</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Page</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Page</em>' containment reference.
	 * @see #setFromPage(Page)
	 * @see org.emftext.language.bibtex.BibtexPackage#getPageField_FromPage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Page getFromPage();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.PageField#getFromPage <em>From Page</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Page</em>' containment reference.
	 * @see #getFromPage()
	 * @generated
	 */
	void setFromPage(Page value);

	/**
	 * Returns the value of the '<em><b>To Page</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Page</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Page</em>' containment reference.
	 * @see #setToPage(Page)
	 * @see org.emftext.language.bibtex.BibtexPackage#getPageField_ToPage()
	 * @model containment="true"
	 * @generated
	 */
	Page getToPage();

	/**
	 * Sets the value of the '{@link org.emftext.language.bibtex.PageField#getToPage <em>To Page</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Page</em>' containment reference.
	 * @see #getToPage()
	 * @generated
	 */
	void setToPage(Page value);

} // PageField
