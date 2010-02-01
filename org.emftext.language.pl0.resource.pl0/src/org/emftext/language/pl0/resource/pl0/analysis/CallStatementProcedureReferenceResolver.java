/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.analysis;

public class CallStatementProcedureReferenceResolver implements org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolver<org.emftext.language.pl0.CallStatement, org.emftext.language.pl0.ProcedureDeclaration> {
	
	private org.emftext.language.pl0.resource.pl0.analysis.Pl0DefaultResolverDelegate<org.emftext.language.pl0.CallStatement, org.emftext.language.pl0.ProcedureDeclaration> delegate = new org.emftext.language.pl0.resource.pl0.analysis.Pl0DefaultResolverDelegate<org.emftext.language.pl0.CallStatement, org.emftext.language.pl0.ProcedureDeclaration>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.pl0.CallStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolveResult<org.emftext.language.pl0.ProcedureDeclaration> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.pl0.ProcedureDeclaration element, org.emftext.language.pl0.CallStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
