package org.emftext.language.java.util.arrays;

import org.emftext.language.java.arrays.ArrayTypeable;
import org.emftext.language.java.parameters.VariableLengthParameter;

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
