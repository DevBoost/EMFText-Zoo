/**
 * 
 */
package org.emftext.language.template_concepts.interpreter.evaluators;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.template_concepts.interpreter.Context;

/**
 * @author Marcel Böhme
 * Comment created on: 17.04.2009
 */
public abstract class AEvaluator {
	private final EObject evaluatedObject;
	private final Context context;

	public AEvaluator(EObject evaluatedObject, Context context){
		this.evaluatedObject = evaluatedObject;
		this.context = context;
	}

	/**
	 * Getter
	 * @return the evaluatedObject
	 */
	public EObject getEvaluatedObject() {
		return evaluatedObject;
	}

	/**
	 * Getter
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}
	
}
