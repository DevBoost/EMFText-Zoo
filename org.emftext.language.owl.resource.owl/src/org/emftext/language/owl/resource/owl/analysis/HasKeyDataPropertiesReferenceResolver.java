package org.emftext.language.owl.resource.owl.analysis;

public class HasKeyDataPropertiesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.HasKey, org.emftext.language.owl.DataProperty> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.DataProperty element, org.emftext.language.owl.HasKey container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.HasKey container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.DataProperty> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
