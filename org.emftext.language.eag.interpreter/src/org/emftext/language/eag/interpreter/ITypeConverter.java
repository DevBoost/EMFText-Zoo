package org.emftext.language.eag.interpreter;

public interface ITypeConverter {

	public Class<?>[] getAvailableConversions(Class<?> type);
	
	public Object convertTo(Object type, Class<?> targetType);
}
