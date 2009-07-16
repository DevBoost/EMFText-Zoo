/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package parametercheck.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import parametercheck.DeclaredParameter;
import parametercheck.ParameterDecl;
import parametercheck.ParametercheckPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link parametercheck.impl.DeclaredParameterImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link parametercheck.impl.DeclaredParameterImpl#getAsString <em>As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaredParameterImpl extends ParameterUsageImpl implements DeclaredParameter {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected ParameterDecl parameter;

	/**
	 * The default value of the '{@link #getAsString() <em>As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsString()
	 * @generated
	 * @ordered
	 */
	protected static final String AS_STRING_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getAsString() <em>As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsString()
	 * @generated
	 * @ordered
	 */
	protected String asString = AS_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametercheckPackage.Literals.DECLARED_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDecl getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (ParameterDecl)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParametercheckPackage.DECLARED_PARAMETER__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDecl basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(ParameterDecl newParameter) {
		ParameterDecl oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.DECLARED_PARAMETER__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAsString() {
		return asString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsString(String newAsString) {
		String oldAsString = asString;
		asString = newAsString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.DECLARED_PARAMETER__AS_STRING, oldAsString, asString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParametercheckPackage.DECLARED_PARAMETER__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case ParametercheckPackage.DECLARED_PARAMETER__AS_STRING:
				return getAsString();
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
			case ParametercheckPackage.DECLARED_PARAMETER__PARAMETER:
				setParameter((ParameterDecl)newValue);
				return;
			case ParametercheckPackage.DECLARED_PARAMETER__AS_STRING:
				setAsString((String)newValue);
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
			case ParametercheckPackage.DECLARED_PARAMETER__PARAMETER:
				setParameter((ParameterDecl)null);
				return;
			case ParametercheckPackage.DECLARED_PARAMETER__AS_STRING:
				setAsString(AS_STRING_EDEFAULT);
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
			case ParametercheckPackage.DECLARED_PARAMETER__PARAMETER:
				return parameter != null;
			case ParametercheckPackage.DECLARED_PARAMETER__AS_STRING:
				return AS_STRING_EDEFAULT == null ? asString != null : !AS_STRING_EDEFAULT.equals(asString);
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
		result.append(" (asString: ");
		result.append(asString);
		result.append(')');
		return result.toString();
	}

} //DeclaredParameterImpl
