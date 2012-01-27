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
 * A representation of the model object '<em><b>Clause List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.ClauseList#getClause <em>Clause</em>}</li>
 *   <li>{@link org.emftext.language.prolog.ClauseList#getClauseList <em>Clause List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.prolog.PrologPackage#getClauseList()
 * @model
 * @generated
 */
public interface ClauseList extends EObject {
	/**
	 * Returns the value of the '<em><b>Clause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clause</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clause</em>' containment reference.
	 * @see #setClause(Clause)
	 * @see org.emftext.language.prolog.PrologPackage#getClauseList_Clause()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Clause getClause();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.ClauseList#getClause <em>Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clause</em>' containment reference.
	 * @see #getClause()
	 * @generated
	 */
	void setClause(Clause value);

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
	 * @see org.emftext.language.prolog.PrologPackage#getClauseList_ClauseList()
	 * @model containment="true"
	 * @generated
	 */
	ClauseList getClauseList();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.ClauseList#getClauseList <em>Clause List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clause List</em>' containment reference.
	 * @see #getClauseList()
	 * @generated
	 */
	void setClauseList(ClauseList value);

} // ClauseList
