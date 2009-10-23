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
package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.IJavaReferenceResolver;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.EnumConstantDecider;
import org.emftext.language.java.resource.java.analysis.decider.FieldDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.LocalVariableDecider;
import org.emftext.language.java.resource.java.analysis.decider.MethodDecider;
import org.emftext.language.java.resource.java.analysis.decider.PackageDecider;
import org.emftext.language.java.resource.java.analysis.decider.ParameterDecider;
import org.emftext.language.java.resource.java.analysis.decider.TypeParameterDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.util.TemporalCompositeClassifier;

public class ElementReferenceTargetReferenceResolver implements 
	IJavaReferenceResolver<ElementReference, ReferenceableElement> {
	
	public java.lang.String deResolve(ReferenceableElement element, ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		if (element instanceof ConcreteClassifier) {
			ConcreteClassifier concreteClassifier = (ConcreteClassifier) element;
			
			Object fullNamesOption = container.eResource().getResourceSet().getLoadOptions().get(
					JavaClasspath.OPTION_ALWAYS_USE_FULLY_QUALIFIED_NAMES);	
			if (!(fullNamesOption instanceof Boolean)) {
				fullNamesOption = Boolean.FALSE;
			}		
			if (Boolean.TRUE.equals(fullNamesOption)) {
				String packageName = "";
				String fullClassName = concreteClassifier.getName();
				EObject parent = concreteClassifier.eContainer();
				while(parent instanceof Classifier) {
					fullClassName = ((Classifier)parent).getName() + "." + fullClassName;
					parent = parent.eContainer();
				}
				if (parent instanceof CompilationUnit) {
					EList<String> namespaces = ((CompilationUnit)parent).getNamespaces();
					for(String s : namespaces) { packageName += s + "."; }
				}
				return packageName + fullClassName;
			}
			
			if(concreteClassifier.getFullName() != null) {
				return concreteClassifier.getFullName();
			}
		}
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ReferenceableElement> result) {
		EObject startingPoint = null;
		EObject alternativeStartingPoint = null;
		EObject target = null;
		Reference parentReference = null;
		
		if(container.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			//a follow up reference: different scope
			parentReference = (Reference) container.eContainer();
			if (parentReference instanceof IdentifierReference &&
					((IdentifierReference)parentReference).getTarget() instanceof Package) {
				startingPoint = ((IdentifierReference)parentReference).getTarget();
			}
			else {
				startingPoint = parentReference.getReferencedType();
				if (parentReference instanceof NestedExpression) {
					alternativeStartingPoint = ((NestedExpression) parentReference
							).getExpression().getAlternativeType();
				}
			
				//do not search on primitive types but their class representation
				if (startingPoint instanceof PrimitiveType) {
					startingPoint = ((PrimitiveType) startingPoint).wrapPrimitiveType();
				}

				if (parentReference instanceof NestedExpression) {
					startingPoint = (((NestedExpression)parentReference).getExpression()).getType();
				}
				
				//special case: anonymous class in constructor call
				while (parentReference instanceof NestedExpression) {
					Expression nestedExpression = ((NestedExpression)parentReference).getExpression();
					if (nestedExpression instanceof Reference) {
						parentReference = (Reference) nestedExpression; 
					}
					else {
						parentReference = null;
					}
				}
				if (parentReference instanceof NewConstructorCall &&
						((NewConstructorCall)parentReference).getAnonymousClass() != null) {
					startingPoint = ((NewConstructorCall)parentReference).getAnonymousClass();
				}
				
			}
		}
		else {
			startingPoint = container;
		}
		
		if(target == null) {
			if(startingPoint instanceof TemporalCompositeClassifier) {
				for(EObject superType : ((TemporalCompositeClassifier)startingPoint).getSuperTypes()) {
					target = searchFromStartingPoint(identifier, container, reference,
							superType);
					if (target != null) {
						break;
					}
				}
			}
			else {
				target = searchFromStartingPoint(identifier, container, reference,
						startingPoint);	
			}
		}
		if(target == null && alternativeStartingPoint != null && !alternativeStartingPoint.equals(startingPoint)) {
			target = searchFromStartingPoint(identifier, container, reference,
					alternativeStartingPoint);
		}
		
		if (target != null) {
			result.addMapping(identifier, (ReferenceableElement) target);
		}
	}

	private EObject searchFromStartingPoint(java.lang.String identifier,
			ElementReference container,
			org.eclipse.emf.ecore.EReference reference, EObject startingPoint) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		deciderList.add(new EnumConstantDecider());
		deciderList.add(new FieldDecider());
		deciderList.add(new LocalVariableDecider());
		deciderList.add(new ParameterDecider());
		deciderList.add(new MethodDecider());
		
		deciderList.add(new ConcreteClassifierDecider());
		deciderList.add(new TypeParameterDecider());
		
		deciderList.add(new PackageDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		return treeWalker.walk(startingPoint, identifier, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
	}
}
