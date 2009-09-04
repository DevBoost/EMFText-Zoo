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
package org.emftext.language.java.resource.java.analysis.helper;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.expressions.AdditiveExpression;
import org.emftext.language.java.expressions.CastExpression;
import org.emftext.language.java.expressions.ExpressionsFactory;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.expressions.RelationExpression;
import org.emftext.language.java.expressions.ShiftExpression;
import org.emftext.language.java.expressions.UnaryExpression;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.operators.AdditiveOperator;
import org.emftext.language.java.operators.GreaterThan;
import org.emftext.language.java.operators.OperatorsFactory;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.JavaContextDependentURIFragmentFactory;
import org.emftext.language.java.resource.java.JavaReferenceResolverSwitch;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.TypesPackage;
import org.emftext.runtime.resource.IContextDependentURIFragment;
import org.emftext.runtime.resource.ITextResource;

/**
 * The JavaModelRepairer can be used to fix part of Java models that
 * are incorrectly create by the Java parser. This is mostly due to 
 * language features which are not context free, but the JavaModelRepairer
 * also simplifies deeply nested expression trees caused by the right 
 * recursive structure of the Java grammar.
 */
public class JavaModelRepairer {

	/**
	 * Modifies the model of the given resource by introducing 
	 * 1) nested expressions that were mistakenly recognized as casts and  
	 * 2) shift expressions that were mistakenly recognized as type arguments
	 * by the generated parser. Calls <code>repairWrongTypeArguments()</code>
	 * and <code>repairWrongCasts()</code>
	 * 
	 * @param resource
	 */
	public static void repair(ITextResource resource) {
		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CastExpression) {
				CastExpression castExpression = (CastExpression) next;
				repairWrongCasts(castExpression, resource);
			}
			if (next instanceof IdentifierReference) {
				IdentifierReference identifierReference = (IdentifierReference) next;
				repairWrongTypeArguments(identifierReference, resource);
			}
		}
	}
	
	/**
	 * Modifies the model of the given resource by introducing nested expressions that
	 * were mistakenly recognized as casts by the generated parser.
	 * 
	 * @param resource
	 */
	public static void repairWrongTypeArguments(
			IdentifierReference identifierReference, ITextResource resource) {
		if(identifierReference.getTypeArguments().size() == 1) {
			//find containing relation expression
			EObject container = identifierReference;
			int idx = -1;
			while(container != null && !(container instanceof RelationExpression)) {
				EObject child = container;
				container = container.eContainer();
				if (child.eContainmentFeature().isMany()) {
					idx = ((List<?>)container.eGet(child.eContainmentFeature())).indexOf(child);
				}
				else {
					idx = 0;
				}
			}
			
			//look for an identifier with type parameters among the children
			if (container != null) {
				RelationExpression relationExpression = (RelationExpression) container;
				//if this is followed by a GreaterThan...
				if(relationExpression.getRelationOperators().size() > idx
						&& relationExpression.getRelationOperators().get(idx) instanceof GreaterThan) {
				
					GreaterThan gt = (GreaterThan) relationExpression.getRelationOperators().get(idx);
					
					ShiftExpression rightSide = (ShiftExpression) relationExpression.getChildren().get(idx + 1);
					NamespaceClassifierReference nsClassifierReference = (NamespaceClassifierReference)((QualifiedTypeArgument)
							identifierReference.getTypeArguments().get(0)).getTypeReference();
					IdentifierReference newReference = createIdentifierReferenceWithProxy(
							resource, nsClassifierReference);
					
					//remove wrong type argument reference from the left
					identifierReference.getTypeArguments().clear();
					
					rightSide.getChildren().add(0,newReference);
					rightSide.getShiftOperators().add(
							OperatorsFactory.eINSTANCE.createRightShift());
					
					EcoreUtil.replace(gt, OperatorsFactory.eINSTANCE.createLessThan());
				}
			}
		}
	}

	/**
	 * Modifies the model of the given resource by introducing nested expressions that
	 * were mistakenly recognized as casts by the generated parser.
	 * 
	 * @param resource
	 */
	public static void repairWrongCasts(CastExpression castExpression, ITextResource resource) {
		if(castExpression.getChild() instanceof UnaryExpression) {
			UnaryExpression unaryExpression = (UnaryExpression) castExpression.getChild();
			if (unaryExpression.getOperators().size() == 1 && 
					unaryExpression.getOperators().get(0) instanceof AdditiveOperator &&
					castExpression.getTypeReference() instanceof NamespaceClassifierReference) {
				
				//try to resolve the cast
				NamespaceClassifierReference nsClassifierReference = (NamespaceClassifierReference)castExpression.getTypeReference();
				EObject proxy = (EObject) nsClassifierReference
						.getClassifierReferences().get(0).eGet(TypesPackage.Literals.CLASSIFIER_REFERENCE__TARGET, false);
				EObject resolved = EcoreUtil.resolve(proxy, castExpression.eResource());

				if (!(resolved instanceof PrimitiveType)) {
					
					IdentifierReference rootIdRef = createIdentifierReferenceWithProxy(
							resource, nsClassifierReference);
					
					//find the containing additive expression to modify it 
					EObject aeChild = castExpression.eContainer();
					while(!(aeChild.eContainer() instanceof AdditiveExpression)) {
						aeChild = aeChild.eContainer();
					}
					AdditiveExpression additiveExpression = (AdditiveExpression) aeChild.eContainer();
					
					NestedExpression nestedExpression = ExpressionsFactory.eINSTANCE.createNestedExpression();

					nestedExpression.setExpression(rootIdRef);
					
					int idx = additiveExpression.getChildren().indexOf(aeChild);
					if (idx + 1 == additiveExpression.getChildren().size()) {
						additiveExpression.getChildren().add(unaryExpression.getChild());
					}
					else {
						additiveExpression.getChildren().add(idx + 1,unaryExpression.getChild());
					}
					if (idx == additiveExpression.getAdditiveOperators().size()) {
						additiveExpression.getAdditiveOperators().add((AdditiveOperator)unaryExpression.getOperators().get(0));
					}
					else {
						additiveExpression.getAdditiveOperators().add(idx,(AdditiveOperator)unaryExpression.getOperators().get(0));
					}
					EcoreUtil.replace(castExpression, nestedExpression);
					
					//TODO #764: set location map for nested expression and additive operator and identifier reference
				}
			}
		}
	}

	private static IdentifierReference createIdentifierReferenceWithProxy(ITextResource resource,
			NamespaceClassifierReference nsClassifierReference) {
		EObject proxy = (EObject) nsClassifierReference
			.getClassifierReferences().get(0).eGet(TypesPackage.Literals.CLASSIFIER_REFERENCE__TARGET, false);
		
		IdentifierReference mainIdReference = ReferencesFactory.eINSTANCE.createIdentifierReference();
		mainIdReference.eSet(
				ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET, proxy);
		String id = ((InternalEObject)proxy).eProxyURI().fragment();
		id = id.substring(IContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
		id = id.substring(id.indexOf("_") + 1);
		
		resource.registerContextDependentProxy(
				new JavaContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new JavaReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
				mainIdReference,
				ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET,
				id,
				proxy);
		
		IdentifierReference rootIdRef = mainIdReference;
		IdentifierReference prevIdRef = null;
		
		//namespace needs to be converted into reference chain
		for(String nsPart : nsClassifierReference.getNamespaces()) {
			IdentifierReference idRef = ReferencesFactory.eINSTANCE.createIdentifierReference();
			InternalEObject newProxy = (InternalEObject) EcoreUtil.copy(proxy);
			
			String newFragment = newProxy.eProxyURI().fragment();
			newFragment = newFragment.substring(0,newFragment.indexOf("_") + 1) + nsPart;
			
			URI newURI = newProxy.eProxyURI().trimFragment().appendFragment(newFragment);
			newProxy.eSetProxyURI(newURI);
			
			idRef.setTarget((ReferenceableElement) newProxy);
			
			resource.registerContextDependentProxy(
					new JavaContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new JavaReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
					idRef,
					ReferencesPackage.Literals.ELEMENT_REFERENCE__TARGET,
					nsPart,
					newProxy);
			
			String proxyURI = newProxy.eProxyURI().toString();
			proxyURI = proxyURI.substring(0,proxyURI.lastIndexOf("_"));
			
			if(prevIdRef != null) {
				prevIdRef.setNext(idRef);
			}
			else {
				rootIdRef = idRef;
			}
			prevIdRef = idRef;
		}
		
		if (prevIdRef != null) {
			prevIdRef.setNext(mainIdReference);
		}
		return rootIdRef;
	}
}
