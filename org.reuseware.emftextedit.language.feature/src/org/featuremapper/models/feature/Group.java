/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.featuremapper.models.feature;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.featuremapper.models.feature.Group#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.Group#getMaxCardinality <em>Max Cardinality</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.Group#getParentFeature <em>Parent Feature</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.Group#getChildFeatures <em>Child Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.featuremapper.models.feature.FeaturePackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends EObject
{
  /**
   * Returns the value of the '<em><b>Min Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min Cardinality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min Cardinality</em>' attribute.
   * @see #setMinCardinality(int)
   * @see org.featuremapper.models.feature.FeaturePackage#getGroup_MinCardinality()
   * @model required="true"
   * @generated
   */
  int getMinCardinality();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.Group#getMinCardinality <em>Min Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min Cardinality</em>' attribute.
   * @see #getMinCardinality()
   * @generated
   */
  void setMinCardinality(int value);

  /**
   * Returns the value of the '<em><b>Max Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Cardinality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Cardinality</em>' attribute.
   * @see #setMaxCardinality(int)
   * @see org.featuremapper.models.feature.FeaturePackage#getGroup_MaxCardinality()
   * @model required="true"
   * @generated
   */
  int getMaxCardinality();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.Group#getMaxCardinality <em>Max Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Cardinality</em>' attribute.
   * @see #getMaxCardinality()
   * @generated
   */
  void setMaxCardinality(int value);

  /**
   * Returns the value of the '<em><b>Parent Feature</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.featuremapper.models.feature.Feature#getGroups <em>Groups</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Feature</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent Feature</em>' container reference.
   * @see #setParentFeature(Feature)
   * @see org.featuremapper.models.feature.FeaturePackage#getGroup_ParentFeature()
   * @see org.featuremapper.models.feature.Feature#getGroups
   * @model opposite="groups" required="true" transient="false"
   * @generated
   */
  Feature getParentFeature();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.Group#getParentFeature <em>Parent Feature</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent Feature</em>' container reference.
   * @see #getParentFeature()
   * @generated
   */
  void setParentFeature(Feature value);

  /**
   * Returns the value of the '<em><b>Child Features</b></em>' containment reference list.
   * The list contents are of type {@link org.featuremapper.models.feature.Feature}.
   * It is bidirectional and its opposite is '{@link org.featuremapper.models.feature.Feature#getParentGroup <em>Parent Group</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child Features</em>' containment reference list.
   * @see org.featuremapper.models.feature.FeaturePackage#getGroup_ChildFeatures()
   * @see org.featuremapper.models.feature.Feature#getParentGroup
   * @model opposite="parentGroup" containment="true" required="true"
   * @generated
   */
  EList<Feature> getChildFeatures();

} // Group
