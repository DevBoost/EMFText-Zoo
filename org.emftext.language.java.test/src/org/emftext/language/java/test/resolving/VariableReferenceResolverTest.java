package org.emftext.language.java.test.resolving;

import java.util.List;

import org.emftext.language.java.Assignment;
import org.emftext.language.java.Block;
import org.emftext.language.java.ExpressionStatement;
import org.emftext.language.java.Field;
import org.emftext.language.java.LocalVariable;
import org.emftext.language.java.LocalVariableStatement;
import org.emftext.language.java.Member;
import org.emftext.language.java.Method;
import org.emftext.language.java.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.Reference;
import org.emftext.language.java.Statement;
import org.junit.Test;

public class VariableReferenceResolverTest extends AbstractResolverTest {
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "VariableReferencing";
		org.emftext.language.java.Class clazz = assertParsesToClass(typename);
		assertNotNull(clazz);
		
		List<Member> members = clazz.getMembers();
		assertEquals(2, members.size());
		
		Field field = assertIsField(members.get(0), "var");
		Method method = assertIsMethod(members.get(1), "method");
		
		Block methodBody = method.getBody();
		assertNotNull(methodBody);
		List<Statement> statements = methodBody.getStatements();
		
		assertEquals(6, statements.size());
		Statement statement1 = statements.get(0);
		assertType(statement1, ExpressionStatement.class);
		ExpressionStatement expressionStatement1 = (ExpressionStatement) statement1;
		assertType(expressionStatement1.getExpression(), Assignment.class);
		Assignment assignment1 = (Assignment) expressionStatement1.getExpression();
		Reference target1 = assignment1.getTarget();
		assertType(target1, Reference.class);
		Reference targetSequence1 = (Reference) target1;
		assertEquals(field, ((PackageOrClassifierOrMethodOrVariableReference) targetSequence1.getPrimary()).getTarget());
		
		Statement statement2 = statements.get(1);
		assertType(statement2, LocalVariableStatement.class);
		LocalVariable localVar = ((LocalVariableStatement) statement2).getVariable();

		Statement statement3 = statements.get(2);
		assertType(statement3, ExpressionStatement.class);
		ExpressionStatement expressionStatement3 = (ExpressionStatement) statement3;
		assertType(expressionStatement3.getExpression(), Assignment.class);
		Assignment assignment2 = (Assignment) expressionStatement3.getExpression();
		Reference target2 = assignment2.getTarget();
		assertType(target2, Reference.class);
		Reference targetSequence2 = (Reference) target2;
		assertEquals("The second assignment should reference the local variable.", localVar, ((PackageOrClassifierOrMethodOrVariableReference)targetSequence2.getPrimary()).getTarget());

		Statement statement4 = statements.get(3);
		assertType(statement4, Block.class);
	}
}
