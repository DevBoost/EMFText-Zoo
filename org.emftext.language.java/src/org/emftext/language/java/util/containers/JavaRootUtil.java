package org.emftext.language.java.util.containers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;

public class JavaRootUtil {
	
	/**
	 * @param _this
	 * @return all classes in the same package imports
	 */
	public static EList<ConcreteClassifier> getClassifiersInSamePackage(JavaRoot _this) {
		EList<ConcreteClassifier> defaultImportList = new BasicEList<ConcreteClassifier>();
		
		String packageName = JavaUniquePathConstructor.packageName(_this);

		//locally defined in this container
		if(_this instanceof CompilationUnit) {
			defaultImportList.addAll(((CompilationUnit)_this).getClassifiers());
		}
		
		defaultImportList.addAll(JavaClasspath.get(_this).getClassifiers(
				packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR, "*"));

		return defaultImportList;
	}
	
}
