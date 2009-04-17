package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.AdditionalField;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.members.MembersPackage;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;

public class FieldDecider extends AbstractDecider {

	private static Field STANDARD_ARRAY_LENGTH_FIELD = null;

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Classifier) {
			EList<Member> resultList = 
				ClassifierUtil.getAllMembers((Classifier)container);		
			addArrayLengthFiled(resultList, container);
			return resultList;
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

	private void addArrayLengthFiled(EList<Member> resultList, EObject objectContext) {
		//Arrays have the additional member field "length"
		//We always add the field since we do not know if we have an array or not
		if (STANDARD_ARRAY_LENGTH_FIELD  == null) {
			STANDARD_ARRAY_LENGTH_FIELD = MembersFactory.eINSTANCE.createField();
			STANDARD_ARRAY_LENGTH_FIELD.setName("length");
			ClassifierReference typeReference = TypesFactory.eINSTANCE.createClassifierReference();
			typeReference.setTarget(JavaClasspathUtil.getClass("Integer", objectContext));
			STANDARD_ARRAY_LENGTH_FIELD.setType(typeReference);
		}
		resultList.add(STANDARD_ARRAY_LENGTH_FIELD);
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
				else if (aImport instanceof ClassifierImport) {
					for (EObject member : ((ClassifierImport)aImport).getClassifier().getMembers()) {
						//for (EObject modifier : member.eContents()) {
							//if (modifier instanceof Static) { TODO @jjohannes reactivate this check when the class file loader supports modifiers
								resultList.add(member);
							//}
						//}
					}
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
	
	public boolean walkInto(EObject element) {
		if (element instanceof Field) {
			if (MembersPackage.Literals.MEMBER_CONTAINER__MEMBERS.equals(element.eContainmentFeature())) {
				return true;
			}
		}
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		return referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall);
	}

}
