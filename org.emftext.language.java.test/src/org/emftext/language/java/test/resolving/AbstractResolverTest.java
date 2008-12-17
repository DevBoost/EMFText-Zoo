package org.emftext.language.java.test.resolving;

import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.LocalVariable;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.core.PackageOrClassifierOrMethodOrVariableReference;
import org.emftext.language.java.core.Reference;
import org.emftext.language.java.core.ReferenceableElement;
import org.emftext.language.java.expressions.ConditionalExpression;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.test.AbstractJavaParserTest;

public abstract class AbstractResolverTest extends AbstractJavaParserTest {

	protected static final String TEST_INPUT_FOLDER_RESOLVING = "input/resolving/";

	protected org.emftext.language.java.core.Class assertParsesToClass(String typename) throws Exception {
		return assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.core.Class.class);
	}
	
	protected Field assertIsField(Member member, String expectedName) {
		assertType(member, Field.class);
		Field field = (Field) member;
		assertEquals(expectedName, field.getName());
		return field;
	}

	protected Method assertIsMethod(Member member, String expectedName) {
		assertType(member, Method.class);
		Method method = (Method) member;
		assertEquals(expectedName, method.getName());
		return method;
	}

	protected void assertIsCallToMethod(Statement statement, Method expectedCallTarget) {
		assertIsReferenceTo(statement, expectedCallTarget);
	}
	
	protected void assertIsReferenceToField(Statement statement, Field expectedReferenceTarget) {
		assertIsReferenceTo(statement, expectedReferenceTarget);
	}
	
	protected void assertIsReferenceToLocalVariable(Statement statement, LocalVariable expectedReferenceTarget) {
		assertIsReferenceTo(statement, expectedReferenceTarget);
	}
	
	protected void assertIsReferenceTo(Statement statement, ReferenceableElement expectedReferenceTarget) {
		assertType(statement, ExpressionStatement.class);
		ExpressionStatement expression = (ExpressionStatement) statement;
		Expression methodCallExpression = expression.getExpression();
		ConditionalExpression cond = (ConditionalExpression) methodCallExpression.getConditionalExpression();
		Reference reference = cond.getConditionalOrExpression().
		getConditionalAndExpression().get(0).
		getInclusiveOrExpression().get(0).
		getExclusiveOrExpression().get(0).
		getAndExpression().get(0).
		getEqualityExpression().get(0).
		getInstanceOfExpression().get(0).
		getRelationExpression().
		getShiftExpression().get(0).
		getAdditiveExpression().get(0).
		getMultiplicativeExpression().get(0).
		getUnaryExpression().get(0).
		getUnaryExpressionNotPlusMinus().getPrimary().getReference();
		
		assertType(reference.getPrimary(), PackageOrClassifierOrMethodOrVariableReference.class);
		PackageOrClassifierOrMethodOrVariableReference methodCall = (PackageOrClassifierOrMethodOrVariableReference) reference.getPrimary();
		assertEquals(expectedReferenceTarget, methodCall.getTarget());
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
	
	@Override
	protected boolean ignoreSemanticErrors() {
		return false;
	}

	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER_RESOLVING;
	}
}
