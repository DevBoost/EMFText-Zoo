/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test.resolving;

import java.util.List;

import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.statements.FeatureStatement;
import org.junit.Before;
import org.junit.Test;

/**
 * A test for resolving method calls to the respective method.
 */
public class MethodCallWithoutInheritanceResolverTest extends AbstractResolverTestCase {
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "MethodCallsWithoutInheritance";
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertNotNull(clazz);
		assertMemberCount(clazz, 4);
		
		List<Member> members = clazz.getMembers();
		
		ClassMethod method1 = assertIsMethod(members.get(0), "m1");
		ClassMethod method2 = assertIsMethod(members.get(1), "m2");
		ClassMethod method3 = assertIsMethod(members.get(2), "m3");
		ClassMethod method4 = assertIsMethod(members.get(3), "m3");
		
		List<? extends FeatureStatement> methodStatements2 = method2.getStatements();
		
		//assertEquals(4, methodStatements2.size());
		assertIsCallToMethod(methodStatements2.get(0), method1);
		assertIsCallToMethod(methodStatements2.get(1), method2);
		assertIsCallToMethod(methodStatements2.get(2), method3);
		// the last call should refer to m4, because of the signature
		assertIsCallToMethod(methodStatements2.get(3), method4);
		
		assertResolveAllProxies(clazz);
	}
}
