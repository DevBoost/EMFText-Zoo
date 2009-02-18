package org.emftext.language.java.test.resolving;

import java.util.List;

import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.statements.Block;
import org.emftext.language.java.statements.Statement;
import org.junit.Test;

public class MethodCallsWithLocalTypeReferencesResolverTest extends AbstractResolverTest {
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "MethodCallsWithLocalTypeReferences";
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertNotNull(clazz);
		assertMemberCount(clazz, 4);
		
		List<Member> members = clazz.getMembers();
		
		Method method1 = assertIsMethod(members.get(0), "m1");
		Method method2 = assertIsMethod(members.get(1), "m2");
		Method method3 = assertIsMethod(members.get(2), "m3");
		Method method4 = assertIsMethod(members.get(3), "m3");
		
		List<Statement> methodStatements2 = method2.getStatements();
		
		assertEquals(4, methodStatements2.size());
		assertIsCallToMethod(methodStatements2.get(0), method1);
		assertIsCallToMethod(methodStatements2.get(1), method2);
		assertIsCallToMethod(methodStatements2.get(2), method3);
		// the last call should refer to m4, because of the signature
		assertIsCallToMethod(methodStatements2.get(3), method4);
	}
}
