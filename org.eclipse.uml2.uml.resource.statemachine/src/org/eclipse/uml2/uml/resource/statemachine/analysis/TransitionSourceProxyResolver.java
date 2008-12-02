package org.eclipse.uml2.uml.resource.statemachine.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public class TransitionSourceProxyResolver extends ProxyResolverImpl {
	
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
		
		for(Vertex sourceCand: transition.getContainer().getSubvertices()) {
			if(name.equals(sourceCand.getName())) {
				return sourceCand;
			}
		}
			
		return null;
	}
}
