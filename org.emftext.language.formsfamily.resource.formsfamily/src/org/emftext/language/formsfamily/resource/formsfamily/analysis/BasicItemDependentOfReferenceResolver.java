/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.formsfamily.resource.formsfamily.analysis;

public class BasicItemDependentOfReferenceResolver implements org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyReferenceResolver<org.emftext.language.formsfamily.BasicItem, org.emftext.language.formsfamily.Option> {
	
	private org.emftext.language.formsfamily.resource.formsfamily.analysis.FormsfamilyDefaultResolverDelegate<org.emftext.language.formsfamily.BasicItem, org.emftext.language.formsfamily.Option> delegate = new org.emftext.language.formsfamily.resource.formsfamily.analysis.FormsfamilyDefaultResolverDelegate<org.emftext.language.formsfamily.BasicItem, org.emftext.language.formsfamily.Option>();
	
	public void resolve(String identifier, org.emftext.language.formsfamily.BasicItem container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyReferenceResolveResult<org.emftext.language.formsfamily.Option> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.formsfamily.Option element, org.emftext.language.formsfamily.BasicItem container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
