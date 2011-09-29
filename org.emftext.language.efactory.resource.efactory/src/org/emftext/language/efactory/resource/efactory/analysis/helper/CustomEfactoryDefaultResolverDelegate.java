package org.emftext.language.efactory.resource.efactory.analysis.helper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.efactory.NewObject;
import org.emftext.language.efactory.resource.efactory.analysis.EfactoryDefaultResolverDelegate;


public class CustomEfactoryDefaultResolverDelegate<ContainerType extends EObject, ReferenceType extends EObject> extends
		EfactoryDefaultResolverDelegate<ContainerType, ReferenceType> {

	@Override
	protected boolean hasCorrectEType(EObject element, EClass expectedTypeEClass) {
		EClass targetType = null;
		if (element instanceof NewObject) {
			targetType = ((NewObject) element).getEClass();
		} else {
			targetType = element.eClass();
		}
		
		if (targetType.equals(expectedTypeEClass)) {
			return true;
		}
		
		for (EClass superEClass : targetType.getEAllSuperTypes()) {
			if (superEClass.equals(expectedTypeEClass)) {
				return true;
			}
		}
		
		return false;
	}
}
