package org.emftext.language.java;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.core.CompilationUnit;

public class JavaUniquePathConstructor {
	
	private static final String CLASSIFIERS_PATH_PREFIX = "//@classifiers[name='";
	private static final String PATH_SUFIX = "']";
	
	public static final String JAVA_PATHMAP = "pathmap://java/";
	public static final String DEFAULT_PACKAGE_NAME = "default";
	
	public static String convertClassifierURIToFragmentPart(URI proxyURI) {
		return proxyURI.toString().substring(JAVA_PATHMAP.length());
	}

	public static URI getClassifierResourceURI(String packageName, String name) {
		//TODO construct different if the packageName contains Classes and name points at an inner class
		URI logicalUriString = 
			URI.createURI(JAVA_PATHMAP + packageName + "/" + name + ".java");
		
		return logicalUriString;
	}
	
	public static URI getClassifierURI(String packageName, String name) {
		URI logicalUriString = getClassifierResourceURI(packageName, name);
		//TODO construct different if the packageName contains Classes and name points at an inner class
		logicalUriString = logicalUriString.appendFragment(CLASSIFIERS_PATH_PREFIX + name + PATH_SUFIX);
		return logicalUriString;
	}
	
	public static boolean pointsAtClassifie(URI proxyURI, String classifierName) {
		if(!proxyURI.fragment().startsWith(CLASSIFIERS_PATH_PREFIX)) {
			return false;
		}
		String nameInProxy = proxyURI.fragment().substring(CLASSIFIERS_PATH_PREFIX.length());
		nameInProxy = nameInProxy.substring(0, nameInProxy.length() - PATH_SUFIX.length());
		return nameInProxy.equals(classifierName);
	}

	public static String packageName(CompilationUnit cu) {
		String packageName = null;
		for(String packageNameFragment : cu.getPackage()) {
			if (packageName == null) {
				packageName = packageNameFragment;
			}
			else {
				packageName = packageName + "." + packageNameFragment;
			}
		}
		
		if (packageName == null) {
			packageName = DEFAULT_PACKAGE_NAME;
		}
		return packageName;
	}
}
