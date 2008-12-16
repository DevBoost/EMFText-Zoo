package org.emftext.language.java.test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;
import org.emftext.language.java.annotations.Annotation;
import org.emftext.language.java.core.Block;
import org.emftext.language.java.literals.BooleanLiteral;
import org.emftext.language.java.literals.CharacterLiteral;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.ClassifierImport;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.core.Constructor;
import org.emftext.language.java.core.Enumeration;
import org.emftext.language.java.core.Field;
import org.emftext.language.java.core.StaticImport;
import org.emftext.language.java.literals.FloatingPointLiteral;
import org.emftext.language.java.statements.ForEachLoop;
import org.emftext.language.java.core.Import;
import org.emftext.language.java.core.InitialValue;
import org.emftext.language.java.literals.IntegerLiteral;
import org.emftext.language.java.core.Interface;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.core.NamedElement;
import org.emftext.language.java.statements.Statement;
import org.emftext.language.java.literals.StringLiteral;
import org.emftext.language.java.core.VariableLengthParameter;
import org.junit.Before;
import org.junit.Test;

import pkg.EscapedStrings;

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

	protected static final String TEST_INPUT_FOLDER = "input";

	// a list of files that are excluded from the reprint test, because
	// they contain optional tokens which are lost after parsing them
	private static final String[] FILES_EXCLUDED_FROM_REPRINT_TEST = new String[] {
			"BasicEnumWithCommaAtTheEnd.java",
			"BasicEnumWithCommaAndSemicolonAtTheEnd.java",
			"BasicEnumWithSemicolonAtTheEnd.java",
			"EmptyEnumWithSemicolon.java" };

	private void checkBasicEnum(final String typeName) throws Exception {
		String filename = typeName + ".java";
		CompilationUnit model = parseResource(filename);
		assertNumberOfClassifiers(model, 1);
		Classifier declaration = model.getClassifiers().get(0);
		assertClassifierName(declaration, typeName);
		assertType(declaration, Enumeration.class);

		parseAndReprint(filename);
	}

	private void checkBooleanMember(Member member, boolean expectedInitValue) {
		assertType(member, Field.class);
		Field booleanField = (Field) member;
		InitialValue initValueForBoolean = booleanField.getInitialValue();

		TreeIterator<EObject> iter = initValueForBoolean.eAllContents();
		BooleanLiteral literal = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof BooleanLiteral) literal = (BooleanLiteral)obj;
		}
		assertType(literal, BooleanLiteral.class);
		BooleanLiteral initLiteralForBoolean = (BooleanLiteral) literal;
		assertEquals(expectedInitValue, initLiteralForBoolean.isValue());
	}

	private void checkCharacterMember(Member member, char expectedInitValue) {
		assertType(member, Field.class);
		Field charField = (Field) member;
		InitialValue initValue = charField.getInitialValue();
		
		TreeIterator<EObject> iter = initValue.eAllContents();
		CharacterLiteral literal = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof CharacterLiteral) literal = (CharacterLiteral)obj;
		}
		assertType(literal, CharacterLiteral.class);
		CharacterLiteral initLiteral = (CharacterLiteral) literal;
		assertEquals(expectedInitValue, initLiteral.getValue());
	}

	private void checkFloatMember(Member member, double expectedInitValue) {
		assertType(member, Field.class);
		Field charField = (Field) member;
		InitialValue initValue = charField.getInitialValue();
		
		TreeIterator<EObject> iter = initValue.eAllContents();
		FloatingPointLiteral literal = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof FloatingPointLiteral) literal = (FloatingPointLiteral)obj;
		}
		assertType(literal, FloatingPointLiteral.class);
		FloatingPointLiteral initLiteral = (FloatingPointLiteral) literal;
		assertEquals(expectedInitValue, initLiteral.getValue());
	}

	private void checkIntegerMember(Member member, long expectedInitValue) {
		assertType(member, Field.class);
		Field longField = (Field) member;		
		InitialValue initValue = longField.getInitialValue();
		
		TreeIterator<EObject> iter = initValue.eAllContents();
		IntegerLiteral literal = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof IntegerLiteral) literal = (IntegerLiteral)obj;
		}
		assertType(literal, IntegerLiteral.class);
		IntegerLiteral initLiteralForBoolean = (IntegerLiteral) literal;
		assertEquals(expectedInitValue, initLiteralForBoolean.getValue());
	}

	private void checkStringField(EList<Member> members, String name,
			String expectedValue) {
		NamedElement fieldUnicode = findNamedElement(members, name);
		assertNotNull(fieldUnicode);
		assertType(fieldUnicode, Field.class);
		Field unicode = (Field) fieldUnicode;
		InitialValue value = unicode.getInitialValue();
		
		TreeIterator<EObject> iter = value.eAllContents();
		StringLiteral literal = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof StringLiteral) literal = (StringLiteral)obj;
		}
		assertType(literal, StringLiteral.class);
		StringLiteral stringValue = (StringLiteral) literal;
		assertEquals("Unescaped value expected for field \"" + name + "\".",
				expectedValue, stringValue.getValue());
	}

	private void checkStringMember(Member member, String expectedInitValue) {
		assertType(member, Field.class);
		Field charField = (Field) member;
		InitialValue initValue = charField.getInitialValue();
		
		TreeIterator<EObject> iter = initValue.eAllContents();
		StringLiteral literal = null;
		while(iter.hasNext()){
			Object obj = iter.next();
			if (obj instanceof StringLiteral) literal = (StringLiteral)obj;
		}
		assertType(literal, StringLiteral.class);
		StringLiteral initLiteral = (StringLiteral) literal;
		assertEquals(expectedInitValue, initLiteral.getValue());
	}
	
	private NamedElement findNamedElement(
			EList<? extends NamedElement> members, String name) {
		for (NamedElement next : members) {
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
		String filename = typename + ".java";
		Annotation annotation = assertParsesToAnnotation(typename);
		assertMemberCount(annotation, 10);

		parseAndReprint(filename);
	}

	@Test
	public void testAnonymousInner() throws Exception {
		String typename = "AnonymousInner";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testArguments() throws Exception {
		String typename = "Arguments";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 5);

		parseAndReprint(filename);
	}
	
	@Test
	public void testArrayInitializers() throws Exception {
		String typename = "ArrayInitializers";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 8);

		parseAndReprint(filename);
	}
	
	@Test
	public void testArraysInDeclarationsComplex() throws Exception {
		String typename = "ArraysInDeclarationsComplex";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
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
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
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
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);
		List<Member> members = clazz.getMembers();

		assertType(members.get(0), Field.class);
		assertType(members.get(1), Block.class);

		parseAndReprint(filename);
	}

	@Test
	public void testBasicEnums() throws Exception {
		checkBasicEnum("BasicEnum");
		checkBasicEnum("BasicEnumWithCommaAndSemicolonAtTheEnd");
		checkBasicEnum("BasicEnumWithCommaAtTheEnd");
		checkBasicEnum("BasicEnumWithSemicolonAtTheEnd");
	}
	
	@Test
	public void testBooleanExpressions() throws Exception {
		String typename = "BooleanExpressions";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}

	@Test
	public void testBlocks() throws Exception {
		String typename = "Blocks";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testChainedCalls() throws Exception {
		String typename = "ChainedCalls";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 27);

		parseAndReprint(filename);
	}

	@Test
	public void testComments() throws Exception {
		String typename = "Comments";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testClassWithEnumeratingFieldDeclaration() throws Exception {
		String typename = "ClassWithEnumeratingFieldDeclaration";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		List<Member> members = clazz.getMembers();
		assertType(members.get(0), Field.class);

		parseAndReprint(filename);
	}

	@Test
	public void testConstructorCalls() throws Exception {
		String typename = "ConstructorCalls";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}

	@Test
	public void testEmptyClass() throws Exception {
		CompilationUnit model = parseResource("EmptyClass.java");
		assertNumberOfClassifiers(model, 1);

		Classifier declaration = model.getClassifiers().get(0);
		assertEquals("The name of the declared class equals 'EmptyClass'",
				"EmptyClass", declaration.getName());
		parseAndReprint("EmptyClass.java");
	}
	
	@Test
	public void testEmptyEnum() throws Exception {
		String typename = "EmptyEnum";
		String filename = typename + ".java";
		Enumeration enumeration = assertParsesToEnumeration(typename);
		assertEquals(typename + " should have no members.", 0, enumeration
				.getMembers().size());

		parseAndReprint(filename);
	}

	@Test
	public void testEmptyEnumWithSemicolon() throws Exception {
		checkBasicEnum("EmptyEnumWithSemicolon");
	}

	@Test
	public void testEmptyInterface() throws Exception {
		String typename = "EmptyInterface";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);
		assertEquals(typename + " should have no members.", 0, interfaze
				.getMembers().size());

		parseAndReprint(filename);
	}

	@Test
	public void testEnumImplementingTwoInterfaces() throws Exception {
		String typename = "EnumImplementingTwoInterfaces";
		String filename = typename + ".java";
		Enumeration enumeration = assertParsesToEnumeration(typename);
		assertEquals(typename + " implements two interfaces.", 2, enumeration
				.getImplements().size());

		parseAndReprint(filename);
	}

	@Test
	public void testEscapedStrings() throws Exception {
		String typename = "EscapedStrings";
		File file = new File("pkg" + File.separator + typename + ".java");
		org.emftext.language.java.core.Class clazz = assertParsesToClass(file);
		EList<Member> members = clazz.getMembers();
		assertEquals(typename + " should have 8 members.", 8, members.size());

		// iterate over all fields, get their value using reflection and
		// compare this value with the one from the Java parser
		java.lang.reflect.Field[] fields = EscapedStrings.class
				.getDeclaredFields();
		for (java.lang.reflect.Field field : fields) {
			Object value = field.get(null);
			checkStringField(members, field.getName(), (String) value);
		}

		parseAndReprint(file);
	}

	@Test
	public void testExceptionThrowing() throws Exception {
		String typename = "ExceptionThrowing";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 5);

		List<Member> members = clazz.getMembers();
		assertConstructorThrowsCount(members.get(0), 1);
		assertConstructorThrowsCount(members.get(1), 2);
		assertMethodThrowsCount(members.get(2), 1);
		assertMethodThrowsCount(members.get(3), 2);

		parseAndReprint(filename);
	}

	@Test
	public void testExplicitConstructorCalls() throws Exception {
		String typename = "ExplicitConstructorCalls";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}

	@Test
	public void testExplicitGenericConstructorCalls() throws Exception {
		String typename = "ExplicitGenericConstructorCalls";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}

	@Test
	public void testExplicitGenericInvocation() throws Exception {
		String typename = "ExplicitGenericInvocation";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testExpressions() throws Exception {
		String typename = "Expressions";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);

		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testForEachLoop() throws Exception {
		String typename = "ForEachLoop";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
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
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 5);
		
		parseAndReprint(filename);
	}

	@Test
	public void testGenericConstructors() throws Exception {
		String typename = "GenericConstructors";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
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
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
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
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		parseAndReprint(filename);
	}

	@Test
	public void testIExtendsMultiple() throws Exception {
		String typename = "IExtendsMultiple";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);

		assertEquals("IExtendsMultiple extends two interfaces.", 2, interfaze
				.getExtends().size());

		parseAndReprint(filename);
	}

	@Test
	public void testIGenericMembers() throws Exception {
		String typename = "IGenericMembers";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);

		List<Member> members = interfaze.getMembers();
		assertEquals(filename + " contains exactly three members.", 3, members
				.size());
		assertType(members.get(0), Method.class);
		assertType(members.get(1), Interface.class);
		assertType(members.get(2),
				org.emftext.language.java.core.Class.class);

		assertMethodTypeParameterCount(members.get(0), 1);
		assertInterfaceTypeParameterCount(members.get(1), 1);
		assertClassTypeParameterCount(members.get(2), 1);

		parseAndReprint(filename);
	}

	@Test
	public void testIMembers() throws Exception {
		String typename = "IMembers";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);

		List<Member> members = interfaze.getMembers();
		assertEquals(filename + " contains exactly five members.", 5, members
				.size());
		assertType(members.get(0), Field.class);
		assertType(members.get(1), Method.class);
		assertType(members.get(2), Interface.class);
		assertType(members.get(3),
				org.emftext.language.java.core.Class.class);
		assertType(members.get(4), Enumeration.class);

		parseAndReprint(filename);
	}

	@Test
	public void testImport1() throws Exception {
		String typename = "Import1";
		String filename = typename + ".java";

		parseAndReprint(filename);
	}
	
	@Test
	public void testImport2() throws Exception {
		String typename = "Import2";
		String filename = typename + ".java";

		parseAndReprint(filename);
	}
	
	@Test
	public void testIOneMethod() throws Exception {
		String typename = "IOneMethod";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);

		assertEquals(typename + " contains exactly one member declaration.", 1,
				interfaze.getMembers().size());
		parseAndReprint(filename);
	}

	@Test
	public void testISemicolonOnly() throws Exception {
		String typename = "ISemicolonOnly";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);
		assertEquals(typename + " should have no members.", 0, interfaze
				.getMembers().size());

		parseAndReprint(filename);
	}

	@Test
	public void testITwoPublicVoidMethods() throws Exception {
		String typename = "ITwoPublicVoidMethods";
		String filename = typename + ".java";
		Interface interfaze = assertParsesToInterface(typename);

		EList<Member> members = interfaze.getMembers();
		assertEquals(typename + " contains exactly two member declarations.",
				2, members.size());
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
	public void testLiterals() throws Exception {
		String typename = "Literals";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 12);
		
		EList<Member> members = clazz.getMembers();
		// check the fields and their initialization values
		checkIntegerMember(members.get(1), 3);
		checkIntegerMember(members.get(2), 1);
		checkIntegerMember(members.get(3), 8);
		checkIntegerMember(members.get(4), 0);
		checkFloatMember(members.get(5), 1.5);
		checkCharacterMember(members.get(6), 'a');
		checkStringMember(members.get(7), "abc");
		checkBooleanMember(members.get(8), false);
		checkBooleanMember(members.get(9), true);
		parseAndReprint(filename);
	}

	@Test
	public void testLocalVariableDeclarations() throws Exception {
		String typename = "LocalVariableDeclarations";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}

	@Test
	public void testMembers() throws Exception {
		String typename = "Members";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 6);

		List<Member> members = clazz.getMembers();
		assertType(members.get(0), Field.class);
		assertType(members.get(1), Constructor.class);
		assertType(members.get(2), Method.class);
		assertType(members.get(3), Interface.class);
		assertType(members.get(4),
				org.emftext.language.java.core.Class.class);
		assertType(members.get(5), Enumeration.class);

		parseAndReprint(filename);
	}

	@Test
	public void testMethodCalls() throws Exception {
		String typename = "MethodCalls";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.core.Class.class);
		assertMemberCount(clazz, 4);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	@Test
	public void testMethodCallsWithLocalTypeReferences() throws Exception {
		String typename = "MethodCallsWithLocalTypeReferences";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.core.Class.class);
		assertMemberCount(clazz, 4);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	@Test
	public void testModifiers() throws Exception {
		String typename = "Modifiers";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 29);

		parseAndReprint(filename);
	}

	@Test
	public void testParametersWithModifiers() throws Exception {
		String typename = "ParametersWithModifiers";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 2);

		parseAndReprint(filename);
	}
	
	@Test
	public void testPrimitiveTypeArrays() throws Exception {
		String typename = "PrimitiveTypeArrays";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 4);

		parseAndReprint(filename);
	}
	
	@Test
	public void testPkg_EmptyClass() throws Exception {
		CompilationUnit model = parseResource("pkg/EmptyClass.java");
		assertNumberOfClassifiers(model, 1);
		Classifier declaraction = model.getClassifiers().get(0);
		assertEquals("The name of the declared class equals 'EmptyClass'",
				"EmptyClass", declaraction.getName());
		assertEquals("pkg.Empty is located in a package 'pkg'", "pkg", model
				.getPackage().get(0));
		parseAndReprint("pkg/EmptyClass.java");
	}

	@Test
	public void testPkg_inner_EmptyClass() throws Exception {
		CompilationUnit model = parseResource("pkg/inner/Inner.java");
		assertNumberOfClassifiers(model, 1);
		Classifier declaraction = model.getClassifiers().get(0);
		assertEquals("The name of the declared class equals 'Inner'", "Inner",
				declaraction.getName());
		assertEquals("pkg.inner.Inner is located in a package 'inner'",
				"inner", model.getPackage().get(1));
		assertEquals("Package 'Inner' is located in a package 'pkg'", "pkg",
				model.getPackage().get(0));
		parseAndReprint("pkg/inner/Inner.java");
	}

	/* TODO mseifert
	@Test
	public void testSimpleAnnotations() throws Exception {
		String typename = "SimpleAnnotations";
		String filename = typename + ".java";
		Annotation annotation = assertParsesToAnnotation(typename);
		assertEquals(typename + " should have 2 members.", 2, annotation
				.getMembers().size());

		parseAndReprint(filename);
	}
	*/

	@Test
	public void testStatements() throws Exception {
		assertParsesToClass("ConditionalStatements", 1);
		assertParsesToClass("TryCatchStatements", 4);
		assertParsesToClass("AssertStatements", 1);
		assertParsesToClass("ThrowStatements", 1);
		assertParsesToClass("SynchronizedStatements", 3);
		assertParsesToClass("SwitchStatements", 7);
		assertParsesToClass("DeclarationStatements", 1);
		assertParsesToClass("JumpLabelStatements", 2);
		assertParsesToClass("LoopStatements", 10);
	}
	
	@Test
	public void testStaticImports() throws Exception {
		String typename = "StaticImports";
		String filename = typename + ".java";
		CompilationUnit unit = parseResource(filename, getTestInputFolder());
		List<Import> imports = unit.getImports();
		assertEquals(2, imports.size());
		assertTrue("first import is not static", imports.get(0) instanceof StaticImport);
		assertTrue("second import is static", imports.get(1) instanceof ClassifierImport);

		parseAndReprint(filename);
	}

	@Test
	public void testSuperKeyword() throws Exception {
		String typename = "SuperKeyword";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);
		
		Member method = clazz.getMembers().get(0);
		assertType(method, Constructor.class);

		parseAndReprint(filename);
	}
	
	@Test
	public void testTypeParameters() throws Exception {
		String typename = "TypeParameters";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 11);

		parseAndReprint(filename);
	}

	@Test
	public void testTypeReferencing() throws Exception {
		String typename = "TypeReferencing";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 3);

		parseAndReprint(filename);
	}
	
	@Test
	public void testTypeReferencingExternal() throws Exception {
		String typename = "TypeReferencingExternal";
		String filename = typename + ".java";
		assertParsesToClass(typename);

		parseAndReprint(filename);
	}

	@Test
	public void testUnaryExpressions() throws Exception {
		String typename = "UnaryExpressions";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertMemberCount(clazz, 1);

		parseAndReprint(filename);
	}
	
	@Test
	public void testVariableLengthArgumentList() throws Exception {
		String typename = "VariableLengthArgumentList";
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);

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
		String filename = typename + ".java";
		org.emftext.language.java.core.Class clazz = assertParsesToType(typename, getTestInputFolder(), org.emftext.language.java.core.Class.class);
		assertMemberCount(clazz, 2);
		
		parseAndReprint(filename, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}
	
	/**
	 * This test should run after the others, when all Java sources are registerd.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testResolveProxies() throws Exception {
		assertResolveAllProxies();
	}

	@Test
	public void testHasMissingParseReprints() throws Exception {
		File inputFolder = new File("./" + getTestInputFolder());
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder);
		allTestFiles.removeAll(reprintedResources);
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
		allTestFiles.removeAll(parsedResources);
		// for (final File file : allTestFiles) {
		// TestRunner.run(new TestCase() {
		// public void runTest() {
		// try {
		// System.out.println("here");
		// parseResource(file);
		// }
		// catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// });
		// }
		assertEquals(
				"All testfiles contained in input folder were covered by a test case.",
				Collections.EMPTY_LIST, allTestFiles);
	}
}
