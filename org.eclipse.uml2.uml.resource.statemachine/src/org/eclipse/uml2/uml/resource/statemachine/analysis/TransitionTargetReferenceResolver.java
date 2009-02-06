package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.uml2.uml.Vertex;

public class TransitionTargetReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.uml2.uml.Transition> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return ((Vertex) element).getName();
	}

	@Override
	protected void doResolve(java.lang.String identifier, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
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
