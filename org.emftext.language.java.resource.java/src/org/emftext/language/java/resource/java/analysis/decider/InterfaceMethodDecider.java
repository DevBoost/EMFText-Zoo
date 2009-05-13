package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;

/**
 * To resolve annotation attributes.
 *
 */
public class InterfaceMethodDecider extends AbstractDecider {


	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		if (referenceContainer instanceof AnnotationAttributeSetting) {
			return true;
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Classifier) {
			return ClassifierUtil.getAllMembers((Classifier)container);
		}
		return null;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof InterfaceMethod) {
			Method method = (Method) element;
			if (id.equals(JavaUtil.getName(method))) {
				NamedElement ne = (NamedElement) element;
				return id.equals(JavaUtil.getName(ne));
			}
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (container instanceof MemberContainer) {
			if (MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS.equals(containingReference)) {
				return  true;
			}
		}
		return false;
	}


}
