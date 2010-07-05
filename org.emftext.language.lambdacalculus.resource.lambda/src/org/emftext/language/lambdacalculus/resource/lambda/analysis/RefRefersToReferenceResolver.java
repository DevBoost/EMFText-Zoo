/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.lambdacalculus.resource.lambda.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.lambdacalculus.Abstr;
import org.emftext.language.lambdacalculus.BoundVar;
import org.emftext.language.lambdacalculus.Ref;
import org.emftext.language.lambdacalculus.Var;
import org.emftext.language.lambdacalculus.resource.lambda.ILambdaReferenceResolveResult;
import org.emftext.language.lambdacalculus.resource.lambda.ILambdaReferenceResolver;

public class RefRefersToReferenceResolver implements ILambdaReferenceResolver<Ref, Var> {
	
	public void resolve(String identifier, Ref container, EReference reference, int position, boolean resolveFuzzy, final ILambdaReferenceResolveResult<Var> result) {
		EObject parent = container;
		while (parent != null) {
			if (parent instanceof Abstr) {
				Abstr abstraction = (Abstr) parent;
				BoundVar boundVar = abstraction.getBoundVar();
				if (boundVar.getName().equals(identifier) || resolveFuzzy) {
					result.addMapping(boundVar.getName(), boundVar);
					if (!resolveFuzzy) {
						return;
					}
				}
			}
			parent = parent.eContainer();
		}
	}
	
	public String deResolve(Var element, Ref container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
