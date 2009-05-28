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
package org.emftext.language.java.util.generics;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.classifiers.impl.ClassifierImpl;
import org.emftext.language.java.expressions.CastExpression;
import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.generics.ExtendsTypeArgument;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.generics.TypeArgument;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.generics.TypeParametrizable;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.literals.Super;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.references.ReflectiveClassReference;
import org.emftext.language.java.references.SelfReference;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.classifiers.ClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;
import org.emftext.language.java.util.classifiers.InterfaceUtil;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;
import org.emftext.language.java.util.types.PrimitiveTypeUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

/**
 * A utility class that provides methods that belong to class 
 * TypeParameter, but can not go there, because TypeParameter 
 * is generated.
 */
public class TypeParameterUtil {
	
	/**
	 * This adapter is used to attach type arguments to a type when it is passed through
	 * several getBoundType() calls recursively. A better solution might be
	 * to pass type references along whenever possible. 
	 * <p>
	 * This however will require major changes in the API.
	 */
	public static class TemporalTypeArgumentHolder extends AdapterImpl {
		private EList<TypeArgument> typeArguments = new BasicEList<TypeArgument>();
		
		public EList<TypeArgument> getTypeArguments() {
			return typeArguments;
		}
		
	}
	
	// TODO jjohannes: add Javadoc
	public static class TemporalCompositeClassImpl extends ClassifierImpl {
		
		private TypeParameter creator;
		
		private EList<Classifier> superTypes = new BasicEList<Classifier>();
		
		public TemporalCompositeClassImpl(TypeParameter creator) {
			this.creator = creator;
		}

		public Resource eResource() {
			return creator.eResource();
		}

		public EList<Classifier> getSuperTypes() {
			return superTypes;
		}
	}
	
	/**
	 * Recursively collects all super types 
	 * of the given type parameter if any.
	 * 
	 * @param _this
	 * @param resultClassifierList the list for the result
	 */
	public static void collectAllSuperClassifiers(TypeParameter _this, 
			EList<ConcreteClassifier> resultClassifierList) {
		
		for(TypeReference typeRef : _this.getExtendTypes()) {
			Type type = TypeReferenceUtil.getTarget(typeRef);
			if (type instanceof Interface) {
				Interface superInterface = (Interface) type;
				resultClassifierList.add(superInterface);
				resultClassifierList.addAll(InterfaceUtil.getAllSuperInterfaces(superInterface.getExtends()));
			}
			else if (type instanceof Class) {
				Class superClass = (Class) type;
				resultClassifierList.add(superClass);
				ClassUtil.collectAllSuperClassifiers(superClass, resultClassifierList);
			}
			else if (type instanceof ConcreteClassifier){
				ConcreteClassifier superClassifier = (ConcreteClassifier) type;
				resultClassifierList.add(superClassifier);
			}
			else if (type instanceof TypeParameter) {
				TypeParameter superTypeParameter = (TypeParameter) type;
				collectAllSuperClassifiers(superTypeParameter, resultClassifierList);
			}
		}
	}

