package org.emftext.language.java.test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.expressions.Expression;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.Import;
import org.emftext.language.java.imports.StaticImport;
import org.emftext.language.java.literals.BooleanLiteral;
import org.emftext.language.java.literals.CharacterLiteral;
import org.emftext.language.java.literals.DoubleLiteral;
import org.emftext.language.java.literals.FloatLiteral;
import org.emftext.language.java.literals.IntegerLiteral;
import org.emftext.language.java.literals.LongLiteral;
import org.emftext.language.java.members.Constructor;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.VariableLengthParameter;
import org.emftext.language.java.references.StringReference;
import org.emftext.language.java.statements.Block;
import org.emftext.language.java.statements.ForEachLoop;
import org.emftext.language.java.statements.Statement;
import org.junit.Before;
import org.junit.Test;

import pkg.EscapedStrings;
import pkg.NumberLiterals;

/**
 * JUnit Test suite to test the EMFText JavaModel Parser. New Tests should
 * by added by
 * <ul>
 * <li>putting a Java Source file that contains java expressions to parse to the
 * input/ folder of this plug-in</li>
 * <li>declaring a test case in this path of java source relative to the input
 * folder file to the method parseResource(String relativePath)</li>
 * <li>checking the returned CompilationUnit for correctness
 * </ul>
 * 
 * @author Christian Wende
 */
public class JavaLanguageFeatureTest extends AbstractJavaParserTest {

	public JavaLanguageFeatureTest() throws Exception {
		super();
	}

	private static final String JAVA_FILE_EXTENSION = ".java";

	protected static final String TEST_INPUT_FOLDER = "input";

	// a list of files that are excluded from the reprint test, because
	// they contain optional tokens which are lost after parsing them
	private static final String[] FILES_EXCLUDED_FROM_REPRINT_TEST = new String[] {};

	@Override
	protected ResourceSet getResourceSet() {
		return new ResourceSetImpl();
	}

	private void assertParsableAndReprintable(String filename)
		throws Exception, IOException, BadLocationException {
		JavaRoot root = parseResource(filename);
		assertType(root, CompilationUnit.class);
		CompilationUnit unit = (CompilationUnit) root;
		assertNotNull(unit);
		
		parseAndReprint(filename);
	}

	private void assertParsesToEnumAndReprints(final String typeName) throws Exception {
		String filename = typeName + JAVA_FILE_EXTENSION;
		CompilationUnit model = (CompilationUnit) parseResource(filename);
		assertNumberOfClassifiers(model, 1);
		Classifier declaration = model.getClassifiers().get(0);
		assertClassifierName(declaration, typeName);
		assertType(declaration, Enumeration.class);

		parseAndReprint(filename);
	}

	private void assertIsBooleanField(Member member, boolean expectedInitValue) {
		assertType(member, Field.class);
		Field booleanField = (Field) member;
		Expression initValueForBoolean = booleanField.getInitialValue();

		BooleanLiteral literal = (BooleanLiteral)initValueForBoolean;

		assertType(literal, BooleanLiteral.class);
		BooleanLiteral initLiteralForBoolean = (BooleanLiteral) literal;
		assertEquals(expectedInitValue, initLiteralForBoolean.isValue());
	}

	private void assertIsCharField(Member member, char expectedInitValue) {
		assertType(member, Field.class);
		Field charField = (Field) member;
		Expression initValue = charField.getInitialValue();

		CharacterLiteral literal = (CharacterLiteral)initValue;
		
		assertType(literal, CharacterLiteral.class);
		CharacterLiteral initLiteral = (CharacterLiteral) literal;
		assertEquals(expectedInitValue, initLiteral.getValue());
	}

	private void assertIsDoubleField(Member member, double expectedInitValue) {
		assertType(member, Field.class);
		Field charField = (Field) member;
		Expression initValue = charField.getInitialValue();
		
		DoubleLiteral literal = (DoubleLiteral) initValue;
		
		assertNotNull(member.getName() + " is not a double field.", literal);
		assertType(literal, DoubleLiteral.class);
		DoubleLiteral initLiteral = (DoubleLiteral) literal;
		assertEquals(expectedInitValue, initLiteral.getValue());
	}

