package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;
import org.emftext.language.java.util.members.MethodUtil;

public class MethodDecider extends AbstractDecider {

	protected MethodCall methodCall = null;
	
	protected Method lastFound = null;

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		if (referenceContainer instanceof MethodCall) {
			methodCall = (MethodCall) referenceContainer;
			return true;
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof ConcreteClassifier) {
			return ConcreteClassifierUtil.getAllMembers((ConcreteClassifier)container);
		}
		return null;
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Method) {
			Method method = (Method) element;
			if (id.equals(method.getName())) {
				if (lastFound == null) {
					if (MethodUtil.isMethodForCall(method, methodCall)) {
						lastFound = method;
						return true;
					}
				}
				else {
					if (MethodUtil.isMethodForCall(method, lastFound, methodCall)) {
						lastFound = method;
						return true;
					}
				}
				
			}
		}
		return false;
	}

	public boolean isSure() {
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
