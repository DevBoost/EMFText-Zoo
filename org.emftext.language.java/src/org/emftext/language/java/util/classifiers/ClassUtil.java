package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class ClassUtil {
	
	/**
	 * Recursively collects  all super types (extended classes and implemented interfaces)
	 * of the given class.
	 * 
	 * @param _this the class
	 * @param resultClassifierList the list for the result
	 */
	public static void collectAllSuperClassifiers(Class _this, 
			EList<ConcreteClassifier> classifierList) {
		
		//collects all superclasses
		Class superClass =  _this;
		while (superClass != null && !superClass.eIsProxy() && 
				!superClass.equals(JavaClasspathUtil.getObjectClass(_this))) {
			TypeReference superClassReference = superClass.getExtends();
			if (superClassReference == null) {
				superClassReference = superClass.getDefaultExtends();
			}
			superClass = (Class) TypeReferenceUtil.getTarget(superClassReference);
			if (superClass != null) {
				classifierList.add(superClass);
			}
		}
		
		EList<ConcreteClassifier> superClassList = 
			new BasicEList<ConcreteClassifier>(classifierList);
		
		//collect all implemented interfaces
		InterfaceUtil.collectAllSuperInterfaces(
				_this.getImplements(), classifierList);
		
		//collect all implemented interfaces of super classes
		for(Classifier superClassifier : superClassList) {
			if (superClassifier instanceof Class) {
				InterfaceUtil.collectAllSuperInterfaces(
					((Class)superClassifier).getImplements(), classifierList);
			}
		}
	}
	
	public static PrimitiveType unWrapPrimitiveType(Class _this) {	
		if (JavaClasspathUtil.getClass("Boolean", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createBoolean();
		}
		if (JavaClasspathUtil.getClass("Byte", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createByte();
		}
		if (JavaClasspathUtil.getClass("Character", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createChar();
		}
		if (JavaClasspathUtil.getClass("Float", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createFloat();
		}
		if (JavaClasspathUtil.getClass("Double", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createDouble();
		}
		if (JavaClasspathUtil.getClass("Integer", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createInt();
		}
		if (JavaClasspathUtil.getClass("Long", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createLong();
		}
		if (JavaClasspathUtil.getClass("Short", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createShort();
		}
		if (JavaClasspathUtil.getClass("Void", _this).equals(_this)) {
			return TypesFactory.eINSTANCE.createVoid();
		}
		return null;
	}

}
