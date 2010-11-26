package org.emftext.language.ecore.resource.mecore.mopp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.language.ecore.resource.mecore.IMinEcoreCommand;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MClassifier;
import org.emftext.language.mecore.MComplexMultiplicity;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MEnum;
import org.emftext.language.mecore.MEnumLiteral;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MModelElement;
import org.emftext.language.mecore.MMultiplicity;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.MSimpleMultiplicity;
import org.emftext.language.mecore.MSimpleMultiplicityValue;
import org.emftext.language.mecore.MType;

public class MinEcoreWrapper {
	
	private Map<MModelElement, EModelElement> mapping = new LinkedHashMap<MModelElement, EModelElement>();
	private List<IMinEcoreCommand<Object>> commands = new ArrayList<IMinEcoreCommand<Object>>();

	public EPackage wrapMPackage(MPackage mPackage) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		mapping.put(mPackage, ePackage);
		String packageName = mPackage.getName();
		if (packageName == null) {
			ePackage.setName(mPackage.eResource().getURI().fragment());
		} else {
			ePackage.setName(packageName);
		}
		ePackage.setNsURI(mPackage.getNamespace());
		ePackage.setNsPrefix(mPackage.getName());
		
		EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
		for (MClassifier mClassifier : mPackage.getContents()) {
			eClassifiers.add(wrapMClassifier(mClassifier));
		}
		// execute deferred commands
		for (IMinEcoreCommand<Object> command : commands) {
			command.execute(null);
		}
		return ePackage;
	}

	private EClassifier wrapMClassifier(MClassifier mClassifier) {
		if (mClassifier instanceof MClass) {
			return wrapMClass((MClass) mClassifier);
		} else if (mClassifier instanceof MEnum) {
			return wrapMEnum((MEnum) mClassifier);
		}
		return null;
	}

	private EClassifier wrapMEnum(MEnum mEnum) {
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		eEnum.setName(mEnum.getName());
		int count = 0;
		for (MEnumLiteral literal : mEnum.getLiterals()) {
			eEnum.getELiterals().add(wrapMEnumLiteral(literal, count++));
		}
		mapping.put(mEnum, eEnum);
		return eEnum;
	}

	private EEnumLiteral wrapMEnumLiteral(MEnumLiteral literal, int count) {
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		eEnumLiteral.setName(literal.getName());
		eEnumLiteral.setLiteral(literal.getLiteral());
		eEnumLiteral.setValue(count);
		return eEnumLiteral;
	}

	private EClassifier wrapMClass(final MClass mClass) {
		final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		mapping.put(mClass, eClass);
		eClass.setName(mClass.getName());
		eClass.setAbstract(mClass.isAbstract());
		
		// handle features
		List<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		for (MFeature mFeature : mClass.getFeatures()) {
			EStructuralFeature eFeature = wrapMFeature(mFeature);
			if (eFeature == null) {
				continue;
			}
			eStructuralFeatures.add(eFeature);
		}
		
		// handle super types
		commands.add(new IMinEcoreCommand<Object>() {

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
		
		return eClass;
	}

	private EStructuralFeature wrapMFeature(MFeature mFeature) {
		EStructuralFeature eFeature;
		final MType mType = mFeature.getType();
		if (mType == null) {
			return null;
		}
		if (mType instanceof MClass) {
			// complex type, create reference
			final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			commands.add(new IMinEcoreCommand<Object>() {

				public boolean execute(Object context) {
					eReference.setEType((EClass) mapping.get(mType));
					return true;
				}
			});
			eReference.setContainment(!mFeature.isReference());
			eFeature = eReference;
		} else if (mType instanceof MDataType) {
			MDataType mDataType = (MDataType) mType;
			// primitive type, create attribute
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			eAttribute.setEType(mDataType.getEDataType());
			eFeature = eAttribute;
		} else if (mType instanceof MEnum) {
			final EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			commands.add(new IMinEcoreCommand<Object>() {

				public boolean execute(Object context) {
					eAttribute.setEType((EEnum) mapping.get(mType));
					return true;
				}
			});
			eFeature = eAttribute;
		} else {
			throw new RuntimeException("Found unknown subtype of MType: " + mType.eClass().getName());
		}
		setMulitplicity(mFeature, eFeature);
		mapping.put(mFeature, eFeature);
		eFeature.setName(mFeature.getName());
		return eFeature;
	}

	private void setMulitplicity(MFeature mFeature, EStructuralFeature eFeature) {
		MMultiplicity multiplicity = mFeature.getMultiplicity();
		if (multiplicity instanceof MSimpleMultiplicity) {
			MSimpleMultiplicity simpleMultiplicity = (MSimpleMultiplicity) multiplicity;
			MSimpleMultiplicityValue value = simpleMultiplicity.getValue();
			if (value == MSimpleMultiplicityValue.STAR) {
				setBounds(eFeature, 0, -1);
			} else if (value == MSimpleMultiplicityValue.PLUS) {
				setBounds(eFeature, 1, -1);
			} else if (value == MSimpleMultiplicityValue.OPTIONAL) {
				setBounds(eFeature, 0, 1);
			} else {
				setBounds(eFeature, 1, 1);
			}
		} else if (multiplicity instanceof MComplexMultiplicity) {
			MComplexMultiplicity complexMultiplicity = (MComplexMultiplicity) multiplicity;
			eFeature.setLowerBound(complexMultiplicity.getLowerBound());
			eFeature.setUpperBound(complexMultiplicity.getUpperBound());
		} else if (multiplicity == null) {
			setBounds(eFeature, 1, 1);
		}
	}

	private void setBounds(EStructuralFeature eFeature, int lower, int upper) {
		eFeature.setLowerBound(lower);
		eFeature.setUpperBound(upper);
	}
}
