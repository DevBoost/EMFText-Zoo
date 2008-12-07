package org.eclipse.uml2.uml.resource.statemachine; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.emftext.runtime.resource.impl.*;

import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.resource.statemachine.analysis.*;

public class StatemachineTreeAnalyser extends EMFTextTreeAnalyserImpl {

	protected TransitionSourceReferenceResolver transitionSourceReferenceResolver = new TransitionSourceReferenceResolver();

	protected TransitionTargetReferenceResolver transitionTargetReferenceResolver = new TransitionTargetReferenceResolver();

	public void resolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.ResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(String identifier, EObject container, EReference reference, int position, org.emftext.runtime.resource.ResolveResult result) {
		if (container instanceof Transition && reference.getFeatureID() == 26) {
			transitionSourceReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
		if (container instanceof Transition && reference.getFeatureID() == 25) {
			transitionTargetReferenceResolver.resolve(identifier, container, reference, position, false, result);
			return;
		}
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		if (container instanceof Transition && reference.getFeatureID() == 26) {
			return transitionSourceReferenceResolver.deResolve(refObject,container,reference);
		}
		if (container instanceof Transition && reference.getFeatureID() == 25) {
			return transitionTargetReferenceResolver.deResolve(refObject,container,reference);
		}
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
		transitionSourceReferenceResolver.setOptions(options);
		transitionTargetReferenceResolver.setOptions(options);
	}

	public void resolveFuzzy(java.lang.String identifier, EObject container, int position, org.emftext.runtime.resource.ResolveResult result) {

		resolveFuzzy(Transition.class, identifier, container, position, 26, transitionSourceReferenceResolver, result);
		resolveFuzzy(Transition.class, identifier, container, position, 25, transitionTargetReferenceResolver, result);
	}

	protected void resolveFuzzy(Class<?> clazz, String identifier, EObject container, int position, 
			int featureID, 
			org.emftext.runtime.resource.ReferenceResolver resolver, org.emftext.runtime.resource.ResolveResult result
			) {

		//if (clazz.isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
			if (!(feature instanceof EReference)) {
				return;
			}
			resolver.resolve(identifier, container, (EReference) feature, position, true, result);
	}

}
