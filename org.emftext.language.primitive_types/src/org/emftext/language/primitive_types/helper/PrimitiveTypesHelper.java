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
package org.emftext.language.primitive_types.helper;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.primitive_types.Primitive_typesPackage;

public class PrimitiveTypesHelper {

	public static Object getPrimitiveType(Object type) {
		if (!(type instanceof EClass)) {
			return type;
		}
		EClass typeClass = (EClass) type;
		List<EClass> superTypes = typeClass.getEAllSuperTypes();
		for (EClass superType : superTypes) {
			if (Primitive_typesPackage.eINSTANCE.getNsURI().equals(superType.getEPackage().getNsURI())) {
				return superType;
			}
		}
		return null;
	}
}
