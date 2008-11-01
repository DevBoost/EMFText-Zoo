package org.reuseware.emftextedit.language.java.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.reuseware.emftextedit.language.java.Annotation;
import org.reuseware.emftextedit.language.java.Classifier;
import org.reuseware.emftextedit.language.java.CompilationUnit;
import org.reuseware.emftextedit.language.java.Constructor;
import org.reuseware.emftextedit.language.java.Enumeration;
import org.reuseware.emftextedit.language.java.Interface;
import org.reuseware.emftextedit.language.java.Member;
import org.reuseware.emftextedit.language.java.MemberContainer;
import org.reuseware.emftextedit.language.java.Method;
import org.reuseware.emftextedit.language.java.NamedElement;
import org.reuseware.emftextedit.language.java.Public;
import org.reuseware.emftextedit.language.java.Type;
import org.reuseware.emftextedit.language.java.TypeParameter;
import org.reuseware.emftextedit.resource.TextDiagnostic;

/**
 * Abstract superclass that provides some frequently used assert and helper
 * methods.
 */
public abstract class AbstractJavaParserTest extends TestCase {

	public AbstractJavaParserTest() {
		super();
	}

	public AbstractJavaParserTest(String name) {
		super(name);
	}

	protected static final String TEST_INPUT_FOLDER = "input";
	protected static final String TEST_INPUT_FOLDER_RESOLVING = TEST_INPUT_FOLDER + "/resolving/";
	protected static final String TEST_OUTPUT_FOLDER = "output";

	/**
	 * All test files that were parsed by the method parseResource(String
	 * relativePath)
	 */
	protected static List<File> parsedResources = new ArrayList<File>();
	protected static List<File> reprintedResources = new ArrayList<File>();

	protected CompilationUnit parseResource(String filename,
			String inputFolderName) throws Exception {
		return parseResource(new File(filename), inputFolderName);
	}

	protected CompilationUnit parseResource(File inputFile,
			String inputFolderName) throws IOException {
		File inputFolder = new File("./" + inputFolderName);
		File file = new File(inputFolder, inputFile.getPath());
		assertTrue("File " + file + " should exist.", file.exists());
		parsedResources.add(file);
		return parseResource(new FileInputStream(file), file.getName());
	}

	protected CompilationUnit parseResource(InputStream inputStream, String filename) throws IOException {
		return loadResource(inputStream, filename);
	}

	protected static CompilationUnit parseResource(ZipFile file, ZipEntry entry)
			throws IOException {
		return loadResource(file.getInputStream(entry), entry.getName());

	}

