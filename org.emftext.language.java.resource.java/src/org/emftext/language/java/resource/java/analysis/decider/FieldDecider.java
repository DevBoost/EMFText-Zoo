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
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.ImportingElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.AdditionalField;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReflectiveClassReference;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;

//TODO jjohannes: add Javadoc
public class FieldDecider extends AbstractDecider {

	private Field standardArrayLengthField = null;
	
	private Reference fieldReference = null;

	public Field getArrayLengthFiled(EObject objectContext) {
		if (standardArrayLengthField  == null) {
			standardArrayLengthField = MembersFactory.eINSTANCE.createField();
			JavaUtil.setName(standardArrayLengthField, "length");
			ClassifierReference typeReference = TypesFactory.eINSTANCE.createClassifierReference();
			typeReference.setTarget(JavaClasspathUtil.getClass("Integer", objectContext));
			standardArrayLengthField.setType(typeReference);
		}
		return standardArrayLengthField;
	}
	
	private boolean insideDefiningClassifier = true;
	private boolean isStatic = false;
	
	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		EList<EObject> resultList = new BasicEList<EObject>();
		if (container instanceof Classifier) {
			if (container instanceof ConcreteClassifier && insideDefiningClassifier){	
				EList<Member> memberList = 
					ClassifierUtil.getAllMembers((Classifier)container, fieldReference);
				for(Member member : memberList) {
					if (member instanceof Field) {
						resultList.add(member);
						resultList.addAll(((Field)member).getAdditionalFields());
					}
				}
				insideDefiningClassifier = false;
				isStatic = ModifiableUtil.isStatic((ConcreteClassifier)container);
			}
			else {
				EList<Member> memberList = 
					ClassifierUtil.getAllMembers((Classifier)container, fieldReference);
				for(Member member : memberList) {
					if (member instanceof Field) {
						if (!isStatic || ModifiableUtil.isStatic((Field)member)) {
							resultList.add(member);
							resultList.addAll(((Field)member).getAdditionalFields());
						}
					}
				}
			}
		}
		
		if (container instanceof AnonymousClass) {
			resultList.addAll(((AnonymousClass)container).getMembers());
			
			EList<Member> memberList = 
				AnonymousClassUtil.getAllMembers((AnonymousClass)container, fieldReference);
			for(Member member : memberList) {
				if (member instanceof Field) {
					resultList.add(member);
					resultList.addAll(((Field)member).getAdditionalFields());
				}
			}
			return resultList;
		}
		
		if(container instanceof CompilationUnit) {
			addImports(container, resultList);
			addArrayLengthFiled(resultList, container);
		}
		
		return resultList;
	}

	private void addArrayLengthFiled(EList<EObject> resultList, EObject objectContext) {
		//Arrays have the additional member field "length"
		//We always add the field since we do not know if we have an array or not
		resultList.add(getArrayLengthFiled(objectContext));
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
		if (element instanceof Field || element instanceof AdditionalField) {
			NamedElement ne = (NamedElement) element;
			return id.equals(JavaUtil.getName(ne));
		}
		return false;
	}

	public boolean containsCandidates(EObject container, EReference containingReference) {
		return false;
	}
	
	public boolean walkInto(EObject element) {
		return false;
	}

	public boolean canFindTargetsFor(EObject referenceContainer,
			EReference containingReference) {
		if (referenceContainer instanceof MethodCall) {
			return false;
		}
		if (!(referenceContainer instanceof Reference)) {
			return false;
		}
		Reference reference = (Reference) referenceContainer;
		if (reference.getNext() instanceof ReflectiveClassReference) {
			return false;
		}
		if (reference.getNext() instanceof SelfReference) {
			return false;
		}
		fieldReference = (Reference) referenceContainer;
		return true;
	}

}
