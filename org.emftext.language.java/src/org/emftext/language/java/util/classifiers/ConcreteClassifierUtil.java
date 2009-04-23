package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;

public class ConcreteClassifierUtil {
	
	public static EList<ConcreteClassifier> getAllInnerClassifiers(ConcreteClassifier _this) {
		EList<ConcreteClassifier> internalClassifierList = new BasicEList<ConcreteClassifier>();
		
		internalClassifierList.addAll(
				JavaClasspath.get(_this).getInnnerClassifiers(_this));
		
		for(ConcreteClassifier superClassifier : ClassifierUtil.getAllSuperClassifiers(_this)) {
			internalClassifierList.addAll(
					JavaClasspath.get(_this).getInnnerClassifiers(superClassifier));
		}
		
		return internalClassifierList;
	}
	
	public static EList<ClassifierReference> getSuperTypeReferences(ConcreteClassifier _this) {
		EList<ClassifierReference> typeReferenceList = new BasicEList<ClassifierReference>();
		if(_this == null) {
			return typeReferenceList;
		}

		if (_this instanceof Class) {
			Class javaClass = (Class) _this;
			typeReferenceList.add(ClassifierReferenceUtil.getPureClassifierReference(javaClass.getExtends()));
			for(TypeReference interfaceReference : javaClass.getImplements()) {
				typeReferenceList.add(ClassifierReferenceUtil.getPureClassifierReference(interfaceReference));
			}
		} else if (_this instanceof Interface) {
			Interface javaInterface = (Interface) _this;
			for(TypeReference interfaceReference : javaInterface.getExtends()) {
				typeReferenceList.add(ClassifierReferenceUtil.getPureClassifierReference(interfaceReference));
			}
		}
		return typeReferenceList;
	}
	
}
