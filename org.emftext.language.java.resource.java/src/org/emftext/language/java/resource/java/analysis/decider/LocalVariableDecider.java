package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.ForLoop;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.variables.AdditionalLocalVariable;
import org.emftext.language.java.variables.LocalVariable;
import org.emftext.language.java.variables.VariablesPackage;

public class LocalVariableDecider extends AbstractDecider {

	public boolean continueAfterReference() {
		return false;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof LocalVariable || element instanceof AdditionalLocalVariable) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (StatementsPackage.Literals.LOCAL_VARIABLE_STATEMENT__VARIABLE.equals(containingReference)) {
			return true;
		}
		if (VariablesPackage.Literals.LOCAL_VARIABLE__ADDITIONAL_LOCAL_VARIABLES.equals(containingReference)) {
			return true;
		}
		if (StatementsPackage.Literals.FOR_LOOP__INIT.equals(containingReference)) {
			return true;
		}
		return false;
	}
	
	public boolean walkInto(EObject element) {
		if (element instanceof LocalVariableStatement) {
			if (StatementsPackage.Literals.STATEMENT_CONTAINER__STATEMENT.equals(element.eContainmentFeature())) {
				return true;
			}
			if (StatementsPackage.Literals.STATEMENT_LIST_CONTAINER__STATEMENTS.equals(element.eContainmentFeature())) {
				return true;
			}
		}
		if (element instanceof LocalVariable) {
			if (StatementsPackage.Literals.LOCAL_VARIABLE_STATEMENT__VARIABLE.equals(element.eContainmentFeature())) {
				return true;
			}
		}
		if (element instanceof ForLoop) {
			return true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference;
	}

}
