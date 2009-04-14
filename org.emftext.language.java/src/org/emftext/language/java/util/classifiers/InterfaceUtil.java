package org.emftext.language.java.util.classifiers;

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
	 * @param resultInterfaceList the list with the reuslt
	 * @
	 */
	public static void collectAllSuperInterfaces(EList<TypeReference> interfaceReferences,
		EList<ConcreteClassifier> resultInterfaceList) {
	
		for (TypeReference typeArg : interfaceReferences) {
			//use ConcreteClassifier instead of Interface because java.lang.Object can also act as implemented interface
			ConcreteClassifier superInterface = (ConcreteClassifier) TypeReferenceUtil.getTarget(typeArg, null);
			if (superInterface != null) {
				resultInterfaceList.add(superInterface);
				if (superInterface instanceof Interface) {
					collectAllSuperInterfaces(
							((Interface)superInterface).getExtends(), resultInterfaceList);
					collectAllSuperInterfaces(
							((Interface)superInterface).getDefaultExtends(), resultInterfaceList);
				}
			}
		}
	}
	
}