	private void assertIsIntegerField(Member member, int expectedInitValue) {
		assertType(member, Field.class);
		Field longField = (Field) member;		
		Expression initValue = longField.getInitialValue();
		
		IntegerLiteral literal = (IntegerLiteral) initValue;

		assertType(literal, IntegerLiteral.class);
		IntegerLiteral initLiteralForBoolean = (IntegerLiteral) literal;
		assertEquals(expectedInitValue, initLiteralForBoolean.getValue());
	}

	private void assertIsLongField(Member member, long expectedInitValue) {
		assertType(member, Field.class);
		Field longField = (Field) member;		
		Expression initValue = longField.getInitialValue();
		
		LongLiteral literal = (LongLiteral) initValue;

		assertType(literal, LongLiteral.class);
		LongLiteral initLiteralForBoolean = (LongLiteral) literal;
		assertEquals(expectedInitValue, initLiteralForBoolean.getValue());
	}

	private void assertIsNumericField(EList<Member> members, String name,
			Object expectedValue) {
		NamedElement field = findElementByName(members, name);
		assertNotNull(field);
		assertType(field, Field.class);
		Field unicode = (Field) field;
		Expression value = unicode.getInitialValue();
		
		Object initValue = null;
		if (value instanceof IntegerLiteral) {
			initValue = ((IntegerLiteral) value).getValue();
		}
		if (value instanceof LongLiteral) {
			initValue = ((LongLiteral) value).getValue();
		}
		if (value instanceof FloatLiteral) {
			initValue = ((FloatLiteral) value).getValue();
		}
		if (value instanceof DoubleLiteral) {
			initValue = ((DoubleLiteral) value).getValue();
		}
		assertNotNull("Init value for field " + name + " is null.", initValue);
		assertEquals("Field " + name, expectedValue, initValue);
	}

	private void assertIsStringField(EList<Member> members, String name,
			String expectedValue) {
		NamedElement field = findElementByName(members, name);
		assertNotNull(field);
		assertType(field, Field.class);
		Field unicode = (Field) field;
		Expression value = unicode.getInitialValue();

		StringReference literal = (StringReference) value;

		assertType(literal, StringReference.class);
		StringReference stringValue = (StringReference) literal;
		assertEquals("Unescaped value expected for field \"" + name + "\".",
				expectedValue, stringValue.getValue());
	}

	private void assertIsStringField(Member member, String expectedInitValue) {
		assertType(member, Field.class);
		Field charField = (Field) member;
		Expression initValue = charField.getInitialValue();
		
		StringReference literal = (StringReference)initValue;
		
		assertType(literal, StringReference.class);
		StringReference initLiteral = (StringReference) literal;
		assertEquals(expectedInitValue, initLiteral.getValue());
	}
	
