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
