package org.emftext.language.java.util.imports;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.imports.PackageImport;

public class PackageImportUtil {

	public static EList<ConcreteClassifier> getImportedClassifiers(PackageImport _this) {
		EList<ConcreteClassifier> importedClassifiers =  
			JavaClasspath.INSTANCE.getClassifiers(_this);
		
		return importedClassifiers;
	}
}
