package org.emftext.language.statemachine.resource.statemachine;

public class StatemachineReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolverSwitch {
	
	protected org.emftext.language.statemachine.resource.statemachine.analysis.TransitionSourceReferenceResolver transitionSourceReferenceResolver = new org.emftext.language.statemachine.resource.statemachine.analysis.TransitionSourceReferenceResolver();
	protected org.emftext.language.statemachine.resource.statemachine.analysis.TransitionTargetReferenceResolver transitionTargetReferenceResolver = new org.emftext.language.statemachine.resource.statemachine.analysis.TransitionTargetReferenceResolver();
	
	public org.emftext.language.statemachine.resource.statemachine.analysis.TransitionSourceReferenceResolver getTransitionSourceReferenceResolver() {
		return transitionSourceReferenceResolver;
	}
	
	public org.emftext.language.statemachine.resource.statemachine.analysis.TransitionTargetReferenceResolver getTransitionTargetReferenceResolver() {
		return transitionTargetReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		transitionSourceReferenceResolver.setOptions(options);
		transitionTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getTransition().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.uml2.uml.Vertex> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.uml2.uml.Vertex>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__SOURCE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				transitionSourceReferenceResolver.resolve(identifier, (org.eclipse.uml2.uml.Transition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getTransition().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.uml2.uml.Vertex> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.uml2.uml.Vertex>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.TRANSITION__TARGET);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				transitionTargetReferenceResolver.resolve(identifier, (org.eclipse.uml2.uml.Transition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}
