package org.emftext.language.sandwich.resource.sandwich.analysis;

public class InstructionUsingReferenceResolver implements org.emftext.language.sandwich.resource.sandwich.ISandwichReferenceResolver<org.emftext.language.sandwich.Instruction, org.emftext.language.sandwich.FeatureInstructionUsing> {
	
	private org.emftext.language.sandwich.resource.sandwich.analysis.SandwichDefaultResolverDelegate<org.emftext.language.sandwich.Instruction, org.emftext.language.sandwich.FeatureInstructionUsing> delegate = new org.emftext.language.sandwich.resource.sandwich.analysis.SandwichDefaultResolverDelegate<org.emftext.language.sandwich.Instruction, org.emftext.language.sandwich.FeatureInstructionUsing>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.sandwich.resource.sandwich.ISandwichReferenceResolveResult<org.emftext.language.sandwich.FeatureInstructionUsing> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.sandwich.FeatureInstructionUsing element, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