	private <T extends NamedElement> T findElementByName(
			List<T> elements, String name) {
		for (T next : elements) {
			if (name.equals(next.getName())) {
				return next;
			}
		}
		return null;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		for (String file : FILES_EXCLUDED_FROM_REPRINT_TEST) {
			if (file.equals(filename)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER;
	}
	
	/**
	 * This method is executed before every single test and initializes fields
	 * typically needed by the test cases
	 * @throws Exception 
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAnnotations() throws Exception {
		String typename = "Annotations";
		String filename = typename + JAVA_FILE_EXTENSION;
		Annotation annotation = assertParsesToAnnotation(typename);
		assertMemberCount(annotation, 11);

		parseAndReprint(filename);
	}

	@Test
	public void testAnnotationInstances() throws Exception {
		String typename = "AnnotationInstances";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsForInnerTypes() throws Exception {
		String typename = "AnnotationsForInnerTypes";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsForMethods() throws Exception {
		String typename = "AnnotationsForMethods";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 6);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsForParameters() throws Exception {
		String typename = "AnnotationsForParameters";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 15);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsForStatements() throws Exception {
		String typename = "AnnotationsForStatements";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsForAnnotations() throws Exception {
		String typename = "AnnotationsForAnnotations";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsAsAnnotationArguments() throws Exception {
		String typename = "AnnotationsAsAnnotationArguments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 8);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsBetweenKeywords() throws Exception {
		String typename = "AnnotationsBetweenKeywords";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 7);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnnotationsForEnums() throws Exception {
		String typename = "AnnotationsForEnums";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Enumeration eenum = assertParsesToEnumeration(typename);
		assertMemberCount(eenum, 0);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnonymousEnum() throws Exception {
		String typename = "AnonymousEnum";
		String filename = typename + JAVA_FILE_EXTENSION;
		Enumeration enumeration = assertParsesToEnumeration(typename);
		// assert no members because enumeration constants are not members
		assertMemberCount(enumeration, 0);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnonymousEnumWithArguments() throws Exception {
		String typename = "AnonymousEnumWithArguments";
		String filename = typename + JAVA_FILE_EXTENSION;
		Enumeration enumeration = assertParsesToEnumeration(typename);
		// assert one member (the constructor) because enumeration constants are not members
		assertMemberCount(enumeration, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testAnonymousInner() throws Exception {
		String typename = "AnonymousInner";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testArguments() throws Exception {
		String typename = "Arguments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 5);

		parseAndReprint(filename);
	}
	
	@Test
	public void testArrayInitializers() throws Exception {
		String typename = "ArrayInitializers";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 10);

		parseAndReprint(filename);
	}
	
	@Test
	public void testArraysInDeclarationsComplex() throws Exception {
		String typename = "ArraysInDeclarationsComplex";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 6);
		List<Member> members = clazz.getMembers();
		assertType(members.get(0), Field.class);
		assertType(members.get(1), Field.class);
		assertType(members.get(2), Field.class);
		assertType(members.get(3), Method.class);
		assertType(members.get(4), Method.class);

		parseAndReprint(filename);
	}

	@Test
	public void testArraysInDeclarationsSimple() throws Exception {
		String typename = "ArraysInDeclarationsSimple";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 5);
		List<Member> members = clazz.getMembers();

		assertType(members.get(0), Field.class);
		assertType(members.get(1), Field.class);
		assertType(members.get(2), Field.class);
		assertType(members.get(3), Method.class);
		assertType(members.get(4), Method.class);

		parseAndReprint(filename);
	}

	@Test
	public void testAssignments() throws Exception {
		String typename = "Assignments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);
		List<Member> members = clazz.getMembers();

		assertType(members.get(0), Field.class);
		assertType(members.get(1), Block.class);

		parseAndReprint(filename);
	}

	@Test
	public void testBasicEnums() throws Exception {
		assertParsesToEnumAndReprints("BasicEnum");
		assertParsesToEnumAndReprints("BasicEnumWithCommaAndSemicolonAtTheEnd");
		assertParsesToEnumAndReprints("BasicEnumWithCommaAtTheEnd");
		assertParsesToEnumAndReprints("BasicEnumWithSemicolonAtTheEnd");
	}
	
	@Test
	public void testBooleanAssignments() throws Exception {
		String typename = "BooleanAssignments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testBooleanExpressions() throws Exception {
		String typename = "BooleanExpressions";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}

	@Test
	public void testBlocks() throws Exception {
		String typename = "Blocks";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testCasting() throws Exception {
		String typename = "Casting";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testChainedCalls() throws Exception {
		String typename = "ChainedCalls";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 27);

		parseAndReprint(filename);
	}

	@Test
	public void testClassSemicolonOnly() throws Exception {
		String typename = "ClassSemicolonOnly";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}

	@Test
	public void testControlZ() throws Exception {
		String folder = "unicode/";
		assertParsableAndReprintable(folder + "ControlZ.java");
	}

	@Test
	public void testCrazyUnicode() throws Exception {
		String typename = "CrazyUnicode";
		File file = new File("pkg" + File.separator + typename + JAVA_FILE_EXTENSION);
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(file);
		assertMemberCount(clazz, 2);

		parseAndReprint(file);
	}

	@Test
	public void testComments() throws Exception {
		String typename = "Comments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testCommentsAtEOF() throws Exception {
		String typename = "CommentsAtEOF";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 0);

		parseAndReprint(filename);
	}

	@Test
	public void testCommentsInArrayInitializers() throws Exception {
		String typename = "CommentsInArrayInitializers";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}
	
	@Test
	public void testCommentsInFieldDeclaration() throws Exception {
		String typename = "CommentsInFieldDeclaration";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testCommentsBetweenCaseStatements() throws Exception {
		String typename = "CommentsBetweenCaseStatements";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}
	
	@Test
	public void testCommentsBetweenCatchClauses() throws Exception {
		String typename = "CommentsBetweenCatchClauses";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testCommentsBetweenConstructorArguments() throws Exception {
		String typename = "CommentsBetweenConstructorArguments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}
	
	@Test
	public void testCommentsBetweenMethodArguments() throws Exception {
		String typename = "CommentsBetweenMethodArguments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testCommentsBetweenReferenceSequenceParts() throws Exception {
		String typename = "CommentsBetweenReferenceSequenceParts";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}	

	@Test
	public void testCommentsInParExpression() throws Exception {
		String typename = "CommentsInParExpression";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}	

	@Test
	public void testClassWithEnumeratingFieldDeclaration() throws Exception {
		String typename = "ClassWithEnumeratingFieldDeclaration";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		List<Member> members = clazz.getMembers();
		assertType(members.get(0), Field.class);

		parseAndReprint(filename);
	}

	@Test
	public void testConditionalExpressions() throws Exception {
		String typename = "ConditionalExpressions";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}

	@Test
	public void testConstructorCalls() throws Exception {
		String typename = "ConstructorCalls";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}

	@Test
	public void testEmptyClass() throws Exception {
		String typename = "EmptyClass";
		String filename = typename + JAVA_FILE_EXTENSION;
		assertParsesToClass(typename);
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testEmptyEnum() throws Exception {
		String typename = "EmptyEnum";
		String filename = typename + JAVA_FILE_EXTENSION;
		Enumeration enumeration = assertParsesToEnumeration(typename);
		assertEquals(typename + " should have no members.", 0, enumeration
				.getMembers().size());

		parseAndReprint(filename);
	}

	@Test
	public void testEmptyEnumWithSemicolon() throws Exception {
		assertParsesToEnumAndReprints("EmptyEnumWithSemicolon");
	}

	@Test
	public void testEmptyInterface() throws Exception {
		String typename = "EmptyInterface";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);
		assertEquals(typename + " should have no members.", 0, interfaze
				.getMembers().size());

		parseAndReprint(filename);
	}

	@Test
	public void testEnumImplementingTwoInterfaces() throws Exception {
		String typename = "EnumImplementingTwoInterfaces";
		String filename = typename + JAVA_FILE_EXTENSION;
		Enumeration enumeration = assertParsesToEnumeration(typename);
		assertEquals(typename + " implements two interfaces.", 2, enumeration
				.getImplements().size());

		registerInClassPath("IOneMethod" + JAVA_FILE_EXTENSION);
		parseAndReprint(filename);
	}

	@Test
	public void testEnumWithMember() throws Exception {
		String typename = "EnumWithMember";
		String filename = typename + JAVA_FILE_EXTENSION;
		Enumeration enumeration = assertParsesToEnumeration(typename);
		assertMemberCount(enumeration, 2);

		parseAndReprint(filename);
	}
	
	@Test
	public void testEnumWithConstructor() throws Exception {
		String typename = "EnumWithConstructor";
		String filename = typename + JAVA_FILE_EXTENSION;
		Enumeration enumeration = assertParsesToEnumeration(typename);
		assertMemberCount(enumeration, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testEqualityExpression() throws Exception {
		String typename = "EqualityExpression";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}

	@Test
	public void testEscapedStrings() throws Exception {
		String typename = "EscapedStrings";
		File file = new File("pkg" + File.separator + typename + JAVA_FILE_EXTENSION);
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(file);
		assertMemberCount(clazz, 9);

		// iterate over all fields, get their value using reflection and
		// compare this value with the one from the Java parser
		java.lang.reflect.Field[] fields = EscapedStrings.class
				.getDeclaredFields();
		for (java.lang.reflect.Field field : fields) {
			Object value = field.get(null);
			assertIsStringField(clazz.getMembers(), field.getName(), (String) value);
		}

		parseAndReprint(file);
	}

	@Test
	public void testExceptionThrowing() throws Exception {
		String typename = "ExceptionThrowing";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 7);

		List<Member> members = clazz.getMembers();
		assertConstructorThrowsCount(members.get(1), 1);
		assertConstructorThrowsCount(members.get(2), 2);
		assertMethodThrowsCount(members.get(3), 1);
		assertMethodThrowsCount(members.get(4), 3);
		assertMethodThrowsCount(members.get(5), 1);

		parseAndReprint(filename);
	}

	@Test
	public void testExplicitConstructorCalls() throws Exception {
		String typename = "ExplicitConstructorCalls";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testExplicitGenericConstructorCalls() throws Exception {
		String typename = "ExplicitGenericConstructorCalls";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}

	@Test
	public void testExplicitGenericInvocation() throws Exception {
		String typename = "ExplicitGenericInvocation";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testExpressions() throws Exception {
		String typename = "Expressions";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testExpressionsAsMethodArguments() throws Exception {
		String typename = "ExpressionsAsMethodArguments";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}
	
	public void testLegalIdentifiers() throws Exception {
		String typename = "LegalIdentifiers";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testForEachLoop() throws Exception {
		String typename = "ForEachLoop";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		Member simpleForEach = clazz.getMembers().get(1);
		assertType(simpleForEach, Method.class);
		Method simpleForEachMethod = (Method) simpleForEach;
		Block body = simpleForEachMethod.getBody();
		Statement forEach = body.getStatements().get(0);
		assertType(forEach, ForEachLoop.class);
		parseAndReprint(filename);
	}
	
	@Test
	public void testGenericConstructorCalls() throws Exception {
		String typename = "GenericConstructorCalls";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 5);
		
		parseAndReprint(filename);
	}

	@Test
	public void testGenericConstructors() throws Exception {
		String typename = "GenericConstructors";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);
		
		List<Member> members = clazz.getMembers();
		assertConstructorTypeParameterCount(members.get(0), 1);
		assertConstructorTypeParameterCount(members.get(1), 2);
		assertConstructorTypeParameterCount(members.get(2), 1);
		assertConstructorTypeParameterCount(members.get(3), 2);

		parseAndReprint(filename);
	}

	@Test
	public void testGenericMethods() throws Exception {
		String typename = "GenericMethods";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 5);

		List<Member> members = clazz.getMembers();
		assertMethodTypeParameterCount(members.get(0), 1);
		assertMethodTypeParameterCount(members.get(1), 1);
		assertMethodTypeParameterCount(members.get(2), 2);
		assertMethodTypeParameterCount(members.get(3), 2);
		assertMethodTypeParameterCount(members.get(4), 3);

		parseAndReprint(filename);
	}

	@Test
	public void testGenericSuperConstructors() throws Exception {
		String typename = "GenericSuperConstructors";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		parseAndReprint(filename);
	}

	@Test
	public void testIExtendsMultiple() throws Exception {
		String typename = "IExtendsMultiple";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);

		assertEquals("IExtendsMultiple extends two interfaces.", 2, interfaze
				.getExtends().size());

		parseAndReprint(filename);
	}

	@Test
	public void testIGenericMembers() throws Exception {
		String typename = "IGenericMembers";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);
		assertMemberCount(interfaze, 3);
		List<Member> members = interfaze.getMembers();
		assertType(members.get(0), Method.class);
		assertType(members.get(1), Interface.class);
		assertType(members.get(2),
				org.emftext.language.java.classifiers.Class.class);

		assertMethodTypeParameterCount(members.get(0), 1);
		assertInterfaceTypeParameterCount(members.get(1), 1);
		assertClassTypeParameterCount(members.get(2), 1);

		parseAndReprint(filename);
	}

	@Test
	public void testIMembers() throws Exception {
		String typename = "IMembers";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);

		assertMemberCount(interfaze, 5);

		List<Member> members = interfaze.getMembers();
		assertType(members.get(0), Field.class);
		assertType(members.get(1), Method.class);
		assertType(members.get(2), Interface.class);
		assertType(members.get(3),
				org.emftext.language.java.classifiers.Class.class);
		assertType(members.get(4), Enumeration.class);

		parseAndReprint(filename);
	}
	
	@Test
	public void testImport1() throws Exception {
		String typename = "Import1";
		String filename = typename + JAVA_FILE_EXTENSION;

		registerInClassPath("Import2" + JAVA_FILE_EXTENSION);
		
		CompilationUnit model = (CompilationUnit) parseResource(filename);
		assertNumberOfClassifiers(model, 1);
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testImport2() throws Exception {
		String typename = "Import2";
		String filename = typename + JAVA_FILE_EXTENSION;

		CompilationUnit model = (CompilationUnit) parseResource(filename);
		assertNumberOfClassifiers(model, 1);
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testInstanceOfArrayType() throws Exception {
		String typename = "InstanceOfArrayType";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testIOneMethod() throws Exception {
		String typename = "IOneMethod";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);
		assertMemberCount(interfaze, 1);
		
		parseAndReprint(filename);
	}

	@Test
	public void testISemicolonOnly() throws Exception {
		String typename = "ISemicolonOnly";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);
		assertMemberCount(interfaze, 1 /*One empty member*/);

		parseAndReprint(filename);
	}

