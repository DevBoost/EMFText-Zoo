package org.emftext.language.owl.resource.owl.analysis;

import org.emftext.language.owl.resource.owl.analysis.custom.CrossResourceIRIResolver;

public class EquivalentPropertiesObjectPropertiesReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.EquivalentProperties, org.emftext.language.owl.ObjectProperty> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.ObjectProperty element, org.emftext.language.owl.EquivalentProperties container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.EquivalentProperties container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.owl.ObjectProperty> result) {
		CrossResourceIRIResolver.theInstance().doResolve(identifier, container, resolveFuzzy, result, org.emftext.language.owl.ObjectProperty.class);
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
