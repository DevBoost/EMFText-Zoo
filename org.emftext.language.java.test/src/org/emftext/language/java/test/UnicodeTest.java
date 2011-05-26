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
package org.emftext.language.java.test;

import java.io.File;

import org.junit.Test;

/**
 * A separate test case for the input files that contain Unicode escape
 * sequences.
 */
public class UnicodeTest extends AbstractJavaParserTestCase {

	@Test
	public void testUnicodeInput() {
		try {
			assertParsesToClass("ControlZ");
			assertParsesToClass("Unicode");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}

	@Override
	protected String getTestInputFolder() {
		return "src-input" + File.separator + "unicode";
	}

}
