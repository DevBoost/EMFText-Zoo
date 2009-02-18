package org.emftext.language.java.test.resolving;

import java.util.List;

import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.statements.Block;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.LocalVariableStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.variables.LocalVariable;
import org.junit.Test;

public class VariableReferenceResolverTest extends AbstractResolverTest {
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "VariableReferencing";
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertNotNull(clazz);
		
		List<Member> members = clazz.getMembers();
		assertEquals(2, members.size());
		
		Field field = assertIsField(members.get(0), "var");
		Method method = assertIsMethod(members.get(1), "method");
		
		List<Statement> statements = method.getStatements();
		
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
