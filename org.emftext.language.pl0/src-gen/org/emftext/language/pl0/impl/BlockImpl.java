/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.emftext.language.pl0.Block;
import org.emftext.language.pl0.BlockOwner;
import org.emftext.language.pl0.Body;
import org.emftext.language.pl0.ConstDeclaration;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.ProcedureDeclaration;
import org.emftext.language.pl0.Program;
import org.emftext.language.pl0.VarDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.impl.BlockImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.BlockImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.BlockImpl#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.BlockImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.BlockImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.emftext.language.pl0.impl.BlockImpl#getAllOwners <em>All Owners</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockImpl extends EObjectImpl implements Block {
	/**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
	protected EList<VarDeclaration> variables;

	/**
   * The cached value of the '{@link #getConstants() <em>Constants</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getConstants()
   * @generated
   * @ordered
   */
	protected EList<ConstDeclaration> constants;

	/**
   * The cached value of the '{@link #getProcedures() <em>Procedures</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getProcedures()
   * @generated
   * @ordered
   */
	protected EList<ProcedureDeclaration> procedures;

	/**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
	protected Body body;

	/**
   * The cached value of the '{@link #getAllOwners() <em>All Owners</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getAllOwners()
   * @generated
   * @ordered
   */
	protected EList<BlockOwner> allOwners;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected BlockImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return PL0Package.Literals.BLOCK;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<VarDeclaration> getVariables() {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<VarDeclaration>(VarDeclaration.class, this, PL0Package.BLOCK__VARIABLES);
    }
    return variables;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<ConstDeclaration> getConstants() {
    if (constants == null)
    {
      constants = new EObjectContainmentEList<ConstDeclaration>(ConstDeclaration.class, this, PL0Package.BLOCK__CONSTANTS);
    }
    return constants;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<ProcedureDeclaration> getProcedures() {
    if (procedures == null)
    {
      procedures = new EObjectContainmentEList<ProcedureDeclaration>(ProcedureDeclaration.class, this, PL0Package.BLOCK__PROCEDURES);
    }
    return procedures;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Body getBody() {
    return body;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetBody(Body newBody, NotificationChain msgs) {
    Body oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PL0Package.BLOCK__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setBody(Body newBody) {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PL0Package.BLOCK__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PL0Package.BLOCK__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PL0Package.BLOCK__BODY, newBody, newBody));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public BlockOwner getOwner() {
    if (eContainerFeatureID() != PL0Package.BLOCK__OWNER) return null;
    return (BlockOwner)eContainer();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetOwner(BlockOwner newOwner, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newOwner, PL0Package.BLOCK__OWNER, msgs);
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setOwner(BlockOwner newOwner) {
    if (newOwner != eInternalContainer() || (eContainerFeatureID() != PL0Package.BLOCK__OWNER && newOwner != null))
    {
      if (EcoreUtil.isAncestor(this, newOwner))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newOwner != null)
        msgs = ((InternalEObject)newOwner).eInverseAdd(this, PL0Package.BLOCK_OWNER__BLOCK, BlockOwner.class, msgs);
      msgs = basicSetOwner(newOwner, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PL0Package.BLOCK__OWNER, newOwner, newOwner));
  }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<BlockOwner> getAllOwners() {
		List<BlockOwner> owners = new LinkedList<BlockOwner>();
		BlockOwner owner = getOwner();
		owners.add(owner);
		while (!(owner instanceof Program)) {
			ProcedureDeclaration parent = (ProcedureDeclaration) owner;
			Block tempOwner = (Block) parent.eContainer();
			owner = tempOwner.getOwner();
			owners.add(owner);
		}
		return new BasicEList.UnmodifiableEList<BlockOwner>(owners.size(), owners.toArray(new BlockOwner[0]));
//		if (allOwners == null) {
//			allOwners = new EObjectResolvingEList<BlockOwner>(BlockOwner.class, this, PL0Package.BLOCK__ALL_OWNERS);
//		}
//		return allOwners;
	}

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case PL0Package.BLOCK__OWNER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetOwner((BlockOwner)otherEnd, msgs);
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
    switch (featureID)
    {
      case PL0Package.BLOCK__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case PL0Package.BLOCK__CONSTANTS:
        return ((InternalEList<?>)getConstants()).basicRemove(otherEnd, msgs);
      case PL0Package.BLOCK__PROCEDURES:
        return ((InternalEList<?>)getProcedures()).basicRemove(otherEnd, msgs);
      case PL0Package.BLOCK__BODY:
        return basicSetBody(null, msgs);
      case PL0Package.BLOCK__OWNER:
        return basicSetOwner(null, msgs);
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
    switch (eContainerFeatureID())
    {
      case PL0Package.BLOCK__OWNER:
        return eInternalContainer().eInverseRemove(this, PL0Package.BLOCK_OWNER__BLOCK, BlockOwner.class, msgs);
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
    switch (featureID)
    {
      case PL0Package.BLOCK__VARIABLES:
        return getVariables();
      case PL0Package.BLOCK__CONSTANTS:
        return getConstants();
      case PL0Package.BLOCK__PROCEDURES:
        return getProcedures();
      case PL0Package.BLOCK__BODY:
        return getBody();
      case PL0Package.BLOCK__OWNER:
        return getOwner();
      case PL0Package.BLOCK__ALL_OWNERS:
        return getAllOwners();
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
      case PL0Package.BLOCK__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends VarDeclaration>)newValue);
        return;
      case PL0Package.BLOCK__CONSTANTS:
        getConstants().clear();
        getConstants().addAll((Collection<? extends ConstDeclaration>)newValue);
        return;
      case PL0Package.BLOCK__PROCEDURES:
        getProcedures().clear();
        getProcedures().addAll((Collection<? extends ProcedureDeclaration>)newValue);
        return;
      case PL0Package.BLOCK__BODY:
        setBody((Body)newValue);
        return;
      case PL0Package.BLOCK__OWNER:
        setOwner((BlockOwner)newValue);
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
      case PL0Package.BLOCK__VARIABLES:
        getVariables().clear();
        return;
      case PL0Package.BLOCK__CONSTANTS:
        getConstants().clear();
        return;
      case PL0Package.BLOCK__PROCEDURES:
        getProcedures().clear();
        return;
      case PL0Package.BLOCK__BODY:
        setBody((Body)null);
        return;
      case PL0Package.BLOCK__OWNER:
        setOwner((BlockOwner)null);
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
      case PL0Package.BLOCK__VARIABLES:
        return variables != null && !variables.isEmpty();
      case PL0Package.BLOCK__CONSTANTS:
        return constants != null && !constants.isEmpty();
      case PL0Package.BLOCK__PROCEDURES:
        return procedures != null && !procedures.isEmpty();
      case PL0Package.BLOCK__BODY:
        return body != null;
      case PL0Package.BLOCK__OWNER:
        return getOwner() != null;
      case PL0Package.BLOCK__ALL_OWNERS:
        return allOwners != null && !allOwners.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BlockImpl
