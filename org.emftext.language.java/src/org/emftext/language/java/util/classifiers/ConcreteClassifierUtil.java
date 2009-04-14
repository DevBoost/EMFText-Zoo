package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.generics.TypeParameterUtil;

public class ConcreteClassifierUtil {
	
	public static EList<ConcreteClassifier> getAllSuperClassifiers(ConcreteClassifier _this) {
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
		if(_this == null) {
			return superClassifierList;
		}

		if (_this instanceof Class) {
			Class javaClass = (Class) _this;
			ClassUtil.collectAllSuperClassifiers(javaClass, superClassifierList);
		} else if (_this instanceof Interface) {
			Interface javaInterface = (Interface) _this;
			InterfaceUtil.collectAllSuperInterfaces(javaInterface.getExtends(), superClassifierList);
		} else if (_this instanceof Annotation) {
			superClassifierList.add(JavaClasspathUtil.getObjectClass(_this));
		} else if (_this instanceof Enumeration) {
			Enumeration enumeration = (Enumeration) _this;
			InterfaceUtil.collectAllSuperInterfaces(enumeration.getImplements(), superClassifierList);
			//enumerations inherit from java.lang.Enum
			Class enumClass = JavaClasspathUtil.getClass("Enum", _this);
			superClassifierList.add(enumClass);
			ClassUtil.collectAllSuperClassifiers(enumClass, superClassifierList);
			
		} else if (_this instanceof TypeParameter) {
			TypeParameter typeParameter = (TypeParameter) _this;
			TypeParameterUtil.collectAllSuperClassifiers(typeParameter, superClassifierList);
		}

		return superClassifierList;
	}

	
	/**
	 * Returns all members of the given classifier including inner classes and 
	 * all members of super types (extended classes and implemented interfaces).
	 * 
	 * @param _this
	 * @return member list
	 */
	public static EList<Member> getAllMembers(ConcreteClassifier _this) {
		EList<Member> memberList = new BasicEList<Member>();
		if (_this == null) {
			return memberList;
		}
		
		memberList.addAll(_this.getDefaultMembers());
		
		//because inner classes are found in separate class files
		memberList.addAll(
				JavaClasspath.INSTANCE.getInternalClassifiers(_this));

		for (ConcreteClassifier superClassifier : getAllSuperClassifiers(_this)) {
			memberList.addAll(superClassifier.getMembers());
			memberList.addAll(
					JavaClasspath.INSTANCE.getInternalClassifiers(superClassifier));
		}
		return memberList;
	}
	
	public static EList<ConcreteClassifier> getAllInnerClassifiers(ConcreteClassifier _this) {
		EList<ConcreteClassifier> internalClassifierList = new BasicEList<ConcreteClassifier>();
		
		internalClassifierList.addAll(
				JavaClasspath.INSTANCE.getInternalClassifiers(_this));
		
		for(ConcreteClassifier superClassifier : getAllSuperClassifiers(_this)) {
			internalClassifierList.addAll(
					JavaClasspath.INSTANCE.getInternalClassifiers(superClassifier));
		}
		
		return internalClassifierList;
	}
	
}