	/**
	 * Returns the type bound to the given parameter in the context
	 * of the given reference.
	 * 
	 * @param _this
	 * @param reference
	 * @return bound type or parameter if not bound
	 */
	public static Type getBoundType(TypeParameter _this, TypeReference typeReference, Reference reference) {
		if (_this == null) {
			return null;
		}

		EList<Type> resultList = new BasicEList<Type>();
		TypeParametrizable typeParameterDeclarator = (TypeParametrizable) _this.eContainer();
		Reference parentReference = null;
		EList<Type> prevTypeList = new BasicEList<Type>();
		if (reference != null && 
				reference.eContainer() instanceof NestedExpression && 
				reference.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			NestedExpression nestedExpression = (NestedExpression) reference.eContainer();
			Expression expression = null;
			if (nestedExpression.getExpression() instanceof Reference) {
				expression = nestedExpression.getExpression();
			}
			else if (nestedExpression.getExpression() instanceof ConditionalExpression) {
				expression = ((ConditionalExpression)nestedExpression.getExpression()).getExpressionIf();
			}

			
			if (expression instanceof Reference) {
				Reference expressionReference = (Reference) expression;
				//navigate down references
				while(expressionReference.getNext() != null) {
					expressionReference = expressionReference.getNext();
				}
				parentReference = expressionReference;
				Type prevType = ExpressionUtil.getType(nestedExpression.getExpression());
				if(prevType instanceof TemporalCompositeClassImpl) {
					prevTypeList.addAll(((TemporalCompositeClassImpl)prevType).getSuperTypes());
				}
				else {
					prevTypeList.add(prevType);
				}
			}
			else if (nestedExpression.getExpression() instanceof CastExpression) {
				prevTypeList.add(TypeReferenceUtil.getTarget(((CastExpression)nestedExpression.getExpression()).getType()));
			}
		}
		else if (reference != null && reference.eContainingFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
			parentReference = (Reference) reference.eContainer();
			while (parentReference instanceof SelfReference) {
				if (((SelfReference)parentReference).getSelf() instanceof Super) {
					if (parentReference.eContainer() instanceof Reference) {
						parentReference = (Reference) parentReference.eContainer();
					}
					else {
						ConcreteClassifier containingClassifier = JavaUtil.findContainingClassifier(reference);
						if (containingClassifier != null) {
							prevTypeList.add(containingClassifier);
						}
						parentReference = null;
					}
				}
				else {
					break;
				}
			}
			if (parentReference != null) {
				Type prevType = ReferenceUtil.getType(parentReference);
				if(prevType instanceof TemporalCompositeClassImpl) {
					prevTypeList.addAll(((TemporalCompositeClassImpl)prevType).getSuperTypes());
				}
				else {
					prevTypeList.add(prevType);
				}
			}
		}
		else if (reference != null) {
			//prev type is on of the containing classes which can still bind by inheritance
			ConcreteClassifier containingClassifier = JavaUtil.findContainingClassifier(reference);
			while (containingClassifier != null) {
				prevTypeList.add(containingClassifier);
				containingClassifier = JavaUtil.findContainingClassifier(containingClassifier.eContainer());
			}
		}
		
		for(Type prevType : prevTypeList) {
			int typeParameterIndex = -1;
			if (typeParameterDeclarator instanceof ConcreteClassifier) {
				typeParameterIndex = typeParameterDeclarator.getTypeParameters().indexOf(_this);
				if(reference != null) {
					ClassifierReference classifierReference = null;
					if(parentReference instanceof ElementReference) {
						ReferenceableElement prevReferenced = ((ElementReference) parentReference).getTarget();
						if(prevReferenced instanceof TypedElement) {
							classifierReference = ClassifierReferenceUtil.getPureClassifierReference(((TypedElement) prevReferenced).getType());
						}
					}
					if(parentReference instanceof TypedElement) {
						//e.g. New Constructor Call
						classifierReference = ClassifierReferenceUtil.getPureClassifierReference(((TypedElement) parentReference).getType());
					}
					if (prevType instanceof ConcreteClassifier) {
						//bound through inheritance?
						int idx = 0;
						for(ClassifierReference superClassifierReference : ConcreteClassifierUtil.getSuperTypeReferences((ConcreteClassifier) prevType)) {
							if (typeParameterIndex < superClassifierReference.getTypeArguments().size())  {
								//is this an argument for the correct class?
								if (typeParameterDeclarator.equals(TypeReferenceUtil.getTarget(superClassifierReference)) ||
										ClassifierUtil.getAllSuperClassifiers((Classifier)TypeReferenceUtil.getTarget(superClassifierReference)).contains(
												typeParameterDeclarator)) {					 
									TypeArgument arg = superClassifierReference.getTypeArguments().get(typeParameterIndex);
									if (arg instanceof QualifiedTypeArgument) {
										resultList.add(idx, TypeReferenceUtil.getTarget(((QualifiedTypeArgument) arg).getType(), null));
										idx++;
									}
								}
	
							}
						}
						EList<TypeArgument> typeArgumentList;
						TemporalTypeArgumentHolder ttah = null;
						for(Adapter adapter : prevType.eAdapters()) {
							if (adapter instanceof TemporalTypeArgumentHolder) {
								ttah = (TemporalTypeArgumentHolder) adapter; 
								prevType.eAdapters().remove(ttah);
								break;
							}
						}
						if (ttah != null) {
							typeArgumentList = ttah.getTypeArguments();
						}
						else if (classifierReference != null) {
							typeArgumentList = classifierReference.getTypeArguments();
						}
						else {
							typeArgumentList = ECollections.emptyEList();
						}
						
						if (typeParameterIndex < typeArgumentList.size())  {
							TypeArgument arg = typeArgumentList.get(typeParameterIndex);
							if (arg instanceof QualifiedTypeArgument) {
								ClassifierReference theTypeRef = ClassifierReferenceUtil.getPureClassifierReference(((QualifiedTypeArgument) arg).getType());
								Type theType = TypeReferenceUtil.getTarget(theTypeRef, parentReference);
								if (theType != null) {
									if (!theTypeRef.getTypeArguments().isEmpty()) {
										ttah = new TemporalTypeArgumentHolder();
										ttah.getTypeArguments().addAll(theTypeRef.getTypeArguments());
										theType.eAdapters().add(ttah);
									}
								}
								resultList.add(0, theType);
							}
							if (arg instanceof ExtendsTypeArgument) {
								for(TypeReference extendedType : ((ExtendsTypeArgument) arg).getExtendTypes()) {
									resultList.add(0, TypeReferenceUtil.getTarget(extendedType, parentReference));
								}
							}
						}
			
					}
					else if (prevType instanceof TypeParameter) {
						//the prev. type parameter, although unbound, may contain type restrictions through extends 
						resultList.add(prevType);
						for(TypeReference extendedRef : ((TypeParameter) prevType).getExtendTypes()) {
							ConcreteClassifier extended = (ConcreteClassifier )TypeReferenceUtil.getTarget(extendedRef);
							int idx = ((TypeParametrizable)prevType.eContainer()).getTypeParameters().indexOf(prevType);
							if (extended.getTypeParameters().size() > idx) {
								//also add more precise bindings from extensions
								resultList.add(extended.getTypeParameters().get(idx));
							}
						}
					}
				}
				if(reference != null && reference.eContainer() instanceof ReflectiveClassReference) {
					if (reference.eContainer().eContainer() instanceof Reference) {
						//the ".class" instantiation implicitly binds the T parameter of java.lang.Class to the class itself
						resultList.add(0, ReferenceUtil.getType((Reference)reference.eContainer().eContainer()));
					}
				}
			}
		}
		
		if (typeParameterDeclarator instanceof Method) {
			if (reference instanceof MethodCall) {
				Method method = (Method) typeParameterDeclarator;
				MethodCall methodCall = (MethodCall) reference;
				if(method.getTypeParameters().size() == methodCall.getCallTypeArguments().size()) {
					TypeArgument typeArgument = methodCall.getCallTypeArguments().get(method.getTypeParameters().indexOf(_this));
					if (typeArgument instanceof QualifiedTypeArgument) {
						resultList.add(0, TypeReferenceUtil.getTarget(((QualifiedTypeArgument)typeArgument).getType(), parentReference)); 
					} 
				}

				//class type parameter
				int idx = method.getParameters().indexOf(typeReference.eContainer());
				
				//method type parameter
				if (idx == -1) {
					for(Parameter parameter : method.getParameters()) {
						for (TypeArgument typeArgument : parameter.getTypeArguments()) {
							if(typeArgument instanceof QualifiedTypeArgument) {
								if(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()).equals(_this)) {
									idx = method.getParameters().indexOf(parameter);
								}
							}
						}
						ClassifierReference paramTypeReference = ClassifierReferenceUtil.getPureClassifierReference(parameter.getType());
						if (paramTypeReference != null) {
							for (TypeArgument typeArgument : paramTypeReference.getTypeArguments()) {
								if(typeArgument instanceof QualifiedTypeArgument) {
									if(_this.equals(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()))) {
										idx = method.getParameters().indexOf(parameter);
									}
								}
							}
						}
					}
				}
				
				if (idx < methodCall.getArguments().size() && idx >= 0) {
					Expression argument = methodCall.getArguments().get(idx);
					Parameter parameter = method.getParameters().get(idx);
					ClassifierReference parameterType = ClassifierReferenceUtil.getPureClassifierReference(parameter.getType());
					if (argument instanceof NewConstructorCall) {
						ClassifierReference argumentType = ClassifierReferenceUtil.getPureClassifierReference(((NewConstructorCall)argument).getType());
						if (argumentType != null && parameterType.getTypeArguments().size() == argumentType.getTypeArguments().size()) {
							for(TypeArgument typeArgument : parameterType.getTypeArguments()) {
								if(typeArgument instanceof QualifiedTypeArgument) {
									if(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()).equals(_this)) {
										resultList.add(0, TypeReferenceUtil.getTarget(
												((QualifiedTypeArgument)argumentType.getTypeArguments().get(parameterType.getTypeArguments().indexOf(typeArgument))).getType()));
									}
								}
							}
						}
						if (argumentType != null && parameterType.getTarget() instanceof TypeParameter) {
							resultList.add(0,argumentType.getTarget());
						}
					}
					else if (parameterType != null && argument instanceof Reference) {
						Reference argReference = (Reference) argument;
						
						while (argReference.getNext() instanceof Reference &&
								!(argReference.getNext() instanceof ReflectiveClassReference) ) {
							argReference = argReference.getNext();
						}
	
						
						if (argReference instanceof ElementReference) {
							ElementReference elementReference = (ElementReference) argReference;
							while (elementReference.getNext() instanceof ElementReference) {
								elementReference = (ElementReference) elementReference.getNext();
							}
							if (elementReference.getTarget() instanceof TypedElement) {
								ClassifierReference argumentType = ClassifierReferenceUtil.getPureClassifierReference(((TypedElement)elementReference.getTarget()).getType());
								if (argumentType != null && parameterType.getTypeArguments().size() == argumentType.getTypeArguments().size()) {
									for(TypeArgument typeArgument : parameterType.getTypeArguments()) {
										if(typeArgument instanceof QualifiedTypeArgument) {
											if(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()).equals(_this)) {
												int idx2 = parameterType.getTypeArguments().indexOf(typeArgument);
												if (argumentType.getTypeArguments().get(idx2) instanceof QualifiedTypeArgument) {
													resultList.add(0, TypeReferenceUtil.getTarget(
															((QualifiedTypeArgument)argumentType.getTypeArguments().get(idx2)).getType()));
												}
												else if (argumentType.getTypeArguments().get(idx2) instanceof ExtendsTypeArgument) {
													for(TypeReference extendedType : ((ExtendsTypeArgument) argumentType.getTypeArguments().get(idx2)).getExtendTypes()) {
														resultList.add(0, TypeReferenceUtil.getTarget(extendedType));
													}
												}
											}
										}
									}
								}
								if (argumentType != null && parameterType.getTarget() instanceof TypeParameter) {
									resultList.add(0,argumentType.getTarget());
								}
							}
							if(elementReference.getNext() instanceof ReflectiveClassReference) {
								if (parameterType.getTypeArguments().size() == 1) {
									for(TypeArgument typeArgument : parameterType.getTypeArguments()) {
										if(typeArgument instanceof QualifiedTypeArgument) {
											if(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()).equals(_this)) {
												resultList.add(0, ReferenceUtil.getType(elementReference));
											}
										}
									}
								}
							}
						}
						else {
							if (parameterType.getTarget() instanceof TypeParameter) {
								while (argReference.getNext() instanceof Reference) {
									argReference = argReference.getNext();
								}
								resultList.add(0, ReferenceUtil.getType((Reference) argReference));
							}
						}
					}			
				}
				
				//return type
				if(method.equals(typeReference.eContainer())) {
					//bound by the type of a method argument?
					EList<Classifier> allSuperTypes = null;
					for(Parameter parameter : method.getParameters()) {
						if(_this.equals(TypeReferenceUtil.getTarget(parameter.getType()))) {
							idx = method.getParameters().indexOf(parameter);
							Classifier argumentType = (Classifier) ExpressionUtil.getType(methodCall.getArguments().get(idx));
							if(allSuperTypes == null) {
								allSuperTypes = new BasicEList<Classifier>();
								allSuperTypes.add(argumentType);
								allSuperTypes.addAll(ClassifierUtil.getAllSuperClassifiers(argumentType));
							}
							else {
								allSuperTypes.add(argumentType);
								EList<Classifier> allOtherSuperTypes = new BasicEList<Classifier>();
								allOtherSuperTypes.add(argumentType);
								allOtherSuperTypes.addAll(ClassifierUtil.getAllSuperClassifiers(argumentType));
								EList<Classifier> temp = allSuperTypes;
								allSuperTypes = new BasicEList<Classifier>();
								for(Classifier st : allOtherSuperTypes) {
									if(temp.contains(st)) {
										allSuperTypes.add(st);
									}
								}
							}
						}
	 				}
					//all types given by all bindings
					if (allSuperTypes != null) {
						resultList.addAll(allSuperTypes);
					}
				}
			}
		}
		
		//remove nulls
		for(Iterator<?> it = resultList.iterator(); it.hasNext(); ) {
			if (it.next() == null) {
				it.remove();
			}
		}
		
		if(resultList.isEmpty() || 
				(resultList.size() == 1 && resultList.get(0).equals(_this))) {
			return _this;
		}
		else {
			TemporalCompositeClassImpl temp = new TemporalCompositeClassImpl(_this);
			for(Type aResult : resultList) {
				if(aResult instanceof PrimitiveType) {
					aResult = PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType) aResult);
				}
				
				if (aResult instanceof TemporalCompositeClassImpl) {
					//flatten
					temp.getSuperTypes().addAll(((TemporalCompositeClassImpl)aResult).getSuperTypes());
				}
				else {
					temp.getSuperTypes().add((Classifier) aResult);	
				}
			}
			temp.getSuperTypes().add(_this);
			return temp;
		}
	}
	
}
