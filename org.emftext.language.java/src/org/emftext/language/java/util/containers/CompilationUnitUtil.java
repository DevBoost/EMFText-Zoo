package org.emftext.language.java.util.containers;

import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.util.JavaUtil;

public class CompilationUnitUtil {
	
	public static Classifier getClassifier(CompilationUnit _this, String name) {
		for(Classifier candidate : _this.getClassifiers()) {
			if(JavaUtil.getName(candidate).equals(name)) {
				return candidate;
			}
		}
		return null;
	}

}
