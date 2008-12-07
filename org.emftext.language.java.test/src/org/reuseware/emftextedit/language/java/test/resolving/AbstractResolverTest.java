package org.reuseware.emftextedit.language.java.test.resolving;

import org.reuseware.emftextedit.language.java.Field;
import org.reuseware.emftextedit.language.java.Member;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.test.AbstractJavaParserTest;

public abstract class AbstractResolverTest extends AbstractJavaParserTest {

	protected org.reuseware.emftextedit.language.java.Class assertParsesToClass(String typename) throws Exception {
		return assertParsesToType(typename, TEST_INPUT_FOLDER_RESOLVING, org.reuseware.emftextedit.language.java.Class.class);
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
		return false;
	}
	
	@Override
	protected boolean ignoreSemanticErrors() {
		return false;
	}
}
