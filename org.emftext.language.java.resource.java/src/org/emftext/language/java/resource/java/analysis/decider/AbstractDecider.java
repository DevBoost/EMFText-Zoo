package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public abstract class AbstractDecider implements IResolutionTargetDecider {

	protected boolean active = true;
	
	public boolean continueAfterReference() {
		return true;
	}
	
	public boolean walkInto(EObject container, EReference containingReference) {
		return false;
	}
	
	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container)  {
		return null;
	}
	
	public boolean isSure() {
		return true;
	}
	
	
	public void activate() {
		active = true;		
	}

	public void deactivate() {
		active = false;
	}

	public boolean isActive() {
		return active;
	}
}
