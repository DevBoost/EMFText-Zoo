package org.emftext.language.java.closures.resource.closure.analysis;

import java.util.HashMap;
import java.util.Map;

public class PostProcessorHelper {

	static Map<String, String> methodNameMap = new HashMap<String,String>();
	
	public static void add(String closureName, String methodName){
		methodNameMap.put(closureName, methodName);
	}
	
	public static String get(String closureName){
		return methodNameMap.get(closureName);
	}
}
