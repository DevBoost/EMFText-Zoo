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
import parametercheck.Method;
import parametercheck.ParameterUsage;
import parametercheck.ParametercheckPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link parametercheck.impl.CheckImpl#getName <em>Name</em>}</li>
 *   <li>{@link parametercheck.impl.CheckImpl#getParameterusage <em>Parameterusage</em>}</li>
 *   <li>{@link parametercheck.impl.CheckImpl#getException <em>Exception</em>}</li>
 *   <li>{@link parametercheck.impl.CheckImpl#isExceptionIfTrue <em>Exception If True</em>}</li>
 *   <li>{@link parametercheck.impl.CheckImpl#getParentmethod <em>Parentmethod</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckImpl extends EObjectImpl implements Check
{
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
   * The cached value of the '{@link #getException() <em>Exception</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getException()
   * @generated
   * @ordered
   */
  protected parametercheck.Exception exception;

  /**
   * The default value of the '{@link #isExceptionIfTrue() <em>Exception If True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExceptionIfTrue()
   * @generated
   * @ordered
   */
  protected static final boolean EXCEPTION_IF_TRUE_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isExceptionIfTrue() <em>Exception If True</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExceptionIfTrue()
   * @generated
   * @ordered
   */
  protected boolean exceptionIfTrue = EXCEPTION_IF_TRUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CheckImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ParametercheckPackage.Literals.CHECK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.CHECK__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterUsage> getParameterusage()
  {
    if (parameterusage == null)
    {
      parameterusage = new EObjectContainmentEList<ParameterUsage>(ParameterUsage.class, this, ParametercheckPackage.CHECK__PARAMETERUSAGE);
    }
    return parameterusage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public parametercheck.Exception getException()
  {
    return exception;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetException(parametercheck.Exception newException, NotificationChain msgs)
  {
    parametercheck.Exception oldException = exception;
    exception = newException;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParametercheckPackage.CHECK__EXCEPTION, oldException, newException);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setException(parametercheck.Exception newException)
  {
    if (newException != exception)
    {
      NotificationChain msgs = null;
      if (exception != null)
        msgs = ((InternalEObject)exception).eInverseRemove(this, ParametercheckPackage.EXCEPTION__PARENTCHECK, parametercheck.Exception.class, msgs);
      if (newException != null)
        msgs = ((InternalEObject)newException).eInverseAdd(this, ParametercheckPackage.EXCEPTION__PARENTCHECK, parametercheck.Exception.class, msgs);
      msgs = basicSetException(newException, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.CHECK__EXCEPTION, newException, newException));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExceptionIfTrue()
  {
    return exceptionIfTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceptionIfTrue(boolean newExceptionIfTrue)
  {
    boolean oldExceptionIfTrue = exceptionIfTrue;
    exceptionIfTrue = newExceptionIfTrue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.CHECK__EXCEPTION_IF_TRUE, oldExceptionIfTrue, exceptionIfTrue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Method getParentmethod()
  {
    if (eContainerFeatureID() != ParametercheckPackage.CHECK__PARENTMETHOD) return null;
    return (Method)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParentmethod(Method newParentmethod, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParentmethod, ParametercheckPackage.CHECK__PARENTMETHOD, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentmethod(Method newParentmethod)
  {
    if (newParentmethod != eInternalContainer() || (eContainerFeatureID() != ParametercheckPackage.CHECK__PARENTMETHOD && newParentmethod != null))
    {
      if (EcoreUtil.isAncestor(this, newParentmethod))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParentmethod != null)
        msgs = ((InternalEObject)newParentmethod).eInverseAdd(this, ParametercheckPackage.METHOD__CHECK, Method.class, msgs);
      msgs = basicSetParentmethod(newParentmethod, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ParametercheckPackage.CHECK__PARENTMETHOD, newParentmethod, newParentmethod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ParametercheckPackage.CHECK__EXCEPTION:
        if (exception != null)
          msgs = ((InternalEObject)exception).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParametercheckPackage.CHECK__EXCEPTION, null, msgs);
        return basicSetException((parametercheck.Exception)otherEnd, msgs);
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParentmethod((Method)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ParametercheckPackage.CHECK__PARAMETERUSAGE:
        return ((InternalEList<?>)getParameterusage()).basicRemove(otherEnd, msgs);
      case ParametercheckPackage.CHECK__EXCEPTION:
        return basicSetException(null, msgs);
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        return basicSetParentmethod(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        return eInternalContainer().eInverseRemove(this, ParametercheckPackage.METHOD__CHECK, Method.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ParametercheckPackage.CHECK__NAME:
        return getName();
      case ParametercheckPackage.CHECK__PARAMETERUSAGE:
        return getParameterusage();
      case ParametercheckPackage.CHECK__EXCEPTION:
        return getException();
      case ParametercheckPackage.CHECK__EXCEPTION_IF_TRUE:
        return isExceptionIfTrue();
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        return getParentmethod();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ParametercheckPackage.CHECK__NAME:
        setName((String)newValue);
        return;
      case ParametercheckPackage.CHECK__PARAMETERUSAGE:
        getParameterusage().clear();
        getParameterusage().addAll((Collection<? extends ParameterUsage>)newValue);
        return;
      case ParametercheckPackage.CHECK__EXCEPTION:
        setException((parametercheck.Exception)newValue);
        return;
      case ParametercheckPackage.CHECK__EXCEPTION_IF_TRUE:
        setExceptionIfTrue((Boolean)newValue);
        return;
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        setParentmethod((Method)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ParametercheckPackage.CHECK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ParametercheckPackage.CHECK__PARAMETERUSAGE:
        getParameterusage().clear();
        return;
      case ParametercheckPackage.CHECK__EXCEPTION:
        setException((parametercheck.Exception)null);
        return;
      case ParametercheckPackage.CHECK__EXCEPTION_IF_TRUE:
        setExceptionIfTrue(EXCEPTION_IF_TRUE_EDEFAULT);
        return;
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        setParentmethod((Method)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ParametercheckPackage.CHECK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ParametercheckPackage.CHECK__PARAMETERUSAGE:
        return parameterusage != null && !parameterusage.isEmpty();
      case ParametercheckPackage.CHECK__EXCEPTION:
        return exception != null;
      case ParametercheckPackage.CHECK__EXCEPTION_IF_TRUE:
        return exceptionIfTrue != EXCEPTION_IF_TRUE_EDEFAULT;
      case ParametercheckPackage.CHECK__PARENTMETHOD:
        return getParentmethod() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", exceptionIfTrue: ");
    result.append(exceptionIfTrue);
    result.append(')');
    return result.toString();
  }

} //CheckImpl
