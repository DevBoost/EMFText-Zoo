package org.emftext.language.java.util.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.arrays.ArrayTypeable;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.parameters.VariableLengthParameter;
import org.emftext.language.java.types.Boolean;
import org.emftext.language.java.types.Byte;
import org.emftext.language.java.types.Char;
import org.emftext.language.java.types.Double;
import org.emftext.language.java.types.Float;
import org.emftext.language.java.types.Int;
import org.emftext.language.java.types.Long;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Short;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypedElement;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.arrays.ArrayTypeableUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.classifiers.ClassUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;

public class TypeUtil {
	
	/**
	 * @param _this
	 * @param otherType
	 * @return if both type are equal
	 */
	public static boolean equalsType(Type _this, int _thisArrayDim,
			Type otherType, int otherArrayDim) {
		
		//do comparison on the classifier level
		if (_this instanceof PrimitiveType) {
			_this = PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType) _this);
		}
		if (otherType instanceof PrimitiveType) {
			otherType = PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType) otherType);
		}
		
		if (_thisArrayDim == otherArrayDim &&
				otherType instanceof Classifier && _this instanceof Classifier &&
				(otherType.equals(_this))) {	
			return true;
		}
		
		return false;
	}

	/**
	 * @param _this
	 * @param otherType
	 * @return if the other type is equal to me or a super type of me
	 */
	public static boolean isSuperType(Type _this, int arrayDim,
			Type otherType, ArrayTypeable otherArrayType) {
		
		
		//if I am a void, I am of every type
		if (_this.equals(JavaClasspathUtil.getClass("Void", _this))) {
			return true;
		}
		
		//if the other is Object I am a subtype in any case (also array dimensions do not matter)
		if (otherType.equals(JavaClasspathUtil.getObjectClass(_this))) {
			return true;
		}
		
		//String, primitives, and arrays are serializable
		ConcreteClassifier serializableClass = (ConcreteClassifier) EcoreUtil.resolve(
				JavaClasspath.get(_this).getClassifier("java.io.Serializable"), _this);
		if (otherType.equals(serializableClass)) {
			if (_this.equals(serializableClass)) {
	 			return true;
			}
			else if (_this.equals(JavaClasspathUtil.getStringClass(_this))) {
	 			return true;
			}
			else if (_this instanceof PrimitiveType) {
				return true;
			}
			else if (arrayDim > 0) {
				//all arrays are serializable
				return true;
			}
		}
		
		//if one of us is a parameter to the best of my knowledge, we might match
		if(_this instanceof TypeParameter || otherType instanceof TypeParameter ) {
			return true;
		}
		
		//if array dimensions do not match, I am no subtype
		boolean isTypeParameter = false;		
		if (otherArrayType instanceof TypedElement) {
			Type type = TypeReferenceUtil.getTarget(((TypedElement)otherArrayType).getType());
			isTypeParameter = type instanceof TypeParameter;
		}
		boolean isVariableLengthParameter = otherArrayType instanceof VariableLengthParameter;
		
		int otherArrayDim = ArrayTypeableUtil.getArrayDimension(otherArrayType);
		if (isTypeParameter && isVariableLengthParameter) {
			if(arrayDim != otherArrayDim && arrayDim != otherArrayDim-1 && arrayDim < otherArrayDim) {
				return false;
			}
		}
		else if (isTypeParameter) {
			if(arrayDim < otherArrayDim) {
				return false;
			}
		}
		else if (isVariableLengthParameter) {
			if(arrayDim != otherArrayDim && arrayDim != otherArrayDim-1) {
				return false;
			}
		}
		else {
			if(arrayDim != otherArrayDim) {
				return false;
			}
		}
		
		//annotations
		if(_this instanceof Annotation && 
				(otherType.equals(JavaClasspathUtil.getAnnotationClass(_this)) ||
						ClassifierUtil.getAllSuperClassifiers(
								(ConcreteClassifier)_this).contains(JavaClasspathUtil.getAnnotationClass(_this)))) {
			return true;
		}

		//do comparison on the classifier level
		if (_this instanceof PrimitiveType) {
			_this = PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType) _this);
		}
		if (otherType instanceof PrimitiveType) {
			otherType = PrimitiveTypeUtil.wrapPrimitiveType((PrimitiveType) otherType);
		}
		
		//compare in type hierarchy
		if (otherType instanceof ConcreteClassifier && _this instanceof ConcreteClassifier &&
				(otherType.equals(_this) || 
						ClassifierUtil.getAllSuperClassifiers(
								(ConcreteClassifier)_this).contains(otherType))) {
			return true;
		}
		
		if (otherType instanceof ConcreteClassifier && _this instanceof AnonymousClass &&
				AnonymousClassUtil.getAllSuperClassifiers(
						(AnonymousClass)_this).contains(otherType)) {
			
			return true;
		}
		
		//everything can be implicitly casted to CharSequence, so I match when the other type is a CharSequence
		Interface charSequenceClass = JavaClasspathUtil.getInterface("CharSequence", _this);
		
		if (otherType instanceof ConcreteClassifier) {
			if(otherType.equals(charSequenceClass) ||
					ClassifierUtil.getAllSuperClassifiers(
							(ConcreteClassifier)otherType).contains(charSequenceClass)) {
				return true;
			}
		}

		//there are some specifics for primitive types not reflected in the type hierarchy
		if (otherType instanceof Class) {
			PrimitiveType primitiveType = ClassUtil.unWrapPrimitiveType((Class) otherType);
			if(primitiveType == null) {
				return false;
			}
			otherType = primitiveType;
		}
		
		if (_this instanceof Class) {
			PrimitiveType primitiveType = ClassUtil.unWrapPrimitiveType((Class) _this);
			if(primitiveType == null) {
				return false;
			}
			_this = primitiveType;
		}

		if (_this instanceof Boolean) {
			if (otherType instanceof Boolean) {
				return true;
			}
			else {
				return false;
			}
		}
		if (_this instanceof Byte ||
				_this instanceof Int ||
				_this instanceof Short ||
				_this instanceof Long ||
				_this instanceof Char) {
			if (otherType instanceof Byte ||
					otherType instanceof Int ||
					otherType instanceof Short ||
					otherType instanceof Long ||
					otherType instanceof Char ||
					otherType instanceof Float ||
					otherType instanceof Double) {
				return true;
			}
			else {
				return false;
			}
		}
		if (_this instanceof Float ||
				_this instanceof Double) {
			if (otherType instanceof Float ||
					otherType instanceof Double) {
				return true;
			}
			else {
				return false;
			}
		}

		return false;
	}
}
