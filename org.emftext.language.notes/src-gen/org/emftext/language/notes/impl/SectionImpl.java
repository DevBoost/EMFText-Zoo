/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.notes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.notes.BulletPoint;
import org.emftext.language.notes.Namedelement;
import org.emftext.language.notes.NotesPackage;
import org.emftext.language.notes.Section;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.notes.impl.SectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.notes.impl.SectionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.emftext.language.notes.impl.SectionImpl#getSuperSection <em>Super Section</em>}</li>
 *   <li>{@link org.emftext.language.notes.impl.SectionImpl#getBullets <em>Bullets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SectionImpl extends PartImpl implements Section {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuperSection() <em>Super Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperSection()
	 * @generated
	 * @ordered
	 */
	protected Section superSection;

	/**
	 * The cached value of the '{@link #getBullets() <em>Bullets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBullets()
	 * @generated
	 * @ordered
	 */
	protected EList<BulletPoint> bullets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NotesPackage.Literals.SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotesPackage.SECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotesPackage.SECTION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section getSuperSection() {
		if (superSection != null && superSection.eIsProxy()) {
			InternalEObject oldSuperSection = (InternalEObject)superSection;
			superSection = (Section)eResolveProxy(oldSuperSection);
			if (superSection != oldSuperSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NotesPackage.SECTION__SUPER_SECTION, oldSuperSection, superSection));
			}
		}
		return superSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section basicGetSuperSection() {
		return superSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperSection(Section newSuperSection) {
		Section oldSuperSection = superSection;
		superSection = newSuperSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotesPackage.SECTION__SUPER_SECTION, oldSuperSection, superSection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BulletPoint> getBullets() {
		if (bullets == null) {
			bullets = new EObjectContainmentEList<BulletPoint>(BulletPoint.class, this, NotesPackage.SECTION__BULLETS);
		}
		return bullets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NotesPackage.SECTION__BULLETS:
				return ((InternalEList<?>)getBullets()).basicRemove(otherEnd, msgs);
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
			case NotesPackage.SECTION__NAME:
				return getName();
			case NotesPackage.SECTION__ID:
				return getId();
			case NotesPackage.SECTION__SUPER_SECTION:
				if (resolve) return getSuperSection();
				return basicGetSuperSection();
			case NotesPackage.SECTION__BULLETS:
				return getBullets();
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
			case NotesPackage.SECTION__NAME:
				setName((String)newValue);
				return;
			case NotesPackage.SECTION__ID:
				setId((String)newValue);
				return;
			case NotesPackage.SECTION__SUPER_SECTION:
				setSuperSection((Section)newValue);
				return;
			case NotesPackage.SECTION__BULLETS:
				getBullets().clear();
				getBullets().addAll((Collection<? extends BulletPoint>)newValue);
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
			case NotesPackage.SECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NotesPackage.SECTION__ID:
				setId(ID_EDEFAULT);
				return;
			case NotesPackage.SECTION__SUPER_SECTION:
				setSuperSection((Section)null);
				return;
			case NotesPackage.SECTION__BULLETS:
				getBullets().clear();
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
			case NotesPackage.SECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NotesPackage.SECTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NotesPackage.SECTION__SUPER_SECTION:
				return superSection != null;
			case NotesPackage.SECTION__BULLETS:
				return bullets != null && !bullets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Namedelement.class) {
			switch (derivedFeatureID) {
				case NotesPackage.SECTION__NAME: return NotesPackage.NAMEDELEMENT__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Namedelement.class) {
			switch (baseFeatureID) {
				case NotesPackage.NAMEDELEMENT__NAME: return NotesPackage.SECTION__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //SectionImpl
