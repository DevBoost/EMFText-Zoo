/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.commons.NamespaceAwareElement;

/**
 * This provides functionality to construct unique identifier 
 * (i.e., logical URI strings) for Java classes represented as EMF-models.
 */
public class JavaUniquePathConstructor {
	
	/**
	 * Pathmap (URI scheme + first segment) for Java classes.
	 */
	public static final String JAVA_CLASSIFIER_PATHMAP = "pathmap:/javaclass/";
	
	/**
	 * Pathmap (URI scheme + first segment) for Java classes.
	 */
	public static final String JAVA_PACKAGE_PATHMAP    = "pathmap:/javapackage/";
	
	/**
	 * Start of a URI fragment part pointing at a classifier contained in a 
	 * compilation unit.
	 */
	public static final String CLASSIFIERS_ROOT_PATH_PREFIX = "@classifiers[name='";
	
	/**
	 * Start of a URI fragment part pointing at a classifier contained as member in 
	 * another classifier.
	 */
	public static final String CLASSIFIERS_SUB_PATH_PREFIX  = "@members[name='";
	
	/**
	 * End of a URI fragment part.
	 */
	public static final String CLASSIFIERS_PATH_SUFIX       = "']";
	
	/**
	 * Java's separator for package names (.).
	 */
	public static final String PACKAGE_SEPARATOR    = "."; 
	
	/**
	 * Java's separator for classifier names ($).
	 */
	public static final String CLASSIFIER_SEPARATOR = "$";

	/**
	 * Constructs an URI from a fully qualified classifier name
	 * pointing at the resource containing the classifier.
	 * 
	 * @param fullQualifiedName
	 * @return the logical URI for the classifier
	 */
	public static URI getJavaFileResourceURI(String fullQualifiedName) {
		String logicalUriString = JAVA_CLASSIFIER_PATHMAP;
		logicalUriString = logicalUriString + fullQualifiedName + ".java";
		
		return URI.createURI(logicalUriString);
	}
	
	/**
	 * Constructs an URI from a fully qualified classifier name
	 * pointing at the file containing the classifier and the classifier
	 * itself inside the EMF-model constructed from that resource.
	 * 
	 * @param fullQualifiedName
	 * @return the logical URI for the classifier
	 */
	public static URI getClassifierURI(String fullQualifiedName) {
		URI logicalUri = getJavaFileResourceURI(fullQualifiedName);
		
		String classesPart = fullQualifiedName;
		int idx = fullQualifiedName.lastIndexOf(PACKAGE_SEPARATOR);
		if (idx >= 0) {
			classesPart = classesPart.substring(idx + 1);
		}
		String[] classNames = classesPart.split("\\" + CLASSIFIER_SEPARATOR);
		
		String uriFragment = "";
		for(int i = 0; i < classNames.length; i++) {
			if (i == 0) {
				uriFragment = uriFragment + "//" + CLASSIFIERS_ROOT_PATH_PREFIX;
			}
			else {
				uriFragment = uriFragment + "/" + CLASSIFIERS_SUB_PATH_PREFIX;
			}
			uriFragment = uriFragment + classNames[i] + CLASSIFIERS_PATH_SUFIX;
		}
		
		logicalUri = logicalUri.appendFragment(
				uriFragment);
		return logicalUri;
	}
	
	/**
	 * Returns a simple name (i.e., last segment) for a given fully
	 * qualified name
	 * 
	 * @param fullQualifiedName
	 * @return simple name string
	 */
	public static String getSimpleClassName(String fullQualifiedName) {
		int idx1 = fullQualifiedName.lastIndexOf(PACKAGE_SEPARATOR);
		int idx2 = fullQualifiedName.lastIndexOf(CLASSIFIER_SEPARATOR);
		if (idx1 == -1 && idx2 == -1) {
			return fullQualifiedName;
		}
		if (idx1 > idx2) {
			return fullQualifiedName.substring(idx1 + 1);
		}
		else {
			return fullQualifiedName.substring(idx2 + 1);
		}
	}

	/**
	 * Constructs a single string representation of the given element's
	 * namespace, assuming that the namespace points at a package 
	 * (and not a classifier).
	 * 
	 * @param nsaElement
	 * @return
	 */
	public static String packageName(NamespaceAwareElement nsaElement) {
		EList<String> packageNameSegements = nsaElement.getNamespaces();
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
