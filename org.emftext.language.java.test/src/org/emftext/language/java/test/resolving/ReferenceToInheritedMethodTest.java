/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.java.test.resolving;

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.junit.Test;

/**
 * A test for resolving method calls to the respective inherited method.
 */
public class ReferenceToInheritedMethodTest extends AbstractResolverTestCase {
	
	@Test
	public void testReferencing() throws Exception {
		// TODO fix
		//testReferencing("MethodCallsWithoutInheritance");
		//testReferencing("ReferenceToInheritedMethod");
	}

	protected void testReferencing(String typename) throws IOException, BadLocationException {
		String filename =  typename + ".java";
		parseAndReprint(filename);
	}
}
