package org.emftext.language.owl.resource.owl.analysis;

public class DataPropertyValueLiteralReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.owl.DataPropertyValue, org.emftext.language.owl.Literal> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.owl.Literal element, org.emftext.language.owl.DataPropertyValue container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.owl.DataPropertyValue container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
