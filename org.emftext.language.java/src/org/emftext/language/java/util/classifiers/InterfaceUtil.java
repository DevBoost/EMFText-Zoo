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
package org.emftext.language.java.util.classifiers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class InterfaceUtil {

	/**
	 * Recursively collects all interfaces implemented 
	 * by the given list of references to interfaces.
	 * 
	 * @param interfaceReferences a list of references to interfaces
	 * @param resultInterfaceList the list with the result
	 */
	public static EList<ConcreteClassifier> getAllSuperInterfaces(EList<TypeReference> interfaceReferences) {
		EList<EList<ConcreteClassifier>> resultInterfaceList = new BasicEList<EList<ConcreteClassifier>>();
		collectAllSuperInterfaces(interfaceReferences, resultInterfaceList, 0);
		EList<ConcreteClassifier> completeResult = new BasicEList<ConcreteClassifier>();
		for(EList<ConcreteClassifier> levelList : resultInterfaceList) {
			completeResult.addAll(levelList);
		}
		return completeResult;
	}

	public static void collectAllSuperInterfaces(EList<TypeReference> interfaceReferences,
		EList<EList<ConcreteClassifier>> resultInterfaceList, int level) {
	
		EList<ConcreteClassifier> levelList;
		if(level < resultInterfaceList.size()) {
			levelList = resultInterfaceList.get(level);
		}
		else {
			levelList = new BasicEList<ConcreteClassifier>();
			resultInterfaceList.add(levelList);
		}

		
		for (TypeReference typeArg : interfaceReferences) {
			//use ConcreteClassifier instead of Interface because java.lang.Object can also act as implemented interface
			ConcreteClassifier superInterface = (ConcreteClassifier) TypeReferenceUtil.getTarget(typeArg, null);
			if (superInterface != null) {
				levelList.add(superInterface);
				if (superInterface instanceof Interface) {
					collectAllSuperInterfaces(
							((Interface)superInterface).getExtends(), resultInterfaceList, level + 1);
					collectAllSuperInterfaces(
							((Interface)superInterface).getDefaultExtends(), resultInterfaceList, level + 1);
				}
			}
		}
	}
	
}
