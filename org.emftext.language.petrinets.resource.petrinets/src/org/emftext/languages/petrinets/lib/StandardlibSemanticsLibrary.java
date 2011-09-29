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
package org.emftext.languages.petrinets.lib;

public class StandardlibSemanticsLibrary {

	public static int add(int arg1, int arg2) {
		return arg1 + arg2;
	}

	public static int sub(int arg1, int arg2) {
		return arg1 - arg2;
	}

	public static int mult(int arg1, int arg2) {
		return arg1 * arg2;
	}

	public static int div(int arg1, int arg2) {
		return arg1 / arg2;
	}

	public static int power(int arg1, int arg2) {
		Double result = new Double(java.lang.Math.pow(arg1, arg2));
		return result.intValue();
	}

	public static String append(String arg1, String arg2) {
		return arg1.concat(arg2);
	}

	public static boolean and(boolean arg1, boolean arg2) {
		return arg1 && arg2;
	}

	public static boolean or(boolean arg1, boolean arg2) {
		return arg1 || arg2;
	}

	public static boolean not(boolean arg1) {
		return !arg1;
	}

	public static boolean isNull(Object arg1) {
		return arg1 == null;
	}

	public static boolean isNotNull(Object arg1) {
		return !(arg1 == null);
	}

	public static float div(float arg1, float arg2) {
		return arg1 / arg2;
	}

	public static float floatValue(int arg1) {
		return new Integer(arg1).floatValue();
	}

	public static float mult(float arg1, float arg2) {
		return arg1 * arg2;
	}

	public static float add(float arg1, float arg2) {
		return arg1 + arg2;
	}

	public static float sub(float arg1, float arg2) {
		return arg1 - arg2;
	}

}
