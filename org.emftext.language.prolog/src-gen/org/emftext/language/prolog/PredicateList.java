/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.PredicateList#getPredicateList <em>Predicate List</em>}</li>
 *   <li>{@link org.emftext.language.prolog.PredicateList#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.prolog.PrologPackage#getPredicateList()
 * @model
 * @generated
 */
public interface PredicateList extends Query {
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
	 * @see org.emftext.language.prolog.PrologPackage#getPredicateList_Predicate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Predicate getPredicate();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.PredicateList#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(Predicate value);

	/**
	 * Returns the value of the '<em><b>Predicate List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate List</em>' reference.
	 * @see #setPredicateList(PredicateList)
	 * @see org.emftext.language.prolog.PrologPackage#getPredicateList_PredicateList()
	 * @model
	 * @generated
	 */
	PredicateList getPredicateList();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.PredicateList#getPredicateList <em>Predicate List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate List</em>' reference.
	 * @see #getPredicateList()
	 * @generated
	 */
	void setPredicateList(PredicateList value);

} // PredicateList
