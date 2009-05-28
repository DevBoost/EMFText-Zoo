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

import org.emftext.language.java.arrays.ArrayTypeable;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.arrays.ArrayTypeableUtil;
import org.emftext.language.java.util.generics.TypeParameterUtil;
import org.emftext.language.java.util.references.ReferenceUtil;

/**
 * A utility class that provides methods that belong to class 
 * TypeReference, but can not go there, because TypeReference
 * is generated.
 */
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
			
			if (reference instanceof MethodCall) {
				MethodCall potentialCloneCall = (MethodCall) reference;
				//clone returns the type of the cloned in the case of arrays
				if ("clone".equals(JavaUtil.getName(potentialCloneCall.getTarget()))) {
					if(potentialCloneCall.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
						if (potentialCloneCall.eContainer() instanceof ElementReference) {
							ElementReference prevRef = (ElementReference) potentialCloneCall.eContainer();
							if (prevRef.getTarget() instanceof ArrayTypeable && 
									ArrayTypeableUtil.getArrayDimension((ArrayTypeable)prevRef.getTarget()) > 0) {
								type = ReferenceUtil.getType(prevRef);
							}
						}
						
					}
				}
			}
		}

		else if(_this instanceof PrimitiveType) {
			return (PrimitiveType) _this;
		}
		
		//resolve parameter to real type
		if (type instanceof TypeParameter) {
			type = TypeParameterUtil.getBoundType((TypeParameter) type, _this, reference);
		}

		if (type != null && type.eIsProxy()) {
			//this may happen, when e.g. a super type is resolved. It is ok.
			return null;
		}
		
		return type;
	}
}
