package org.emftext.language.eag.interpreter.numbers;

import org.emftext.language.eag.interpreter.ITypeConverter;

public class NumberConverter implements ITypeConverter {

	public Class<?>[] getAvailableConversions(Class<?> type) {
		if (type == Integer.class) {
			return new Class<?>[] {Float.class, Double.class};
		}
		if (type == Float.class) {
			return new Class<?>[] {Double.class};
		}
		return null;
	}

	public Object convertTo(Object type, Class<?> targetType) {
		if (type instanceof Integer) {
			if (targetType == Float.class) {
				return new Float((Integer) type);
			}
			if (targetType == Double.class) {
				return new Double((Integer) type);
			}
		}
		if (type instanceof Float) {
			if (targetType == Double.class) {
				return new Float((Float) type);
			}
		}
		return null;
	}

}
