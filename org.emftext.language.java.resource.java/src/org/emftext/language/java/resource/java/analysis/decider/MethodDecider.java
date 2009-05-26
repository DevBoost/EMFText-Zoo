package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.ImportingElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.imports.ImportUtil;
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
		if (container instanceof Classifier) {
			return ClassifierUtil.getAllMembers((Classifier)container);
		}
		
		if (container instanceof AnonymousClass) {
			EList<Member> resultList = 
				AnonymousClassUtil.getAllMembers((AnonymousClass)container);
			return resultList;
		}
		
		if(container instanceof CompilationUnit) {
			EList<EObject> resultList = new BasicEList<EObject>();
			addImports(container, resultList);
			return resultList;
		}
		
		return null;
	}
	
	private void addImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof ImportingElement) {
			for(Import aImport : ((ImportingElement)container).getImports()) {
				if (aImport instanceof StaticMemberImport) {
					resultList.addAll(((StaticMemberImport)aImport).getStaticMembers());
				}
				else if (aImport instanceof StaticClassifierImport) {
					resultList.addAll(ImportUtil.getMemberList(aImport));
				}
			}
		}
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Method) {
			Method method = (Method) element;
			if (id.equals(JavaUtil.getName(method))) {
				if (lastFound == null) {
					if (MethodUtil.isMethodForCall(method, methodCall)) {
						lastFound = method;
						return true;
					}
				}
				else if (!lastFound.equals(method)) {
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
