
package org.emftext.language.formsextension.resource.formsextension.analysis;

public class ExtendedFormCompilationUnitReferenceResolver implements org.emftext.language.formsextension.resource.formsextension.IFormsextensionReferenceResolver<org.emftext.language.formsextension.ExtendedForm, org.emftext.language.java.containers.CompilationUnit> {
	
	private org.emftext.language.formsextension.resource.formsextension.analysis.FormsextensionDefaultResolverDelegate<org.emftext.language.formsextension.ExtendedForm, org.emftext.language.java.containers.CompilationUnit> delegate = new org.emftext.language.formsextension.resource.formsextension.analysis.FormsextensionDefaultResolverDelegate<org.emftext.language.formsextension.ExtendedForm, org.emftext.language.java.containers.CompilationUnit>();
	
	public void resolve(String identifier, org.emftext.language.formsextension.ExtendedForm container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.formsextension.resource.formsextension.IFormsextensionReferenceResolveResult<org.emftext.language.java.containers.CompilationUnit> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.java.containers.CompilationUnit element, org.emftext.language.formsextension.ExtendedForm container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
