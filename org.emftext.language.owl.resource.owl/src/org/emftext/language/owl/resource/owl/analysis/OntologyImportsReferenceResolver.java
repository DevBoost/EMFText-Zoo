package org.emftext.language.owl.resource.owl.analysis;

public class OntologyImportsReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.Ontology, org.emftext.language.owl.Ontology> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Ontology element, org.emftext.language.owl.Ontology container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.Ontology container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.Ontology> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
