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
package org.emftext.language.java.util.arrays;

import org.emftext.language.java.arrays.ArrayTypeable;
import org.emftext.language.java.parameters.VariableLengthParameter;

/**
 * A utility class that provides methods that belong to class 
 * ArrayTypeable, but can not go there, because ArrayTypeable 
 * is generated.
 */
public class ArrayTypeableUtil {

	public static int getArrayDimension(ArrayTypeable _this) {
		if (_this != null) {
			int size = _this.getArrayDimensionsBefore().size() + _this.getArrayDimensionsAfter().size();
			if (_this instanceof VariableLengthParameter) {
				size++;
			}
			return size;
		}
		return 0;
	}
	
}
