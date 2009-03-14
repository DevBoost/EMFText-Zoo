package org.emftext.language.owl.resource.owl.analysis;

public class SameIndividualsIndividualsReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.SameIndividuals, org.emftext.language.owl.Individual> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Individual element, org.emftext.language.owl.SameIndividuals container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.SameIndividuals container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.Individual> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
