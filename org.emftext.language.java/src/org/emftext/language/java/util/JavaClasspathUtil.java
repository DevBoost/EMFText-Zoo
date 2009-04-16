package org.emftext.language.java.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;

/**
 * Utility methods to for common class path queries.
 */
public class JavaClasspathUtil {
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing the class with the given name located in <code>java.lang</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getClass(String name, EObject objectContext) {
		if (objectContext.eResource() == null) {
			throw new IllegalArgumentException("object context element must have a resource");
		}
		Class classClass = (Class) JavaClasspath.INSTANCE.getClassifier(
				"java.lang." + name);
		classClass = (Class) EcoreUtil.resolve(classClass, objectContext);
		return classClass;
	}
	
	public static Interface getInterface(String name, EObject objectContext) {
		if (objectContext.eResource() == null) {
			throw new IllegalArgumentException("object context element  must have a resource");
		}
		ConcreteClassifier classClass = JavaClasspath.INSTANCE.getClassifier(
				"java.lang." + name);
		return (Interface) EcoreUtil.resolve(classClass, objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.Class</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getClassClass(EObject objectContext)  {
		return getClass("Class", objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.Object</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getObjectClass(EObject objectContext)  {
		return getClass("Object", objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.String</code>.
	 * 
     * @param objectContext a context object whose resource set is used to obtain the class model element
	 * @return the Class
	 */
	public static Class getStringClass(EObject objectContext) {
		return getClass("String", objectContext);
	}
	

	

}
