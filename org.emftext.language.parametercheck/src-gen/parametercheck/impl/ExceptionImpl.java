/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import parametercheck.Check;
import parametercheck.ParameterUsage;
import parametercheck.ParametercheckPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exception</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link parametercheck.impl.ExceptionImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link parametercheck.impl.ExceptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link parametercheck.impl.ExceptionImpl#getParameterusage <em>Parameterusage</em>}</li>
 *   <li>{@link parametercheck.impl.ExceptionImpl#getParentcheck <em>Parentcheck</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExceptionImpl extends EObjectImpl implements parametercheck.Exception {
	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

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
	 * The cached value of the '{@link #getParameterusage() <em>Parameterusage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterusage()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterUsage> parameterusage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametercheckPackage.Literals.EXCEPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.EXCEPTION__PACKAGE, oldPackage, package_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.EXCEPTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterUsage> getParameterusage() {
		if (parameterusage == null) {
			parameterusage = new EObjectContainmentEList<ParameterUsage>(ParameterUsage.class, this, ParametercheckPackage.EXCEPTION__PARAMETERUSAGE);
		}
		return parameterusage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check getParentcheck() {
		if (eContainerFeatureID() != ParametercheckPackage.EXCEPTION__PARENTCHECK) return null;
		return (Check)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentcheck(Check newParentcheck, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentcheck, ParametercheckPackage.EXCEPTION__PARENTCHECK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentcheck(Check newParentcheck) {
		if (newParentcheck != eInternalContainer() || (eContainerFeatureID() != ParametercheckPackage.EXCEPTION__PARENTCHECK && newParentcheck != null)) {
			if (EcoreUtil.isAncestor(this, newParentcheck))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentcheck != null)
				msgs = ((InternalEObject)newParentcheck).eInverseAdd(this, ParametercheckPackage.CHECK__EXCEPTION, Check.class, msgs);
			msgs = basicSetParentcheck(newParentcheck, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.EXCEPTION__PARENTCHECK, newParentcheck, newParentcheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentcheck((Check)otherEnd, msgs);
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
			case ParametercheckPackage.EXCEPTION__PARAMETERUSAGE:
				return ((InternalEList<?>)getParameterusage()).basicRemove(otherEnd, msgs);
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				return basicSetParentcheck(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				return eInternalContainer().eInverseRemove(this, ParametercheckPackage.CHECK__EXCEPTION, Check.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParametercheckPackage.EXCEPTION__PACKAGE:
				return getPackage();
			case ParametercheckPackage.EXCEPTION__NAME:
				return getName();
			case ParametercheckPackage.EXCEPTION__PARAMETERUSAGE:
				return getParameterusage();
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				return getParentcheck();
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
			case ParametercheckPackage.EXCEPTION__PACKAGE:
				setPackage((String)newValue);
				return;
			case ParametercheckPackage.EXCEPTION__NAME:
				setName((String)newValue);
				return;
			case ParametercheckPackage.EXCEPTION__PARAMETERUSAGE:
				getParameterusage().clear();
				getParameterusage().addAll((Collection<? extends ParameterUsage>)newValue);
				return;
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				setParentcheck((Check)newValue);
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
			case ParametercheckPackage.EXCEPTION__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case ParametercheckPackage.EXCEPTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ParametercheckPackage.EXCEPTION__PARAMETERUSAGE:
				getParameterusage().clear();
				return;
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				setParentcheck((Check)null);
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
			case ParametercheckPackage.EXCEPTION__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case ParametercheckPackage.EXCEPTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ParametercheckPackage.EXCEPTION__PARAMETERUSAGE:
				return parameterusage != null && !parameterusage.isEmpty();
			case ParametercheckPackage.EXCEPTION__PARENTCHECK:
				return getParentcheck() != null;
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
		result.append(" (package: ");
		result.append(package_);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ExceptionImpl
