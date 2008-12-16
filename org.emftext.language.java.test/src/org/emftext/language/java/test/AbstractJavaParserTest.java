package org.emftext.language.java.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import junit.framework.TestCase;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.UnicodeConverterProvider;
import org.emftext.language.java.annotations.Annotation;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.CompilationUnit;
import org.emftext.language.java.core.Constructor;
import org.emftext.language.java.core.Enumeration;
import org.emftext.language.java.core.Interface;
import org.emftext.language.java.core.Member;
import org.emftext.language.java.core.MemberContainer;
import org.emftext.language.java.core.Method;
import org.emftext.language.java.core.NamedElement;
import org.emftext.language.java.core.TypeParameter;
import org.emftext.language.java.modifiers.Public;
import org.emftext.language.java.resource.classfile.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.resource.TextDiagnostic;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.TextDiagnostic.TextDiagnosticType;

/**
 * Abstract superclass that provides some frequently used assert and helper
 * methods.
 */
public abstract class AbstractJavaParserTest extends TestCase {

	public AbstractJavaParserTest() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
	}

	public AbstractJavaParserTest(String name) {
		super(name);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
	}
	
	public AbstractJavaParserTest(String name, ResourceSet rs) {
		super(name);
		myResourceSet = rs;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
	}

	protected static final String TEST_OUTPUT_FOLDER = "output";

	/**
	 * All test files that were parsed by the method parseResource(String
	 * relativePath)
	 */
	protected static List<File> parsedResources = new ArrayList<File>();
	protected static List<File> reprintedResources = new ArrayList<File>();
	
	protected static ResourceSet myResourceSet = new ResourceSetImpl();

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
		return parseResource(file.getCanonicalPath(), ignoreSemanticErrors());
	}

	protected CompilationUnit parseResource(String filename, boolean ignoreSemanticErrors) throws IOException {
		return loadResource(filename, ignoreSemanticErrors);
	}

	protected static CompilationUnit parseResource(ZipFile file, ZipEntry entry, boolean ignoreSemanticErrors)
			throws IOException {
		//FIXME change entry.getName to full qualified path
		return loadResource(URI.createURI("archive:file:///" + new File(".").getAbsoluteFile().toURI().getRawPath() + file.getName() + "!/" + entry.getName()), ignoreSemanticErrors);
	}

	private static CompilationUnit loadResource(
			String filePath, boolean ignoreSemanticErrors) throws IOException {
		return loadResource(URI.createFileURI(filePath), ignoreSemanticErrors);
	}
	
	private static CompilationUnit loadResource(
			URI uri, boolean ignoreSemanticErrors) throws IOException {
		TextResource resource = (TextResource) myResourceSet.createResource(uri);
		resource.load(getLoadOptions());
		assertNoErrors(uri.toString(), resource, ignoreSemanticErrors);
		assertNoWarnings(uri.toString(), resource);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + uri.toString()
				+ "' was parsed to CompilationUnit.",
				content instanceof CompilationUnit);
		CompilationUnit cUnit = (CompilationUnit) content;
		return cUnit;
	}

	protected static Map<?, ?> getLoadOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		return map;
	}

	private static void assertNoErrors(String fileIdentifier,
			TextResource resource, boolean ignoreSemanticErrors) {
		EList<Diagnostic> errors = new BasicEList<Diagnostic>(resource.getErrors());
		if (ignoreSemanticErrors) {
			for (Diagnostic error : resource.getErrors()) {
				if (error instanceof TextDiagnostic && ((TextDiagnostic) error).getType() == TextDiagnosticType.RESOLVE_PROBLEM) {
					errors.remove(error);
				}
			}
		}
		printErrors(fileIdentifier, errors);
		assertTrue("The resource should be parsed without errors.", errors
				.size() == 0);
	}

	private static void assertNoWarnings(String fileIdentifier,
			TextResource resource) {
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
		/* FIXME! parseAndReprint(zip.getInputStream(entry), new FileOutputStream(
				outputFile)); */
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
		
		Resource resource = myResourceSet.createResource(URI.createFileURI(inputFile.getCanonicalPath().toString()));

		resource.load(null);
		
		if (!ignoreSemanticErrors()) {
			// This will not work if external resources are not yet registered (order of tests)
			//assertResolveAllProxies(resource);
		}
		
		resource.setURI(URI.createFileURI(outputFileName));
		
		
		resource.save(null);
		
		assertTrue("File " + outputFile.getAbsolutePath() + " exists.",
				outputFile.exists());

		if (!isExcludedFromReprintTest(file.getPath())) {
			compareTextContents(new FileInputStream(inputFile),
					new FileInputStream(outputFile));
		}
	}

	protected abstract boolean isExcludedFromReprintTest(String filename);

	protected boolean ignoreSemanticErrors() {
		return true;
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
		assertType(member, org.emftext.language.java.core.Class.class);
		org.emftext.language.java.core.Class clazz = (org.emftext.language.java.core.Class) member;
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
		List<Classifier> exceptions = method.getExceptions();
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
		List<Classifier> exceptions = constructor.getExceptions();
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
				org.emftext.language.java.core.Class.class);
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

	protected void assertNumberOfClassifiers(CompilationUnit model,
			int expectedCount) {
		assertEquals("The compilation unit should contain " + expectedCount
				+ " classifier declaration(s).", expectedCount, model
				.getClassifiers().size());
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

	protected org.emftext.language.java.core.Class assertParsesToClass(
			File file) throws Exception {
		return assertParsesToType(file,
				org.emftext.language.java.core.Class.class);
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
		assertNumberOfClassifiers(model, 1);

		Classifier declaration = model.getClassifiers().get(0);
		assertClassifierName(declaration, typename);
		assertType(declaration, expectedType);
		return expectedType.cast(declaration);
	}

	protected <T> T assertParsesToType(String typename, Class<T> expectedType)
			throws Exception {
		return assertParsesToType(typename, getTestInputFolder(),
				expectedType);
	}

	protected abstract String getTestInputFolder();

	private <T> T assertParsesToType(File file, Class<T> expectedType)
			throws Exception {
		CompilationUnit model = parseResource(file);

		assertNumberOfClassifiers(model, 1);

		Classifier declaration = model.getClassifiers().get(0);
		assertType(declaration, expectedType);
		return expectedType.cast(declaration);
	}

	private CompilationUnit parseResource(File file) throws Exception {
		return parseResource(file, getTestInputFolder());
	}

	protected void parseAndReprint(String filename)
			throws MalformedTreeException, IOException, BadLocationException {
		parseAndReprint(filename, getTestInputFolder(),
				TEST_OUTPUT_FOLDER);
	}

	protected void parseAndReprint(File file) throws MalformedTreeException,
			IOException, BadLocationException {
		parseAndReprint(file, getTestInputFolder(), TEST_OUTPUT_FOLDER);
	}

	protected CompilationUnit parseResource(String filename) throws Exception {
		return parseResource(filename, getTestInputFolder());
	}

	protected org.emftext.language.java.core.Class assertParsesToClass(
			String typename) throws Exception {
		return assertParsesToType(typename,
				org.emftext.language.java.core.Class.class);
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
		org.emftext.language.java.core.Class clazz = assertParsesToClass(typename);
		assertEquals(typename + " should have " + expectedMembers
				+ " member(s).", expectedMembers, clazz.getMembers().size());

		parseAndReprint(filename);
	}
	
	protected void assertResolveAllProxies(EObject element) {
		assertResolveAllProxies(element.eResource());
	}
	
	protected void assertResolveAllProxies() {
		boolean failure = false;
		for(URI uri : new ArrayList<URI>(JavaClasspath.INSTANCE.URI_MAP.keySet())) {
			if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
				//do not load all default classfildes
				if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP + "java")) {
					continue;
				}
				if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP + "com.sun")) {
					continue;
				}
				if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP + "sun")) {
					continue;
				}
				if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP + "org.omg")) {
					continue;
				}
				
				Resource r = myResourceSet.getResource(uri, true);
				assertNotNull("The resource '" + uri + "' should exist",r);
				failure = assertResolveAllProxies(r) || failure;
				
			}
		}
		assertFalse("There are unresolved proxies", failure);
	}
	
	protected boolean assertResolveAllProxies(Resource resource) {
		boolean failure = false;
		if (!ignoreSemanticErrors()) {
			for(Iterator<EObject> elementIt = EcoreUtil.getAllContents(resource, true); elementIt.hasNext(); ) {
				InternalEObject nextElement = (InternalEObject) elementIt.next();
				assertFalse("Can not reslove: " + nextElement.eProxyURI(), nextElement.eIsProxy());
				for (EObject crElement : nextElement.eCrossReferences()) {
					crElement = EcoreUtil.resolve(crElement, resource);
					if (crElement.eIsProxy()) {
						System.out.println("Can not resolve: " + ((InternalEObject) crElement).eProxyURI());
						failure = true;
					}
				}
			}
		}
		return failure;
	}
}
