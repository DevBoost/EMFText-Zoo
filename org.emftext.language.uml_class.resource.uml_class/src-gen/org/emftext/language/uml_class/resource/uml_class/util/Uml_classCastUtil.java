package org.emftext.language.uml_class.resource.uml_class.util;

// Utility class that provides a method to cast objects to
// type parameterized classes without a warning.
public class Uml_classCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
