package org.reuseware.emftextedit.language.java.test.resolving;

import java.util.List;

import org.junit.Test;
import org.reuseware.emftextedit.language.java.Block;
import org.reuseware.emftextedit.language.java.Expression;
import org.reuseware.emftextedit.language.java.Member;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.reuseware.emftextedit.language.java.SingleExpression;
import org.reuseware.emftextedit.language.java.Statement;

public class MethodCallResolverTest extends AbstractResolverTest {
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "MethodCalls";
		org.reuseware.emftextedit.language.java.Class clazz = assertParsesToClass(typename);
		assertNotNull(clazz);
		assertMemberCount(clazz, 4);
		
		List<Member> members = clazz.getMembers();
		
		Method method1 = assertIsMethod(members.get(0), "m1");
		Method method2 = assertIsMethod(members.get(1), "m2");
		Method method3 = assertIsMethod(members.get(2), "m3");
		Method method4 = assertIsMethod(members.get(3), "m3");
		
		Block methodBody2 = method2.getBody();
		assertNotNull(methodBody2);
		List<Statement> methodStatements2 = methodBody2.getStatements();
		
		assertEquals(4, methodStatements2.size());
		assertIsCallToMethod(methodStatements2.get(0), method1);
		assertIsCallToMethod(methodStatements2.get(1), method2);
		assertIsCallToMethod(methodStatements2.get(2), method3);
		// the last call should refer to m4, because of the signature
		assertIsCallToMethod(methodStatements2.get(3), method4);
	}

	private void assertIsCallToMethod(Statement statement, Method expectedCallTarget) {
		assertType(statement, SingleExpression.class);
		SingleExpression expression = (SingleExpression) statement;
		Expression methodCallExpression = expression.getExpression();
		assertType(methodCallExpression, PackageOrClassifierOrMethodOrVariableReference.class);
		PackageOrClassifierOrMethodOrVariableReference methodCall = (PackageOrClassifierOrMethodOrVariableReference) methodCallExpression;
		assertEquals(expectedCallTarget, methodCall.getTarget());
	}
}
