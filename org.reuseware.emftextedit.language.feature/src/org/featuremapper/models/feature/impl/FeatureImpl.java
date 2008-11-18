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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.featuremapper.models.feature.Annotation;
import org.featuremapper.models.feature.Attribute;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeaturePackage;
import org.featuremapper.models.feature.Group;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getMaxCardinality <em>Max Cardinality</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getParentGroup <em>Parent Group</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.impl.FeatureImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends EObjectImpl implements Feature
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
   * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributes()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributes;

  /**
   * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroups()
   * @generated
   * @ordered
   */
  protected EList<Group> groups;

  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraints()
   * @generated
   * @ordered
   */
  protected EList<Constraint> constraints;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureImpl()
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
    return FeaturePackage.Literals.FEATURE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.FEATURE__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.FEATURE__MIN_CARDINALITY, oldMinCardinality, minCardinality));
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
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.FEATURE__MAX_CARDINALITY, oldMaxCardinality, maxCardinality));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributes()
  {
    if (attributes == null)
    {
      attributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, FeaturePackage.FEATURE__ATTRIBUTES, FeaturePackage.ATTRIBUTE__FEATURE);
    }
    return attributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Group> getGroups()
  {
    if (groups == null)
    {
      groups = new EObjectContainmentWithInverseEList<Group>(Group.class, this, FeaturePackage.FEATURE__GROUPS, FeaturePackage.GROUP__PARENT_FEATURE);
    }
    return groups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Group getParentGroup()
  {
    if (eContainerFeatureID != FeaturePackage.FEATURE__PARENT_GROUP) return null;
    return (Group)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParentGroup(Group newParentGroup, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParentGroup, FeaturePackage.FEATURE__PARENT_GROUP, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentGroup(Group newParentGroup)
  {
    if (newParentGroup != eInternalContainer() || (eContainerFeatureID != FeaturePackage.FEATURE__PARENT_GROUP && newParentGroup != null))
    {
      if (EcoreUtil.isAncestor(this, newParentGroup))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParentGroup != null)
        msgs = ((InternalEObject)newParentGroup).eInverseAdd(this, FeaturePackage.GROUP__CHILD_FEATURES, Group.class, msgs);
      msgs = basicSetParentGroup(newParentGroup, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FeaturePackage.FEATURE__PARENT_GROUP, newParentGroup, newParentGroup));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentWithInverseEList<Annotation>(Annotation.class, this, FeaturePackage.FEATURE__ANNOTATIONS, FeaturePackage.ANNOTATION__FEATURE);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Constraint> getConstraints()
  {
    if (constraints == null)
    {
      constraints = new EObjectWithInverseResolvingEList.ManyInverse<Constraint>(Constraint.class, this, FeaturePackage.FEATURE__CONSTRAINTS, FeaturePackage.CONSTRAINT__CONSTRAINED_FEATURES);
    }
    return constraints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMandatory()
  {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
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
      case FeaturePackage.FEATURE__ATTRIBUTES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
      case FeaturePackage.FEATURE__GROUPS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGroups()).basicAdd(otherEnd, msgs);
      case FeaturePackage.FEATURE__PARENT_GROUP:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParentGroup((Group)otherEnd, msgs);
      case FeaturePackage.FEATURE__ANNOTATIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotations()).basicAdd(otherEnd, msgs);
      case FeaturePackage.FEATURE__CONSTRAINTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
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
      case FeaturePackage.FEATURE__ATTRIBUTES:
        return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
      case FeaturePackage.FEATURE__GROUPS:
        return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
      case FeaturePackage.FEATURE__PARENT_GROUP:
        return basicSetParentGroup(null, msgs);
      case FeaturePackage.FEATURE__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case FeaturePackage.FEATURE__CONSTRAINTS:
        return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
      case FeaturePackage.FEATURE__PARENT_GROUP:
        return eInternalContainer().eInverseRemove(this, FeaturePackage.GROUP__CHILD_FEATURES, Group.class, msgs);
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
      case FeaturePackage.FEATURE__NAME:
        return getName();
      case FeaturePackage.FEATURE__MIN_CARDINALITY:
        return new Integer(getMinCardinality());
      case FeaturePackage.FEATURE__MAX_CARDINALITY:
        return new Integer(getMaxCardinality());
      case FeaturePackage.FEATURE__ATTRIBUTES:
        return getAttributes();
      case FeaturePackage.FEATURE__GROUPS:
        return getGroups();
      case FeaturePackage.FEATURE__PARENT_GROUP:
        return getParentGroup();
      case FeaturePackage.FEATURE__ANNOTATIONS:
        return getAnnotations();
      case FeaturePackage.FEATURE__CONSTRAINTS:
        return getConstraints();
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
      case FeaturePackage.FEATURE__NAME:
        setName((String)newValue);
        return;
      case FeaturePackage.FEATURE__MIN_CARDINALITY:
        setMinCardinality(((Integer)newValue).intValue());
        return;
      case FeaturePackage.FEATURE__MAX_CARDINALITY:
        setMaxCardinality(((Integer)newValue).intValue());
        return;
      case FeaturePackage.FEATURE__ATTRIBUTES:
        getAttributes().clear();
        getAttributes().addAll((Collection<? extends Attribute>)newValue);
        return;
      case FeaturePackage.FEATURE__GROUPS:
        getGroups().clear();
        getGroups().addAll((Collection<? extends Group>)newValue);
        return;
      case FeaturePackage.FEATURE__PARENT_GROUP:
        setParentGroup((Group)newValue);
        return;
      case FeaturePackage.FEATURE__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case FeaturePackage.FEATURE__CONSTRAINTS:
        getConstraints().clear();
        getConstraints().addAll((Collection<? extends Constraint>)newValue);
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
      case FeaturePackage.FEATURE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case FeaturePackage.FEATURE__MIN_CARDINALITY:
        setMinCardinality(MIN_CARDINALITY_EDEFAULT);
        return;
      case FeaturePackage.FEATURE__MAX_CARDINALITY:
        setMaxCardinality(MAX_CARDINALITY_EDEFAULT);
        return;
      case FeaturePackage.FEATURE__ATTRIBUTES:
        getAttributes().clear();
        return;
      case FeaturePackage.FEATURE__GROUPS:
        getGroups().clear();
        return;
      case FeaturePackage.FEATURE__PARENT_GROUP:
        setParentGroup((Group)null);
        return;
      case FeaturePackage.FEATURE__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case FeaturePackage.FEATURE__CONSTRAINTS:
        getConstraints().clear();
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
      case FeaturePackage.FEATURE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case FeaturePackage.FEATURE__MIN_CARDINALITY:
        return minCardinality != MIN_CARDINALITY_EDEFAULT;
      case FeaturePackage.FEATURE__MAX_CARDINALITY:
        return maxCardinality != MAX_CARDINALITY_EDEFAULT;
      case FeaturePackage.FEATURE__ATTRIBUTES:
        return attributes != null && !attributes.isEmpty();
      case FeaturePackage.FEATURE__GROUPS:
        return groups != null && !groups.isEmpty();
      case FeaturePackage.FEATURE__PARENT_GROUP:
        return getParentGroup() != null;
      case FeaturePackage.FEATURE__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case FeaturePackage.FEATURE__CONSTRAINTS:
        return constraints != null && !constraints.isEmpty();
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
    result.append(", minCardinality: ");
    result.append(minCardinality);
    result.append(", maxCardinality: ");
    result.append(maxCardinality);
    result.append(')');
    return result.toString();
  }

} //FeatureImpl
