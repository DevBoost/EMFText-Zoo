package org.emftext.language.owl.resource.owl.analysis;

public class DataPropertyRestrictionDataPropertyReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.DataPropertyRestriction, org.emftext.language.owl.DataProperty> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.DataProperty element, org.emftext.language.owl.DataPropertyRestriction container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.DataPropertyRestriction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
