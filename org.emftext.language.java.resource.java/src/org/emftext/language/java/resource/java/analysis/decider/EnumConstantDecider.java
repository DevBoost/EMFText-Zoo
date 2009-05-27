package org.emftext.language.java.resource.java.analysis.decider;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.classifiers.ClassifiersPackage;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.expressions.AssignmentExpression;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.ImportingElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.modifiers.AnnotableAndModifiable;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.statements.Switch;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.generics.TypeParameterUtil;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.language.java.variables.LocalVariable;

public class EnumConstantDecider extends AbstractDecider {

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof EnumConstant) {
			NamedElement ne = (NamedElement) element;
			return id.equals(JavaUtil.getName(ne));
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
			if (variableType instanceof TypeParameterUtil.TemporalCompositeClassImpl) {
				for(Type superType : ((TypeParameterUtil.TemporalCompositeClassImpl)variableType).getSuperTypes()) {
					if (superType instanceof Enumeration) {
						return ((Enumeration)superType).getConstants();	
					}
				}
			}
		}
		if (container instanceof AssignmentExpression) {
			AssignmentExpression assignmentExpression = (AssignmentExpression) container;
			Type assignmentExpressionType = ExpressionUtil.getType(assignmentExpression);
			if (assignmentExpressionType instanceof Enumeration) {
				return ((Enumeration)assignmentExpressionType).getConstants();	
			}
		}
		if (container instanceof LocalVariable) {
			LocalVariable localVariable = (LocalVariable) container;
			Type assignmentExpressionType = TypeReferenceUtil.getTarget(localVariable.getType());
			if (assignmentExpressionType instanceof Enumeration) {
				return ((Enumeration)assignmentExpressionType).getConstants();	
			}
		}
		
		EList<EObject> resultList = addImports(container);
		
		return resultList;
	}
	
	private EList<EObject> addImports(EObject container) {
		if(container instanceof ImportingElement) {
			EList<EObject> resultList = new BasicEList<EObject>();
			for(Import aImport : ((ImportingElement)container).getImports()) {
				if (aImport instanceof StaticMemberImport) {
					resultList.addAll(((StaticMemberImport)aImport).getStaticMembers());
				}
				else if (aImport instanceof StaticClassifierImport) {
					resultList.addAll(ImportUtil.getMemberList(aImport));
				}
				else if (aImport instanceof ClassifierImport) {
					for (EObject member : ((ClassifierImport)aImport).getClassifier().getMembers()) {
						if (member instanceof AnnotableAndModifiable) {
							if(ModifiableUtil.isStatic((AnnotableAndModifiable)member)) {
								resultList.add(member);
							}
						}
					}
				}
			}
			return resultList;
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
