package org.emftext.language.java.test.resolving;

import java.util.List;

import org.emftext.language.java.core.Block;
import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.LocalVariable;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.Statement;
import org.junit.Test;

public class VariableReferenceResolverTest extends AbstractResolverTest {
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "VariableReferencing";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
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
		assertIsReferenceToField(statement1, field);
		
		Statement statement2 = statements.get(1);
		assertType(statement2, LocalVariableStatement.class);
		LocalVariable localVar = ((LocalVariableStatement) statement2).getVariable();

		Statement statement3 = statements.get(2);
		assertIsReferenceToLocalVariable(statement3, localVar);

		Statement statement4 = statements.get(3);
		assertType(statement4, Block.class);
	}
}
