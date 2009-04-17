package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.ClassifiersPackage;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.Switch;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.expressions.ExpressionUtil;

public class EnumConstantDecider extends AbstractDecider {

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof EnumConstant) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Switch) {
			Switch aSwitch = (Switch) container;
			Type variableType = ExpressionUtil.getType(aSwitch.getVariable());
			if (variableType instanceof Enumeration) {
				return ((Enumeration)variableType).getConstants();	
			}
		}
		return null;
	}
	
	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (ClassifiersPackage.Literals.ENUMERATION__CONSTANTS.equals(containingReference)) {
			return true;
		}
		return false;
	}

	
	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall);
	}

}
