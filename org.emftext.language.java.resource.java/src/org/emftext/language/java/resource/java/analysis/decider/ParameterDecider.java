package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersPackage;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.ForEachLoop;
import org.emftext.language.java.statements.StatementsPackage;

public class ParameterDecider extends AbstractDecider {

	public boolean continueAfterReference() {
		return false;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Parameter) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (ParametersPackage.Literals.PARAMETRIZABLE__PARAMETERS.equals(containingReference)) {
			return  true;
		}
		if (StatementsPackage.Literals.CATCH_BLOCK__PARAMETER.equals(containingReference)) {
			return  true;
		}
		if (StatementsPackage.Literals.FOR_EACH_LOOP__NEXT.equals(containingReference)) {
			return  true;
		}
		return false;
	}
	
	public boolean walkInto(EObject element) {
		if (element instanceof ForEachLoop) {
			return true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall);
	}

}
