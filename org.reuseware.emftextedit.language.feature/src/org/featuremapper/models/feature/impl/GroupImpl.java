/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.featuremapper.models.feature.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeaturePackage;
import org.featuremapper.models.feature.Group;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.featuremapper.models.feature.impl.GroupImpl#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.GroupImpl#getMaxCardinality <em>Max Cardinality</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.GroupImpl#getParentFeature <em>Parent Feature</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.GroupImpl#getChildFeatures <em>Child Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends EObjectImpl implements Group
{
  /**
   * The default value of the '{@link #getMinCardinality() <em>Min Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinCardinality()
   * @generated
   * @ordered
   */
  protected static final int MIN_CARDINALITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMinCardinality() <em>Min Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMinCardinality()
   * @generated
   * @ordered
   */
  protected int minCardinality = MIN_CARDINALITY_EDEFAULT;

  /**
   * The default value of the '{@link #getMaxCardinality() <em>Max Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxCardinality()
   * @generated
   * @ordered
   */
  protected static final int MAX_CARDINALITY_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMaxCardinality() <em>Max Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxCardinality()
   * @generated
   * @ordered
   */
  protected int maxCardinality = MAX_CARDINALITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getChildFeatures() <em>Child Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getChildFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> childFeatures;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GroupImpl()
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
    return FeaturePackage.Literals.GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMinCardinality()
  {
    return minCardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMinCardinality(int newMinCardinality)
  {
    int oldMinCardinality = minCardinality;
    minCardinality = newMinCardinality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.GROUP__MIN_CARDINALITY, oldMinCardinality, minCardinality));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMaxCardinality()
  {
    return maxCardinality;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxCardinality(int newMaxCardinality)
  {
    int oldMaxCardinality = maxCardinality;
    maxCardinality = newMaxCardinality;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.GROUP__MAX_CARDINALITY, oldMaxCardinality, maxCardinality));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature getParentFeature()
  {
    if (eContainerFeatureID != FeaturePackage.GROUP__PARENT_FEATURE) return null;
    return (Feature)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParentFeature(Feature newParentFeature, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParentFeature, FeaturePackage.GROUP__PARENT_FEATURE, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentFeature(Feature newParentFeature)
  {
    if (newParentFeature != eInternalContainer() || (eContainerFeatureID != FeaturePackage.GROUP__PARENT_FEATURE && newParentFeature != null))
    {
      if (EcoreUtil.isAncestor(this, newParentFeature))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParentFeature != null)
        msgs = ((InternalEObject)newParentFeature).eInverseAdd(this, FeaturePackage.FEATURE__GROUPS, Feature.class, msgs);
      msgs = basicSetParentFeature(newParentFeature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.GROUP__PARENT_FEATURE, newParentFeature, newParentFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getChildFeatures()
  {
    if (childFeatures == null)
    {
      childFeatures = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, FeaturePackage.GROUP__CHILD_FEATURES, FeaturePackage.FEATURE__PARENT_GROUP);
    }
    return childFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case FeaturePackage.GROUP__PARENT_FEATURE:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParentFeature((Feature)otherEnd, msgs);
      case FeaturePackage.GROUP__CHILD_FEATURES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildFeatures()).basicAdd(otherEnd, msgs);
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
      case FeaturePackage.GROUP__PARENT_FEATURE:
        return basicSetParentFeature(null, msgs);
      case FeaturePackage.GROUP__CHILD_FEATURES:
        return ((InternalEList<?>)getChildFeatures()).basicRemove(otherEnd, msgs);
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
    switch (eContainerFeatureID)
    {
      case FeaturePackage.GROUP__PARENT_FEATURE:
        return eInternalContainer().eInverseRemove(this, FeaturePackage.FEATURE__GROUPS, Feature.class, msgs);
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
      case FeaturePackage.GROUP__MIN_CARDINALITY:
        return new Integer(getMinCardinality());
      case FeaturePackage.GROUP__MAX_CARDINALITY:
        return new Integer(getMaxCardinality());
      case FeaturePackage.GROUP__PARENT_FEATURE:
        return getParentFeature();
      case FeaturePackage.GROUP__CHILD_FEATURES:
        return getChildFeatures();
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
      case FeaturePackage.GROUP__MIN_CARDINALITY:
        setMinCardinality(((Integer)newValue).intValue());
        return;
      case FeaturePackage.GROUP__MAX_CARDINALITY:
        setMaxCardinality(((Integer)newValue).intValue());
        return;
      case FeaturePackage.GROUP__PARENT_FEATURE:
        setParentFeature((Feature)newValue);
        return;
      case FeaturePackage.GROUP__CHILD_FEATURES:
        getChildFeatures().clear();
        getChildFeatures().addAll((Collection<? extends Feature>)newValue);
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
      case FeaturePackage.GROUP__MIN_CARDINALITY:
        setMinCardinality(MIN_CARDINALITY_EDEFAULT);
        return;
      case FeaturePackage.GROUP__MAX_CARDINALITY:
        setMaxCardinality(MAX_CARDINALITY_EDEFAULT);
        return;
      case FeaturePackage.GROUP__PARENT_FEATURE:
        setParentFeature((Feature)null);
        return;
      case FeaturePackage.GROUP__CHILD_FEATURES:
        getChildFeatures().clear();
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
      case FeaturePackage.GROUP__MIN_CARDINALITY:
        return minCardinality != MIN_CARDINALITY_EDEFAULT;
      case FeaturePackage.GROUP__MAX_CARDINALITY:
        return maxCardinality != MAX_CARDINALITY_EDEFAULT;
      case FeaturePackage.GROUP__PARENT_FEATURE:
        return getParentFeature() != null;
      case FeaturePackage.GROUP__CHILD_FEATURES:
        return childFeatures != null && !childFeatures.isEmpty();
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
    result.append(" (minCardinality: ");
    result.append(minCardinality);
    result.append(", maxCardinality: ");
    result.append(maxCardinality);
    result.append(')');
    return result.toString();
  }

} //GroupImpl
