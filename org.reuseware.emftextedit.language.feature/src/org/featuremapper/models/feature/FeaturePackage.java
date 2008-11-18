/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.featuremapper.models.feature;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.featuremapper.models.feature.FeatureFactory
 * @model kind="package"
 * @generated
 */
public interface FeaturePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "feature";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.tudresden.de/feature";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "feature";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FeaturePackage eINSTANCE = org.featuremapper.models.feature.impl.FeaturePackageImpl.init();

  /**
   * The meta object id for the '{@link org.featuremapper.models.feature.impl.FeatureModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.featuremapper.models.feature.impl.FeatureModelImpl
   * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getFeatureModel()
   * @generated
   */
  int FEATURE_MODEL = 0;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODEL__CONSTRAINTS = 0;

  /**
   * The feature id for the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODEL__ROOT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODEL__NAME = 2;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODEL__CHILDREN = 3;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODEL__PARENT = 4;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_MODEL_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.featuremapper.models.feature.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.featuremapper.models.feature.impl.FeatureImpl
   * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = 0;

  /**
   * The feature id for the '<em><b>Min Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__MIN_CARDINALITY = 1;

  /**
   * The feature id for the '<em><b>Max Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__MAX_CARDINALITY = 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__ATTRIBUTES = 3;

  /**
   * The feature id for the '<em><b>Groups</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__GROUPS = 4;

  /**
   * The feature id for the '<em><b>Parent Group</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__PARENT_GROUP = 5;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__ANNOTATIONS = 6;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__CONSTRAINTS = 7;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.featuremapper.models.feature.impl.GroupImpl <em>Group</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.featuremapper.models.feature.impl.GroupImpl
   * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getGroup()
   * @generated
   */
  int GROUP = 2;

  /**
   * The feature id for the '<em><b>Min Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__MIN_CARDINALITY = 0;

  /**
   * The feature id for the '<em><b>Max Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__MAX_CARDINALITY = 1;

  /**
   * The feature id for the '<em><b>Parent Feature</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__PARENT_FEATURE = 2;

  /**
   * The feature id for the '<em><b>Child Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP__CHILD_FEATURES = 3;

  /**
   * The number of structural features of the '<em>Group</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GROUP_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.featuremapper.models.feature.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.featuremapper.models.feature.impl.ConstraintImpl
   * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 3;

  /**
   * The feature id for the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__LANGUAGE = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Constrained Features</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__CONSTRAINED_FEATURES = 2;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.featuremapper.models.feature.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.featuremapper.models.feature.impl.AttributeImpl
   * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 4;

  /**
   * The feature id for the '<em><b>Feature</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__FEATURE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 3;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.featuremapper.models.feature.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.featuremapper.models.feature.impl.AnnotationImpl
   * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 5;

  /**
   * The feature id for the '<em><b>Feature</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__FEATURE = 0;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.featuremapper.models.feature.FeatureModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.featuremapper.models.feature.FeatureModel
   * @generated
   */
  EClass getFeatureModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.featuremapper.models.feature.FeatureModel#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraints</em>'.
   * @see org.featuremapper.models.feature.FeatureModel#getConstraints()
   * @see #getFeatureModel()
   * @generated
   */
  EReference getFeatureModel_Constraints();

  /**
   * Returns the meta object for the containment reference '{@link org.featuremapper.models.feature.FeatureModel#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root</em>'.
   * @see org.featuremapper.models.feature.FeatureModel#getRoot()
   * @see #getFeatureModel()
   * @generated
   */
  EReference getFeatureModel_Root();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.FeatureModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.featuremapper.models.feature.FeatureModel#getName()
   * @see #getFeatureModel()
   * @generated
   */
  EAttribute getFeatureModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.featuremapper.models.feature.FeatureModel#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.featuremapper.models.feature.FeatureModel#getChildren()
   * @see #getFeatureModel()
   * @generated
   */
  EReference getFeatureModel_Children();

  /**
   * Returns the meta object for the container reference '{@link org.featuremapper.models.feature.FeatureModel#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see org.featuremapper.models.feature.FeatureModel#getParent()
   * @see #getFeatureModel()
   * @generated
   */
  EReference getFeatureModel_Parent();

  /**
   * Returns the meta object for class '{@link org.featuremapper.models.feature.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see org.featuremapper.models.feature.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.featuremapper.models.feature.Feature#getName()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Name();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Feature#getMinCardinality <em>Min Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Min Cardinality</em>'.
   * @see org.featuremapper.models.feature.Feature#getMinCardinality()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_MinCardinality();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Feature#getMaxCardinality <em>Max Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Cardinality</em>'.
   * @see org.featuremapper.models.feature.Feature#getMaxCardinality()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_MaxCardinality();

  /**
   * Returns the meta object for the containment reference list '{@link org.featuremapper.models.feature.Feature#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.featuremapper.models.feature.Feature#getAttributes()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link org.featuremapper.models.feature.Feature#getGroups <em>Groups</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Groups</em>'.
   * @see org.featuremapper.models.feature.Feature#getGroups()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Groups();

  /**
   * Returns the meta object for the container reference '{@link org.featuremapper.models.feature.Feature#getParentGroup <em>Parent Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent Group</em>'.
   * @see org.featuremapper.models.feature.Feature#getParentGroup()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_ParentGroup();

  /**
   * Returns the meta object for the containment reference list '{@link org.featuremapper.models.feature.Feature#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.featuremapper.models.feature.Feature#getAnnotations()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Annotations();

  /**
   * Returns the meta object for the reference list '{@link org.featuremapper.models.feature.Feature#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Constraints</em>'.
   * @see org.featuremapper.models.feature.Feature#getConstraints()
   * @see #getFeature()
   * @generated
   */
  EReference getFeature_Constraints();

  /**
   * Returns the meta object for class '{@link org.featuremapper.models.feature.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Group</em>'.
   * @see org.featuremapper.models.feature.Group
   * @generated
   */
  EClass getGroup();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Group#getMinCardinality <em>Min Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Min Cardinality</em>'.
   * @see org.featuremapper.models.feature.Group#getMinCardinality()
   * @see #getGroup()
   * @generated
   */
  EAttribute getGroup_MinCardinality();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Group#getMaxCardinality <em>Max Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Cardinality</em>'.
   * @see org.featuremapper.models.feature.Group#getMaxCardinality()
   * @see #getGroup()
   * @generated
   */
  EAttribute getGroup_MaxCardinality();

  /**
   * Returns the meta object for the container reference '{@link org.featuremapper.models.feature.Group#getParentFeature <em>Parent Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent Feature</em>'.
   * @see org.featuremapper.models.feature.Group#getParentFeature()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_ParentFeature();

  /**
   * Returns the meta object for the containment reference list '{@link org.featuremapper.models.feature.Group#getChildFeatures <em>Child Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child Features</em>'.
   * @see org.featuremapper.models.feature.Group#getChildFeatures()
   * @see #getGroup()
   * @generated
   */
  EReference getGroup_ChildFeatures();

  /**
   * Returns the meta object for class '{@link org.featuremapper.models.feature.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see org.featuremapper.models.feature.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Constraint#getLanguage <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Language</em>'.
   * @see org.featuremapper.models.feature.Constraint#getLanguage()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Language();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Constraint#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see org.featuremapper.models.feature.Constraint#getExpression()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Expression();

  /**
   * Returns the meta object for the reference list '{@link org.featuremapper.models.feature.Constraint#getConstrainedFeatures <em>Constrained Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Constrained Features</em>'.
   * @see org.featuremapper.models.feature.Constraint#getConstrainedFeatures()
   * @see #getConstraint()
   * @generated
   */
  EReference getConstraint_ConstrainedFeatures();

  /**
   * Returns the meta object for class '{@link org.featuremapper.models.feature.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.featuremapper.models.feature.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the container reference '{@link org.featuremapper.models.feature.Attribute#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Feature</em>'.
   * @see org.featuremapper.models.feature.Attribute#getFeature()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.featuremapper.models.feature.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Attribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.featuremapper.models.feature.Attribute#getType()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Type();

  /**
   * Returns the meta object for the attribute '{@link org.featuremapper.models.feature.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.featuremapper.models.feature.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.featuremapper.models.feature.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.featuremapper.models.feature.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the container reference '{@link org.featuremapper.models.feature.Annotation#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Feature</em>'.
   * @see org.featuremapper.models.feature.Annotation#getFeature()
   * @see #getAnnotation()
   * @generated
   */
  EReference getAnnotation_Feature();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FeatureFactory getFeatureFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.featuremapper.models.feature.impl.FeatureModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.featuremapper.models.feature.impl.FeatureModelImpl
     * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getFeatureModel()
     * @generated
     */
    EClass FEATURE_MODEL = eINSTANCE.getFeatureModel();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODEL__CONSTRAINTS = eINSTANCE.getFeatureModel_Constraints();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODEL__ROOT = eINSTANCE.getFeatureModel_Root();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE_MODEL__NAME = eINSTANCE.getFeatureModel_Name();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODEL__CHILDREN = eINSTANCE.getFeatureModel_Children();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_MODEL__PARENT = eINSTANCE.getFeatureModel_Parent();

    /**
     * The meta object literal for the '{@link org.featuremapper.models.feature.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.featuremapper.models.feature.impl.FeatureImpl
     * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

    /**
     * The meta object literal for the '<em><b>Min Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__MIN_CARDINALITY = eINSTANCE.getFeature_MinCardinality();

    /**
     * The meta object literal for the '<em><b>Max Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__MAX_CARDINALITY = eINSTANCE.getFeature_MaxCardinality();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__ATTRIBUTES = eINSTANCE.getFeature_Attributes();

    /**
     * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__GROUPS = eINSTANCE.getFeature_Groups();

    /**
     * The meta object literal for the '<em><b>Parent Group</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__PARENT_GROUP = eINSTANCE.getFeature_ParentGroup();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__ANNOTATIONS = eINSTANCE.getFeature_Annotations();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE__CONSTRAINTS = eINSTANCE.getFeature_Constraints();

    /**
     * The meta object literal for the '{@link org.featuremapper.models.feature.impl.GroupImpl <em>Group</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.featuremapper.models.feature.impl.GroupImpl
     * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getGroup()
     * @generated
     */
    EClass GROUP = eINSTANCE.getGroup();

    /**
     * The meta object literal for the '<em><b>Min Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP__MIN_CARDINALITY = eINSTANCE.getGroup_MinCardinality();

    /**
     * The meta object literal for the '<em><b>Max Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GROUP__MAX_CARDINALITY = eINSTANCE.getGroup_MaxCardinality();

    /**
     * The meta object literal for the '<em><b>Parent Feature</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP__PARENT_FEATURE = eINSTANCE.getGroup_ParentFeature();

    /**
     * The meta object literal for the '<em><b>Child Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GROUP__CHILD_FEATURES = eINSTANCE.getGroup_ChildFeatures();

    /**
     * The meta object literal for the '{@link org.featuremapper.models.feature.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.featuremapper.models.feature.impl.ConstraintImpl
     * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__LANGUAGE = eINSTANCE.getConstraint_Language();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__EXPRESSION = eINSTANCE.getConstraint_Expression();

    /**
     * The meta object literal for the '<em><b>Constrained Features</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT__CONSTRAINED_FEATURES = eINSTANCE.getConstraint_ConstrainedFeatures();

    /**
     * The meta object literal for the '{@link org.featuremapper.models.feature.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.featuremapper.models.feature.impl.AttributeImpl
     * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__FEATURE = eINSTANCE.getAttribute_Feature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link org.featuremapper.models.feature.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.featuremapper.models.feature.impl.AnnotationImpl
     * @see org.featuremapper.models.feature.impl.FeaturePackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANNOTATION__FEATURE = eINSTANCE.getAnnotation_Feature();

  }

} //FeaturePackage
