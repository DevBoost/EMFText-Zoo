package org.emftext.language.java.util.arrays;

import org.emftext.language.java.arrays.ArrayTypable;

public class ArrayTypeableUtil {

	public static boolean equals(ArrayTypable _this, ArrayTypable other) {
		int dim1 = 0;
		int dim2 = 0;
		
		if (_this != null) {
			dim1 = _this.getArrayDimensionsBefore().size() + _this.getArrayDimensionsAfter().size();
		}
		if (other != null) {
			dim2 = other.getArrayDimensionsBefore().size() + other.getArrayDimensionsAfter().size();
		}
		return dim1 == dim2;
	}
	
}
