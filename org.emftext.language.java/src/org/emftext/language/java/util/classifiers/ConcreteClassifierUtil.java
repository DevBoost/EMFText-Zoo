package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;

public class ConcreteClassifierUtil {
	
	public static EList<ConcreteClassifier> getAllInnerClassifiers(ConcreteClassifier _this) {
		EList<ConcreteClassifier> innerClassifierList = new BasicEList<ConcreteClassifier>();
		
		innerClassifierList.addAll(
				JavaClasspath.get(_this).getInnnerClassifiers(_this));
		
		for(ConcreteClassifier superClassifier : ClassifierUtil.getAllSuperClassifiers(_this)) {
			EList<ConcreteClassifier> superInnerList = 
				JavaClasspath.get(_this).getInnnerClassifiers(superClassifier);
			
			for(ConcreteClassifier superInner : superInnerList) {
				if (superInner.eIsProxy()) {
					superInner = (ConcreteClassifier) EcoreUtil.resolve(superInner, _this);
				}
				if(!ModifiableUtil.isHidden(superInner, _this)) {
					innerClassifierList.add(superInner);
				}
			}
		}
		
		return innerClassifierList;
	}
	
	public static EList<ClassifierReference> getSuperTypeReferences(ConcreteClassifier _this) {
		EList<ClassifierReference> typeReferenceList = new BasicEList<ClassifierReference>();
		if(_this == null) {
			return typeReferenceList;
		}

		if (_this instanceof Class) {
			Class javaClass = (Class) _this;
			if (javaClass.getExtends() != null) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(javaClass.getExtends());
				typeReferenceList.add(classifierReference);
				ConcreteClassifier target = (ConcreteClassifier) classifierReference.getTarget();
				if (!target.equals(JavaClasspathUtil.getObjectClass(_this))) {
					typeReferenceList.addAll(getSuperTypeReferences(target));
				}
			}	
			for(TypeReference interfaceReference : javaClass.getImplements()) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(interfaceReference);
				typeReferenceList.add(classifierReference);
				typeReferenceList.addAll(getSuperTypeReferences((ConcreteClassifier) classifierReference.getTarget()));
			}
		} else if (_this instanceof Interface) {
			Interface javaInterface = (Interface) _this;
			for(TypeReference interfaceReference : javaInterface.getExtends()) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(interfaceReference);
				typeReferenceList.add(classifierReference);
				typeReferenceList.addAll(getSuperTypeReferences((ConcreteClassifier) classifierReference.getTarget()));
			}
		}
		return typeReferenceList;
	}
	
}
