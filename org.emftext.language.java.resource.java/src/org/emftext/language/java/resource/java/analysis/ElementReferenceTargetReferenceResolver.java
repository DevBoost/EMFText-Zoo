package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesPackage;
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
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.generics.TypeParameterUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.PrimitiveTypeUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class ElementReferenceTargetReferenceResolver extends 
	AbstractReferenceResolver<ElementReference, ReferenceableElement> {
	
	@Override	
	protected java.lang.String doDeResolve(ReferenceableElement element, ElementReference container, org.eclipse.emf.ecore.EReference reference) {
		if (element instanceof ConcreteClassifier) {
			ConcreteClassifier concreteClassifier = (ConcreteClassifier) element;
			if(concreteClassifier.getFullName() != null) {
				return concreteClassifier.getFullName();
			}
		}
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, ElementReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ReferenceableElement> result) {
		EObject startingPoint = null;
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
				startingPoint = ReferenceUtil.getType(parentReference);
			
				//do not search on primitive types but their class representation
				if (startingPoint instanceof PrimitiveType) {
					startingPoint = PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType) startingPoint);
				}

				if (parentReference instanceof NestedExpression) {
					startingPoint = ExpressionUtil.getType(((NestedExpression)parentReference).getExpression());
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
		
		if (target == null) {
			if(startingPoint instanceof Type && parentReference instanceof ElementReference) {
				ReferenceableElement parentTarget = ((ElementReference)parentReference).getTarget();
				//there might be more possible bindings
				if(parentTarget instanceof TypedElement) {
					TypeReference typeReference = ((TypedElement)parentTarget).getType();
					Type type = TypeReferenceUtil.getTarget(typeReference);
					if (type instanceof TypeParameter) {
						List<Type> allStartingPoints = TypeParameterUtil.getAllBoundTypes((TypeParameter)type, typeReference, parentReference);
						for(Type aStartingPoint : allStartingPoints) {
							target = searchFromStartingPoint(identifier, container, reference,
									aStartingPoint);
							if(target != null) {
								break;
							}
						}
					}
				}
			}
		}
		
		if(target == null) {
			target = searchFromStartingPoint(identifier, container, reference,
					startingPoint);
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
}
