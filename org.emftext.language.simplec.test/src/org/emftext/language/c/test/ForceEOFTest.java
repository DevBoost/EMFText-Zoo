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
package org.emftext.language.c.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;

public class ForceEOFTest extends AbstractCTestCase {

	private static final String TEST_INPUT_FROM_MEMORY = "int x;;";

	public void testForceEOF() {
		try {
			EObject unit = tryToLoadResource(new ByteArrayInputStream(TEST_INPUT_FROM_MEMORY.getBytes()), "test_input_from_memory.c", null);
			assertTrue("Additional semicolon at the end should prevent successful parsing", unit.eResource().getErrors().size() > 0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
