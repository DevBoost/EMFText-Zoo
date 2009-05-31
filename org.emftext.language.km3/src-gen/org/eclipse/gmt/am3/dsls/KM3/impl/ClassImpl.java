/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmt.am3.dsls.KM3.KM3Package;
import org.eclipse.gmt.am3.dsls.KM3.Operation;
import org.eclipse.gmt.am3.dsls.KM3.StructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl#getIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 *   <li>{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends ClassifierImpl implements org.eclipse.gmt.am3.dsls.KM3.Class {
	/**
	 * The default value of the '{@link #getIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_ABSTRACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected Boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSupertypes() <em>Supertypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupertypes()
	 * @generated
	 * @ordered
	 */
	protected EList<org.eclipse.gmt.am3.dsls.KM3.Class> supertypes;

	/**
	 * The cached value of the '{@link #getStructuralFeatures() <em>Structural Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuralFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeature> structuralFeatures;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KM3Package.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(Boolean newIsAbstract) {
		Boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KM3Package.CLASS__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.eclipse.gmt.am3.dsls.KM3.Class> getSupertypes() {
		if (supertypes == null) {
			supertypes = new EObjectResolvingEList<org.eclipse.gmt.am3.dsls.KM3.Class>(org.eclipse.gmt.am3.dsls.KM3.Class.class, this, KM3Package.CLASS__SUPERTYPES);
		}
		return supertypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeature> getStructuralFeatures() {
		if (structuralFeatures == null) {
			structuralFeatures = new EObjectContainmentWithInverseEList<StructuralFeature>(StructuralFeature.class, this, KM3Package.CLASS__STRUCTURAL_FEATURES, KM3Package.STRUCTURAL_FEATURE__OWNER);
		}
		return structuralFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, KM3Package.CLASS__OPERATIONS, KM3Package.OPERATION__OWNER);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KM3Package.CLASS__STRUCTURAL_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuralFeatures()).basicAdd(otherEnd, msgs);
			case KM3Package.CLASS__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KM3Package.CLASS__STRUCTURAL_FEATURES:
				return ((InternalEList<?>)getStructuralFeatures()).basicRemove(otherEnd, msgs);
			case KM3Package.CLASS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
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
			case KM3Package.CLASS__IS_ABSTRACT:
				return getIsAbstract();
			case KM3Package.CLASS__SUPERTYPES:
				return getSupertypes();
			case KM3Package.CLASS__STRUCTURAL_FEATURES:
				return getStructuralFeatures();
			case KM3Package.CLASS__OPERATIONS:
				return getOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KM3Package.CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case KM3Package.CLASS__SUPERTYPES:
				getSupertypes().clear();
				getSupertypes().addAll((Collection<? extends org.eclipse.gmt.am3.dsls.KM3.Class>)newValue);
				return;
			case KM3Package.CLASS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				getStructuralFeatures().addAll((Collection<? extends StructuralFeature>)newValue);
				return;
			case KM3Package.CLASS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Operation>)newValue);
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
			case KM3Package.CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case KM3Package.CLASS__SUPERTYPES:
				getSupertypes().clear();
				return;
			case KM3Package.CLASS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				return;
			case KM3Package.CLASS__OPERATIONS:
				getOperations().clear();
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
			case KM3Package.CLASS__IS_ABSTRACT:
				return IS_ABSTRACT_EDEFAULT == null ? isAbstract != null : !IS_ABSTRACT_EDEFAULT.equals(isAbstract);
			case KM3Package.CLASS__SUPERTYPES:
				return supertypes != null && !supertypes.isEmpty();
			case KM3Package.CLASS__STRUCTURAL_FEATURES:
				return structuralFeatures != null && !structuralFeatures.isEmpty();
			case KM3Package.CLASS__OPERATIONS:
				return operations != null && !operations.isEmpty();
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
		result.append(" (isAbstract: ");
		result.append(isAbstract);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
