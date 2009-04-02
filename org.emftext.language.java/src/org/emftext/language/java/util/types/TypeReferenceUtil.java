package org.emftext.language.java.util.types;

import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.generics.TypeParameterUtil;

public class TypeReferenceUtil {

	/**
	 * Returns the type referenced by the given <code>TypeReference</code>
	 * considering all concrete subclasses of <code>TypeReference</code> used
	 * by the Java metamodel. 
	 * 
	 * @param typeReference the type reference 
	 * @return the type
	 */
	public static Type getTarget(TypeReference typeReference) {
		return getTarget(typeReference, null);
	}
	
	/**
	 * Returns the type referenced by the given <code>TypeReference</code>
	 * considering all concrete subclasses of <code>TypeReference</code> used
	 * by the Java metamodel. If type parameters are bound in the given reference,
	 * the bound type will be returned instead tf the parameter.
	 * 
	 * @param typeReference the type reference 
	 * @return the type
	 */
	public static Type getTarget(TypeReference typeReference, Reference reference) {
		
		Type type = null;
		if (typeReference instanceof ClassifierReference || 
				typeReference instanceof NamespaceClassifierReference) {
			ClassifierReference classifierRef = ClassifierReferenceUtil.getPureClassifierReference(typeReference);
			if (classifierRef != null) {
				type = classifierRef.getTarget();
			}
		}

		else if(typeReference instanceof PrimitiveType) {
			return (PrimitiveType) typeReference;
		}
		
		//resolve parameter to real type
		if (type instanceof TypeParameter) {
			type = TypeParameterUtil.getBoundType((TypeParameter) type, reference);
		}

		if (type != null && type.eIsProxy()) {
			//this may happen, when e.g. a super type is resolved. It is ok.
			return null;
		}
		
		return type;
	}
}