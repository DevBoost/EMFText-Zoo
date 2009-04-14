package org.emftext.language.java.util.types;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.AnonymousClass;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.generics.TypeParameter;
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
import org.emftext.language.java.types.Void;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.classifiers.AnonymousClassUtil;
import org.emftext.language.java.util.classifiers.ClassUtil;
import org.emftext.language.java.util.classifiers.ConcreteClassifierUtil;

public class TypeUtil {
	
	public static boolean equalsType(EObject _this,
			EObject otherType) {
		
		if (otherType instanceof Classifier && _this instanceof Classifier &&
				(otherType.equals(_this))) {	
			return true;
		}
		else if (otherType instanceof PrimitiveType && _this instanceof PrimitiveType && 
				otherType.eClass().equals(_this.eClass())) {
			return true;
		}
		
		return false;
	}

	public static boolean isSuperType(Type _this,
			Type otherType) {
		
		
		//if I am a void, I am of every type
		if (_this.equals(JavaClasspathUtil.getClass("Void", _this))) {
			return true;
		}
		
		//if one of us is a parameter to the best of my knowledge, we might match
		if(_this instanceof TypeParameter || otherType instanceof TypeParameter ) {
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
						ConcreteClassifierUtil.getAllSuperClassifiers(
								(ConcreteClassifier)_this).contains(otherType))) {
			return true;
		}
		
		if (otherType instanceof ConcreteClassifier && _this instanceof AnonymousClass &&
				AnonymousClassUtil.getAllSuperClassifiers(
						(AnonymousClass)_this).contains(otherType)) {
			
			return true;
		}
		
		//everything can be implicitly casted to CharSequence, so I match when the other type is a CharSequence
		Class charSequenceClass = JavaClasspathUtil.getClass("CharSequence", _this);
		
		if (otherType instanceof ConcreteClassifier) {
			if(otherType.equals(charSequenceClass) ||
					ConcreteClassifierUtil.getAllSuperClassifiers(
							(ConcreteClassifier)otherType).contains(charSequenceClass)) {
				return true;
			}
		}

		//there are some specifics for primitive types not reflected in the type hierarchy
		if (otherType instanceof Class) {
			PrimitiveType primitiveType = ClassUtil.unWrapPrimitiveType((Class) otherType);
			if(primitiveType != null) {
				return false;
			}
			otherType = primitiveType;
		}
		else {
			return false;
		}
		
		if (_this instanceof Class) {
			PrimitiveType primitiveType = ClassUtil.unWrapPrimitiveType((Class) _this);
			if(primitiveType == null) {
				return false;
			}
			_this = primitiveType;
		}
		else {
			return false;
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
