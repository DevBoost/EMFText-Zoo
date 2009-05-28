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
package org.emftext.language.java.util.containers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;

/**
 * A utility class that provides methods that belong to class 
 * JavaRoot, but can not go there, because JavaRoot 
 * is generated.
 */
public class JavaRootUtil {
	
	/**
	 * @param _this
	 * @return all classes in the same package imports
	 */
	public static EList<ConcreteClassifier> getClassifiersInSamePackage(JavaRoot _this) {
		EList<ConcreteClassifier> defaultImportList = new BasicEList<ConcreteClassifier>();
		
		String packageName = JavaUniquePathConstructor.packageName(_this);

		//locally defined in this container
		if(_this instanceof CompilationUnit) {
			defaultImportList.addAll(((CompilationUnit)_this).getClassifiers());
		}
		
		defaultImportList.addAll(JavaClasspath.get(_this).getClassifiers(
				packageName + JavaUniquePathConstructor.PACKAGE_SEPARATOR, "*"));

		return defaultImportList;
	}
	
}
