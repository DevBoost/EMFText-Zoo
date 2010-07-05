/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.lambdacalculus.resource.lambda.analysis;

public class RefRefersToReferenceResolver implements org.emftext.language.lambdacalculus.resource.lambda.ILambdaReferenceResolver<org.emftext.language.lambdacalculus.Ref, org.emftext.language.lambdacalculus.Var> {
	
	private org.emftext.language.lambdacalculus.resource.lambda.analysis.LambdaDefaultResolverDelegate<org.emftext.language.lambdacalculus.Ref, org.emftext.language.lambdacalculus.Var> delegate = new org.emftext.language.lambdacalculus.resource.lambda.analysis.LambdaDefaultResolverDelegate<org.emftext.language.lambdacalculus.Ref, org.emftext.language.lambdacalculus.Var>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.lambdacalculus.Ref container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.lambdacalculus.resource.lambda.ILambdaReferenceResolveResult<org.emftext.language.lambdacalculus.Var> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.lambdacalculus.Var element, org.emftext.language.lambdacalculus.Ref container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
