package org.emftext.language.java.util.imports;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.util.classifiers.ClassifierUtil;

public class ImportUtil {

	/**
	 * Returns the classifier with the given name 
	 * located in the namespace defined by the import.
	 * 
	 * @param _this
	 * @param classifierName the name of the classifier
	 * @return imported classifier (proxy)
	 */
	public static ConcreteClassifier getClassifier(Import _this, String classifierName) {
		String containerName = JavaClasspath.get(_this).getContainerNameFromNamespace(_this);
		if (containerName == null) {
			return null;
		}
		
		String fullQualifiedName = containerName + classifierName;
		return JavaClasspath.get(_this).getClassifier(fullQualifiedName);
	}

	/**
	 * Returns the imported classifier assuming the import's namespace
	 * identifies a classifier.
	 * 
	 * @param _this 
	 * @return list of imported classifiers (proxies)
	 */
	public static ConcreteClassifier getClassifier(Import _this) {
		String fullQualifiedName = JavaClasspath.get(_this).getContainerNameFromNamespace(_this);
		if (fullQualifiedName == null || fullQualifiedName.endsWith(JavaUniquePathConstructor.PACKAGE_SEPARATOR)) {
			return null;
		}
		//cut the trailing separator
		fullQualifiedName = fullQualifiedName.substring(0,fullQualifiedName.length() - 1);
		
		return (ConcreteClassifier) EcoreUtil.resolve(
				JavaClasspath.get(_this).getClassifier(fullQualifiedName), _this);
	}
	
	/**
	 * Returns all imported members assuming the import's namespace
	 * identifies a classifier.
	 * 
	 * @param _this 
	 * @return list of imported classifiers (proxies)
	 */
	public static EList<Member> getMemberList(Import _this) {
		ConcreteClassifier concreteClassifier = getClassifier(_this);
		
		if(concreteClassifier == null || concreteClassifier.eIsProxy()) {
			return ECollections.emptyEList();
		}
		
		return ClassifierUtil.getAllMembers(concreteClassifier);
	}
	
	/**
	 * Returns a list of imported classifiers assuming the import's namespace
	 * identifies a package.
	 * 
	 * @param _this 
	 * @return imported classifier (proxy)
	 */
	public static EList<ConcreteClassifier> getClassifierList(Import _this) {
		String containerName = JavaClasspath.get(_this).getContainerNameFromNamespace(_this);
		if (containerName == null) {
			return ECollections.emptyEList();
		}
		
		return JavaClasspath.get(_this).getClassifiers(containerName, "*");
	}

}
