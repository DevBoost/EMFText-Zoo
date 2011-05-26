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
package org.emftext.language.c_sharp.test.cssyntaxcheck;

public class CheckCSPrecondition {

	public static boolean checkWindowsInstalled(){
		return System.getProperty("os.name").startsWith("Windows");
	}

	public static boolean checkDotNetInstalled(){
		if (checkWindowsInstalled()){
			//add check for .net
		}
		return true;
	}

	public static boolean checkAll(){
		return (checkWindowsInstalled() && checkWindowsInstalled());
	}
}
