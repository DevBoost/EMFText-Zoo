package org.emftext.language.java.test.resolving;

import java.util.List;

import org.emftext.language.java.Assignment;
import org.emftext.language.java.Block;
import org.emftext.language.java.ExpressionStatement;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.Member;
import org.emftext.language.java.Method;
import org.emftext.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.PrimaryReference;
import org.emftext.language.java.Statement;
import org.junit.Before;
import org.junit.Test;

public class MethodCallWithoutInheritanceResolverTest extends AbstractResolverTest {
	
	@Before
	public void setUp() {
		JavaClasspath.INSTANCE.registerClassifier("java.lang", "Object", null);
	}
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "MethodCallsWithoutInheritance";
		org.emftext.language.java.Class clazz = assertParsesToClass(typename);
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
		
		//assertEquals(4, methodStatements2.size());
		assertIsCallToMethod(methodStatements2.get(0), method1);
		assertIsCallToMethod(methodStatements2.get(1), method2);
		assertIsCallToMethod(methodStatements2.get(2), method3);
		// the last call should refer to m4, because of the signature
		assertIsCallToMethod(methodStatements2.get(3), method4);
		
		assertResolveAllProxies(clazz);
	}

	private void assertIsCallToMethod(Statement statement, Method expectedCallTarget) {
		assertType(statement, ExpressionStatement.class);
		ExpressionStatement expression = (ExpressionStatement) statement;
		Assignment methodCallExpression = (Assignment) expression.getExpression();
		PrimaryReference reference = methodCallExpression.getTarget().getPrimary();
		assertType(reference, PackageOrClassifierOrMethodOrVariableReference.class);
		PackageOrClassifierOrMethodOrVariableReference methodCall = (PackageOrClassifierOrMethodOrVariableReference) reference;
		assertEquals(expectedCallTarget, methodCall.getTarget());
	}
}
