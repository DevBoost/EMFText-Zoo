package org.emftext.language.java.util.generics;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.generics.TypeArgument;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.generics.TypeParametrizable;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.classifiers.ClassUtil;
import org.emftext.language.java.util.classifiers.InterfaceUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;
import org.emftext.language.java.util.types.TypeReferenceUtil;

public class TypeParameterUtil {
	
	public static  void collectAllSuperClassifiers( TypeParameter typeParameter, 
			EList<ConcreteClassifier> resultClassifierList) {
		
		for(TypeReference typeRef : typeParameter.getExtendTypes()) {
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
	 * @return
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
							TypeArgument arg = classifierReference.getTypeArguments().get(typeParameterIndex);
							if (arg instanceof QualifiedTypeArgument) {
								return TypeReferenceUtil.getTarget(((QualifiedTypeArgument) arg).getType(), null);
							}
						}
					}
				}
			}
		}
		
		if (typeParameterDeclarator instanceof Method) {
			Method method = (Method) typeParameterDeclarator;
			for(int i = 0; i < method.getParameters().size(); i++) {
				ClassifierReference classifierReference = ClassifierReferenceUtil.getPureClassifierReference(method.getParameters().get(i).getType());
				if(classifierReference != null && _this.equals(classifierReference.getTarget())) {
					typeParameterIndex = i;
					break;
				}
			}
			if (reference instanceof ElementReference) {
				ElementReference idReference = (ElementReference)reference;

				if (typeParameterIndex != -1 && typeParameterIndex < idReference.getTypeArguments().size()) {
					TypeArgument typeArgument = idReference.getTypeArguments().get(typeParameterIndex);
					if(typeArgument instanceof QualifiedTypeArgument) {
						return TypeReferenceUtil.getTarget(((QualifiedTypeArgument)typeArgument).getType(), null);
					}
				}
			}
		}
		
		return _this;
	}
}
