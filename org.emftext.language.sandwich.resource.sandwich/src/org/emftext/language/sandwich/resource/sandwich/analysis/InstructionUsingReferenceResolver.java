package org.emftext.language.sandwich.resource.sandwich.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.sandwich.AttIngredientName;
import org.emftext.language.sandwich.Ingredient;
import org.emftext.language.sandwich.IngredientName;
import org.emftext.language.sandwich.Instruction;
import org.emftext.language.sandwich.RefInstructionUsing;
import org.emftext.runtime.resource.IReferenceResolveResult;

public class InstructionUsingReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.sandwich.Instruction, org.emftext.language.sandwich.RefInstructionUsing> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.sandwich.RefInstructionUsing element, org.emftext.language.sandwich.Instruction container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(String identifier, Instruction container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<RefInstructionUsing> result) {
		result.setErrorMessage("Ingredient " + identifier + " can not be found.");
		TreeIterator<EObject> it = container.eResource().getAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof Ingredient) {
				Ingredient ingredient = (Ingredient) next;
				AttIngredientName attName = ingredient.getName();
				if (attName == null) {
					continue;
				}
				if (attName instanceof IngredientName) {
					IngredientName iName = (IngredientName) attName;
					if (identifier.equals(iName.getValue())) {
						result.addMapping(identifier, ingredient);
					}
				}
			}
		}
	}
}
