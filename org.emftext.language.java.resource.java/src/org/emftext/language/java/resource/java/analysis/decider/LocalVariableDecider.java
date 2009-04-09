package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.variables.AdditionalLocalVariable;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.VariablesPackage;

public class LocalVariableDecider implements IResolutionTargetDecider {

	public boolean continueAfterReference() {
		return false;
	}

	public EList<EObject> getAdditionalCandidates(EObject container) {
		return null;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof LocalVariable || element instanceof AdditionalLocalVariable) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean lookInto(EObject container, EReference containingReference) {
		if (StatementsPackage.Literals.STATEMENT_CONTAINER__STATEMENT.equals(containingReference)) {
			return  true;
		}
		if (StatementsPackage.Literals.LOCAL_VARIABLE_STATEMENT__VARIABLE.equals(containingReference)) {
			return true;
		}
		if (VariablesPackage.Literals.LOCAL_VARIABLE__ADDITIONAL_LOCAL_VARIABLES.equals(containingReference)) {
			return true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference;
	}

}
