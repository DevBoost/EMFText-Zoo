package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.AdditionalField;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;

public class FieldDecider extends AbstractDecider {

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof ConcreteClassifier) {
			return ConcreteClassifierUtil.getAllMembers((ConcreteClassifier)container);
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
		if(container instanceof CompilationUnit) {
			for(Import aImport : ((CompilationUnit)container).getImports()) {
				if (aImport instanceof StaticMemberImport) {
					resultList.addAll(((StaticMemberImport)aImport).getStaticMembers());
				}
				else if (aImport instanceof StaticClassifierImport) {
					resultList.addAll(((StaticClassifierImport)aImport).getStaticMembers());
				}
			}
		}
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Field || element instanceof AdditionalField) {
			NamedElement ne = (NamedElement) element;
			return id.equals(ne.getName());
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		if (MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS.equals(containingReference)) {
			return  true;
		}
		if (MembersPackage.Literals.FIELD__ADDITIONAL_FIELDS.equals(containingReference)) {
			return  true;
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference;
	}

}
