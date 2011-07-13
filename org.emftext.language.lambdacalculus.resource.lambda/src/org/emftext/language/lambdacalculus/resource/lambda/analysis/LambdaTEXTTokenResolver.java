
package org.emftext.language.lambdacalculus.resource.lambda.analysis;

public class LambdaTEXTTokenResolver implements org.emftext.language.lambdacalculus.resource.lambda.ILambdaTokenResolver {
	
	private org.emftext.language.lambdacalculus.resource.lambda.analysis.LambdaDefaultTokenResolver defaultTokenResolver = new org.emftext.language.lambdacalculus.resource.lambda.analysis.LambdaDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.lambdacalculus.resource.lambda.ILambdaTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
