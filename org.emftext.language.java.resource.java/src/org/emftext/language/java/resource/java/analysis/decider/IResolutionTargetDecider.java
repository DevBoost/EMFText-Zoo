package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IResolutionTargetDecider {
	
	boolean canFindTargetsFor(EObject referenceContainer, EReference containingReference);
	
	boolean isPossibleTarget(String id, EObject element);
	
	boolean lookInto(EObject container, EReference containingReference);
	
	boolean continueAfterReference();

	EList<? extends EObject> getAdditionalCandidates(EObject container);
}
