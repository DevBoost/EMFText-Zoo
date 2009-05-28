/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
import org.emftext.language.java.statements.StatementsPackage;
import org.emftext.language.java.statements.Switch;
import org.emftext.language.java.statements.SwitchCase;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.generics.TypeParameterUtil;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.language.java.variables.LocalVariable;

/**
 * A decider that looks for enumeration constants.
 */
public class EnumConstantDecider extends AbstractDecider {

	private EObject reference = null;
	
	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof EnumConstant) {
			NamedElement ne = (NamedElement) element;
			return id.equals(JavaUtil.getName(ne));
		}
		return false;
	}

	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		if (container instanceof Switch &&
				reference.eContainmentFeature().equals(StatementsPackage.Literals.CONDITIONAL__CONDITION) &&
				reference.eContainer() instanceof SwitchCase) {
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
		reference = referenceContainer;
		return referenceContainer instanceof Reference && !(referenceContainer instanceof MethodCall);
	}

}
