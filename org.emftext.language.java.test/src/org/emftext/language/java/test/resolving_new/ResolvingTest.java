package org.emftext.language.java.test.resolving_new;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.test.AbstractJavaParserTestCase;

/**
 * A test for the reference resolving mechanism. Each folder
 * contained INPUT_FOLDER is treated as a Java project and 
 * parsed into one ResourceSet. Afterwards all references are
 * resolved and the annotations contained as comments in the
 * input files are checked.
 * 
 * TODO we should create an individual test for each folder
 * so tests can run independently without causing the whole
 * suite to fail after the first assertion fails
 */
public class ResolvingTest extends AbstractJavaParserTestCase {
	
	private static final String INPUT_FOLDER = "input" + File.separator + "resolving_new";

	public class IgnoreSVNFilter implements FileFilter {

		public boolean accept(File file) {
			if (file.getName().equals(".svn")) {
				// ignore subversion directories
				return false;
			}
			return true;
		}
	}
	
	public void testResolving() {
		// iterate over all folders in the input folder
		File inputFolder = new File(getTestInputFolder());
		File[] testDirectories = inputFolder.listFiles(new IgnoreSVNFilter());
		for (File nextDirectory : testDirectories) {
			testDirectory(nextDirectory);
		}
	}

	private void testDirectory(File testDirectory) {
		String directoryName = testDirectory.getName();
		String[] parts = directoryName.split("_");
		assertEquals("The directory name should contain two parts separated by an underscore.", 2, parts.length);
		String expectedTargetString = parts[1];
		int size;
		try {
			size = Integer.parseInt(expectedTargetString);
		} catch (NumberFormatException nfe) {
			fail("Can't parse expected number of targets in directory name.");
			return;
		}
		// collect all java files and parse them into one
		// resource set
		ResourceSet set = new ResourceSetImpl();
		set.getLoadOptions().putAll(getLoadOptions());
		parseAll(testDirectory, set);
		
		// resolve all references
		EcoreUtil.resolveAll(set);
		
		// find all commented EObjects that are sources or targets
		Map<String, Object> actualTargetsMap = new HashMap<String, Object>();
		Map<String, Object> expectedTargetsMap = new HashMap<String, Object>();
		findSourcesAndTargets(set, actualTargetsMap, expectedTargetsMap);
		
		// check whether the actual targets match the expected targets
		for (String actualID : actualTargetsMap.keySet()) {
			Object actualTarget = actualTargetsMap.get(actualID);
			Object expectedTarget = expectedTargetsMap.get(actualID);
			assertEquals("Target objects should match (ID " + actualID + ").", expectedTarget, actualTarget);
		}
		assertEquals("Number of expected and actual targets should match.", actualTargetsMap.keySet().size(), expectedTargetsMap.keySet().size());

		// check whether the expected number of targets is present
		assertEquals("Number of targets should match the expected number.", actualTargetsMap.keySet().size(), size);
	}

	private void findSourcesAndTargets(ResourceSet set,
			Map<String, Object> actualTargetsMap,
			Map<String, Object> expectedTargetsMap) {
		List<Resource> resources = set.getResources();
		for (Resource resource : resources) {
			TreeIterator<EObject> contentIterator = resource.getAllContents();
			while (contentIterator.hasNext()) {
				EObject next = contentIterator.next();
				if (next instanceof Commentable) {
					Commentable commentable = (Commentable) next;
					List<String> commentList = commentable.getComments();
					String comments = collapse(commentList);
					if (comments.length() > 0) {
						if (comments.contains("source:")) {
							String[] parts = comments.split(":");
							assertEquals("Expected three parts in comment separated by double colon (source:<id>:nameOfReference).", 3, parts.length);
							String id = parts[1].trim();
							String referenceName = parts[2].trim();
							EStructuralFeature feature = commentable.eClass().getEStructuralFeature(referenceName);
							assertNotNull("Can't find feature \"" + referenceName + "\"", feature);
							Object target = commentable.eGet(feature);
							assertNotNull(target);
							actualTargetsMap.put(id, target);
						}
						if (comments.contains("target:")) {
							String[] parts = comments.split(":");
							assertEquals("Expected two parts in comment separated by double colon (target:<id>).", 2, parts.length);
							String id = parts[1].trim();
							expectedTargetsMap.put(id, commentable);
						}
					}
				}
			}
		}
	}

	private String collapse(List<String> commentList) {
		StringBuilder sb = new StringBuilder();
		for (String comment : commentList) {
			sb.append(comment);
		}
		return sb.toString();
	}

	private void parseAll(File testDirectory, ResourceSet set) {
		File[] files = testDirectory.listFiles(new IgnoreSVNFilter());
		for (File file : files) {
			if (file.isDirectory()) {
				parseAll(file, set);
			} else if (file.getName().endsWith(".java")) {
				// parse file into resource set
				URI uri = URI.createFileURI(file.getAbsolutePath());
				Resource resource = set.createResource(uri);
				try {
					resource.load(getLoadOptions());
				} catch (IOException e) {
					fail(e.getMessage());
				}
			} else {
				fail("Found unexpected unknown file " + file.getAbsolutePath());
			}
		}
	}

	@Override
	protected String getTestInputFolder() {
		return INPUT_FOLDER;
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
