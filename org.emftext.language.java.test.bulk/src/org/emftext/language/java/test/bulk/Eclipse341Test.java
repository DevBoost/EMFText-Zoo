/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;

import org.eclipse.core.runtime.CoreException;

/**
 * Uses JaMoPP to parse and print the source files of
 * Eclipse 3.4.1 (Ganymede).
 */
public class Eclipse341Test extends AbstractZipFileInputTest {
	
	public static final String TEST_FOLDER = "eclipse-3.4.1";
	public static final String START_ENTRY = "";
	public static final int    THREAD_NO   = 8;
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO);
	}
}
