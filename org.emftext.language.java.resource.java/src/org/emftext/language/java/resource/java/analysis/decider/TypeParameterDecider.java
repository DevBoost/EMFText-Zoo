package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.generics.GenericsPackage;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.types.ClassifierReference;

public class TypeParameterDecider extends AbstractDecider {

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof TypeParameter) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (GenericsPackage.Literals.TYPE_PARAMETRIZABLE__TYPE_PARAMETERS.equals(containingReference)) {
			return true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return (referenceContainer instanceof Reference ||
				referenceContainer instanceof ClassifierReference);
	}
}
