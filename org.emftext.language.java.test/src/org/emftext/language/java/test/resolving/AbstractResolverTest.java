package org.emftext.language.java.test.resolving;

import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.Method;
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
