package org.emftext.language.formular.resource.formular.analysis;

public class FrageAbhaengigVonReferenceResolver implements org.emftext.language.formular.resource.formular.IFormularReferenceResolver<org.emftext.language.formular.Frage, org.emftext.language.formular.Option> {
	
	private org.emftext.language.formular.resource.formular.analysis.FormularDefaultResolverDelegate<org.emftext.language.formular.Frage, org.emftext.language.formular.Option> delegate = new org.emftext.language.formular.resource.formular.analysis.FormularDefaultResolverDelegate<org.emftext.language.formular.Frage, org.emftext.language.formular.Option>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.formular.Frage container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.formular.resource.formular.IFormularReferenceResolveResult<org.emftext.language.formular.Option> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.formular.Option element, org.emftext.language.formular.Frage container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
