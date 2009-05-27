package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.generics.TypeParameterUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class ClassifierUtil {
	
	/**
	 * Returns all members of the given classifier including inner classes and 
	 * all members of super types (extended classes and implemented interfaces).
	 * 
	 * @param _this
	 * @param context to check protected visibility
	 * @return member list
	 */
	public static EList<Member> getAllMembers(Classifier _this, Commentable context) {
		EList<Member> memberList = new BasicEList<Member>();
		if (_this == null) {
			return memberList;
		}
		
		if (_this instanceof ConcreteClassifier) {
			ConcreteClassifier concreteClassifier = (ConcreteClassifier) _this;
			memberList.addAll(concreteClassifier.getMembers());
			memberList.addAll(concreteClassifier.getDefaultMembers());
			//because inner classes are found in separate class files
			memberList.addAll(ConcreteClassifierUtil.getAllInnerClassifiers(concreteClassifier));
		}
		
		EList<EObject> possiblyVisibleSuperClassifier = ECollections.emptyEList();
		if (_this instanceof TypeParameter) {
			possiblyVisibleSuperClassifier = new BasicEList<EObject>();
			for(TypeReference typeReference : ((TypeParameter)_this).getExtendTypes()) {
				possiblyVisibleSuperClassifier.add(TypeReferenceUtil.getTarget(typeReference));
			}
		}
		
		for (ConcreteClassifier superClassifier : ClassifierUtil.getAllSuperClassifiers(_this)) {
			for(Member member : superClassifier.getMembers()) {
				if(member instanceof AnnotableAndModifiable) {					
					AnnotableAndModifiable modifiable = (AnnotableAndModifiable) member;

					if(!ModifiableUtil.isHidden(modifiable, context)) {
						memberList.add(member);
					}
					else if (possiblyVisibleSuperClassifier.contains(superClassifier)) {
						memberList.add(member);
					}
				}
				else {
					memberList.add(member);
				}
			}
			memberList.addAll(superClassifier.getDefaultMembers());
		}
		return memberList;
	}
	
	public static EList<ConcreteClassifier> getAllSuperClassifiers(Classifier _this) {
		EList<ConcreteClassifier> superClassifierList = new BasicEList<ConcreteClassifier>();
		if(_this == null) {
			return superClassifierList;
		}

		if (_this instanceof Class) {
			Class javaClass = (Class) _this;
			ClassUtil.collectAllSuperClassifiers(javaClass, superClassifierList);
		} else if (_this instanceof Interface) {
			Interface javaInterface = (Interface) _this;
			superClassifierList.addAll(InterfaceUtil.getAllSuperInterfaces(javaInterface.getExtends()));
			superClassifierList.addAll(InterfaceUtil.getAllSuperInterfaces(javaInterface.getDefaultExtends()));
		} else if (_this instanceof Annotation) {
			superClassifierList.add(JavaClasspathUtil.getAnnotationClass(_this));
		} else if (_this instanceof Enumeration) {
			Enumeration enumeration = (Enumeration) _this;
			superClassifierList.addAll(InterfaceUtil.getAllSuperInterfaces(enumeration.getImplements()));
			//enumerations inherit from java.lang.Enum
			Class enumClass = JavaClasspathUtil.getClass("Enum", _this);
			superClassifierList.add(enumClass);
			ClassUtil.collectAllSuperClassifiers(enumClass, superClassifierList);
			
		} else if (_this instanceof TypeParameter) {
			TypeParameter typeParameter = (TypeParameter) _this;
			TypeParameterUtil.collectAllSuperClassifiers(typeParameter, superClassifierList);
		} else if (_this instanceof TypeParameterUtil.TemporalCompositeClassImpl) {
			for(Classifier superType : ((TypeParameterUtil.TemporalCompositeClassImpl)_this).getSuperTypes()) {
				superClassifierList.addAll(getAllSuperClassifiers(superType));
			}
		}

		return superClassifierList;
	}
}
