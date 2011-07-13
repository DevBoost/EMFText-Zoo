
package org.emftext.language.sumup.resource.sumup.analysis;

public class UnitNumeratorsReferenceResolver implements org.emftext.language.sumup.resource.sumup.ISumupReferenceResolver<org.emftext.language.sumup.Unit, org.emftext.language.sumup.UnitDeclaration> {
	
	private org.emftext.language.sumup.resource.sumup.analysis.SumupDefaultResolverDelegate<org.emftext.language.sumup.Unit, org.emftext.language.sumup.UnitDeclaration> delegate = new org.emftext.language.sumup.resource.sumup.analysis.SumupDefaultResolverDelegate<org.emftext.language.sumup.Unit, org.emftext.language.sumup.UnitDeclaration>();
	
	public void resolve(String identifier, org.emftext.language.sumup.Unit container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.sumup.resource.sumup.ISumupReferenceResolveResult<org.emftext.language.sumup.UnitDeclaration> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.sumup.UnitDeclaration element, org.emftext.language.sumup.Unit container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
