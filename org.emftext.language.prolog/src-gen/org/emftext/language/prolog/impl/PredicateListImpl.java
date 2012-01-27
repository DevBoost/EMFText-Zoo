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

import org.emftext.language.prolog.Predicate;
import org.emftext.language.prolog.PredicateList;
import org.emftext.language.prolog.PrologPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.impl.PredicateListImpl#getPredicateList <em>Predicate List</em>}</li>
 *   <li>{@link org.emftext.language.prolog.impl.PredicateListImpl#getPredicate <em>Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateListImpl extends QueryImpl implements PredicateList {
	/**
	 * The cached value of the '{@link #getPredicateList() <em>Predicate List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicateList()
	 * @generated
	 * @ordered
	 */
	protected PredicateList predicateList;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrologPackage.Literals.PREDICATE_LIST;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE_LIST__PREDICATE, oldPredicate, newPredicate);
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
				msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PREDICATE_LIST__PREDICATE, null, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PREDICATE_LIST__PREDICATE, null, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE_LIST__PREDICATE, newPredicate, newPredicate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateList getPredicateList() {
		if (predicateList != null && predicateList.eIsProxy()) {
			InternalEObject oldPredicateList = (InternalEObject)predicateList;
			predicateList = (PredicateList)eResolveProxy(oldPredicateList);
			if (predicateList != oldPredicateList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PrologPackage.PREDICATE_LIST__PREDICATE_LIST, oldPredicateList, predicateList));
			}
		}
		return predicateList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateList basicGetPredicateList() {
		return predicateList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicateList(PredicateList newPredicateList) {
		PredicateList oldPredicateList = predicateList;
		predicateList = newPredicateList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.PREDICATE_LIST__PREDICATE_LIST, oldPredicateList, predicateList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrologPackage.PREDICATE_LIST__PREDICATE:
				return basicSetPredicate(null, msgs);
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
			case PrologPackage.PREDICATE_LIST__PREDICATE_LIST:
				if (resolve) return getPredicateList();
				return basicGetPredicateList();
			case PrologPackage.PREDICATE_LIST__PREDICATE:
				return getPredicate();
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
			case PrologPackage.PREDICATE_LIST__PREDICATE_LIST:
				setPredicateList((PredicateList)newValue);
				return;
			case PrologPackage.PREDICATE_LIST__PREDICATE:
				setPredicate((Predicate)newValue);
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
			case PrologPackage.PREDICATE_LIST__PREDICATE_LIST:
				setPredicateList((PredicateList)null);
				return;
			case PrologPackage.PREDICATE_LIST__PREDICATE:
				setPredicate((Predicate)null);
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
			case PrologPackage.PREDICATE_LIST__PREDICATE_LIST:
				return predicateList != null;
			case PrologPackage.PREDICATE_LIST__PREDICATE:
				return predicate != null;
		}
		return super.eIsSet(featureID);
	}

} //PredicateListImpl
