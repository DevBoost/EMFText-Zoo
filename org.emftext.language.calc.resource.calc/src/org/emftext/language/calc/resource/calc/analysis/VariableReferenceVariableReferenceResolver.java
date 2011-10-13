/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.calc.resource.calc.analysis;

public class VariableReferenceVariableReferenceResolver implements org.emftext.language.calc.resource.calc.ICalcReferenceResolver<org.emftext.language.calc.VariableReference, org.emftext.language.calc.Variable> {
	
	private org.emftext.language.calc.resource.calc.analysis.CalcDefaultResolverDelegate<org.emftext.language.calc.VariableReference, org.emftext.language.calc.Variable> delegate = new org.emftext.language.calc.resource.calc.analysis.CalcDefaultResolverDelegate<org.emftext.language.calc.VariableReference, org.emftext.language.calc.Variable>();
	
	public void resolve(String identifier, org.emftext.language.calc.VariableReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.calc.resource.calc.ICalcReferenceResolveResult<org.emftext.language.calc.Variable> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.calc.Variable element, org.emftext.language.calc.VariableReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
