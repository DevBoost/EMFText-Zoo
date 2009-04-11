package org.emftext.language.statemachine.resource.statemachine.analysis;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class TransitionSourceReferenceResolver extends 
	AbstractReferenceResolver<Transition, Vertex> {

	@Override
	protected java.lang.String doDeResolve(Vertex element, org.eclipse.uml2.uml.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	@Override
	protected void doResolve(String identifier, Transition container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<Vertex> result) {	
		
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
