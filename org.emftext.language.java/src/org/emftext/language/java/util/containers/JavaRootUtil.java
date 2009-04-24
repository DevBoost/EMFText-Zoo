package org.emftext.language.java.util.containers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.JavaRoot;

public class JavaRootUtil {
	
	/**
	 * @param _this
	 * @return all classes in the same package imports
	 */
	public static EList<ConcreteClassifier> getClassifiersInSamePackage(JavaRoot _this) {
		EList<ConcreteClassifier> defaultImportList = new BasicEList<ConcreteClassifier>();
		
		String packageName = JavaUniquePathConstructor.packageName(_this);
		
		if(!packageName.equals("")) {
			defaultImportList.addAll(JavaClasspath.get(_this).getClassifiers(
					packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR, "*"));
		}

		if(packageName.equals("")) {
			//put the package behind the default imports when the default package is used
			
			//TODO this works for tests; Is this the desired behavior? Usually default package is not used
			defaultImportList.addAll(JavaClasspath.get(_this).getClassifiers(
					packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR, "*"));
		}
		
		return defaultImportList;
	}
	
	/**
	 * @param _this
	 * @return all default imports (<code>java.lang</code>)
	 */
	public static EList<ConcreteClassifier> getDefaultImports(JavaRoot _this) {
		return JavaClasspath.get(_this).getDefaultImports();
	}

}
