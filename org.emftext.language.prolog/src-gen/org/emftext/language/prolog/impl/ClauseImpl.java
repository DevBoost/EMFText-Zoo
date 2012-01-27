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

import org.emftext.language.prolog.Clause;
import org.emftext.language.prolog.Predicate;
import org.emftext.language.prolog.PredicateList;
import org.emftext.language.prolog.PrologPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.impl.ClauseImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.emftext.language.prolog.impl.ClauseImpl#getPredicateList <em>Predicate List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClauseImpl extends EObjectImpl implements Clause {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate predicate;

	/**
	 * The cached value of the '{@link #getPredicateList() <em>Predicate List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateList()
	 * @generated
	 * @ordered
	 */
	protected PredicateList predicateList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrologPackage.Literals.CLAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Predicate getPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicate(Predicate newPredicate, NotificationChain msgs) {
		Predicate oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE__PREDICATE, oldPredicate, newPredicate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(Predicate newPredicate) {
		if (newPredicate != predicate) {
			NotificationChain msgs = null;
			if (predicate != null)
				msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE__PREDICATE, null, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE__PREDICATE, null, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE__PREDICATE, newPredicate, newPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateList getPredicateList() {
		return predicateList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicateList(PredicateList newPredicateList, NotificationChain msgs) {
		PredicateList oldPredicateList = predicateList;
		predicateList = newPredicateList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE__PREDICATE_LIST, oldPredicateList, newPredicateList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicateList(PredicateList newPredicateList) {
		if (newPredicateList != predicateList) {
			NotificationChain msgs = null;
			if (predicateList != null)
				msgs = ((InternalEObject)predicateList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE__PREDICATE_LIST, null, msgs);
			if (newPredicateList != null)
				msgs = ((InternalEObject)newPredicateList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE__PREDICATE_LIST, null, msgs);
			msgs = basicSetPredicateList(newPredicateList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE__PREDICATE_LIST, newPredicateList, newPredicateList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrologPackage.CLAUSE__PREDICATE:
				return basicSetPredicate(null, msgs);
			case PrologPackage.CLAUSE__PREDICATE_LIST:
				return basicSetPredicateList(null, msgs);
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
			case PrologPackage.CLAUSE__PREDICATE:
				return getPredicate();
			case PrologPackage.CLAUSE__PREDICATE_LIST:
				return getPredicateList();
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
			case PrologPackage.CLAUSE__PREDICATE:
				setPredicate((Predicate)newValue);
				return;
			case PrologPackage.CLAUSE__PREDICATE_LIST:
				setPredicateList((PredicateList)newValue);
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
			case PrologPackage.CLAUSE__PREDICATE:
				setPredicate((Predicate)null);
				return;
			case PrologPackage.CLAUSE__PREDICATE_LIST:
				setPredicateList((PredicateList)null);
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
			case PrologPackage.CLAUSE__PREDICATE:
				return predicate != null;
			case PrologPackage.CLAUSE__PREDICATE_LIST:
				return predicateList != null;
		}
		return super.eIsSet(featureID);
	}

} //ClauseImpl
