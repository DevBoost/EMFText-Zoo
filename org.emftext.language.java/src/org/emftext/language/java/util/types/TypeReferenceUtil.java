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
	 * @param _this 
	 * @return the type
	 */
	public static Type getTarget(TypeReference _this) {
		return getTarget(_this, null);
	}
	
	/**
	 * Returns the type referenced by the given <code>TypeReference</code>
	 * considering all concrete subclasses of <code>TypeReference</code> used
	 * by the Java metamodel. If type parameters are bound in the given reference,
	 * the bound type will be returned instead of the parameter.
	 * 
	 * @param _this
	 * @return the type
	 */
	public static Type getTarget(TypeReference _this, Reference reference) {
		
		Type type = null;
		if (_this instanceof ClassifierReference || 
				_this instanceof NamespaceClassifierReference) {
			ClassifierReference classifierRef = ClassifierReferenceUtil.getPureClassifierReference(_this);
			if (classifierRef != null) {
				type = classifierRef.getTarget();
			}
		}

		else if(_this instanceof PrimitiveType) {
			return (PrimitiveType) _this;
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