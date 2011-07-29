/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.mecore.resource.mecore.mopp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MClassifier;
import org.emftext.language.mecore.MComplexMultiplicity;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MEcoreType;
import org.emftext.language.mecore.MEnum;
import org.emftext.language.mecore.MEnumLiteral;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MModelElement;
import org.emftext.language.mecore.MMultiplicity;
import org.emftext.language.mecore.MOperation;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.MParameter;
import org.emftext.language.mecore.MSimpleMultiplicity;
import org.emftext.language.mecore.MSimpleMultiplicityValue;
import org.emftext.language.mecore.MType;
import org.emftext.language.mecore.MTypedElement;
import org.emftext.language.mecore.resource.mecore.IMecoreCommand;

/**
 * Converts Mecore models to Ecore models. The wrapper tries to keep the 
 * contents of the previous Ecore model to the extent possible.
 */
public class MecoreWrapper {
	
	private static final String ANNOTATION_SOURCE = MecoreWrapper.class.getName();
	private static final String COMMENT_KEY = "WARNING";
	private static final String COMMENT_VALUE = "This element was generated from an .mecore file. Removing this annotation will signal the MinimalEcore builder to keep this element.";
	
	private Map<MModelElement, EModelElement> mapping = new LinkedHashMap<MModelElement, EModelElement>();
	
	/**
	 * Some steps in the creation of the Ecore model need to be postponed (e.g., the creation
	 * of super type references). We collect these steps in this list of commands and execute
	 * them after the structure of the Ecore model was created completely.
	 */
	private List<IMecoreCommand<Object>> commands = new ArrayList<IMecoreCommand<Object>>();

	public EPackage wrapMPackage(MPackage mPackage, EPackage existingEPackage) {
		if (existingEPackage != null) {
			mapping.put(mPackage, existingEPackage);
		}
		EPackage superPackage = null;
		if (existingEPackage != null) {
			existingEPackage.getESuperPackage();
		}
		EPackage ePackage = findOrCreateEPackage(mPackage, superPackage);
		
		// set package properties
		String packageName = mPackage.getName();
		if (packageName == null) {
			ePackage.setName(mPackage.eResource().getURI().fragment());
		} else {
			ePackage.setName(packageName);
		}
		ePackage.setNsURI(mPackage.getNamespace());
		ePackage.setNsPrefix(mPackage.getName());
		
		// process package contents
		for (MClassifier mClassifier : mPackage.getContents()) {
			wrapMClassifier(mClassifier, ePackage);
		}
		
		// execute deferred commands
		for (IMecoreCommand<Object> command : commands) {
			command.execute(null);
		}
		
		removeObsoleteElements(ePackage);
		return ePackage;
	}

	private void removeObsoleteElements(EPackage ePackage) {
		List<EObject> obsoleteElements = new ArrayList<EObject>();
		removeObsoleteElements(ePackage, obsoleteElements);
		for (EObject eObject : obsoleteElements) {
			EcoreUtil.remove(eObject);
		}
	}

	private void removeObsoleteElements(EObject eObject, List<EObject> obsoleteElements) {
		// remove elements that have an MEcore annotation, but that are not present
		// in the .mecore file anymore
		for (EObject child : eObject.eContents()) {
			boolean wasMapped = mapping.values().contains(child);
			boolean isAnnotation = child instanceof EAnnotation;
			if (hasAnnotation(child) && !wasMapped && !isAnnotation) {
				obsoleteElements.add(child);
			} else {
				// call method recursively on children
				removeObsoleteElements(child, obsoleteElements);
			}
		}
	}

	private void addAnnotation(EModelElement element, String comment) {
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnnotation.setSource(ANNOTATION_SOURCE);
		eAnnotation.getDetails().put(COMMENT_KEY, comment);
		element.getEAnnotations().add(eAnnotation);
	}

	private boolean hasAnnotation(EObject eObject) {
		if (eObject instanceof EModelElement) {
			EModelElement element = (EModelElement) eObject;
			EAnnotation annotation = element.getEAnnotation(ANNOTATION_SOURCE);
			return annotation != null;
		} else {
			return false;
		}
	}

	private void wrapMClassifier(MClassifier mClassifier, EPackage ePackage) {
		if (mClassifier instanceof MClass) {
			wrapMClass((MClass) mClassifier, ePackage);
		} else if (mClassifier instanceof MEnum) {
			wrapMEnum((MEnum) mClassifier, ePackage);
		}
	}

