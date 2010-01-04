/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.language.java.test.resolving;

import java.io.File;

import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.statements.ExpressionStatement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.test.AbstractJavaParserTestCase;
import org.emftext.language.java.variables.LocalVariable;

/**
 * An abstract super class for all test cases that check reference resolving.
 * It provides some assert methods that can be used to check the correctness
 * of reference targets.
 */
public abstract class AbstractResolverTestCase extends AbstractJavaParserTestCase {

	protected static final String TEST_INPUT_FOLDER_RESOLVING = "input" + File.separator + "resolving" + File.separator;

	protected org.emftext.language.java.classifiers.Class assertParsesToClass(String typename) throws Exception {
		return assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.classifiers.Class.class);
	}
	
	protected Field assertIsField(Member member, String expectedName) {
		assertType(member, Field.class);
		Field field = (Field) member;
		assertEquals(expectedName, field.getName());
		return field;
	}

	protected ClassMethod assertIsMethod(Member member, String expectedName) {
		assertType(member, ClassMethod.class);
		ClassMethod method = (ClassMethod) member;
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
		assertNotNull(methodCallExpression);
		/*TODO fix
		 * 
		 * ConditionalExpression cond = (ConditionalExpression) methodCallExpression.getConditionalExpression();
		PrimaryExpression reference = cond.getConditionalOrExpression().
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
		getUnaryExpressionNotPlusMinus().getPrimaryExpression();*/
		
		//assertType(reference, IdentifierReference.class);
		//IdentifierReference identifierReference = (IdentifierReference) reference;
		//assertEquals(expectedReferenceTarget, identifierReference.getTarget());
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
	
	@Override
	protected boolean ignoreSemanticErrors(String filename) {
		return false;
	}

	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER_RESOLVING;
	}
}
