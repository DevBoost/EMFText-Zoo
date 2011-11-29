/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.notes.BulletPoint;
import org.emftext.language.notes.NotesPackage;
import org.emftext.language.notes.TextPart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bullet Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.notes.impl.BulletPointImpl#getTextParts <em>Text Parts</em>}</li>
 *   <li>{@link org.emftext.language.notes.impl.BulletPointImpl#getSubPoints <em>Sub Points</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BulletPointImpl extends PartImpl implements BulletPoint {
	/**
	 * The cached value of the '{@link #getTextParts() <em>Text Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextParts()
	 * @generated
	 * @ordered
	 */
	protected EList<TextPart> textParts;

	/**
	 * The cached value of the '{@link #getSubPoints() <em>Sub Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<BulletPoint> subPoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BulletPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NotesPackage.Literals.BULLET_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TextPart> getTextParts() {
		if (textParts == null) {
			textParts = new EObjectContainmentEList<TextPart>(TextPart.class, this, NotesPackage.BULLET_POINT__TEXT_PARTS);
		}
		return textParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BulletPoint> getSubPoints() {
		if (subPoints == null) {
			subPoints = new EObjectContainmentEList<BulletPoint>(BulletPoint.class, this, NotesPackage.BULLET_POINT__SUB_POINTS);
		}
		return subPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NotesPackage.BULLET_POINT__TEXT_PARTS:
				return ((InternalEList<?>)getTextParts()).basicRemove(otherEnd, msgs);
			case NotesPackage.BULLET_POINT__SUB_POINTS:
				return ((InternalEList<?>)getSubPoints()).basicRemove(otherEnd, msgs);
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
			case NotesPackage.BULLET_POINT__TEXT_PARTS:
				return getTextParts();
			case NotesPackage.BULLET_POINT__SUB_POINTS:
				return getSubPoints();
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
			case NotesPackage.BULLET_POINT__TEXT_PARTS:
				getTextParts().clear();
				getTextParts().addAll((Collection<? extends TextPart>)newValue);
				return;
			case NotesPackage.BULLET_POINT__SUB_POINTS:
				getSubPoints().clear();
				getSubPoints().addAll((Collection<? extends BulletPoint>)newValue);
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
			case NotesPackage.BULLET_POINT__TEXT_PARTS:
				getTextParts().clear();
				return;
			case NotesPackage.BULLET_POINT__SUB_POINTS:
				getSubPoints().clear();
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
			case NotesPackage.BULLET_POINT__TEXT_PARTS:
				return textParts != null && !textParts.isEmpty();
			case NotesPackage.BULLET_POINT__SUB_POINTS:
				return subPoints != null && !subPoints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BulletPointImpl
