/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.prolog.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.prolog.Atom;
import org.emftext.language.prolog.Predicate;
import org.emftext.language.prolog.PrologPackage;
import org.emftext.language.prolog.TermList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.impl.PredicateImpl#getAtom <em>Atom</em>}</li>
 *   <li>{@link org.emftext.language.prolog.impl.PredicateImpl#getTermList <em>Term List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateImpl extends EObjectImpl implements Predicate {
	/**
	 * The cached value of the '{@link #getAtom() <em>Atom</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtom()
	 * @generated
	 * @ordered
	 */
	protected Atom atom;

	/**
	 * The cached value of the '{@link #getTermList() <em>Term List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTermList()
	 * @generated
	 * @ordered
	 */
	protected TermList termList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrologPackage.Literals.PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom getAtom() {
		return atom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAtom(Atom newAtom, NotificationChain msgs) {
		Atom oldAtom = atom;
		atom = newAtom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE__ATOM, oldAtom, newAtom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtom(Atom newAtom) {
		if (newAtom != atom) {
			NotificationChain msgs = null;
			if (atom != null)
				msgs = ((InternalEObject)atom).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PREDICATE__ATOM, null, msgs);
			if (newAtom != null)
				msgs = ((InternalEObject)newAtom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PREDICATE__ATOM, null, msgs);
			msgs = basicSetAtom(newAtom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE__ATOM, newAtom, newAtom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TermList getTermList() {
		return termList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTermList(TermList newTermList, NotificationChain msgs) {
		TermList oldTermList = termList;
		termList = newTermList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE__TERM_LIST, oldTermList, newTermList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTermList(TermList newTermList) {
		if (newTermList != termList) {
			NotificationChain msgs = null;
			if (termList != null)
				msgs = ((InternalEObject)termList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PREDICATE__TERM_LIST, null, msgs);
			if (newTermList != null)
				msgs = ((InternalEObject)newTermList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PREDICATE__TERM_LIST, null, msgs);
			msgs = basicSetTermList(newTermList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE__TERM_LIST, newTermList, newTermList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrologPackage.PREDICATE__ATOM:
				return basicSetAtom(null, msgs);
			case PrologPackage.PREDICATE__TERM_LIST:
				return basicSetTermList(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PrologPackage.PREDICATE__ATOM:
				return getAtom();
			case PrologPackage.PREDICATE__TERM_LIST:
				return getTermList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PrologPackage.PREDICATE__ATOM:
				setAtom((Atom)newValue);
				return;
			case PrologPackage.PREDICATE__TERM_LIST:
				setTermList((TermList)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PrologPackage.PREDICATE__ATOM:
				setAtom((Atom)null);
				return;
			case PrologPackage.PREDICATE__TERM_LIST:
				setTermList((TermList)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PrologPackage.PREDICATE__ATOM:
				return atom != null;
			case PrologPackage.PREDICATE__TERM_LIST:
				return termList != null;
		}
		return super.eIsSet(featureID);
	}

} //PredicateImpl