	@Test
	public void testITwoPublicVoidMethods() throws Exception {
		String typename = "ITwoPublicVoidMethods";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);
		assertMemberCount(interfaze, 2);

		EList<Member> members = interfaze.getMembers();
		Member member1 = members.get(0);
		Member member2 = members.get(1);
		Method method1 = (Method) member1;
		Method method2 = (Method) member2;
		assertModifierCount(method1, 1);
		assertModifierCount(method2, 1);
		assertIsPublic(method1);
		assertIsPublic(method2);

		parseAndReprint(filename);
	}
	
	@Test
	public void testIWithComments() throws Exception {
		String typename = "IWithComments";
		String filename = typename + JAVA_FILE_EXTENSION;
		Interface interfaze = assertParsesToInterface(typename);
		assertMemberCount(interfaze, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testLiterals() throws Exception {
		String typename = "Literals";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 26);
		
		EList<Member> members = clazz.getMembers();
		// check the fields and their initialization values
		assertIsIntegerField(findElementByName(members, "i1"), 3);
		assertIsIntegerField(members.get(2), 1);
		assertIsLongField(members.get(3), 8);
		assertIsLongField(members.get(4), 0);
		assertIsDoubleField(members.get(9), 1.5);
		assertIsCharField(members.get(10), 'a');
		assertIsStringField(members.get(11), "abc");
		assertIsBooleanField(members.get(12), false);
		assertIsBooleanField(members.get(13), true);
		
		Member maxLongField = findElementByName(members, "maxLong");
		assertNotNull(maxLongField);
		assertIsLongField(maxLongField, 0xffffffffffffffffL);
		
		Member i7Field = findElementByName(members, "i7");
		assertNotNull(i7Field);
		assertIsIntegerField(i7Field, 0xff);
		
		Member i8Field = findElementByName(members, "i8");
		assertNotNull(i8Field);
		assertIsLongField(i8Field, 10);
		
		parseAndReprint(filename);
	}

	@Test
	public void testLocalVariableDeclarations() throws Exception {
		String typename = "LocalVariableDeclarations";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testLocation() throws Exception {
		String filename = "locations/Location.java";
		assertParsableAndReprintable(filename);
	}
	
	@Test
	public void testMembers() throws Exception {
		String typename = "Members";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 6);

		List<Member> members = clazz.getMembers();
		assertType(members.get(0), Field.class);
		assertType(members.get(1), Constructor.class);
		assertType(members.get(2), Method.class);
		assertType(members.get(3), Interface.class);
		assertType(members.get(4),
				org.emftext.language.java.classifiers.Class.class);
		assertType(members.get(5), Enumeration.class);

		parseAndReprint(filename);
	}

	@Test
	public void testResolving() throws Exception {
		String folder = "resolving/";
		assertParsableAndReprintable(folder + "MethodCalls.java");
		assertParsableAndReprintable(folder + "MethodCallsWithLocalTypeReferences.java");
		assertParsableAndReprintable(folder + "MethodCallsWithoutInheritance.java");
		assertParsableAndReprintable(folder + "ReferenceToInheritedMethod.java");
		assertParsableAndReprintable(folder + "VariableReferencing.java");
	}

	@Test
	public void testMethodCallsWithLocalTypeReferences() throws Exception {
		String typename = "MethodCallsWithLocalTypeReferences";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	@Test
	public void testModifiers() throws Exception {
		String typename = "Modifiers";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 29);

		parseAndReprint(filename);
	}

	@Test
	public void testMultipleImplements() throws Exception {
		String typename = "MultipleImplements";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 0);
		EList<QualifiedTypeArgument> implementedInterfaces = clazz.getImplements();
		assertEquals(2, implementedInterfaces.size());

		parseAndReprint(filename);
	}

	@Test
	public void testMultiplications() throws Exception {
		String typename = "Multiplications";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		EList<Member> members = clazz.getMembers();
		
		Field longField = (Field) members.get(1);		
		Expression initValue = longField.getInitialValue();
				
		TreeIterator<EObject> iter = initValue.eAllContents();
		IntegerLiteral literal1 = null;
		IntegerLiteral literal2 = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof IntegerLiteral) {
				if (literal1==null)literal1 = (IntegerLiteral)obj;
				else literal2 = (IntegerLiteral)obj;				
			}
		}
		assertNotNull("no IntegerLiteral found", literal1);
		assertNotNull("no second IntegerLiteral found", literal2);
		assertEquals(3, literal1.getValue());
		assertEquals(4, literal2.getValue());
		
		
		parseAndReprint(filename);
	}

	@Test
	public void testNumberLiterals() throws Exception {
		String typename = "NumberLiterals";
		File file = new File("pkg" + File.separator + typename + JAVA_FILE_EXTENSION);
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(file);
		assertMemberCount(clazz, 46);
		
		// iterate over all fields, get their value using reflection and
		// compare this value with the one from the Java parser
		java.lang.reflect.Field[] fields = NumberLiterals.class
				.getDeclaredFields();
		for (java.lang.reflect.Field field : fields) {
			Object value = field.get(null);
			assertIsNumericField(clazz.getMembers(), field.getName(), value);
		}

		parseAndReprint(file);
	}

	@Test
	public void testParametersWithModifiers() throws Exception {
		String typename = "ParametersWithModifiers";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}
	
	@Test
	public void testPrimitiveTypeArrays() throws Exception {
		String typename = "PrimitiveTypeArrays";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}
	
	@Test
	public void testPkg_EmptyClass() throws Exception {
		CompilationUnit model = (CompilationUnit) parseResource("pkg/EmptyClass.java");
		assertNumberOfClassifiers(model, 1);
		Classifier declaraction = model.getClassifiers().get(0);
		assertEquals("The name of the declared class equals 'EmptyClass'",
				"EmptyClass", declaraction.getName());
		assertEquals("pkg.Empty is located in a package 'pkg'", "pkg", model
				.getNamespaces().get(0));
		parseAndReprint("pkg/EmptyClass.java");
	}

	@Test
	public void testPkg_inner_EmptyClass() throws Exception {
		CompilationUnit model = (CompilationUnit) parseResource("pkg/inner/Inner.java");
		assertNumberOfClassifiers(model, 1);
		Classifier declaraction = model.getClassifiers().get(0);
		assertEquals("The name of the declared class equals 'Inner'", "Inner",
				declaraction.getName());
		assertEquals("pkg.inner.Inner is located in a package 'inner'",
				"inner", model.getNamespaces().get(1));
		assertEquals("Package 'Inner' is located in a package 'pkg'", "pkg",
				model.getNamespaces().get(0));
		parseAndReprint("pkg/inner/Inner.java");
	}
	
	@Test
	public void testPkg_PackageAnnotation() throws Exception {
		CompilationUnit model = (CompilationUnit) parseResource("pkg/PackageAnnotation.java");
		assertNumberOfClassifiers(model, 1);
		parseAndReprint("pkg/PackageAnnotation.java");
	}
	
	@Test
	public void testPkg_package_info() throws Exception {
		parseAndReprint("pkg/package-info.java");
	}

	@Test
	public void testSemicolonAfterMembers() throws Exception {
		String typename = "SemicolonAfterMembers";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2 + 4 /* + 4 empty */);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	@Test
	public void testSemicolonAfterExpressions() throws Exception {
		String typename = "SemicolonAfterExpressions";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}
	
	@Test
	public void testSimpleAnnotations() throws Exception {
		String typename = "SimpleAnnotations";
		String filename = typename + JAVA_FILE_EXTENSION;
		Annotation annotation = assertParsesToAnnotation(typename);
		assertEquals(typename + " should have 2 members.", 2, annotation
				.getMembers().size());

		parseAndReprint(filename);
	}

	@Test
	public void testSimpleMethodCalls() throws Exception {
		String typename = "SimpleMethodCalls";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	@Test
	public void testStatements() throws Exception {
		assertParsesToClass("ConditionalStatements", 4);
		assertParsesToClass("TryCatchStatements", 4);
		assertParsesToClass("AssertStatements", 1);
		assertParsesToClass("ThrowStatements", 1);
		assertParsesToClass("SynchronizedStatements", 3);
		assertParsesToClass("SwitchStatements", 12);
		assertParsesToClass("DeclarationStatements", 1);
		assertParsesToClass("JumpLabelStatements", 4);
		assertParsesToClass("LoopStatements", 11);
	}
	
	@Test
	public void testStaticImports() throws Exception {
		String typename = "StaticImports";
		String filename = typename + JAVA_FILE_EXTENSION;
		CompilationUnit unit = (CompilationUnit) parseResource(filename, getTestInputFolder());
		List<Import> imports = unit.getImports();
		assertEquals(2, imports.size());
		assertTrue("first import is not static", imports.get(0) instanceof StaticImport);
		assertTrue("second import is static", imports.get(1) instanceof ClassifierImport);

		parseAndReprint(filename);
	}
	
	@Test
	public void testStringLiteralReferencing() throws Exception {
		String typename = "StringLiteralReferencing";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testSuperKeyword() throws Exception {
		String typename = "SuperKeyword";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		Member method = clazz.getMembers().get(0);
		assertType(method, Constructor.class);

		parseAndReprint(filename);
	}
	
	@Test
	public void testSynchronized() throws Exception {
		String typename = "Synchronized";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testTypeParameters() throws Exception {
		String typename = "TypeParameters";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 14);

		parseAndReprint(filename);
	}

	@Test
	public void testTypeReferencing() throws Exception {
		String typename = "TypeReferencing";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}
	
	@Test
	public void testTypeReferencingExternal() throws Exception {
		String typename = "TypeReferencingExternal";
		String filename = typename + JAVA_FILE_EXTENSION;
		assertParsesToClass(typename);

		parseAndReprint(filename);
	}

	@Test
	public void testUnaryExpressions() throws Exception {
		String typename = "UnaryExpressions";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testUsingAnnotations() throws Exception {
		String typename = "UsingAnnotations";
		String filename = "pkg" + File.separator + typename + JAVA_FILE_EXTENSION;
		assertParsesToClass(new File(filename));
		
		parseAndReprint(filename);
	}
	
	@Test
	public void testUnicode() throws Exception {
		String folder = "unicode/";
		assertParsableAndReprintable(folder + "Unicode.java");
	}

	@Test
	public void testUnicodeIdentifiers() throws Exception {
		String folder = "unicode/";
		assertParsableAndReprintable(folder + "UnicodeIdentifiers.java");
	}

	@Test
	public void testVariableLengthArgumentList() throws Exception {
		String typename = "VariableLengthArgumentList";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 4);
		Member firstMember = clazz.getMembers().get(0);
		Constructor constructor = assertIsConstructor(firstMember);
		assertEquals(
				"Constructor of " + typename + " should habe 1 parameter.", 1,
				constructor.getParameters().size());
		assertType(constructor.getParameters().get(0),
				VariableLengthParameter.class);

		parseAndReprint(filename);
	}

	@Test
	public void testVariableReferencing() throws Exception {
		String typename = "VariableReferencing";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.classifiers.Class.class);
		assertMemberCount(clazz, 2);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}
	
	
	@Test
	public void testParserKiller() throws Exception {
		String typename = "AbstractClassesParserKiller";
		String filename = typename + JAVA_FILE_EXTENSION;
		org.emftext.language.java.classifiers.Class clazz = assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.classifiers.Class.class);
		assertNotNull(clazz);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	@Test
	public void testHasMissingParseReprints() throws Exception {
		File inputFolder = new File("./" + getTestInputFolder());
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder);
		allTestFiles.removeAll(getReprintedResources());
		for (File file : allTestFiles) {
			System.out.println("Not parsed and reprinted: " + file);
		}
		System.out.println("Not parsed and reprinted total: "
				+ allTestFiles.size());
		assertEquals("All testfiles were parsed and reprinted.",
				Collections.EMPTY_LIST, allTestFiles);
	}

	
	
	/**
	 * This is a meta-test which checks naively if all test files were covered
	 * by test cases in this suite. WARNING: this test needs to stay at the end
	 * of the class, to be the last test executed.
	 * 
	 * @throws BadLocationException
	 * @throws IOException
	 * @throws MalformedTreeException
	 */
	@Test
	public void testHasMissingParses() throws CoreException,
			MalformedTreeException, IOException, BadLocationException {
		File inputFolder = new File("." + File.separator
				+ getTestInputFolder());
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder);
		allTestFiles.removeAll(getParsedResources());
		assertEquals(
				"All testfiles contained in input folder were covered by a test case.",
				Collections.EMPTY_LIST, allTestFiles);
	}
}