	private static CompilationUnit loadResource(InputStream fileInputStream,
			String fileIdentifier) throws IOException {
		JavaResourceImplTestWrapper resource = new JavaResourceImplTestWrapper();
		resource.load(fileInputStream, Collections.EMPTY_MAP);
		assertNoErrors(fileIdentifier, resource);
		assertNoWarnings(fileIdentifier, resource);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to CompilationUnit.",
				content instanceof CompilationUnit);
		CompilationUnit cUnit = (CompilationUnit) content;
		return cUnit;
	}

	private static void assertNoErrors(String fileIdentifier,
			JavaResourceImplTestWrapper resource) {
		EList<Diagnostic> errors = resource.getErrors();
		printErrors(fileIdentifier, errors);
		assertTrue("The resource should be parsed without errors.", errors
				.size() == 0);
	}

	private static void assertNoWarnings(String fileIdentifier,
			JavaResourceImplTestWrapper resource) {
		EList<Diagnostic> warnings = resource.getWarnings();
		printWarnings(fileIdentifier, warnings);
		assertTrue("The resource should be parsed without warnings.", warnings
				.size() == 0);
	}

	protected static void printErrors(String filename, EList<Diagnostic> errors) {
		printDiagnostics(filename, errors, "Errors");
	}

	protected static void printWarnings(String filename,
			EList<Diagnostic> warnings) {
		printDiagnostics(filename, warnings, "Warnings");
	}

	private static void printDiagnostics(String filename,
			EList<Diagnostic> errors, String diagnosticType) {
		if (errors.size() == 0) {
			return;
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append(diagnosticType + " while parsing resource '" + filename
				+ "':\n");
		for (Diagnostic diagnostic : errors) {
			String text;
			if (diagnostic instanceof TextDiagnostic) {
				TextDiagnostic textDiagnostic = (TextDiagnostic) diagnostic;
				text = textDiagnostic.getMessage() + " at ("
						+ textDiagnostic.getLine() + ","
						+ textDiagnostic.getColumn() + ")";
			} else {
				text = diagnostic.getMessage();
			}
			buffer.append("\t" + text + "\n");
		}
		System.out.println(buffer.toString());
	}

	protected void parseAndReprint(ZipFile zip, ZipEntry entry,
			String outputFolderName) throws Exception {
		String entryName = entry.getName();
		String outputFileName = "./" + outputFolderName + File.separator
				+ entryName;
		File outputFile = prepareOutputFile(outputFileName);
		parseAndReprint(zip.getInputStream(entry), new FileOutputStream(
				outputFile));
		assertTrue("File " + outputFile.getAbsolutePath() + " exists.",
				outputFile.exists());
		if (!isExcludedFromReprintTest(entryName)) {
			compareTextContents(zip.getInputStream(entry), new FileInputStream(
					outputFile));
		}
	}

	protected void parseAndReprint(String filename, String inputFolderName,
			String outputFolderName) throws MalformedTreeException,
			IOException, BadLocationException {
		File file = new File(filename);
		parseAndReprint(file, inputFolderName, outputFolderName);
	}

	protected void parseAndReprint(File file, String inputFolderName,
			String outputFolderName) throws MalformedTreeException,
			IOException, BadLocationException {
		File inputFolder = new File("." + File.separator + inputFolderName);
		File inputFile = new File(inputFolder + File.separator + file.getPath());
		assertTrue("File " + inputFile.getAbsolutePath() + " exists.",
				inputFile.exists());
		String outputFileName = calculateOutputFilename(inputFile,
				inputFolderName, outputFolderName);
		File outputFile = prepareOutputFile(outputFileName);
		reprintedResources.add(inputFile);
		parseAndReprint(new FileInputStream(inputFile), new FileOutputStream(
				outputFile));
		assertTrue("File " + outputFile.getAbsolutePath() + " exists.",
				outputFile.exists());

		if (!isExcludedFromReprintTest(file.getPath())) {
			compareTextContents(new FileInputStream(inputFile),
					new FileInputStream(outputFile));
		}
	}

	protected abstract boolean isExcludedFromReprintTest(String filename);

	private static void parseAndReprint(InputStream inputStream,
			OutputStream outputStream) throws IOException,
			MalformedTreeException, BadLocationException {
		JavaResourceImplTestWrapper resource = new JavaResourceImplTestWrapper();
		resource.load(inputStream, Collections.EMPTY_MAP);
		resource.save(outputStream, Collections.EMPTY_MAP);
	}

	private static boolean compareTextContents(InputStream inputStream,
			InputStream inputStream2) throws MalformedTreeException,
			BadLocationException, IOException {
		String inputFileContents = normalize(readTextContents(inputStream));
		String firstPrintContents = normalize(readTextContents(inputStream2));
		assertEquals(
				"The file printed from the parser CompilationUnit equals the given inputFile",
				inputFileContents, firstPrintContents);
		return false;
	}

	private static String calculateOutputFilename(File inputFile,
			String inputFolderName, String outputFolderName) {
		File inputPath = new File("." + File.separator + inputFolderName);
		int trimOffset = inputPath.getAbsolutePath().length();
		File outputFolder = new File("." + File.separator + outputFolderName);
		File outputFile = new File(outputFolder + File.separator
				+ inputFile.getAbsolutePath().substring(trimOffset));
		return outputFile.getAbsolutePath();
	}

	private static File prepareOutputFile(String outputFileName) {
		File outputFile = new File(outputFileName);
		File parent = outputFile.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		return outputFile;
	}

	private static String readTextContents(InputStream inputStream) {
		StringBuffer contents = new StringBuffer();
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(
					inputStream));
			try {
				String line = null; // not declared within while loop
				while ((line = input.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}

	private static String normalize(String code) throws MalformedTreeException,
			BadLocationException, IOException {
		Properties options = new Properties();
		BufferedInputStream stream = null;
		try {
			stream = new BufferedInputStream(new FileInputStream(new File(
					"./formatter.cfg")));
			options.load(stream);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
				}
			}
		}
		CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(options);
		Document doc = new Document();
		doc.set(code);
		TextEdit edit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT,
				code, 0, code.length(), 0, null);
		if (edit != null) {
			edit.apply(doc);
		}
		return doc.get();
	}

	protected static List<File> collectAllFilesRecursive(File startFolder)
			throws CoreException {
		if (startFolder.isFile())
			return Collections.emptyList();
		List<File> allFiles = new ArrayList<File>();
		for (File member : startFolder.listFiles()) {
			if (member.isFile()) {
				if (member.getName().endsWith("java")) {
					allFiles.add(member);
				}
			} else if (member.isDirectory()) {
				if (!member.getName().equals(".svn")) {
					allFiles.addAll(collectAllFilesRecursive(member));
				}
			}
		}
		return allFiles;
	}

	protected void assertClassTypeParameterCount(Member member,
			int expectedNumberOfTypeArguments) {
		assertType(member, org.reuseware.emftextedit.language.java.Class.class);
		org.reuseware.emftextedit.language.java.Class clazz = (org.reuseware.emftextedit.language.java.Class) member;
		List<TypeParameter> typeParameters = clazz.getTypeParameters();
		assertEquals("Expected " + expectedNumberOfTypeArguments
				+ " type parameter(s).", expectedNumberOfTypeArguments,
				typeParameters.size());
	}

	protected void assertInterfaceTypeParameterCount(Member member,
			int expectedNumberOfTypeArguments) {
		assertType(member, Interface.class);
		Interface interfaze = (Interface) member;
		List<TypeParameter> typeParameters = interfaze.getTypeParameters();
		assertEquals("Expected " + expectedNumberOfTypeArguments
				+ " type parameter(s).", expectedNumberOfTypeArguments,
				typeParameters.size());
	}

	protected void assertMethodThrowsCount(Member member,
			int expectedNumberOfThrownExceptions) {
		assertType(member, Method.class);
		Method method = (Method) member;
		List<Type> exceptions = method.getExceptions();
		assertEquals("Expected " + expectedNumberOfThrownExceptions
				+ " exception(s).", expectedNumberOfThrownExceptions,
				exceptions.size());
	}

	protected void assertMethodTypeParameterCount(Member member,
			int expectedNumberOfTypeArguments) {
		assertType(member, Method.class);
		Method method = (Method) member;
		List<TypeParameter> typeParameters = method.getTypeParameters();
		assertEquals("Expected " + expectedNumberOfTypeArguments
				+ " type parameter(s).", expectedNumberOfTypeArguments,
				typeParameters.size());
	}

	protected void assertConstructorThrowsCount(Member member,
			int expectedNumberOfThrownExceptions) {
		assertType(member, Constructor.class);
		Constructor constructor = (Constructor) member;
		List<Type> exceptions = constructor.getExceptions();
		assertEquals("Expected " + expectedNumberOfThrownExceptions
				+ " exception(s).", expectedNumberOfThrownExceptions,
				exceptions.size());
	}

	protected void assertConstructorTypeParameterCount(Member member,
			int expectedNumberOfTypeArguments) {
		assertType(member, Constructor.class);
		Constructor constructor = (Constructor) member;
		List<TypeParameter> typeParameters = constructor.getTypeParameters();
		assertEquals("Expected " + expectedNumberOfTypeArguments
				+ " type parameter(s).", expectedNumberOfTypeArguments,
				typeParameters.size());
	}

	protected void assertIsClass(Classifier classifier) {
		assertType(classifier,
				org.reuseware.emftextedit.language.java.Class.class);
	}

	protected void assertIsInterface(Classifier classifier) {
		assertType(classifier, Interface.class);
	}

	protected Constructor assertIsConstructor(Member member) {
		assertType(member, Constructor.class);
		return (Constructor) member;
	}

	protected void assertType(EObject object, Class<?> expectedType) {
		assertTrue("The object should have type '"
				+ expectedType.getSimpleName() + "', but was "
				+ object.getClass().getSimpleName(), expectedType
				.isInstance(object));
	}

	protected void assertClassifierName(Classifier declaration,
			String expectedName) {
		assertEquals("The name of the declared classifier should equal '"
				+ expectedName + "'", expectedName, declaration.getName());
	}

	protected void assertNumberOfClassifierDeclarations(CompilationUnit model,
			int expectedCount) {
		assertEquals("The compilation unit should contain " + expectedCount
				+ " classifier declaration(s).", expectedCount, model
				.getClassifierDeclarations().size());
	}

	protected void assertModifierCount(Method method,
			int expectedNumberOfModifiers) {
		assertEquals("Method '" + method.getName() + "' should have "
				+ expectedNumberOfModifiers + " modifier(s).",
				expectedNumberOfModifiers, method.getModifiers().size());
	}

	protected void assertIsPublic(Method method) {
		assertTrue("Method '" + method.getName() + "' should be public.",
				method.getModifiers().get(0) instanceof Public);
	}

	protected org.reuseware.emftextedit.language.java.Class assertParsesToClass(
			File file) throws Exception {
		return assertParsesToType(file,
				org.reuseware.emftextedit.language.java.Class.class);
	}

	protected Enumeration assertParsesToEnumeration(String typename)
			throws Exception {
		return assertParsesToType(typename, Enumeration.class);
	}

	protected Interface assertParsesToInterface(String typename)
			throws Exception {
		return assertParsesToType(typename, Interface.class);
	}

	protected Annotation assertParsesToAnnotation(String typename)
			throws Exception {
		return assertParsesToType(typename, Annotation.class);
	}

	protected <T> T assertParsesToType(String typename, String folder,
			Class<T> expectedType) throws Exception {
		String filename = typename + ".java";
		CompilationUnit model = parseResource(filename, folder);
		assertEquals(
				filename + " contains exactly one classifier declaration.", 1,
				model.getClassifierDeclarations().size());

		Classifier declaration = model.getClassifierDeclarations().get(0);
		assertClassifierName(declaration, typename);
		assertType(declaration, expectedType);
		return expectedType.cast(declaration);
	}

	protected <T> T assertParsesToType(String typename, Class<T> expectedType)
			throws Exception {
		return assertParsesToType(typename, TEST_INPUT_FOLDER,
				expectedType);
	}

	private <T> T assertParsesToType(File file, Class<T> expectedType)
			throws Exception {
		CompilationUnit model = parseResource(file);
		assertEquals(file + " contains exactly one classifier declaration.", 1,
				model.getClassifierDeclarations().size());

		Classifier declaration = model.getClassifierDeclarations().get(0);
		assertType(declaration, expectedType);
		return expectedType.cast(declaration);
	}

	private CompilationUnit parseResource(File file) throws Exception {
		return parseResource(file, TEST_INPUT_FOLDER);
	}

	protected void parseAndReprint(String filename)
			throws MalformedTreeException, IOException, BadLocationException {
		parseAndReprint(filename, TEST_INPUT_FOLDER,
				TEST_OUTPUT_FOLDER);
	}

	protected void parseAndReprint(File file) throws MalformedTreeException,
			IOException, BadLocationException {
		parseAndReprint(file, TEST_INPUT_FOLDER, TEST_OUTPUT_FOLDER);
	}

	protected CompilationUnit parseResource(String filename) throws Exception {
		return parseResource(filename, TEST_INPUT_FOLDER);
	}

	protected org.reuseware.emftextedit.language.java.Class assertParsesToClass(
			String typename) throws Exception {
		return assertParsesToType(typename,
				org.reuseware.emftextedit.language.java.Class.class);
	}

	protected void assertMemberCount(
			MemberContainer container,
			int expectedCount) {
		String name = container.toString();
		if (container instanceof NamedElement) {
			name = ((NamedElement) container).getName();
		}
		assertEquals(name + " should have " + expectedCount
				+ " member(s).", expectedCount, container.getMembers().size());
	}

	protected void assertParsesToClass(String typename, int expectedMembers)
			throws Exception, IOException, BadLocationException {
		String filename = typename + ".java";
		org.reuseware.emftextedit.language.java.Class clazz = assertParsesToClass(typename);
		assertEquals(typename + " should have " + expectedMembers
				+ " member(s).", expectedMembers, clazz.getMembers().size());

		parseAndReprint(filename);
	}
}
