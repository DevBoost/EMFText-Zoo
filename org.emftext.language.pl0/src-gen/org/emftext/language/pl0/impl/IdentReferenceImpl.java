/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.language.pl0.Declaration;
import org.emftext.language.pl0.IdentReference;
import org.emftext.language.pl0.PL0Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ident Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.impl.IdentReferenceImpl#getIdent <em>Ident</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentReferenceImpl extends FactorImpl implements IdentReference {
	/**
   * The cached value of the '{@link #getIdent() <em>Ident</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIdent()
   * @generated
   * @ordered
   */
	protected Declaration ident;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected IdentReferenceImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PL0Package.Literals.IDENT_REFERENCE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Declaration getIdent() {
    if (ident != null && ident.eIsProxy())
    {
      InternalEObject oldIdent = (InternalEObject)ident;
      ident = (Declaration)eResolveProxy(oldIdent);
      if (ident != oldIdent)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PL0Package.IDENT_REFERENCE__IDENT, oldIdent, ident));
      }
    }
    return ident;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Declaration basicGetIdent() {
    return ident;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setIdent(Declaration newIdent) {
    Declaration oldIdent = ident;
    ident = newIdent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PL0Package.IDENT_REFERENCE__IDENT, oldIdent, ident));
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
      case PL0Package.IDENT_REFERENCE__IDENT:
        if (resolve) return getIdent();
        return basicGetIdent();
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
    switch (featureID)
    {
      case PL0Package.IDENT_REFERENCE__IDENT:
        setIdent((Declaration)newValue);
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
      case PL0Package.IDENT_REFERENCE__IDENT:
        setIdent((Declaration)null);
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
      case PL0Package.IDENT_REFERENCE__IDENT:
        return ident != null;
    }
    return super.eIsSet(featureID);
  }

} //IdentReferenceImpl
