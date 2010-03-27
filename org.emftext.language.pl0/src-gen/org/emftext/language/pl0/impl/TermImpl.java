/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.pl0.Factor;
import org.emftext.language.pl0.OptionalFactor;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.Term;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.impl.TermImpl#getObligatory <em>Obligatory</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.TermImpl#getOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermImpl extends EObjectImpl implements Term {
	/**
   * The cached value of the '{@link #getObligatory() <em>Obligatory</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getObligatory()
   * @generated
   * @ordered
   */
	protected Factor obligatory;

	/**
   * The cached value of the '{@link #getOptional() <em>Optional</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOptional()
   * @generated
   * @ordered
   */
	protected EList<OptionalFactor> optional;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TermImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PL0Package.Literals.TERM;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Factor getObligatory() {
    return obligatory;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetObligatory(Factor newObligatory, NotificationChain msgs) {
    Factor oldObligatory = obligatory;
    obligatory = newObligatory;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PL0Package.TERM__OBLIGATORY, oldObligatory, newObligatory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setObligatory(Factor newObligatory) {
    if (newObligatory != obligatory)
    {
      NotificationChain msgs = null;
      if (obligatory != null)
        msgs = ((InternalEObject)obligatory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PL0Package.TERM__OBLIGATORY, null, msgs);
      if (newObligatory != null)
        msgs = ((InternalEObject)newObligatory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PL0Package.TERM__OBLIGATORY, null, msgs);
      msgs = basicSetObligatory(newObligatory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PL0Package.TERM__OBLIGATORY, newObligatory, newObligatory));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<OptionalFactor> getOptional() {
    if (optional == null)
    {
      optional = new EObjectContainmentEList<OptionalFactor>(OptionalFactor.class, this, PL0Package.TERM__OPTIONAL);
    }
    return optional;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case PL0Package.TERM__OBLIGATORY:
        return basicSetObligatory(null, msgs);
      case PL0Package.TERM__OPTIONAL:
        return ((InternalEList<?>)getOptional()).basicRemove(otherEnd, msgs);
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
    switch (featureID)
    {
      case PL0Package.TERM__OBLIGATORY:
        return getObligatory();
      case PL0Package.TERM__OPTIONAL:
        return getOptional();
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
    switch (featureID)
    {
      case PL0Package.TERM__OBLIGATORY:
        setObligatory((Factor)newValue);
        return;
      case PL0Package.TERM__OPTIONAL:
        getOptional().clear();
        getOptional().addAll((Collection<? extends OptionalFactor>)newValue);
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
    switch (featureID)
    {
      case PL0Package.TERM__OBLIGATORY:
        setObligatory((Factor)null);
        return;
      case PL0Package.TERM__OPTIONAL:
        getOptional().clear();
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
    switch (featureID)
    {
      case PL0Package.TERM__OBLIGATORY:
        return obligatory != null;
      case PL0Package.TERM__OPTIONAL:
        return optional != null && !optional.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TermImpl
