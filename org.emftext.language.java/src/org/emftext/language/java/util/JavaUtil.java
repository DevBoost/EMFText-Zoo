package org.emftext.language.java.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;

/**
 * Convenient methods to navigate a Java model. 
 */
public class JavaUtil {

	/**
	 * @param objectContext
	 * @return all default imports (<code>java.lang</code>)
	 */
	public static EList<ConcreteClassifier> getDefaultImports(EObject objectContext) {
		return JavaClasspath.get(objectContext).getDefaultImports();
	}
	
	/**
	 * Finds the containing classifier for the given element.
	 * 
	 * @param value
	 * @return containing classifier
	 */
	public static ConcreteClassifier findContainingClassifier(EObject value) {
		while (!(value instanceof ConcreteClassifier) && value != null) {
			value = value.eContainer();
		}
		return (ConcreteClassifier) value;
	}
	
	/**
	 * Finds the containing anonymous class for the given element.
	 * 
	 * @param value
	 * @return containing anonymous class 
	 */
	public static AnonymousClass findContainingAnonymousClass(EObject value) {
		while (!(value instanceof AnonymousClass) 
				&& !(value instanceof ConcreteClassifier) //do not jump over other classifiers 
				&& value != null) {
			value = value.eContainer();
		}
		if (!(value instanceof AnonymousClass)) {
			return null;
		}
		return (AnonymousClass) value;
	}
	
	/**
	 * Finds the containing compilation unit for the given element.
	 * 
	 * @param value
	 * @return containing compilation unit
	 */
	public static CompilationUnit findContainingCompilationUnit(EObject value) {
		while (!(value instanceof CompilationUnit) && value != null) {
			value = value.eContainer();
		}
		return (CompilationUnit) value;
	}

	/**
	 * Finds the containing annotation instance for the given element.
	 * 
	 * @param value
	 * @return containing annotation instance
	 */
	public static AnnotationInstance findContainingAnnotationInstance(EObject value) {
		while (!(value instanceof AnnotationInstance) && value != null) {
			value = value.eContainer();
		}
		return (AnnotationInstance) value;
	}
}
