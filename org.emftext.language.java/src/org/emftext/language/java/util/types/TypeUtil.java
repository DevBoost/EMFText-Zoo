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
package org.emftext.language.java.util.types;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.emftext.language.java.util.generics.TypeParameterUtil;

/**
 * A utility class that provides methods that belong to class 
 * Type, but can not go there, because Type is generated.
 */
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
		
		if(_this == null || otherType == null) {
			return false;
		}
		
		if (_this instanceof TypeParameterUtil.TemporalCompositeClassImpl || otherType instanceof TypeParameterUtil.TemporalCompositeClassImpl) {
			EList<Type> thisTypeList = new BasicEList<Type>();
			EList<Type> otherTypeList = new BasicEList<Type>();
			if (_this instanceof TypeParameterUtil.TemporalCompositeClassImpl) {
				thisTypeList.addAll(((TypeParameterUtil.TemporalCompositeClassImpl)_this).getSuperTypes());
			}
			else {
				thisTypeList.add(_this);
			}
			if (otherType instanceof TypeParameterUtil.TemporalCompositeClassImpl) {
				otherTypeList.addAll(((TypeParameterUtil.TemporalCompositeClassImpl)otherType).getSuperTypes());
			}
			else {
				otherTypeList.add(_this);
			}
			
			
			for(Type oneThisType : thisTypeList) {
				for(Type oneOtherType : otherTypeList) {
					boolean result = isSuperType(oneThisType, arrayDim, oneOtherType, otherArrayType);
					if (result) {
						return true;
					}	
				}
			}
			return false;
		}
		
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
		if(_this instanceof TypeParameter) {
			return true;
		}
		if(otherType instanceof TypeParameter ) {
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
