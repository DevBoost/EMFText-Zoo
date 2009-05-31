/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmt.am3.dsls.KM3.KM3Package;
import org.eclipse.gmt.am3.dsls.KM3.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.impl.ReferenceImpl#getIsContainer <em>Is Container</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.impl.ReferenceImpl#getOpposite <em>Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceImpl extends StructuralFeatureImpl implements Reference {
	/**
	 * The default value of the '{@link #getIsContainer() <em>Is Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsContainer()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_CONTAINER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsContainer() <em>Is Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsContainer()
	 * @generated
	 * @ordered
	 */
	protected Boolean isContainer = IS_CONTAINER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected Reference opposite;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KM3Package.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsContainer() {
		return isContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsContainer(Boolean newIsContainer) {
		Boolean oldIsContainer = isContainer;
		isContainer = newIsContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KM3Package.REFERENCE__IS_CONTAINER, oldIsContainer, isContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getOpposite() {
		if (opposite != null && opposite.eIsProxy()) {
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (Reference)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KM3Package.REFERENCE__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(Reference newOpposite) {
		Reference oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KM3Package.REFERENCE__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KM3Package.REFERENCE__IS_CONTAINER:
				return getIsContainer();
			case KM3Package.REFERENCE__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
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
			case KM3Package.REFERENCE__IS_CONTAINER:
				setIsContainer((Boolean)newValue);
				return;
			case KM3Package.REFERENCE__OPPOSITE:
				setOpposite((Reference)newValue);
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
			case KM3Package.REFERENCE__IS_CONTAINER:
				setIsContainer(IS_CONTAINER_EDEFAULT);
				return;
			case KM3Package.REFERENCE__OPPOSITE:
				setOpposite((Reference)null);
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
			case KM3Package.REFERENCE__IS_CONTAINER:
				return IS_CONTAINER_EDEFAULT == null ? isContainer != null : !IS_CONTAINER_EDEFAULT.equals(isContainer);
			case KM3Package.REFERENCE__OPPOSITE:
				return opposite != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isContainer: ");
		result.append(isContainer);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
