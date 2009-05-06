package org.emftext.language.java.util.generics;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.classifiers.impl.ClassifierImpl;
import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.expressions.NestedExpression;
import org.emftext.language.java.generics.ExtendsTypeArgument;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.generics.TypeArgument;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.generics.TypeParametrizable;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.references.ReflectiveClassReference;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.classifiers.ClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;
import org.emftext.language.java.util.classifiers.InterfaceUtil;
import org.emftext.language.java.util.expressions.ExpressionUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class TypeParameterUtil {
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
	public static  void collectAllSuperClassifiers(TypeParameter _this, 
			EList<ConcreteClassifier> resultClassifierList) {
		
		for(TypeReference typeRef : _this.getExtendTypes()) {
			Type type = TypeReferenceUtil.getTarget(typeRef);
			if (type instanceof Interface) {
				Interface superInterface = (Interface) type;
				resultClassifierList.add(superInterface);
				InterfaceUtil.collectAllSuperInterfaces(superInterface.getExtends(), resultClassifierList);
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
		EList<Type> resultList = new BasicEList<Type>();
		TypeParametrizable typeParameterDeclarator = (TypeParametrizable) _this.eContainer();
		Reference parentReference = null;
		Type prevType = null;
		if (reference != null && reference.eContainer() instanceof NestedExpression) {
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
				prevType = ExpressionUtil.getType(nestedExpression.getExpression());
			}
		}
		else if (reference != null && reference.eContainer() instanceof Reference) {
			parentReference = (Reference) reference.eContainer();
			prevType = ReferenceUtil.getType(parentReference);
		}
		
		
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
					for(ClassifierReference superClassifierReference : ConcreteClassifierUtil.getSuperTypeReferences((ConcreteClassifier) prevType)) {
						if (typeParameterIndex < superClassifierReference.getTypeArguments().size())  {
							//is this an argument for the correct class?
							if (typeParameterDeclarator.equals(TypeReferenceUtil.getTarget(superClassifierReference))) {					 
								TypeArgument arg = superClassifierReference.getTypeArguments().get(typeParameterIndex);
								if (arg instanceof QualifiedTypeArgument) {
									resultList.add(0, TypeReferenceUtil.getTarget(((QualifiedTypeArgument) arg).getType(), null));
								}
							}

						}
					}
					if (classifierReference != null && typeParameterIndex < classifierReference.getTypeArguments().size())  {
						TypeArgument arg = classifierReference.getTypeArguments().get(typeParameterIndex);
						if (arg instanceof QualifiedTypeArgument) {
							resultList.add(0, TypeReferenceUtil.getTarget(((QualifiedTypeArgument) arg).getType(), parentReference));
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
				}
			}
			if(reference != null && reference.eContainer() instanceof ReflectiveClassReference) {
				if (reference.eContainer().eContainer() instanceof Reference) {
					//the ".class" instantiation implicitly binds the T parameter of java.lang.Class to the class itself
					resultList.add(0, ReferenceUtil.getType((Reference)reference.eContainer().eContainer()));
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
									if(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()).equals(_this)) {
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
					
					if (parameterType != null && argument instanceof Reference) {
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
		
		if(resultList.isEmpty() || 
				(resultList.size() == 1 && resultList.get(0).equals(_this))) {
			return _this;
		}
		else {
			TemporalCompositeClassImpl temp = new TemporalCompositeClassImpl(_this);
			for(Type aResult : resultList) {
				temp.getSuperTypes().add((Classifier) aResult);
			}
			temp.getSuperTypes().add(_this);
			return temp;
		}
	}
	
}
