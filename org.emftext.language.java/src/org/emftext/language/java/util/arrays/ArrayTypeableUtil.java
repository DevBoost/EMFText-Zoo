package org.emftext.language.java.util.arrays;

import org.emftext.language.java.arrays.ArrayTypeable;

public class ArrayTypeableUtil {

	public static int getArrayDimension(ArrayTypeable _this) {
		if (_this != null) {
			return _this.getArrayDimensionsBefore().size() + _this.getArrayDimensionsAfter().size();
		}
		return 0;
	}
	
}
