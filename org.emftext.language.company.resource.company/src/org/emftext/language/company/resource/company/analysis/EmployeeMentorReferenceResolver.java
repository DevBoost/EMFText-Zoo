
package org.emftext.language.company.resource.company.analysis;

public class EmployeeMentorReferenceResolver implements org.emftext.language.company.resource.company.ICompanyReferenceResolver<org.emftext.language.company.Employee, org.emftext.language.company.Employee> {
	
	private org.emftext.language.company.resource.company.analysis.CompanyDefaultResolverDelegate<org.emftext.language.company.Employee, org.emftext.language.company.Employee> delegate = new org.emftext.language.company.resource.company.analysis.CompanyDefaultResolverDelegate<org.emftext.language.company.Employee, org.emftext.language.company.Employee>();
	
	public void resolve(String identifier, org.emftext.language.company.Employee container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.company.resource.company.ICompanyReferenceResolveResult<org.emftext.language.company.Employee> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.company.Employee element, org.emftext.language.company.Employee container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
