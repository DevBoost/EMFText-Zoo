package org.emftext.language.java.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Class;

/**
 * Utility methods to for common class path queries.
 * 
 */
public class JavaClasspathUtil {
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing the class with the given name located in <code>java.lang</code>.
	 * @param resourceSet the resource set in which the Class is or will be loaded
	 * 
	 * @return the Class
	 */
	public static Class getClass(String name, EObject objectContext) {
		Class classClass = (Class) JavaClasspath.INSTANCE.getClassifier(
				"java.lang." + name);
		classClass = (Class) EcoreUtil.resolve(classClass, objectContext);
		return classClass;
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.Class</code>.
	 * 
	 * @param resourceSet the resource set in which the Class is or will be loaded
	 * @return the Class
	 */
	public static Class getClassClass(EObject objectContext)  {
		return getClass("Class", objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.Object</code>.
	 * 
	 * @param resourceSet the resource set in which the Class is or will be loaded
	 * @return the Class
	 */
	public static Class getObjectClass(EObject objectContext)  {
		return getClass("Object", objectContext);
	}
	
	/**
	 * Finds the <code>org.emftext.language.java.classifiers.Class</code>
	 * representing <code>java.lang.String</code>.
	 * 
	 * @param resourceSet the resource set in which the Class is or will be loaded
	 * @return the Class
	 */
	public static Class getStringClass(EObject objectContext) {
		return getClass("String", objectContext);
	}
	

	

}
