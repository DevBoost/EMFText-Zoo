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
package org.emftext.language.java.test.bugs;

import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.references.ReferencesFactory;
import org.emftext.language.java.resource.java.util.JavaResourceUtil;
import org.emftext.language.java.statements.Return;
import org.emftext.language.java.statements.StatementsFactory;
import org.junit.Test;

public class Bug1818Test extends AbstractTestCase {

	public Bug1818Test() {
		super();
	}
	
	@Test
	public void testPrintReturn() {
	    Return newReturnStatement = StatementsFactory.eINSTANCE.createReturn();
	    ClassMethod method = MembersFactory.eINSTANCE.createClassMethod();
	    method.setName("methodCall");
	    MethodCall methodCall = ReferencesFactory.eINSTANCE.createMethodCall();
	    methodCall.setTarget(method);
		method.getStatements().add(newReturnStatement);
		newReturnStatement.setReturnValue(methodCall);
		String text = JavaResourceUtil.getText(newReturnStatement);
		assertEquals("return methodCall();", text);
	}

}
