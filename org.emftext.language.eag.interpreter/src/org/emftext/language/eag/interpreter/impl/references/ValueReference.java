package org.emftext.language.eag.interpreter.impl.references;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.eag.interpreter.impl.ComputationContext;

public class ValueReference implements IReference {
	
	private ComputationContext context;

	public ValueReference(ComputationContext context) {
		super();
		this.context = context;
	}

	public void setTarget(Object newValue) {
		context.setResult(newValue);
	}

	public Object getTarget() {
		return context.getResult();
	}

	public IReference getReference(EStructuralFeature feature) {
		Object result = context.getResult();
		assert result != null;
		assert result instanceof EObject;
		EObject eResult = (EObject) result;
		return ReferenceFactory.INSTANCE.createReference(eResult.eGet(feature));
	}
}