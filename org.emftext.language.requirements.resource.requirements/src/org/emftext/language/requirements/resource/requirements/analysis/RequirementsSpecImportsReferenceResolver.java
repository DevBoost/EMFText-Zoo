
package org.emftext.language.requirements.resource.requirements.analysis;

public class RequirementsSpecImportsReferenceResolver implements org.emftext.language.requirements.resource.requirements.IRequirementsReferenceResolver<org.emftext.language.requirements.RequirementsSpec, org.emftext.language.requirements.RequirementsSpec> {
	
	private org.emftext.language.requirements.resource.requirements.analysis.RequirementsDefaultResolverDelegate<org.emftext.language.requirements.RequirementsSpec, org.emftext.language.requirements.RequirementsSpec> delegate = new org.emftext.language.requirements.resource.requirements.analysis.RequirementsDefaultResolverDelegate<org.emftext.language.requirements.RequirementsSpec, org.emftext.language.requirements.RequirementsSpec>();
	
	public void resolve(String identifier, org.emftext.language.requirements.RequirementsSpec container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.requirements.resource.requirements.IRequirementsReferenceResolveResult<org.emftext.language.requirements.RequirementsSpec> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.requirements.RequirementsSpec element, org.emftext.language.requirements.RequirementsSpec container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
