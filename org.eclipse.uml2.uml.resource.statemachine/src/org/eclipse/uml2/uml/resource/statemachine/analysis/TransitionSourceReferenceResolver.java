package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.uml2.uml.Vertex;

public class TransitionSourceReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.eclipse.uml2.uml.Transition> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return ((Vertex) element).getName();
	}

	@Override
	protected void doResolve(java.lang.String identifier, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {	
		
		for (Vertex sourceCand: container.getContainer().getSubvertices()) {
			if (resolveFuzzy) {
				if (sourceCand.getName().startsWith(identifier)) {
					result.addMapping(sourceCand.getName(), sourceCand);
				}
			} else {
				if (identifier.equals(sourceCand.getName())) {
					result.addMapping(identifier, sourceCand);
				}
			}
		}
	}
}