	private void wrapMEnum(MEnum mEnum, EPackage ePackage) {
		EEnum eEnum = findOrCreateEEnum(mEnum, ePackage);
		eEnum.setName(mEnum.getName());
		int count = 0;
		for (MEnumLiteral literal : mEnum.getLiterals()) {
			wrapMEnumLiteral(literal, eEnum, count++);
		}
		mapping.put(mEnum, eEnum);
	}

	private void wrapMEnumLiteral(MEnumLiteral literal, EEnum existingEEnum, int count) {
		EEnumLiteral eEnumLiteral = findOrCreateEEnumLiteral(literal, existingEEnum);
		eEnumLiteral.setName(literal.getName());
		eEnumLiteral.setLiteral(literal.getLiteral());
		eEnumLiteral.setValue(count);
		mapping.put(literal, eEnumLiteral);
	}

	private void wrapMClass(final MClass mClass, EPackage ePackage) {
		final EClass eClass = findOrCreateEClass(mClass, ePackage);
		mapping.put(mClass, eClass);
		eClass.getESuperTypes().clear();
		eClass.setName(mClass.getName());
		eClass.setAbstract(mClass.isAbstract());
		
		// handle features
		for (MFeature mFeature : mClass.getFeatures()) {
			wrapMFeature(mFeature, eClass);
		}
		
		// handle operations
		for (MOperation mOperation : mClass.getOperations()) {
			wrapMOperation(mOperation, eClass);
		}
		
		// handle super types
		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				for (MClass supertype : mClass.getSupertypes()) {
					EClass eSuperType = (EClass) mapping.get(supertype);
					if (eSuperType == null) {
						continue;
					}
					eClass.getESuperTypes().add(eSuperType);
				}
				return true;
			}
		});
	}

	private void wrapMFeature(MFeature mFeature, EClass existingEClass) {
		EStructuralFeature eFeature;
		final MType mType = mFeature.getType();
		if (mType == null) {
			return;
		}
		if (mType instanceof MClass) {
			eFeature = createReference(mFeature, mType, existingEClass);
		} else if (mType instanceof MDataType) {
			eFeature = createAttribute(mFeature, existingEClass, mType);
		} else if (mType instanceof MEnum) {
			final EAttribute eAttribute = findOrCreateEAttribute(mFeature, existingEClass);
			commands.add(new IMecoreCommand<Object>() {

				public boolean execute(Object context) {
					eAttribute.setEType((EEnum) mapping.get(mType));
					return true;
				}
			});
			eFeature = eAttribute;
		} else if (mType instanceof MEcoreType) {
			eFeature = createReference(mFeature, mType, existingEClass);
		} else {
			throw new RuntimeException("Found unknown subtype of MType: " + mType.eClass().getName());
		}
		setMulitplicity(mFeature, eFeature);
		mapping.put(mFeature, eFeature);
		eFeature.setName(mFeature.getName());
	}

	private EStructuralFeature createAttribute(MFeature mFeature,
			EClass existingEClass, final MType mType) {
		// primitive type, create attribute
		EAttribute eAttribute = findOrCreateEAttribute(mFeature, existingEClass);
		setType(eAttribute, mType);
		return eAttribute;
	}

	private void wrapMOperation(MOperation mOperation, EClass existingEClass) {
		final MType mType = mOperation.getType();
		if (mType == null) {
			return;
		}
		final EOperation eOperation = findOrCreateEOperation(mOperation, existingEClass);
		// TODO handle parameters
		for (MParameter mParameter : mOperation.getParameters()) {
			wrapMParameter(mParameter, eOperation);
		}

		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				eOperation.setEType((EClassifier) mapping.get(mType));
				return true;
			}
		});

		setMulitplicity(mOperation, eOperation);
		mapping.put(mOperation, eOperation);
		eOperation.setName(mOperation.getName());
	}

	private void wrapMParameter(MParameter mParameter, EOperation existingOperation) {
		final MType mType = mParameter.getType();
		if (mType == null) {
			return;
		}
		final EParameter eParameter = findOrCreateEParameter(mParameter, existingOperation);

		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				setType(eParameter, mType);
				return true;
			}
		});

		setMulitplicity(mParameter, eParameter);
		mapping.put(mParameter, eParameter);
		eParameter.setName(mParameter.getName());
	}

	private EStructuralFeature createReference(MFeature mFeature, final MType mType, EClass eClass) {
		// complex type, create reference
		final EReference eReference = findOrCreateEReference(mFeature, eClass);
		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				setType(eReference, mType);
				return true;
			}
		});
		eReference.setContainment(!mFeature.isReference());
		return eReference;
	}

	private void setMulitplicity(MTypedElement mElement, ETypedElement eElement) {
		MMultiplicity multiplicity = mElement.getMultiplicity();
		if (multiplicity instanceof MSimpleMultiplicity) {
			MSimpleMultiplicity simpleMultiplicity = (MSimpleMultiplicity) multiplicity;
			MSimpleMultiplicityValue value = simpleMultiplicity.getValue();
			if (value == MSimpleMultiplicityValue.STAR) {
				setBounds(eElement, 0, -1);
			} else if (value == MSimpleMultiplicityValue.PLUS) {
				setBounds(eElement, 1, -1);
			} else if (value == MSimpleMultiplicityValue.OPTIONAL) {
				setBounds(eElement, 0, 1);
			} else {
				setBounds(eElement, 1, 1);
			}
		} else if (multiplicity instanceof MComplexMultiplicity) {
			MComplexMultiplicity complexMultiplicity = (MComplexMultiplicity) multiplicity;
			eElement.setLowerBound(complexMultiplicity.getLowerBound());
			eElement.setUpperBound(complexMultiplicity.getUpperBound());
		} else if (multiplicity == null) {
			setBounds(eElement, 1, 1);
		}
	}

	private void setBounds(ETypedElement element, int lower, int upper) {
		element.setLowerBound(lower);
		element.setUpperBound(upper);
	}

	private EPackage findOrCreateEPackage(MPackage mPackage, EPackage existingSuperPackage) {
		if (mapping.containsKey(mPackage)) {
			return (EPackage) mapping.get(mPackage);
		}

		if (existingSuperPackage != null) {
			List<EPackage> existingSubPackages = existingSuperPackage.getESubpackages();
			for (EPackage existingSubPackage : existingSubPackages) {
				if (mPackage.getName().equals(existingSubPackage.getName())) {
					mapping.put(mPackage, existingSubPackage);
					return (EPackage) existingSubPackage;
				}
			}
		}

		// if we can't find an existing EPackage, we need to create a fresh one
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		addAnnotation(ePackage, COMMENT_VALUE);
		if (existingSuperPackage != null) {
			existingSuperPackage.getESubpackages().add(ePackage);
		}
		mapping.put(mPackage, ePackage);
		return ePackage;
	}

	private EClass findOrCreateEClass(MClass mClass, EPackage ePackage) {
		if (mapping.containsKey(mClass)) {
			return (EClass) mapping.get(mClass);
		}
		
		EClassifier existingEClassifier = ePackage.getEClassifier(mClass.getName());
		if (existingEClassifier != null && existingEClassifier instanceof EClass) {
			mapping.put(mClass, existingEClassifier);
			return (EClass) existingEClassifier;
		}
		
		// if we can't find an existing EClass, we need to create a fresh one
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		addAnnotation(eClass, COMMENT_VALUE);
		ePackage.getEClassifiers().add(eClass);
		mapping.put(mClass, eClass);
		return eClass;
	}

	private EEnum findOrCreateEEnum(MEnum mEnum, EPackage ePackage) {
		if (mapping.containsKey(mEnum)) {
			return (EEnum) mapping.get(mEnum);
		}
		
		EClassifier existingEClassifier = ePackage.getEClassifier(mEnum.getName());
		if (existingEClassifier != null && existingEClassifier instanceof EEnum) {
			mapping.put(mEnum, existingEClassifier);
			return (EEnum) existingEClassifier;
		}
		
		// if we can't find an existing EEnum, we need to create a fresh one
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		addAnnotation(eEnum, COMMENT_VALUE);
		ePackage.getEClassifiers().add(eEnum);
		mapping.put(mEnum, eEnum);
		return eEnum;
	}

	private EEnumLiteral findOrCreateEEnumLiteral(MEnumLiteral mEnumLiteral, EEnum existingEnum) {
		if (mapping.containsKey(mEnumLiteral)) {
			return (EEnumLiteral) mapping.get(mEnumLiteral);
		}

		EEnumLiteral existingEEnumLiteral = existingEnum.getEEnumLiteral(mEnumLiteral.getName());
		if (existingEEnumLiteral != null) {
			mapping.put(mEnumLiteral, existingEEnumLiteral);
			return existingEEnumLiteral;
		}
		
		// if we can't find an existing EEnumLiteral, we need to create a fresh one
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		addAnnotation(eEnumLiteral, COMMENT_VALUE);
		existingEnum.getELiterals().add(eEnumLiteral);
		mapping.put(mEnumLiteral, eEnumLiteral);
		return eEnumLiteral;
	}

	private EAttribute findOrCreateEAttribute(MFeature mFeature, EClass existingEClass) {
		if (mapping.containsKey(mFeature)) {
			return (EAttribute) mapping.get(mFeature);
		}

		EStructuralFeature existingFeature = existingEClass.getEStructuralFeature(mFeature.getName());
		if (existingFeature != null && existingFeature instanceof EAttribute) {
			mapping.put(mFeature, existingFeature);
			return (EAttribute) existingFeature;
		}
		
		// if we can't find an existing EAttribute, we need to create a fresh one
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		addAnnotation(eAttribute, COMMENT_VALUE);
		existingEClass.getEStructuralFeatures().add(eAttribute);
		mapping.put(mFeature, eAttribute);
		return eAttribute;
	}

	private EReference findOrCreateEReference(MFeature mFeature, EClass existingEClass) {
		if (mapping.containsKey(mFeature)) {
			return (EReference) mapping.get(mFeature);
		}

		EStructuralFeature existingFeature = existingEClass.getEStructuralFeature(mFeature.getName());
		if (existingFeature != null && existingFeature instanceof EReference) {
			mapping.put(mFeature, existingFeature);
			return (EReference) existingFeature;
		}
		
		// if we can't find an existing EReference, we need to create a fresh one
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		addAnnotation(eReference, COMMENT_VALUE);
		existingEClass.getEStructuralFeatures().add(eReference);
		mapping.put(mFeature, eReference);
		return eReference;
	}

	private EOperation findOrCreateEOperation(MOperation mOperation, EClass existingEClass) {
		if (mapping.containsKey(mOperation)) {
			return (EOperation) mapping.get(mOperation);
		}

		EOperation existingOperation = null;
		for (EOperation operation : existingEClass.getEOperations()) {
			String name = operation.getName();
			if (name != null && name.equals(mOperation.getName())) {
				// TODO check parameter types and return type
				existingOperation = operation;
				break;
			}
		}
		
		if (existingOperation != null && existingOperation instanceof EOperation) {
			mapping.put(mOperation, existingOperation);
			return (EOperation) existingOperation;
		}
		
		// if we can't find an existing EOperation, we need to create a fresh one
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		addAnnotation(eOperation, COMMENT_VALUE);
		existingEClass.getEOperations().add(eOperation);
		mapping.put(mOperation, eOperation);
		return eOperation;
	}

	private EParameter findOrCreateEParameter(MParameter mParameter, EOperation existingEOperation) {
		if (mapping.containsKey(mParameter)) {
			return (EParameter) mapping.get(mParameter);
		}

		EParameter existingParameter = null;
		for (EParameter parameter : existingEOperation.getEParameters()) {
			String name = parameter.getName();
			if (name != null && name.equals(mParameter.getName())) {
				// TODO check parameter types and return type
				existingParameter = parameter;
				break;
			}
		}
		
		if (existingParameter != null && existingParameter instanceof EParameter) {
			mapping.put(mParameter, existingParameter);
			return (EParameter) existingParameter;
		}
		
		// if we can't find an existing EParameter, we need to create a fresh one
		EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		addAnnotation(eParameter, COMMENT_VALUE);
		existingEOperation.getEParameters().add(eParameter);
		mapping.put(mParameter, eParameter);
		return eParameter;
	}

	public Map<MModelElement, EModelElement> getMapping() {
		return mapping;
	}

	private void setType(ETypedElement eTypedElement, MType mType) {
		if (mType instanceof MEcoreType) {
			MEcoreType mEcoreType = (MEcoreType) mType;
			eTypedElement.setEType(mEcoreType.getEcoreType());
		} else if (mType instanceof MDataType) {
			MDataType mDataType = (MDataType) mType;
			eTypedElement.setEType(mDataType.getEDataType());
		} else {
			eTypedElement.setEType((EClass) mapping.get(mType));
		}
	}
}
