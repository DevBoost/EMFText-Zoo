package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

public class TransitionTargetReferenceResolver extends org.emftext.runtime.resource.impl.ReferenceResolverImpl {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		return ((Vertex)element).getName();
	}

	@Override
	protected void doResolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		Transition transition = (Transition) container;	
		
		for (Vertex targetCand: transition.getContainer().getSubvertices()) {
			if (resolveFuzzy) {
				if (identifier.startsWith(targetCand.getName())) {
					result.addMapping(identifier, targetCand);
				}
			} else {
				if (identifier.equals(targetCand.getName())) {
					result.addMapping(identifier, targetCand);
				}
			}
		}
	}
}
