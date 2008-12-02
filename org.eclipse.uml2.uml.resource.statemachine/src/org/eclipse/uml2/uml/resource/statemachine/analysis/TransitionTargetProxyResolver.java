package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public class TransitionTargetProxyResolver extends ProxyResolverImpl {

	@Override
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {

		return ((Vertex)element).getName();
	}

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		String name = proxy.eProxyURI().fragment();
		Transition transition = (Transition) container;	
		
		for(Vertex targetCand: transition.getContainer().getSubvertices()) {
			if(name.equals(targetCand.getName())) {
				return targetCand;
			}
		}
			
		return null;
	}

	
}
