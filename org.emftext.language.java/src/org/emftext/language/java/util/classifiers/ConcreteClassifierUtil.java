package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;

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
	
}
