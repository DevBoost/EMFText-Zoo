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
 * A representation of the model object '<em><b>Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.Clause#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.emftext.language.prolog.Clause#getPredicateList <em>Predicate List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.prolog.PrologPackage#getClause()
 * @model
 * @generated
 */
public interface Clause extends EObject {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(Predicate)
	 * @see org.emftext.language.prolog.PrologPackage#getClause_Predicate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.Clause#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

	/**
	 * Returns the value of the '<em><b>Predicate List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate List</em>' containment reference.
	 * @see #setPredicateList(PredicateList)
	 * @see org.emftext.language.prolog.PrologPackage#getClause_PredicateList()
	 * @model containment="true"
	 * @generated
	 */
	PredicateList getPredicateList();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.Clause#getPredicateList <em>Predicate List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate List</em>' containment reference.
	 * @see #getPredicateList()
	 * @generated
	 */
	void setPredicateList(PredicateList value);

} // Clause
