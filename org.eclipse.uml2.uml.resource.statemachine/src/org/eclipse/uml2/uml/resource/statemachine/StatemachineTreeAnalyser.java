package org.eclipse.uml2.uml.resource.statemachine; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.*;

import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.resource.statemachine.analysis.*;

public class StatemachineTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected TransitionTargetProxyResolver transitionTargetProxyResolver = new TransitionTargetProxyResolver();

	protected TransitionSourceProxyResolver transitionSourceProxyResolver = new TransitionSourceProxyResolver();

	public EObject resolve(InternalEObject proxy, EObject container, EReference reference, TextResource resource, boolean reportErrors) {
		if (container instanceof Transition && reference.getFeatureID() == 25) {
			return transitionTargetProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		if (container instanceof Transition && reference.getFeatureID() == 26) {
			return transitionSourceProxyResolver.resolve(proxy,container,reference,resource,reportErrors);
		}
		return null;
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof Transition && reference.getFeatureID() == 25) {
			return transitionTargetProxyResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Transition && reference.getFeatureID() == 26) {
			return transitionSourceProxyResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		transitionTargetProxyResolver.setOptions(options);
		transitionSourceProxyResolver.setOptions(options);
	}
}
