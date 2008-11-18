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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.featuremapper.models.feature.FeatureModel#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.FeatureModel#getRoot <em>Root</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.FeatureModel#getName <em>Name</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.FeatureModel#getChildren <em>Children</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.FeatureModel#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.featuremapper.models.feature.FeaturePackage#getFeatureModel()
 * @model
 * @generated
 */
public interface FeatureModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
   * The list contents are of type {@link org.featuremapper.models.feature.Constraint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraints</em>' containment reference list.
   * @see org.featuremapper.models.feature.FeaturePackage#getFeatureModel_Constraints()
   * @model containment="true"
   * @generated
   */
  EList<Constraint> getConstraints();

  /**
   * Returns the value of the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' containment reference.
   * @see #setRoot(Feature)
   * @see org.featuremapper.models.feature.FeaturePackage#getFeatureModel_Root()
   * @model containment="true"
   * @generated
   */
  Feature getRoot();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.FeatureModel#getRoot <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' containment reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(Feature value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.featuremapper.models.feature.FeaturePackage#getFeatureModel_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.FeatureModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.featuremapper.models.feature.FeatureModel}.
   * It is bidirectional and its opposite is '{@link org.featuremapper.models.feature.FeatureModel#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.featuremapper.models.feature.FeaturePackage#getFeatureModel_Children()
   * @see org.featuremapper.models.feature.FeatureModel#getParent
   * @model opposite="parent" containment="true"
   * @generated
   */
  EList<FeatureModel> getChildren();

  /**
   * Returns the value of the '<em><b>Parent</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.featuremapper.models.feature.FeatureModel#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' container reference.
   * @see #setParent(FeatureModel)
   * @see org.featuremapper.models.feature.FeaturePackage#getFeatureModel_Parent()
   * @see org.featuremapper.models.feature.FeatureModel#getChildren
   * @model opposite="children" transient="false"
   * @generated
   */
  FeatureModel getParent();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.FeatureModel#getParent <em>Parent</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' container reference.
   * @see #getParent()
   * @generated
   */
  void setParent(FeatureModel value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<Feature> getAllFeatures();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  EList<Feature> getMandatoryFeatures();

} // FeatureModel
