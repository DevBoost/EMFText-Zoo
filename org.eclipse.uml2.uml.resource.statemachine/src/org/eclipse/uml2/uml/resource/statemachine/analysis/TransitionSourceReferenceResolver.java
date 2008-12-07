package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.emftext.runtime.resource.ResolveResult;

public class TransitionSourceReferenceResolver extends org.emftext.runtime.resource.impl.ReferenceResolverImpl {

	@Override
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {

		return ((Vertex)element).getName();
	}

	@Override
	protected void doResolve(String name, EObject container, EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {
		
		Transition transition = (Transition) container;	
		
		for (Vertex sourceCand: transition.getContainer().getSubvertices()) {
			if (resolveFuzzy) {
				if (name.startsWith(sourceCand.getName())) {
					result.addMapping(name, sourceCand);
				}
			} else {
				if (name.equals(sourceCand.getName())) {
					result.addMapping(name, sourceCand);
				}
			}
		}
	}
}
