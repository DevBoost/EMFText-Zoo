package org.emftext.language.java.test.xmi;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.JavaRoot;
import org.emftext.language.java.containers.Package;
import org.emftext.language.java.test.AbstractJavaParserTestCase;
import org.emftext.language.java.test.util.ThreadedTestSuite;

public class JavaXMISerializationTest extends AbstractJavaParserTestCase {

	protected static final String TEST_INPUT_FOLDER_NAME = "src-input";
	protected static final String TEST_OUTPUT_FOLDER_NAME = "output";
	
	// The following files can not be saved to XMI, because they contain
	// characters XML (1.0) does not support.
	protected static final String[] filesWithInvalidCharacters = new String [] {
		"EscapedStrings.java", "UnicodeIdentifiers.java", "SpecialCharacters.java", 
		"StaticImports.java" //because it depends on EscapedStrings
	};
	
	public static Test suite() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		final JavaXMISerializationTest test = new JavaXMISerializationTest();

		TestSuite suite = new ThreadedTestSuite(
		"Suite testing XMI conversion for all files in the input directory automatically", 30 * 1000, 1);
		File inputFolder = new File("./" + TEST_INPUT_FOLDER_NAME);
		List<File> allTestFiles = collectAllFilesRecursive(inputFolder, "java");
		for (final File file : allTestFiles) {
			if (!Arrays.asList(filesWithInvalidCharacters).contains(file.getName())) {
				addFileToClasspath(test, file);
				addLoadTest(test, suite, file);
			}
		}

		addTransferToXMITest(test, suite);
		
