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
 * the Netbeans IDE.
 */
public class NetbeansTest extends AbstractZipFileInputTestCase {

	public static final String TEST_FOLDER = "netbeans-6.5.1";
	public static final String START_ENTRY = "";
	public static final int    THREAD_NO   = 8;
	
	public static final String[] EXCLUDED_TESTS = new String[] {
		//TODO excluded until issue #767 is fixed
		"org/netbeans/modules/cnd/repository/disk/DiskRepositoryManager.java",
		"org/netbeans/modules/cnd/repository/queue/RepositoryQueue.java",
		"org/netbeans/modules/cnd/repository/queue/RepositoryWritingThread.java",
		//TODO excluded until issue #763 is fixed
		"org/netbeans/modules/print/util/Config.java",
		//This test fails, because it contains character escaped with octal notation
		//that are reprinted in a different way as they were defined ('\0' becomes '\000').
		//This is not wrong, but the JDTMatcher recognizes different structures in the
		//file because of this and reports an reprint error.
		"org/netbeans/modules/php/editor/parser/ASTPHP5Parser.java"
	};
	
	public static Test suite() throws CoreException, IOException {
		return constructSuite(TEST_FOLDER, START_ENTRY, THREAD_NO, EXCLUDED_TESTS);
	}
	
}
