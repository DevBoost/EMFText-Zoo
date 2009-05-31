/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmt.am3.dsls.KM3.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.gmt.am3.dsls.KM3.Attribute;
import org.eclipse.gmt.am3.dsls.KM3.Classifier;
import org.eclipse.gmt.am3.dsls.KM3.DataType;
import org.eclipse.gmt.am3.dsls.KM3.EnumLiteral;
import org.eclipse.gmt.am3.dsls.KM3.Enumeration;
import org.eclipse.gmt.am3.dsls.KM3.KM3Factory;
import org.eclipse.gmt.am3.dsls.KM3.KM3Package;
import org.eclipse.gmt.am3.dsls.KM3.Metamodel;
import org.eclipse.gmt.am3.dsls.KM3.Operation;
import org.eclipse.gmt.am3.dsls.KM3.Parameter;
import org.eclipse.gmt.am3.dsls.KM3.Reference;
import org.eclipse.gmt.am3.dsls.KM3.StructuralFeature;
import org.eclipse.gmt.am3.dsls.KM3.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KM3FactoryImpl extends EFactoryImpl implements KM3Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KM3Factory init() {
		try {
			KM3Factory theKM3Factory = (KM3Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/gmt/2005/KM3"); 
			if (theKM3Factory != null) {
				return theKM3Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KM3FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KM3FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case KM3Package.CLASSIFIER: return createClassifier();
			case KM3Package.DATA_TYPE: return createDataType();
			case KM3Package.ENUMERATION: return createEnumeration();
			case KM3Package.ENUM_LITERAL: return createEnumLiteral();
			case KM3Package.CLASS: return createClass();
			case KM3Package.TYPED_ELEMENT: return createTypedElement();
			case KM3Package.STRUCTURAL_FEATURE: return createStructuralFeature();
			case KM3Package.ATTRIBUTE: return createAttribute();
			case KM3Package.REFERENCE: return createReference();
			case KM3Package.OPERATION: return createOperation();
			case KM3Package.PARAMETER: return createParameter();
			case KM3Package.PACKAGE: return createPackage();
			case KM3Package.METAMODEL: return createMetamodel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier createClassifier() {
		ClassifierImpl classifier = new ClassifierImpl();
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteral createEnumLiteral() {
		EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
		return enumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.gmt.am3.dsls.KM3.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement createTypedElement() {
		TypedElementImpl typedElement = new TypedElementImpl();
		return typedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeature createStructuralFeature() {
		StructuralFeatureImpl structuralFeature = new StructuralFeatureImpl();
		return structuralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.gmt.am3.dsls.KM3.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel createMetamodel() {
		MetamodelImpl metamodel = new MetamodelImpl();
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KM3Package getKM3Package() {
		return (KM3Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KM3Package getPackage() {
		return KM3Package.eINSTANCE;
	}

} //KM3FactoryImpl