		for (final File file : allTestFiles) {
			if (!Arrays.asList(filesWithInvalidCharacters).contains(file.getName())) {
				addSaveAndCompareTest(test, suite, file);
			}
		}
		return suite;
	}

	private static void addLoadTest(final JavaXMISerializationTest test,
			TestSuite suite, final File file) {
		suite.addTest(new TestCase("Loading " + file.getName()) {
			public void runTest() {
				try {
					JavaRoot root = test.loadResource(file.getAbsolutePath());
					test.assertResolveAllProxies(root);
				}
				catch (Exception e) {
					e.printStackTrace();
					fail(e.getClass() +  ": " + e.getMessage());
				}
			}
		});
	}
	
	private static void addSaveAndCompareTest(final JavaXMISerializationTest test,
			TestSuite suite, final File file) {
		suite.addTest(new TestCase("Saving and comparing XMI " + file.getName()) {
			public void runTest() {
				try {
					test.compare(file);
				}
				catch (Exception e) {
					e.printStackTrace();
					fail(e.getClass() +  ": " + e.getMessage());
				}
			}
		});
	}
	
	private static void addTransferToXMITest(final JavaXMISerializationTest test,
			TestSuite suite) {
		suite.addTest(new TestCase("Coverting all Java resources to XMI") {
			public void runTest() {
				try {
					test.transferToXMI();
				}
				catch (Exception e) {
					e.printStackTrace();
					fail(e.getClass() +  ": " + e.getMessage());
				}
			}
		});
	}
	
	private static void addFileToClasspath(
			final JavaXMISerializationTest test, File file) throws Exception {
		JavaClasspath cp = JavaClasspath.get(test.getResourceSet());
		String fullName = file.getPath().substring(TEST_INPUT_FOLDER_NAME.length() + 3, file.getPath().length() - 5);
		fullName = fullName.replace(File.separator, ".");
		int idx = fullName.lastIndexOf(".");
		String packageName;
		String classifierName;
		if (idx == -1) {
			packageName = "";
			classifierName = fullName;
		} else {
			packageName = fullName.substring(0, idx);
			classifierName = fullName.substring(idx + 1);			
		}
		cp.registerClassifier(packageName, classifierName, URI.createFileURI(file.getAbsolutePath()));
	}
	
	private ResourceSet sharedTestResourceSet = null;
	
	@Override
	protected ResourceSet getResourceSet() {
		if (sharedTestResourceSet == null) {
			sharedTestResourceSet = super.getResourceSet();
		}
		return sharedTestResourceSet;
	}
	
	@Override
	protected Map<? extends Object, ? extends Object> getLoadOptions() {
		Map<? extends Object, ? extends Object> m = super.getLoadOptions();
		//m.put(XMIResource.OPTION_XML_VERSION, "1.1");
		return m;
	}
	
	protected void transferToXMI() throws Exception {
		ResourceSet rs = getResourceSet();
		EcoreUtil.resolveAll(rs);
		for (Resource javaResource : new ArrayList<Resource>(rs.getResources())) {
			JavaRoot root = (JavaRoot) javaResource.getContents().get(0);
			String outputFileName = "ERROR";
			if (root instanceof CompilationUnit) {
				outputFileName = root.getName().substring(0, root.getName().length() - 5).replace(".", File.separator);

			} else if (root instanceof Package) {
				outputFileName = root.getNamespacesAsString().replace(".", File.separator) + File.separator + root.getName() + File.separator + "package-info";
				if (outputFileName.startsWith(File.separator)) {
					outputFileName = outputFileName.substring(1);
				}
			} else {
				fail();
			}
			File outputFile = new File("." + File.separator + TEST_OUTPUT_FOLDER_NAME + File.separator + outputFileName);
			URI xmiFileURI = URI.createFileURI(outputFile.getAbsolutePath()).appendFileExtension("xmi");	
			Resource xmiResource = rs.createResource(xmiFileURI);
			xmiResource.getContents().addAll(javaResource.getContents());

		}
		for (Resource xmiResource : rs.getResources()) {
			if (xmiResource instanceof XMIResource) {
				try {
					xmiResource.save(rs.getLoadOptions());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	protected void compare(File file) throws Exception {
		ResourceSet rs = getResourceSet();
		String outputXMIFileName = calculateOutputFilename(file,
				getTestInputFolder(), TEST_OUTPUT_FOLDER);
		URI xmiFileURI = URI.createFileURI(outputXMIFileName).trimFileExtension().appendFileExtension("xmi");
		Resource xmiResource = rs.getResource(xmiFileURI, false);
		assertNotNull(xmiResource);
		EObject root = xmiResource.getContents().get(0);
		xmiResource.save(rs.getLoadOptions());
		
		//reload
		ResourceSet reloadeSet = super.getResourceSet();
		Resource reloadedResource = null;
		try {
			reloadedResource = reloadeSet.getResource(xmiFileURI, true);
		} catch (Exception e) {
			fail(e.getClass() +  ": " + e.getMessage());
		}
		assertResolveAllProxies(reloadedResource);
		for (Diagnostic d : reloadedResource.getErrors()) {
			System.out.println(d.getMessage());
		}
		assertTrue("Parsed XMI contains errors", 
				reloadedResource.getErrors().isEmpty());
		
		EObject reloadedRoot = reloadedResource.getContents().get(0);
	    EqualityHelper equalityHelper = new EqualityHelper() {
			private static final long serialVersionUID = 1L;

			@Override
	    	public boolean equals(EObject eObject1, EObject eObject2) {
	    		boolean result = super.equals(eObject1, eObject2);
	    		if (!result) {
	    			System.out.println("Not equal: " + eObject1 + " != " + eObject2);
	    		}
	    		return result;
	    	}
	    	
	    	@Override
	    	protected boolean haveEqualFeature(EObject eObject1,
	    			EObject eObject2, EStructuralFeature feature) {
	    		if (feature.isTransient()) {
	    			//ignore transient features
	    			return true;
	    		}
	    		return super.haveEqualFeature(eObject1, eObject2, feature);
	    	}
	    };
	    
	    assertTrue("Original and reloaded XMI are not equal",
	    		equalityHelper.equals(root, reloadedRoot));
		
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}

	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER_NAME;
	}

}
