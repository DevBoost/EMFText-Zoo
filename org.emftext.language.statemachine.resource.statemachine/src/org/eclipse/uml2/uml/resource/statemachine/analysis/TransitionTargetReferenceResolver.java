package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class TransitionTargetReferenceResolver extends 
	AbstractReferenceResolver<Transition, Vertex> {

	@Override
	protected java.lang.String doDeResolve(Vertex element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return ((Vertex) element).getName();
	}

	@Override
	protected void doResolve(String identifier, Transition container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<Vertex> result) {	
		for (Vertex targetCand: container.getContainer().getSubvertices()) {
			if (resolveFuzzy) {
				if (targetCand.getName().startsWith(identifier)) {
					result.addMapping(targetCand.getName(), targetCand);
				}
			} else {
				if (identifier.equals(targetCand.getName())) {
					result.addMapping(identifier, targetCand);
				}
			}
		}
	}
}
