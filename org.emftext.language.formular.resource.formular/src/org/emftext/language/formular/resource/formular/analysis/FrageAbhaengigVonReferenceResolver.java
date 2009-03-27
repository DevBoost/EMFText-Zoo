package org.emftext.language.formular.resource.formular.analysis;

public class FrageAbhaengigVonReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.formular.Frage, org.emftext.language.formular.Option> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.formular.Option element, org.emftext.language.formular.Frage container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.formular.Frage container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.formular.Option> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
