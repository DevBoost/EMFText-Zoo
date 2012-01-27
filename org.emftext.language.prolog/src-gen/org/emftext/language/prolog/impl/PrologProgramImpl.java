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

import org.emftext.language.prolog.ClauseList;
import org.emftext.language.prolog.PrologPackage;
import org.emftext.language.prolog.PrologProgram;
import org.emftext.language.prolog.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.prolog.impl.PrologProgramImpl#getClauseList <em>Clause List</em>}</li>
 *   <li>{@link org.emftext.language.prolog.impl.PrologProgramImpl#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrologProgramImpl extends EObjectImpl implements PrologProgram {
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
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected Query query;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrologProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrologPackage.Literals.PROLOG_PROGRAM;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST, oldClauseList, newClauseList);
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
				msgs = ((InternalEObject)clauseList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST, null, msgs);
			if (newClauseList != null)
				msgs = ((InternalEObject)newClauseList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST, null, msgs);
			msgs = basicSetClauseList(newClauseList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST, newClauseList, newClauseList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuery(Query newQuery, NotificationChain msgs) {
		Query oldQuery = query;
		query = newQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PrologPackage.PROLOG_PROGRAM__QUERY, oldQuery, newQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(Query newQuery) {
		if (newQuery != query) {
			NotificationChain msgs = null;
			if (query != null)
				msgs = ((InternalEObject)query).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PROLOG_PROGRAM__QUERY, null, msgs);
			if (newQuery != null)
				msgs = ((InternalEObject)newQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PrologPackage.PROLOG_PROGRAM__QUERY, null, msgs);
			msgs = basicSetQuery(newQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrologPackage.PROLOG_PROGRAM__QUERY, newQuery, newQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST:
				return basicSetClauseList(null, msgs);
			case PrologPackage.PROLOG_PROGRAM__QUERY:
				return basicSetQuery(null, msgs);
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
			case PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST:
				return getClauseList();
			case PrologPackage.PROLOG_PROGRAM__QUERY:
				return getQuery();
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
			case PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST:
				setClauseList((ClauseList)newValue);
				return;
			case PrologPackage.PROLOG_PROGRAM__QUERY:
				setQuery((Query)newValue);
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
			case PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST:
				setClauseList((ClauseList)null);
				return;
			case PrologPackage.PROLOG_PROGRAM__QUERY:
				setQuery((Query)null);
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
			case PrologPackage.PROLOG_PROGRAM__CLAUSE_LIST:
				return clauseList != null;
			case PrologPackage.PROLOG_PROGRAM__QUERY:
				return query != null;
		}
		return super.eIsSet(featureID);
	}

} //PrologProgramImpl
