package org.reuseware.emftextedit.language.java.test.resolving;

import java.util.List;

import org.junit.Test;
import org.reuseware.emftextedit.language.java.Assignment;
import org.reuseware.emftextedit.language.java.Block;
import org.reuseware.emftextedit.language.java.Expression;
import org.reuseware.emftextedit.language.java.Field;
import org.reuseware.emftextedit.language.java.LocalVariable;
import org.reuseware.emftextedit.language.java.Member;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.ReferenceSequence;
import org.reuseware.emftextedit.language.java.SingleExpression;
import org.reuseware.emftextedit.language.java.Statement;

public class VariableReferenceResolverTest extends AbstractResolverTest {
	
	@Test
	public void testReferencing() throws Exception {
		String typename = "VariableReferencing";
		org.reuseware.emftextedit.language.java.Class clazz = assertParsesToClass(typename);
		assertNotNull(clazz);
		
		List<Member> members = clazz.getMembers();
		assertEquals(2, members.size());
		
		Field field = assertIsField(members.get(0), "var");
		Method method = assertIsMethod(members.get(1), "method");
		
		Block methodBody = method.getBody();
		assertNotNull(methodBody);
		List<Statement> statements = methodBody.getStatements();
		
		assertEquals(4, statements.size());
		Statement statement1 = statements.get(0);
		assertType(statement1, Assignment.class);
		Assignment assignment1 = (Assignment) statement1;
		ReferenceSequence target1 = assignment1.getTarget();
		assertType(target1, ReferenceSequence.class);
		ReferenceSequence targetSequence1 = (ReferenceSequence) target1;
		assertEquals(field, targetSequence1.getPrimary());
		
		Statement statement2 = statements.get(1);
		assertType(statement2, LocalVariable.class);
		LocalVariable localVar = (LocalVariable) statement2;

		Statement statement3 = statements.get(2);
		assertType(statement3, Assignment.class);
		Assignment assignment2 = (Assignment) statement3;
		ReferenceSequence target2 = assignment2.getTarget();
		assertType(target2, ReferenceSequence.class);
		ReferenceSequence targetSequence2 = (ReferenceSequence) target2;
		assertEquals("The second assignment should reference the local variable.", localVar, targetSequence2.getPrimary());

		Statement statement4 = statements.get(3);
		assertType(statement4, Block.class);
	}
}
