package org.emftext.language.java.resource.java.analysis.helper;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;

public class ScopedTreeWalker {
	
	protected List<IResolutionTargetDecider> deciderList;
	
	private EObject currentBestResult = null;
	private boolean finished = false;
	
	public ScopedTreeWalker(List<IResolutionTargetDecider> deciderList) {
		this.deciderList = deciderList;
	}
	
	private void doWalk(String identifier, EObject startingPoint, EReference navOrigin, int posInNavOrigin) {

		searchInDirectChildren(identifier, startingPoint, navOrigin, posInNavOrigin);
		if(finished) {
			return;
		}
		
		for(IResolutionTargetDecider decider : deciderList) {
			if (decider.isActive()) {
				walkDown(decider, identifier, startingPoint, navOrigin, posInNavOrigin);
			}
		}
		if(finished) {
			return;
		}
		
		walkUp(identifier, startingPoint);
	}

	private void walkUp(String identifier, EObject container) {
		//walk up
		if (container.eContainer() != null) {
			EReference navOrigin = container.eContainmentFeature();
			int posInNavOrigin = 0;
			if (navOrigin.isMany()) {
				EList<?> value = (EList<?>)container.eContainer().eGet(navOrigin);
				posInNavOrigin = value.indexOf(container);
			}
			
			doWalk(identifier, container.eContainer(), navOrigin, posInNavOrigin);
		}
	}
	
	private void walkDown(IResolutionTargetDecider decider, String identifier, EObject container, EReference navOrigin, int posInNavOrigin) {
		EClass containerClass = container.eClass();
		
		for(EReference reference : containerClass.getEAllReferences()) {
			if(reference.isContainment()) {
				EList<EObject> contentList = null;
				if (decider.continueAfterReference()) {
					contentList = getContentList(container, reference, null, -1);
				}
				else {
					contentList = getContentList(container, reference, navOrigin, posInNavOrigin);
				}
				for(EObject element : contentList) {
					if(decider.walkInto(element)) {
						searchInDirectChildren(identifier, element, null, -1);
						if(finished) {
							return;
						}
						//walk further down
						walkDown(decider, identifier, element, null, -1);
						if(finished) {
							return;
						}
					}
				}
			}
		}
	}

	private void searchInDirectChildren(String identifier, EObject container, EReference navOrigin, int posInNavOrigin) {
		
		EClass containerClass = container.eClass();
		
		for(IResolutionTargetDecider decider : deciderList) {
			if (decider.isActive()) {
				for(EReference reference : containerClass.getEAllReferences()) {
					if(reference.isContainment()) {
						if(decider.containsCandidates(container, reference)) {
							EList<EObject> contentList = null;
							if (decider.continueAfterReference()) {
								contentList = getContentList(container, reference, null, -1);
							}
							else {
								contentList = getContentList(container, reference, navOrigin, posInNavOrigin);
							}
							for(EObject element : contentList) {
								if(decider.isPossibleTarget(identifier, element)) {
									currentBestResult = element;
									if (decider.isSure()) {
										finished = true;
									}
								}
							}
						}
					}
				}
				
				EList<? extends EObject> additionalCandidates = decider.getAdditionalCandidates(identifier, container);
				
				if (additionalCandidates != null) {
					for(EObject element : additionalCandidates) {
						if(decider.isPossibleTarget(identifier, element)) {
							currentBestResult = element;
							if (decider.isSure()) {
								finished = true;
								return;
							}
						}
					}
				}
			}
		}
	}
	

	private EList<EObject> getContentList(EObject container, EReference reference, EReference navOrigin, int posInNavOrigin) {
		EList<EObject> contentList = new BasicEList<EObject>();
		
		if(!reference.isMany()) {
			EObject value = (EObject)container.eGet(reference);
			contentList.add(value);		
		}
		else {
			@SuppressWarnings("unchecked")
			EList<EObject> value = (EList<EObject>)container.eGet(reference);
			if (!reference.equals(navOrigin)) {
				contentList.addAll(value);
			}
			else {
				contentList.addAll(value.subList(0, posInNavOrigin + 1));
			}
		}
		
		return contentList;
	}


	public EObject walk(EObject startingPoint, 
			String identifier, EObject container,
			EReference crossReference) {
		
		if (startingPoint == null) {
			return null;
		}
		
		//deactivate deciders not suited here at all
		for(IResolutionTargetDecider decider : deciderList) {
			if (!decider.canFindTargetsFor(container, crossReference)) {
				decider.deactivate();
			}
		}
		
		doWalk(identifier, startingPoint, null, -1);

		for(IResolutionTargetDecider decider : deciderList) {
			decider.activate();
		}
		
		return currentBestResult;
		
	}

}
