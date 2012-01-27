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
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.Predicate#getAtom <em>Atom</em>}</li>
 *   <li>{@link org.emftext.language.prolog.Predicate#getTermList <em>Term List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.prolog.PrologPackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends EObject {
	/**
	 * Returns the value of the '<em><b>Atom</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atom</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atom</em>' containment reference.
	 * @see #setAtom(Atom)
	 * @see org.emftext.language.prolog.PrologPackage#getPredicate_Atom()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Atom getAtom();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.Predicate#getAtom <em>Atom</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atom</em>' containment reference.
	 * @see #getAtom()
	 * @generated
	 */
	void setAtom(Atom value);

	/**
	 * Returns the value of the '<em><b>Term List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Term List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Term List</em>' containment reference.
	 * @see #setTermList(TermList)
	 * @see org.emftext.language.prolog.PrologPackage#getPredicate_TermList()
	 * @model containment="true"
	 * @generated
	 */
	TermList getTermList();

	/**
	 * Sets the value of the '{@link org.emftext.language.prolog.Predicate#getTermList <em>Term List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Term List</em>' containment reference.
	 * @see #getTermList()
	 * @generated
	 */
	void setTermList(TermList value);

} // Predicate
