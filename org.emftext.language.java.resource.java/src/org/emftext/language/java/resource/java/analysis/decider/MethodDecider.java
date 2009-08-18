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
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.ImportingElement;
import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.MethodCall;

/**
 * A decider that looks for methods.
 */
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
	
	private boolean insideDefiningClassifier = true;
	private boolean isStatic = false;
	
	public EList<? extends EObject> getAdditionalCandidates(String identifier, EObject container) {
		EList<EObject> resultList = new BasicEList<EObject>();
		if (container instanceof Classifier) {
			if (container instanceof ConcreteClassifier && insideDefiningClassifier){	
				EList<Member> memberList = 
					((Classifier)container).getAllMembers(methodCall);
				for(Member member : memberList) {
					if (member instanceof Method) {
						resultList.add(member);
					}
				}
				insideDefiningClassifier = false;
				isStatic = ((ConcreteClassifier)container).isStatic();
			}
			else {
				EList<Member> memberList = 
					((Classifier)container).getAllMembers(methodCall);
				for(Member member : memberList) {
					if (member instanceof Method) {
						if (!isStatic || ((Method)member).isStatic()) {
							resultList.add(member);
						}
					}
				}
			}
		}
		
		if (container instanceof AnonymousClass) {
			resultList.addAll(((AnonymousClass)container).getMembers());
			
			EList<Member> memberList = 
				((AnonymousClass)container).getAllMembers(methodCall);
			for(Member member : memberList) {
				if (member instanceof Method) {
					resultList.add(member);
				}
			}
			return resultList;
		}
		
		if(container instanceof CompilationUnit) {
			addImports(container, resultList);
		}
		
		return resultList;
	}
	
	private void addImports(EObject container,
			EList<EObject> resultList) {
		if(container instanceof ImportingElement) {
			for(Import aImport : ((ImportingElement)container).getImports()) {
				if (aImport instanceof StaticMemberImport) {
					resultList.addAll(((StaticMemberImport)aImport).getStaticMembers());
				}
				else if (aImport instanceof StaticClassifierImport) {
					resultList.addAll(aImport.getImportedMembers());
				}
			}
		}
	}

	public boolean isPossibleTarget(String id, EObject element) {
		if (element instanceof Method) {
			Method method = (Method) element;
			if (id.equals(method.getName())) {
				if (lastFound == null) {
					if (method.isSomeMethodForCall(methodCall)) {
						lastFound = method;
						return true;
					}
				}
				else if (!lastFound.equals(method)) {
					if (method.isBetterMethodForCall(lastFound, methodCall)) {
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
		return false;
	}


}
