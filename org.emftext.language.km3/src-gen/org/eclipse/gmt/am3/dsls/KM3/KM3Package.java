/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3;

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
 * @see org.eclipse.gmt.am3.dsls.KM3.KM3Factory
 * @model kind="package"
 * @generated
 */
public interface KM3Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "KM3";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/gmt/2005/KM3";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "km3";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KM3Package eINSTANCE = org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.LocatedElementImpl <em>Located Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.LocatedElementImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getLocatedElement()
	 * @generated
	 */
	int LOCATED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATED_ELEMENT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATED_ELEMENT__COMMENTS_BEFORE = 1;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATED_ELEMENT__COMMENTS_AFTER = 2;

	/**
	 * The number of structural features of the '<em>Located Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ModelElementImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__PACKAGE = LOCATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ClassifierImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__LOCATION = MODEL_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__COMMENTS_BEFORE = MODEL_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__COMMENTS_AFTER = MODEL_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__PACKAGE = MODEL_ELEMENT__PACKAGE;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.DataTypeImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__LOCATION = CLASSIFIER__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__COMMENTS_BEFORE = CLASSIFIER__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__COMMENTS_AFTER = CLASSIFIER__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PACKAGE = CLASSIFIER__PACKAGE;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.EnumerationImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LOCATION = CLASSIFIER__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__COMMENTS_BEFORE = CLASSIFIER__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__COMMENTS_AFTER = CLASSIFIER__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__PACKAGE = CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERALS = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.EnumLiteralImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__LOCATION = MODEL_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__COMMENTS_BEFORE = MODEL_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__COMMENTS_AFTER = MODEL_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__PACKAGE = MODEL_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Enum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__ENUM = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__LOCATION = CLASSIFIER__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__COMMENTS_BEFORE = CLASSIFIER__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__COMMENTS_AFTER = CLASSIFIER__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__PACKAGE = CLASSIFIER__PACKAGE;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supertypes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPERTYPES = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Structural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__STRUCTURAL_FEATURES = CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OPERATIONS = CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.TypedElementImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__LOCATION = MODEL_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__COMMENTS_BEFORE = MODEL_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__COMMENTS_AFTER = MODEL_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__PACKAGE = MODEL_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__LOWER = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__UPPER = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__IS_ORDERED = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__IS_UNIQUE = MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.StructuralFeatureImpl <em>Structural Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.StructuralFeatureImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getStructuralFeature()
	 * @generated
	 */
	int STRUCTURAL_FEATURE = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__LOCATION = TYPED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__COMMENTS_BEFORE = TYPED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__COMMENTS_AFTER = TYPED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__PACKAGE = TYPED_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__LOWER = TYPED_ELEMENT__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__UPPER = TYPED_ELEMENT__UPPER;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__IS_ORDERED = TYPED_ELEMENT__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__IS_UNIQUE = TYPED_ELEMENT__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__OWNER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subset Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__SUBSET_OF = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE__DERIVED_FROM = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Structural Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.AttributeImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 9;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__LOCATION = STRUCTURAL_FEATURE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__COMMENTS_BEFORE = STRUCTURAL_FEATURE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__COMMENTS_AFTER = STRUCTURAL_FEATURE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PACKAGE = STRUCTURAL_FEATURE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__LOWER = STRUCTURAL_FEATURE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__UPPER = STRUCTURAL_FEATURE__UPPER;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_ORDERED = STRUCTURAL_FEATURE__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_UNIQUE = STRUCTURAL_FEATURE__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = STRUCTURAL_FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = STRUCTURAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Subset Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SUBSET_OF = STRUCTURAL_FEATURE__SUBSET_OF;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DERIVED_FROM = STRUCTURAL_FEATURE__DERIVED_FROM;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ReferenceImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LOCATION = STRUCTURAL_FEATURE__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__COMMENTS_BEFORE = STRUCTURAL_FEATURE__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__COMMENTS_AFTER = STRUCTURAL_FEATURE__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = STRUCTURAL_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__PACKAGE = STRUCTURAL_FEATURE__PACKAGE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__LOWER = STRUCTURAL_FEATURE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__UPPER = STRUCTURAL_FEATURE__UPPER;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_ORDERED = STRUCTURAL_FEATURE__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_UNIQUE = STRUCTURAL_FEATURE__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TYPE = STRUCTURAL_FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__OWNER = STRUCTURAL_FEATURE__OWNER;

	/**
	 * The feature id for the '<em><b>Subset Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__SUBSET_OF = STRUCTURAL_FEATURE__SUBSET_OF;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__DERIVED_FROM = STRUCTURAL_FEATURE__DERIVED_FROM;

	/**
	 * The feature id for the '<em><b>Is Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__IS_CONTAINER = STRUCTURAL_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__OPPOSITE = STRUCTURAL_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = STRUCTURAL_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.OperationImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__LOCATION = TYPED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__COMMENTS_BEFORE = TYPED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__COMMENTS_AFTER = TYPED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PACKAGE = TYPED_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__LOWER = TYPED_ELEMENT__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__UPPER = TYPED_ELEMENT__UPPER;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_ORDERED = TYPED_ELEMENT__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__IS_UNIQUE = TYPED_ELEMENT__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETERS = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ParameterImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 12;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__LOCATION = TYPED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMENTS_BEFORE = TYPED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__COMMENTS_AFTER = TYPED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PACKAGE = TYPED_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__LOWER = TYPED_ELEMENT__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__UPPER = TYPED_ELEMENT__UPPER;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_ORDERED = TYPED_ELEMENT__IS_ORDERED;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_UNIQUE = TYPED_ELEMENT__IS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OWNER = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.PackageImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 13;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__LOCATION = MODEL_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__COMMENTS_BEFORE = MODEL_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__COMMENTS_AFTER = MODEL_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__PACKAGE = MODEL_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__CONTENTS = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__METAMODEL = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.MetamodelImpl <em>Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.MetamodelImpl
	 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getMetamodel()
	 * @generated
	 */
	int METAMODEL = 14;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__LOCATION = LOCATED_ELEMENT__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__COMMENTS_BEFORE = LOCATED_ELEMENT__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__COMMENTS_AFTER = LOCATED_ELEMENT__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL__CONTENTS = LOCATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_FEATURE_COUNT = LOCATED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement <em>Located Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Located Element</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.LocatedElement
	 * @generated
	 */
	EClass getLocatedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getLocation()
	 * @see #getLocatedElement()
	 * @generated
	 */
	EAttribute getLocatedElement_Location();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getCommentsBefore <em>Comments Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments Before</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getCommentsBefore()
	 * @see #getLocatedElement()
	 * @generated
	 */
	EAttribute getLocatedElement_CommentsBefore();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getCommentsAfter <em>Comments After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments After</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.LocatedElement#getCommentsAfter()
	 * @see #getLocatedElement()
	 * @generated
	 */
	EAttribute getLocatedElement_CommentsAfter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.ModelElement#getName()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmt.am3.dsls.KM3.ModelElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.ModelElement#getPackage()
	 * @see #getModelElement()
	 * @generated
	 */
	EReference getModelElement_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Enumeration#getLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmt.am3.dsls.KM3.EnumLiteral#getEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enum</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.EnumLiteral#getEnum()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EReference getEnumLiteral_Enum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class#getIsAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsAbstract();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getSupertypes <em>Supertypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supertypes</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class#getSupertypes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Supertypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getStructuralFeatures <em>Structural Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structural Features</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class#getStructuralFeatures()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_StructuralFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Class#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Class#getOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Operations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.TypedElement#getLower()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Lower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.TypedElement#getUpper()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Upper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsOrdered()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_IsOrdered();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.TypedElement#getIsUnique()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_IsUnique();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmt.am3.dsls.KM3.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature <em>Structural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature
	 * @generated
	 */
	EClass getStructuralFeature();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getOwner()
	 * @see #getStructuralFeature()
	 * @generated
	 */
	EReference getStructuralFeature_Owner();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getSubsetOf <em>Subset Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subset Of</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getSubsetOf()
	 * @see #getStructuralFeature()
	 * @generated
	 */
	EReference getStructuralFeature_SubsetOf();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getDerivedFrom <em>Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.StructuralFeature#getDerivedFrom()
	 * @see #getStructuralFeature()
	 * @generated
	 */
	EReference getStructuralFeature_DerivedFrom();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.gmt.am3.dsls.KM3.Reference#getIsContainer <em>Is Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Container</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Reference#getIsContainer()
	 * @see #getReference()
	 * @generated
	 */
	EAttribute getReference_IsContainer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.gmt.am3.dsls.KM3.Reference#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Reference#getOpposite()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Opposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmt.am3.dsls.KM3.Operation#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Operation#getOwner()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Operation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Operation#getParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmt.am3.dsls.KM3.Parameter#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Parameter#getOwner()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Package#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Package#getContents()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Contents();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.gmt.am3.dsls.KM3.Package#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Metamodel</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Package#getMetamodel()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Metamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmt.am3.dsls.KM3.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Metamodel
	 * @generated
	 */
	EClass getMetamodel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmt.am3.dsls.KM3.Metamodel#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.eclipse.gmt.am3.dsls.KM3.Metamodel#getContents()
	 * @see #getMetamodel()
	 * @generated
	 */
	EReference getMetamodel_Contents();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KM3Factory getKM3Factory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.LocatedElementImpl <em>Located Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.LocatedElementImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getLocatedElement()
		 * @generated
		 */
		EClass LOCATED_ELEMENT = eINSTANCE.getLocatedElement();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATED_ELEMENT__LOCATION = eINSTANCE.getLocatedElement_Location();

		/**
		 * The meta object literal for the '<em><b>Comments Before</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATED_ELEMENT__COMMENTS_BEFORE = eINSTANCE.getLocatedElement_CommentsBefore();

		/**
		 * The meta object literal for the '<em><b>Comments After</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATED_ELEMENT__COMMENTS_AFTER = eINSTANCE.getLocatedElement_CommentsAfter();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ModelElementImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__PACKAGE = eINSTANCE.getModelElement_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ClassifierImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.DataTypeImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.EnumerationImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__LITERALS = eINSTANCE.getEnumeration_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.EnumLiteralImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Enum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL__ENUM = eINSTANCE.getEnumLiteral_Enum();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ClassImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ABSTRACT = eINSTANCE.getClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Supertypes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPERTYPES = eINSTANCE.getClass_Supertypes();

		/**
		 * The meta object literal for the '<em><b>Structural Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__STRUCTURAL_FEATURES = eINSTANCE.getClass_StructuralFeatures();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OPERATIONS = eINSTANCE.getClass_Operations();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.TypedElementImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__LOWER = eINSTANCE.getTypedElement_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__UPPER = eINSTANCE.getTypedElement_Upper();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__IS_ORDERED = eINSTANCE.getTypedElement_IsOrdered();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__IS_UNIQUE = eINSTANCE.getTypedElement_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.StructuralFeatureImpl <em>Structural Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.StructuralFeatureImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getStructuralFeature()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE = eINSTANCE.getStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE__OWNER = eINSTANCE.getStructuralFeature_Owner();

		/**
		 * The meta object literal for the '<em><b>Subset Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE__SUBSET_OF = eINSTANCE.getStructuralFeature_SubsetOf();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE__DERIVED_FROM = eINSTANCE.getStructuralFeature_DerivedFrom();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.AttributeImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ReferenceImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Is Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE__IS_CONTAINER = eINSTANCE.getReference_IsContainer();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__OPPOSITE = eINSTANCE.getReference_Opposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.OperationImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNER = eINSTANCE.getOperation_Owner();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PARAMETERS = eINSTANCE.getOperation_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.ParameterImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__OWNER = eINSTANCE.getParameter_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.PackageImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__CONTENTS = eINSTANCE.getPackage_Contents();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__METAMODEL = eINSTANCE.getPackage_Metamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmt.am3.dsls.KM3.impl.MetamodelImpl <em>Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.MetamodelImpl
		 * @see org.eclipse.gmt.am3.dsls.KM3.impl.KM3PackageImpl#getMetamodel()
		 * @generated
		 */
		EClass METAMODEL = eINSTANCE.getMetamodel();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METAMODEL__CONTENTS = eINSTANCE.getMetamodel_Contents();

	}

} //KM3Package
