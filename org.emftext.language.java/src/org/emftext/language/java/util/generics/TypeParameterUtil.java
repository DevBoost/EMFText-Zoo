package org.emftext.language.java.util.generics;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.expressions.Expression;
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
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.classifiers.ClassUtil;
import org.emftext.language.java.util.classifiers.InterfaceUtil;
import org.emftext.language.java.util.references.ReferenceUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class TypeParameterUtil {
	
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
			if (type instanceof Class) {
				Class superClass = (Class) type;
				resultClassifierList.add(superClass);
				ClassUtil.collectAllSuperClassifiers(superClass, resultClassifierList);
			}
			if (type instanceof TypeParameter) {
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
	public static Type getBoundType(TypeParameter _this, Reference reference) {
		TypeParametrizable typeParameterDeclarator = (TypeParametrizable) _this.eContainer();
		int typeParameterIndex = -1;
		if (typeParameterDeclarator instanceof ConcreteClassifier) {
			typeParameterIndex = typeParameterDeclarator.getTypeParameters().indexOf(_this);
			if(reference != null && reference.eContainer() instanceof ElementReference) {
				ReferenceableElement prevRef = ((ElementReference) reference.eContainer()).getTarget();
				if (prevRef instanceof TypedElement) {
					TypeReference prevTypeReference = ((TypedElement) prevRef).getType();
					if (prevTypeReference instanceof TypeReference || prevTypeReference instanceof NamespaceClassifierReference) {
						ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(prevTypeReference);
						Type prevType = TypeReferenceUtil.getTarget(classifierReference, (ElementReference) reference.eContainer());
						if (classifierReference != null && !classifierReference.getTypeArguments().isEmpty() && prevType instanceof ConcreteClassifier) {
							if (typeParameterIndex < classifierReference.getTypeArguments().size())  {
								TypeArgument arg = classifierReference.getTypeArguments().get(typeParameterIndex);
								if (arg instanceof QualifiedTypeArgument) {
									return TypeReferenceUtil.getTarget(((QualifiedTypeArgument) arg).getType(), null);
								}	
							}
						}
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
						return TypeReferenceUtil.getTarget(((QualifiedTypeArgument)typeArgument).getType()); 
					} 
				}

				for(Expression argument : methodCall.getArguments()) {
					int idx = methodCall.getArguments().indexOf(argument);
					if (idx >= method.getParameters().size()) {
						continue;
					}
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
												return TypeReferenceUtil.getTarget(
														((QualifiedTypeArgument)argumentType.getTypeArguments().get(parameterType.getTypeArguments().indexOf(typeArgument))).getType());
											}
										}
									}
								}
								if (argumentType != null && parameterType.getTarget() instanceof TypeParameter) {
									return argumentType.getTarget();
								}
							}
							if(elementReference.getNext() instanceof ReflectiveClassReference) {
								if (parameterType.getTypeArguments().size() == 1) {
									for(TypeArgument typeArgument : parameterType.getTypeArguments()) {
										if(typeArgument instanceof QualifiedTypeArgument) {
											if(TypeReferenceUtil.getTarget(((QualifiedTypeArgument) typeArgument).getType()).equals(_this)) {
												return ReferenceUtil.getType(elementReference);
											}
										}
									}
								}
							}
						}
						else {
							if (parameterType.getTarget() instanceof TypeParameter) {
								return ReferenceUtil.getType((Reference) argReference);
							}
						}
					}
				}
			}
		}
		
		return _this;
	}
	
}
