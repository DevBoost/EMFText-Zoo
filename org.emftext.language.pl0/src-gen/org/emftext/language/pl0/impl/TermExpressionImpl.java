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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.pl0.OptionalTerm;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.PlusMinusOperator;
import org.emftext.language.pl0.Term;
import org.emftext.language.pl0.TermExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.impl.TermExpressionImpl#getObligatory <em>Obligatory</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.TermExpressionImpl#getOptional <em>Optional</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.TermExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermExpressionImpl extends ExpressionImpl implements TermExpression {
	/**
   * The cached value of the '{@link #getObligatory() <em>Obligatory</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getObligatory()
   * @generated
   * @ordered
   */
	protected Term obligatory;

	/**
   * The cached value of the '{@link #getOptional() <em>Optional</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOptional()
   * @generated
   * @ordered
   */
	protected EList<OptionalTerm> optional;

	/**
   * The default value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
	protected static final PlusMinusOperator OP_EDEFAULT = PlusMinusOperator.PLUS;

	/**
   * The cached value of the '{@link #getOp() <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getOp()
   * @generated
   * @ordered
   */
	protected PlusMinusOperator op = OP_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TermExpressionImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PL0Package.Literals.TERM_EXPRESSION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Term getObligatory() {
    return obligatory;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetObligatory(Term newObligatory, NotificationChain msgs) {
    Term oldObligatory = obligatory;
    obligatory = newObligatory;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PL0Package.TERM_EXPRESSION__OBLIGATORY, oldObligatory, newObligatory);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setObligatory(Term newObligatory) {
    if (newObligatory != obligatory)
    {
      NotificationChain msgs = null;
      if (obligatory != null)
        msgs = ((InternalEObject)obligatory).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PL0Package.TERM_EXPRESSION__OBLIGATORY, null, msgs);
      if (newObligatory != null)
        msgs = ((InternalEObject)newObligatory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PL0Package.TERM_EXPRESSION__OBLIGATORY, null, msgs);
      msgs = basicSetObligatory(newObligatory, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PL0Package.TERM_EXPRESSION__OBLIGATORY, newObligatory, newObligatory));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<OptionalTerm> getOptional() {
    if (optional == null)
    {
      optional = new EObjectContainmentEList<OptionalTerm>(OptionalTerm.class, this, PL0Package.TERM_EXPRESSION__OPTIONAL);
    }
    return optional;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public PlusMinusOperator getOp() {
    return op;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOp(PlusMinusOperator newOp) {
    PlusMinusOperator oldOp = op;
    op = newOp == null ? OP_EDEFAULT : newOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PL0Package.TERM_EXPRESSION__OP, oldOp, op));
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
      case PL0Package.TERM_EXPRESSION__OBLIGATORY:
        return basicSetObligatory(null, msgs);
      case PL0Package.TERM_EXPRESSION__OPTIONAL:
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
      case PL0Package.TERM_EXPRESSION__OBLIGATORY:
        return getObligatory();
      case PL0Package.TERM_EXPRESSION__OPTIONAL:
        return getOptional();
      case PL0Package.TERM_EXPRESSION__OP:
        return getOp();
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
      case PL0Package.TERM_EXPRESSION__OBLIGATORY:
        setObligatory((Term)newValue);
        return;
      case PL0Package.TERM_EXPRESSION__OPTIONAL:
        getOptional().clear();
        getOptional().addAll((Collection<? extends OptionalTerm>)newValue);
        return;
      case PL0Package.TERM_EXPRESSION__OP:
        setOp((PlusMinusOperator)newValue);
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
      case PL0Package.TERM_EXPRESSION__OBLIGATORY:
        setObligatory((Term)null);
        return;
      case PL0Package.TERM_EXPRESSION__OPTIONAL:
        getOptional().clear();
        return;
      case PL0Package.TERM_EXPRESSION__OP:
        setOp(OP_EDEFAULT);
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
      case PL0Package.TERM_EXPRESSION__OBLIGATORY:
        return obligatory != null;
      case PL0Package.TERM_EXPRESSION__OPTIONAL:
        return optional != null && !optional.isEmpty();
      case PL0Package.TERM_EXPRESSION__OP:
        return op != OP_EDEFAULT;
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
    result.append(" (op: ");
    result.append(op);
    result.append(')');
    return result.toString();
  }

} //TermExpressionImpl
