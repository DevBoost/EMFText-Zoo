package org.emftext.language.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.core.CompilationUnit;

public class JavaUniquePathConstructor {
	
	public static final String CLASSIFIERS_ROOT_PATH_PREFIX = "//@classifiers[name='";
	public static final String CLASSIFIERS_SUB_PATH_PREFIX  = "/@members[name='";
	public static final String CLASSIFIERS_PATH_SUFIX  = "']";
	
	public static final String PACKAGE_SEPARATOR = "."; 
	public static final String CLASSIFIER_SEPARATOR   = "$";
		
	public static final String JAVA_CLASSIFIER_PATHMAP   = "pathmap://javaclass/";
	public static final String JAVA_PACKAGE_PATHMAP = "pathmap://javapackage/";
	
	public static URI getJavaFileResourceURI(String fullQualifiedName) {
		String logicalUriString = JAVA_CLASSIFIER_PATHMAP;
		logicalUriString = logicalUriString + fullQualifiedName + ".java";
		
		return URI.createURI(logicalUriString);
	}
	
	public static URI getClassifierURI(String fullQualifiedName) {
		URI logicalUri = getJavaFileResourceURI(fullQualifiedName);
		
		String classesPart = fullQualifiedName;
		int idx = fullQualifiedName.lastIndexOf(".");
		if (idx >= 0) {
			classesPart = classesPart.substring(idx + 1);
		}
		String[] classNames = classesPart.split("\\" + CLASSIFIER_SEPARATOR);
		
		String uriFragment = "";
		for(int i = 0; i < classNames.length; i++) {
			if (i == 0) {
				uriFragment = uriFragment + CLASSIFIERS_ROOT_PATH_PREFIX;
			}
			else {
				uriFragment = uriFragment + CLASSIFIERS_SUB_PATH_PREFIX;
			}
			uriFragment = uriFragment + classNames[i] + CLASSIFIERS_PATH_SUFIX;
		}
		
		logicalUri = logicalUri.appendFragment(
				uriFragment);
		return logicalUri;
	}
	
	public static boolean pointsAtClassifie(URI proxyURI, String classifierName) {
		if(!proxyURI.fragment().startsWith(CLASSIFIERS_ROOT_PATH_PREFIX)) {
			return false;
		}
		String nameInProxy = proxyURI.fragment().substring(CLASSIFIERS_ROOT_PATH_PREFIX.length());
		nameInProxy = nameInProxy.substring(0, nameInProxy.length() - CLASSIFIERS_PATH_SUFIX.length());
		return nameInProxy.equals(classifierName);
	}

	public static String packageName(CompilationUnit cu) {
		EList<String> packageNameSegements = cu.getPackage();
		String packageName = packageName(packageNameSegements);
		
		if (packageName == null) {
			packageName = "";
		}
		return packageName;
	}

	private static String packageName(EList<String> packageNameSegements) {
		String packageName = null;
		for(String packageNamePart : packageNameSegements) {
			if (packageName == null) {
				packageName = packageNamePart;
			}
			else {
				packageName = packageName + PACKAGE_SEPARATOR + packageNamePart;
			}
		}
		return packageName;
	}
}
