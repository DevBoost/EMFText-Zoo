package org.emftext.language.owl.resource.owl.analysis;

public class ConjunctionClazzReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.Conjunction, org.emftext.language.owl.Class> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Class element, org.emftext.language.owl.Conjunction container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.Conjunction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.Class> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
