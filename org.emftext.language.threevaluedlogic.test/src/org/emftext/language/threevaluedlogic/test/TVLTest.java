package org.emftext.language.threevaluedlogic.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.threevaluedlogic.Constants;
import org.emftext.language.threevaluedlogic.Formula;
import org.emftext.language.threevaluedlogic.InterpreterProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptions;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlMetaInformation;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlResourceFactory;

public class TVLTest extends TestCase {

	public void setUp() throws Exception {
		super.setUp();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new TvlMetaInformation().getSyntaxName(),
				new TvlResourceFactory());
	}
	
	public void testInterpreter() {
		// check basic truth table (for or)
		assertComputedValue(Constants.TRUE, "TRUE OR TRUE");
		assertComputedValue(Constants.TRUE, "TRUE OR UNKNOWN"); 
		assertComputedValue(Constants.TRUE, "TRUE OR FALSE"); 
		assertComputedValue(Constants.TRUE, "UNKNOWN OR TRUE"); 
		assertComputedValue(Constants.UNKNOWN, "UNKNOWN OR UNKNOWN"); 
		assertComputedValue(Constants.UNKNOWN, "UNKNOWN OR FALSE"); 
		assertComputedValue(Constants.TRUE, "FALSE OR TRUE");
		assertComputedValue(Constants.UNKNOWN, "FALSE OR UNKNOWN"); 
		assertComputedValue(Constants.FALSE, "FALSE OR FALSE");

		// check basic truth table (for and)
		assertComputedValue(Constants.TRUE, "TRUE AND TRUE");
		assertComputedValue(Constants.UNKNOWN, "TRUE AND UNKNOWN");
		assertComputedValue(Constants.FALSE, "TRUE AND FALSE");
		assertComputedValue(Constants.UNKNOWN, "UNKNOWN AND TRUE");
		assertComputedValue(Constants.UNKNOWN, "UNKNOWN AND UNKNOWN");
		assertComputedValue(Constants.FALSE, "UNKNOWN AND FALSE");
		assertComputedValue(Constants.FALSE, "FALSE AND TRUE");
		assertComputedValue(Constants.FALSE, "FALSE AND UNKNOWN");
		assertComputedValue(Constants.FALSE, "FALSE AND FALSE");

		// check basic truth table (for not)
		assertComputedValue(Constants.FALSE, "TRUE");
		assertComputedValue(Constants.UNKNOWN, "UNKNOWN");
		assertComputedValue(Constants.TRUE, "FALSE");
	}

	private void assertComputedValue(Constants result, String formula) {
		try {
			Formula root = loadResource(formula, "from memory");
			assertEquals(result, root.getComputedValue());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private Formula loadResource(String text, String fileIdentifier) throws IOException {
		return loadResource(new ByteArrayInputStream(text.getBytes()), fileIdentifier);
	}

	private Formula loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {

		Resource resource = load(inputStream, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier + "' was parsed to type Formula.",
				content instanceof Formula);
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
		Formula root = (Formula) content;
		return root;
	}

	private Resource load(InputStream inputStream, String uri)
			throws IOException {
		Map<?, ?> options = getLoadOptions();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + new TvlMetaInformation().getSyntaxName()));
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}

	private Map<?, ?> getLoadOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ITvlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new InterpreterProvider());
		return options;
	}
}
