package org.emftext.language.owl.resource.owl.analysis;

import org.emftext.language.owl.resource.owl.analysis.custom.CrossResourceIRIResolver;

public class IndividualsAtomicIndividualsReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.IndividualsAtomic, org.emftext.language.owl.Individual> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Individual element, org.emftext.language.owl.IndividualsAtomic container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.IndividualsAtomic container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.Individual> result) {
		CrossResourceIRIResolver.theInstance().doResolve(identifier, container, resolveFuzzy, result, org.emftext.language.owl.Individual.class);
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
