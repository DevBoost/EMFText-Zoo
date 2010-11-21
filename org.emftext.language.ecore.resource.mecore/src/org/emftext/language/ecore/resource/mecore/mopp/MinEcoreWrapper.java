package org.emftext.language.ecore.resource.mecore.mopp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.emftext.language.ecore.resource.mecore.IMinEcoreCommand;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MClassifier;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MModelElement;
import org.emftext.language.mecore.MPackage;
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
		}
		return null;
	}

	private EClassifier wrapMClass(MClass mClass) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		mapping.put(mClass, eClass);
		eClass.setName(mClass.getName());
		
		EList<EStructuralFeature> eStructuralFeatures = eClass.getEStructuralFeatures();
		for (MFeature mFeature : mClass.getFeatures()) {
			eStructuralFeatures.add(wrapMFeature(mFeature));
		}
		return eClass;
	}

	private EStructuralFeature wrapMFeature(MFeature mFeature) {
		EStructuralFeature eFeature;
		final MType mType = mFeature.getType();
		if (mType instanceof MClass) {
			// complex type, create reference
			final EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			commands.add(new IMinEcoreCommand<Object>() {

				public boolean execute(Object context) {
					eReference.setEType((EClassifier) mapping.get(mType));
					return true;
				}
			});
			eFeature = eReference;
		} else if (mType instanceof MDataType) {
			MDataType mDataType = (MDataType) mType;
			// primitive type, create attribute
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			eAttribute.setEType(mDataType.getEDataType());
			eFeature = eAttribute;
		} else {
			throw new RuntimeException("Found unknown subtype of MType: " + mType.eClass().getName());
		}
		mapping.put(mFeature, eFeature);
		eFeature.setName(mFeature.getName());
		return eFeature;
	}
}
