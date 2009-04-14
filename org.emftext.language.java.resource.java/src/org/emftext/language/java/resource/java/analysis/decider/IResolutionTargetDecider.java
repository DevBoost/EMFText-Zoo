package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface IResolutionTargetDecider {
	
	/**
	 * Determines if the finder is of any use for the given resolving procedure.
	 * 
	 * @param referenceContainer
	 * @param containingReference
	 * @return
	 */
	boolean canFindTargetsFor(EObject referenceContainer, EReference crossReference);
	
	/**
	 * Determines if the decider needs to look into the given reference
	 * 
	 * @param container
	 * @param containingReference
	 * @return
	 */
	boolean containsCandidates(EObject container, EReference containingReference);
	
	boolean walkInto(EObject container, EReference containingReference);
	
	boolean isPossibleTarget(String id, EObject element);
	
	boolean isSure();
	
	boolean continueAfterReference();

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) ;
	
	
	
	void activate();
	
	void deactivate();
	
	boolean isActive();
}
