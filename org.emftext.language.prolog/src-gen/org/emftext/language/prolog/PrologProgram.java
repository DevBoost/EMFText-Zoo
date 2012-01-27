/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.PrologProgram#getClauseList <em>Clause List</em>}</li>
 *   <li>{@link org.emftext.language.prolog.PrologProgram#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.prolog.PrologPackage#getPrologProgram()
 * @model
 * @generated
 */
public interface PrologProgram extends EObject {
	/**
	 * Returns the value of the '<em><b>Clause List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clause List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clause List</em>' containment reference.
	 * @see #setClauseList(ClauseList)
	 * @see org.emftext.language.prolog.PrologPackage#getPrologProgram_ClauseList()
	 * @model containment="true"
	 * @generated
	 */
	ClauseList getClauseList();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.PrologProgram#getClauseList <em>Clause List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clause List</em>' containment reference.
	 * @see #getClauseList()
	 * @generated
	 */
	void setClauseList(ClauseList value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' containment reference.
	 * @see #setQuery(Query)
	 * @see org.emftext.language.prolog.PrologPackage#getPrologProgram_Query()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Query getQuery();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.PrologProgram#getQuery <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' containment reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(Query value);

} // PrologProgram
