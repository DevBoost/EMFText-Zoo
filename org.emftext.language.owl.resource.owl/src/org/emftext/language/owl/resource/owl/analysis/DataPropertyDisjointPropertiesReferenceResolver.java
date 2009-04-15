package org.emftext.language.owl.resource.owl.analysis;

import org.emftext.language.owl.resource.owl.analysis.custom.CrossResourceIRIResolver;

public class DataPropertyDisjointPropertiesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.DataProperty, org.emftext.language.owl.DataProperty> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.DataProperty element, org.emftext.language.owl.DataProperty container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.DataProperty container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.DataProperty> result) {
		CrossResourceIRIResolver.theInstance().doResolve(identifier, container, resolveFuzzy, result, org.emftext.language.owl.DataProperty.class);
				
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
