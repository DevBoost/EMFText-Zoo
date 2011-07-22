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

package org.emftext.language.webtest.runner;

import org.emftext.language.webtest.TestScript;
import org.junit.Test;

public class ExampleTestcase {
	
	@Test
	public void testExample() {
		new WebtestRunner().runTest("../" + TestScript.class.getPackage().getName() + "/metamodel/webtest.newfile.webtest");
	}
}
