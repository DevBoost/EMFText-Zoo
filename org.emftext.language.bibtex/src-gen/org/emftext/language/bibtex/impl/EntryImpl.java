/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.bibtex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.language.bibtex.BibtexKeyField;
import org.emftext.language.bibtex.BibtexPackage;
import org.emftext.language.bibtex.Entry;
import org.emftext.language.bibtex.Field;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.bibtex.impl.EntryImpl#getBibtexKey <em>Bibtex Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EntryImpl extends EObjectImpl implements Entry {
	/**
	 * The cached value of the '{@link #getBibtexKey() <em>Bibtex Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBibtexKey()
	 * @generated
	 * @ordered
	 */
	protected BibtexKeyField bibtexKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BibtexPackage.Literals.ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibtexKeyField getBibtexKey() {
		return bibtexKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBibtexKey(BibtexKeyField newBibtexKey, NotificationChain msgs) {
		BibtexKeyField oldBibtexKey = bibtexKey;
		bibtexKey = newBibtexKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BibtexPackage.ENTRY__BIBTEX_KEY, oldBibtexKey, newBibtexKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBibtexKey(BibtexKeyField newBibtexKey) {
		if (newBibtexKey != bibtexKey) {
			NotificationChain msgs = null;
			if (bibtexKey != null)
				msgs = ((InternalEObject)bibtexKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ENTRY__BIBTEX_KEY, null, msgs);
			if (newBibtexKey != null)
				msgs = ((InternalEObject)newBibtexKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BibtexPackage.ENTRY__BIBTEX_KEY, null, msgs);
			msgs = basicSetBibtexKey(newBibtexKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BibtexPackage.ENTRY__BIBTEX_KEY, newBibtexKey, newBibtexKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Field> getGeneralFields() {
		
				 org.eclipse.emf.common.util.EList< org.emftext.language.bibtex.Field> result = new  org.eclipse.emf.common.util.BasicEList< org.emftext.language.bibtex.Field>();
		
				 org.emftext.language.bibtex.BibtexKeyField bibtexKeyField = getBibtexKey();
		
				result.add(bibtexKeyField);
		
				return result;
		
	}



	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BibtexPackage.ENTRY__BIBTEX_KEY:
				return basicSetBibtexKey(null, msgs);
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
			case BibtexPackage.ENTRY__BIBTEX_KEY:
				return getBibtexKey();
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
			case BibtexPackage.ENTRY__BIBTEX_KEY:
				setBibtexKey((BibtexKeyField)newValue);
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
			case BibtexPackage.ENTRY__BIBTEX_KEY:
				setBibtexKey((BibtexKeyField)null);
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
			case BibtexPackage.ENTRY__BIBTEX_KEY:
				return bibtexKey != null;
		}
		return super.eIsSet(featureID);
	}

} //EntryImpl
