/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.text.edits.MalformedTreeException;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.Enumeration;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.members.Constructor;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.MemberContainer;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.emftext.language.java.modifiers.Modifier;
import org.emftext.language.java.modifiers.Public;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.language.java.resource.java.analysis.helper.JavaPostProcessor;
import org.emftext.language.java.resource.java.analysis.helper.UnicodeConverter;
import org.emftext.language.java.resource.java.analysis.helper.UnicodeConverterProvider;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.resource.ITextDiagnostic;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;

/**
 * Abstract superclass that provides some frequently used assert and helper
 * methods.
 */
public abstract class AbstractJavaParserTestCase extends TestCase {

	public AbstractJavaParserTestCase() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
	}

	public AbstractJavaParserTestCase(String name) {
		super(name);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
	}
	
	protected void registerInClassPath(String file) throws Exception {
		File inputFolder = new File("." + File.separator + getTestInputFolder());
		File inputFile = new File(file);

		CompilationUnit cu = (CompilationUnit) parseResource(inputFile);
		
		inputFile = new File(inputFolder + File.separator + file);
		JavaClasspath.get(cu).registerClassifierSource(cu, URI.createFileURI(inputFile.getCanonicalPath().toString()));
	}

	protected static final String TEST_OUTPUT_FOLDER = "output";

	/**
	 * All test files that were parsed by the method parseResource(String
	 * relativePath)
	 */
	private static List<File> parsedResources = new ArrayList<File>();
	private static List<File> reprintedResources = new ArrayList<File>();

	protected JavaRoot parseResource(String filename,
			String inputFolderName) throws Exception {
		return parseResource(new File(filename), inputFolderName);
	}

	protected JavaRoot parseResource(File inputFile,
			String inputFolderName) throws IOException {
		File inputFolder = new File("./" + inputFolderName);
		File file = new File(inputFolder, inputFile.getPath());
		assertTrue("File " + file + " should exist.", file.exists());
		addParsedResource(file);
		return loadResource(file.getCanonicalPath());
	}

	protected JavaRoot parseResource(ZipFile file, ZipEntry entry)
			throws IOException {
		return loadResource(URI.createURI("archive:file:///" + new File(".").getAbsoluteFile().toURI().getRawPath() + file.getName().replaceAll("\\\\", "/") + "!/" + entry.getName()));
	}

	private JavaRoot loadResource(
			String filePath) throws IOException {
		return loadResource(URI.createFileURI(filePath));
	}
	
	private JavaRoot loadResource(
			URI uri) throws IOException {
		ITextResource resource = (ITextResource) getResourceSet().createResource(uri);
		resource.load(getLoadOptions());
		assertNoErrors(uri.toString(), resource);
		assertNoWarnings(uri.toString(), resource);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + uri.toString()
				+ "' was parsed to CompilationUnit.",
				content instanceof JavaRoot);
		JavaRoot root = (JavaRoot) content;
		return root;
	}

	protected Map<?, ?> getLoadOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		map.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new JavaPostProcessor());
		map.put(JavaClasspath.OPTION_USE_LOCAL_CLASSPATH, Boolean.TRUE);
		return map;
	}

	private static void assertNoErrors(String fileIdentifier,
			ITextResource resource) {
		EList<Diagnostic> errors = new BasicEList<Diagnostic>(resource.getErrors());
		printErrors(fileIdentifier, errors);
		assertTrue("The resource should be parsed without errors.", errors
				.size() == 0);
	}

	private static void assertNoWarnings(String fileIdentifier,
			ITextResource resource) {
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
			if (diagnostic instanceof ITextDiagnostic) {
				ITextDiagnostic textDiagnostic = (ITextDiagnostic) diagnostic;
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

	protected void parseAndReprint(ZipFile file, ZipEntry entry,
			String outputFolderName, String libFolderName) throws Exception {
		String entryName = entry.getName();
		String outputFileName = "./" + outputFolderName + File.separator
				+ entryName;
		File outputFile = prepareOutputFile(outputFileName);
		URI archiveURI = URI.createURI("archive:file:///" + new File(".").getAbsoluteFile().toURI().getRawPath() + file.getName().replaceAll("\\\\", "/") + "!/" + entry.getName());
		
		ResourceSet resourceSet = getResourceSet();
		
		// TODO put this somewhere else
		if (file.getName().endsWith("jdt_test_files" + File.separator + "src.zip")) {
			String prefix = entry.getName().substring(0, entry.getName().indexOf("/") + 1);
			registerLibs(libFolderName, resourceSet, prefix);
		}

		Resource resource = resourceSet.createResource(archiveURI);
		resource.load(getLoadOptions());
		
		if (!ignoreSemanticErrors(entry.getName())) {
			// This will not work if external resources are not yet registered (order of tests)
			assertResolveAllProxies(resource);
		}
		
		if (isExcludedFromReprintTest(entry.getName())) {
			return;
		}
		
		//addReprintedResource(inputFile);
		resource.setURI(URI.createFileURI(outputFileName));	
		resource.save(null);
		
		assertTrue("File " + outputFile.getAbsolutePath() + " exists.",
				outputFile.exists());

		compareTextContents(file.getInputStream(entry),
					new FileInputStream(outputFile));
		
	}
	
	
	protected static void registerLibs(String libdir, ResourceSet resourceSet, String prefix) throws IOException, CoreException  {
		File libFolder = new File("." + File.separator
				+ libdir);
		List<File> allLibFiles = collectAllFilesRecursive(libFolder, "jar");
		
		for(File lib : allLibFiles) {
			JavaClasspath.get(resourceSet).registerClassifierJar(URI.createFileURI(lib.getAbsolutePath()), prefix);
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
		
		Resource resource = getResourceSet().createResource(URI.createFileURI(inputFile.getCanonicalPath().toString()));
		resource.load(getLoadOptions());
		
		assertNoErrors(resource.getURI().toString(), (ITextResource) resource);
		addParsedResource(inputFile);
		
		if (!ignoreSemanticErrors(file.getPath())) {
			// This will not work if external resources are not yet registered (order of tests)
			assertResolveAllProxies(resource);
		}
		
		if (isExcludedFromReprintTest(file.getPath())) {
			return;
		}
		
		addReprintedResource(inputFile);
		resource.setURI(URI.createFileURI(outputFileName));	
		resource.save(null);
		
		assertTrue("File " + outputFile.getAbsolutePath() + " exists.",
				outputFile.exists());

		compareTextContents(new FileInputStream(inputFile),
					new FileInputStream(outputFile));
	}

	protected abstract boolean isExcludedFromReprintTest(String filename);

	protected boolean ignoreSemanticErrors(String filename) {
		return false;
	}

	private static boolean compareTextContents(InputStream inputStream,
			InputStream inputStream2) throws MalformedTreeException,
			BadLocationException, IOException {
		
		//converter unicode
		inputStream = new UnicodeConverter(inputStream);
		
		org.eclipse.jdt.core.dom.CompilationUnit unit1 = parseWithJDT(inputStream);
		removeJavadoc(unit1);

		org.eclipse.jdt.core.dom.CompilationUnit unit2 = parseWithJDT(inputStream2);
		removeJavadoc(unit2);
		
		TalkativeASTMatcher matcher = new TalkativeASTMatcher(true);
		boolean result = unit1.subtreeMatch(matcher, unit2);
		
		assertTrue(
				"Reprint not equal: " + matcher.getDiff(),
				result);

		return result;
	}

	private static org.eclipse.jdt.core.dom.CompilationUnit parseWithJDT(
			InputStream inputStream) {
		ASTParser jdtParser = ASTParser.newParser(AST.JLS3);
		char[] charArray = readTextContents(inputStream).toCharArray();
		jdtParser.setSource(charArray);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_5);
		jdtParser.setCompilerOptions(options);
		
		org.eclipse.jdt.core.dom.CompilationUnit result1 = 
			(org.eclipse.jdt.core.dom.CompilationUnit) jdtParser.createAST(null);
		return result1;
	}

	private static void removeJavadoc(
			org.eclipse.jdt.core.dom.CompilationUnit result1) {
		final List<Javadoc> javadocNodes = new ArrayList<Javadoc>();
		result1.accept(new ASTVisitor() {
			public boolean visit(Javadoc node) {
				javadocNodes.add(node);
				return true;
			}
		});
		for (Javadoc node : javadocNodes) {
			node.delete();
		}
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
		// TODO this does not work on Windows
		File outputFile = new File(outputFileName.replaceAll(" ", "\\%20"));
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

	protected static List<File> collectAllFilesRecursive(File startFolder, String extension)
			throws CoreException {
		if (!startFolder.isDirectory())
			return Collections.emptyList();
		List<File> allFiles = new ArrayList<File>();
		//add sub dirs first
		for (File member : startFolder.listFiles()) {
			if (member.isDirectory()) {
				if (!member.getName().equals(".svn")) {
					allFiles.addAll(collectAllFilesRecursive(member, extension));
				}
			}
		}
		//bin.jar in the end
		for (File member : startFolder.listFiles()) {
			if (member.isFile()) {
				if (member.getName().endsWith(extension)) {
					allFiles.add(member);
				}
			} 
		}
		return allFiles;
	}

	protected void assertClassTypeParameterCount(Member member,
			int expectedNumberOfTypeArguments) {
		assertType(member, org.emftext.language.java.classifiers.Class.class);
		org.emftext.language.java.classifiers.Class clazz = (org.emftext.language.java.classifiers.Class) member;
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
		List<NamespaceClassifierReference> exceptions = method.getExceptions();
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
		List<NamespaceClassifierReference> exceptions = constructor.getExceptions();
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
				org.emftext.language.java.classifiers.Class.class);
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
				+ expectedName + "'", expectedName, JavaUtil.getName(declaration));
	}

	protected void assertNumberOfClassifiers(CompilationUnit model,
			int expectedCount) {
		assertEquals("The compilation unit should contain " + expectedCount
				+ " classifier declaration(s).", expectedCount, model
				.getClassifiers().size());
	}

	protected void assertModifierCount(Method method,
			int expectedNumberOfModifiers) {
		List<Modifier> annotationsAndModifiers = getModifiers(method);
		assertEquals("Method '" + JavaUtil.getName(method) + "' should have "
				+ expectedNumberOfModifiers + " modifier(s).",
				expectedNumberOfModifiers, annotationsAndModifiers.size());
	}

	private List<Modifier> getModifiers(Method method) {
		EList<AnnotationInstanceOrModifier> annotationsAndModifiers = method.getAnnotationsAndModifiers();
		List<Modifier> modifiers = new ArrayList<Modifier>();
		for (AnnotationInstanceOrModifier annotationInstanceOrModifier : annotationsAndModifiers) {
			if (annotationInstanceOrModifier instanceof Modifier) {
				modifiers.add((Modifier) annotationInstanceOrModifier);
			}
		}
		return modifiers;
	}

	protected void assertIsPublic(Method method) {
		assertTrue("Method '" + JavaUtil.getName(method) + "' should be public.",
				getModifiers(method).get(0) instanceof Public);
	}

	protected org.emftext.language.java.classifiers.Class assertParsesToClass(
			File file) throws Exception {
		return assertParsesToType(file,
				org.emftext.language.java.classifiers.Class.class);
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
		JavaRoot model = parseResource(filename, folder);
		if (model instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) model;
			assertNumberOfClassifiers(cu, 1);
	
			Classifier declaration = cu.getClassifiers().get(0);
			assertClassifierName(declaration, typename);
			assertType(declaration, expectedType);
			return expectedType.cast(declaration);
		}
		else {
			return null;
		}
		
	}

	protected <T> T assertParsesToType(String typename, Class<T> expectedType)
			throws Exception {
		return assertParsesToType(typename, getTestInputFolder(),
				expectedType);
	}

	protected abstract String getTestInputFolder();
	
	private <T> T assertParsesToType(File file, Class<T> expectedType)
			throws Exception {

		JavaRoot model = parseResource(file);
		if (model instanceof CompilationUnit) {
			CompilationUnit cu = (CompilationUnit) model;
			assertNumberOfClassifiers(cu, 1);

			Classifier declaration = cu.getClassifiers().get(0);
			assertType(declaration, expectedType);
			return expectedType.cast(declaration);
		}
		else {
			return null;
		}
	}

	private JavaRoot parseResource(File file) throws Exception {
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

	protected JavaRoot parseResource(String filename) throws Exception {
		return parseResource(filename, getTestInputFolder());
	}

	protected org.emftext.language.java.classifiers.Class assertParsesToClass(
			String typename) throws Exception {
		return assertParsesToType(typename,
				org.emftext.language.java.classifiers.Class.class);
	}

	protected void assertMemberCount(
			MemberContainer container,
			int expectedCount) {
		String name = container.toString();
		if (container instanceof NamedElement) {
			name = JavaUtil.getName((NamedElement) container);
		}
		assertEquals(name + " should have " + expectedCount
				+ " member(s).", expectedCount, container.getMembers().size());
	}

	protected void assertParsesToClass(String typename, int expectedMembers)
			throws Exception, IOException, BadLocationException {
		String filename = typename + ".java";
		org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		assertEquals(typename + " should have " + expectedMembers
				+ " member(s).", expectedMembers, clazz.getMembers().size());

		parseAndReprint(filename);
	}
	
	protected void assertResolveAllProxies(EObject element) {
		assertResolveAllProxies(element.eResource());
	}
	
	/*protected void assertResolveAllProxies() {
		boolean failure = false;
		for(URI uri : new ArrayList<URI>(JavaClasspath.INSTANCE.URI_MAP.keySet())) {
			if (uri.toString().startsWith(JavaUniquePathConstructor.JAVA_CLASSIFIER_PATHMAP)) {
				//do not load all default classfiles
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
				
				Resource r = getResourceSet().getResource(uri, true);
				assertNotNull("The resource '" + uri + "' should exist",r);
				failure = assertResolveAllProxies(r) || failure;
				
			}
		}
		assertFalse("There are unresolved proxies", failure);
	}*/
	
	protected ResourceSet getResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getLoadOptions().putAll(getLoadOptions());
		return rs;
	}

	protected boolean assertResolveAllProxies(Resource resource) {
		List<EObject> unresolvedProxies = new TextResourceHelper().findUnresolvedProxies(resource);
		boolean failure = false;
		String msg="";
		
		for (EObject next : unresolvedProxies) {
			InternalEObject nextElement = (InternalEObject) next;
			assertFalse("Can not resolve: " + nextElement.eProxyURI(), nextElement.eIsProxy());
			for (EObject crElement : nextElement.eCrossReferences()) {
				crElement = EcoreUtil.resolve(crElement, resource);
				if (crElement.eIsProxy()) {
					msg += "\nCan not resolve: " + ((InternalEObject) crElement).eProxyURI();
					failure = true;
				}
			}
		}
		assertFalse(msg, failure);
		return failure;
	}
	
	public static List<File> getParsedResources() {
		return parsedResources;
	}

	public static List<File> getReprintedResources() {
		return reprintedResources;
	}

	public void addParsedResource(File file) {
		if (!parsedResources.contains(file)) {
			parsedResources.add(file);
		}
	}

	public void addReprintedResource(File file) {
		if(!reprintedResources.contains(file)) {
			reprintedResources.add(file);
		}
	}
}
