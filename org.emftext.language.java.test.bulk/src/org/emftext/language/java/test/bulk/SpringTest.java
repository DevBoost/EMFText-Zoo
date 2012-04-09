/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test.bulk;

import java.io.IOException;

import junit.framework.Test;

import org.eclipse.core.runtime.CoreException;

/**
 * Uses JaMoPP to parse and print the source files of
 * the Spring framework.
 */
public class SpringTest extends AbstractZipFileInputTestCase {

	public static final String TEST_FOLDER = "spring-framework-3.0.0.M1";
	public static final String START_ENTRY = "";
	public static final int    THREAD_NO   = 8;
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO);
	}
	
}
