package org.emftext.language.java.util.arrays;

import org.emftext.language.java.arrays.ArrayTypable;

public class ArrayTypeableUtil {

	public static int getArrayDimension(ArrayTypable _this) {
		if (_this != null) {
			return _this.getArrayDimensionsBefore().size() + _this.getArrayDimensionsAfter().size();
		}
		return 0;
	}
	
}
