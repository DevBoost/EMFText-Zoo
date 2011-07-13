/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.closures.resource.closure.mopp;

import java.util.HashMap;
import java.util.Map;

public class ClosureBuilderHelper {

	static Map<String, String> methodNameMap = new HashMap<String,String>();
	
	public static void add(String closureName, String methodName){
		methodNameMap.put(closureName, methodName);
	}
	
	public static String get(String closureName){
		return methodNameMap.get(closureName);
	}
}
