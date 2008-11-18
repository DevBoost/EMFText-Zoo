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
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.featuremapper.models.feature.Constraint#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.Constraint#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.featuremapper.models.feature.Constraint#getConstrainedFeatures <em>Constrained Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.featuremapper.models.feature.FeaturePackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject
{
  /**
   * Returns the value of the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Language</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Language</em>' attribute.
   * @see #setLanguage(String)
   * @see org.featuremapper.models.feature.FeaturePackage#getConstraint_Language()
   * @model required="true"
   * @generated
   */
  String getLanguage();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.Constraint#getLanguage <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language</em>' attribute.
   * @see #getLanguage()
   * @generated
   */
  void setLanguage(String value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' attribute.
   * @see #setExpression(String)
   * @see org.featuremapper.models.feature.FeaturePackage#getConstraint_Expression()
   * @model required="true"
   * @generated
   */
  String getExpression();

  /**
   * Sets the value of the '{@link org.featuremapper.models.feature.Constraint#getExpression <em>Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' attribute.
   * @see #getExpression()
   * @generated
   */
  void setExpression(String value);

  /**
   * Returns the value of the '<em><b>Constrained Features</b></em>' reference list.
   * The list contents are of type {@link org.featuremapper.models.feature.Feature}.
   * It is bidirectional and its opposite is '{@link org.featuremapper.models.feature.Feature#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constrained Features</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constrained Features</em>' reference list.
   * @see org.featuremapper.models.feature.FeaturePackage#getConstraint_ConstrainedFeatures()
   * @see org.featuremapper.models.feature.Feature#getConstraints
   * @model opposite="constraints" required="true"
   * @generated
   */
  EList<Feature> getConstrainedFeatures();

} // Constraint
