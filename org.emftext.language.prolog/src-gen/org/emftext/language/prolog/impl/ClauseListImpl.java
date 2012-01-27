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
import org.emftext.language.prolog.ClauseList;
import org.emftext.language.prolog.PrologPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clause List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.impl.ClauseListImpl#getClause <em>Clause</em>}</li>
 *   <li>{@link org.emftext.language.prolog.impl.ClauseListImpl#getClauseList <em>Clause List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClauseListImpl extends EObjectImpl implements ClauseList {
	/**
	 * The cached value of the '{@link #getClause() <em>Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClause()
	 * @generated
	 * @ordered
	 */
	protected Clause clause;

	/**
	 * The cached value of the '{@link #getClauseList() <em>Clause List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClauseList()
	 * @generated
	 * @ordered
	 */
	protected ClauseList clauseList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClauseListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrologPackage.Literals.CLAUSE_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clause getClause() {
		return clause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClause(Clause newClause, NotificationChain msgs) {
		Clause oldClause = clause;
		clause = newClause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE_LIST__CLAUSE, oldClause, newClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClause(Clause newClause) {
		if (newClause != clause) {
			NotificationChain msgs = null;
			if (clause != null)
				msgs = ((InternalEObject)clause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE_LIST__CLAUSE, null, msgs);
			if (newClause != null)
				msgs = ((InternalEObject)newClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE_LIST__CLAUSE, null, msgs);
			msgs = basicSetClause(newClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE_LIST__CLAUSE, newClause, newClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClauseList getClauseList() {
		return clauseList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClauseList(ClauseList newClauseList, NotificationChain msgs) {
		ClauseList oldClauseList = clauseList;
		clauseList = newClauseList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE_LIST__CLAUSE_LIST, oldClauseList, newClauseList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClauseList(ClauseList newClauseList) {
		if (newClauseList != clauseList) {
			NotificationChain msgs = null;
			if (clauseList != null)
				msgs = ((InternalEObject)clauseList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE_LIST__CLAUSE_LIST, null, msgs);
			if (newClauseList != null)
				msgs = ((InternalEObject)newClauseList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.CLAUSE_LIST__CLAUSE_LIST, null, msgs);
			msgs = basicSetClauseList(newClauseList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.CLAUSE_LIST__CLAUSE_LIST, newClauseList, newClauseList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrologPackage.CLAUSE_LIST__CLAUSE:
				return basicSetClause(null, msgs);
			case PrologPackage.CLAUSE_LIST__CLAUSE_LIST:
				return basicSetClauseList(null, msgs);
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
			case PrologPackage.CLAUSE_LIST__CLAUSE:
				return getClause();
			case PrologPackage.CLAUSE_LIST__CLAUSE_LIST:
				return getClauseList();
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
			case PrologPackage.CLAUSE_LIST__CLAUSE:
				setClause((Clause)newValue);
				return;
			case PrologPackage.CLAUSE_LIST__CLAUSE_LIST:
				setClauseList((ClauseList)newValue);
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
			case PrologPackage.CLAUSE_LIST__CLAUSE:
				setClause((Clause)null);
				return;
			case PrologPackage.CLAUSE_LIST__CLAUSE_LIST:
				setClauseList((ClauseList)null);
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
			case PrologPackage.CLAUSE_LIST__CLAUSE:
				return clause != null;
			case PrologPackage.CLAUSE_LIST__CLAUSE_LIST:
				return clauseList != null;
		}
		return super.eIsSet(featureID);
	}

} //ClauseListImpl
