/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0ReferenceResolverSwitch implements org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolverSwitch {
	
	protected org.emftext.language.pl0.resource.pl0.analysis.CallStatementProcedureReferenceResolver callStatementProcedureReferenceResolver = new org.emftext.language.pl0.resource.pl0.analysis.CallStatementProcedureReferenceResolver();
	protected org.emftext.language.pl0.resource.pl0.analysis.AssignmentLeftReferenceResolver assignmentLeftReferenceResolver = new org.emftext.language.pl0.resource.pl0.analysis.AssignmentLeftReferenceResolver();
	protected org.emftext.language.pl0.resource.pl0.analysis.IdentReferenceIdentReferenceResolver identReferenceIdentReferenceResolver = new org.emftext.language.pl0.resource.pl0.analysis.IdentReferenceIdentReferenceResolver();
	
	public org.emftext.language.pl0.resource.pl0.analysis.CallStatementProcedureReferenceResolver getCallStatementProcedureReferenceResolver() {
		return callStatementProcedureReferenceResolver;
	}
	
	public org.emftext.language.pl0.resource.pl0.analysis.AssignmentLeftReferenceResolver getAssignmentLeftReferenceResolver() {
		return assignmentLeftReferenceResolver;
	}
	
	public org.emftext.language.pl0.resource.pl0.analysis.IdentReferenceIdentReferenceResolver getIdentReferenceIdentReferenceResolver() {
		return identReferenceIdentReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		callStatementProcedureReferenceResolver.setOptions(options);
		assignmentLeftReferenceResolver.setOptions(options);
		identReferenceIdentReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.pl0.resource.pl0.IPl0ReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.pl0.PL0Package.eINSTANCE.getCallStatement().isInstance(container)) {
			Pl0FuzzyResolveResult<org.emftext.language.pl0.ProcedureDeclaration> frr = new Pl0FuzzyResolveResult<org.emftext.language.pl0.ProcedureDeclaration>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				callStatementProcedureReferenceResolver.resolve(identifier, (org.emftext.language.pl0.CallStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.pl0.PL0Package.eINSTANCE.getAssignment().isInstance(container)) {
			Pl0FuzzyResolveResult<org.emftext.language.pl0.VarDeclaration> frr = new Pl0FuzzyResolveResult<org.emftext.language.pl0.VarDeclaration>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				assignmentLeftReferenceResolver.resolve(identifier, (org.emftext.language.pl0.Assignment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.pl0.PL0Package.eINSTANCE.getIdentReference().isInstance(container)) {
			Pl0FuzzyResolveResult<org.emftext.language.pl0.Declaration> frr = new Pl0FuzzyResolveResult<org.emftext.language.pl0.Declaration>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				identReferenceIdentReferenceResolver.resolve(identifier, (org.emftext.language.pl0.IdentReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}
