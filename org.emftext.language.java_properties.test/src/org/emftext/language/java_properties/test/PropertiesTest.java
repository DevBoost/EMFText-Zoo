package org.emftext.language.java_properties.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java_properties.KeyValuePair;
import org.emftext.language.java_properties.PropertySet;
import org.emftext.language.java_properties.resource.properties.analysis.PropertiesVALUETokenResolver;
import org.emftext.language.java_properties.resource.properties.mopp.PropertiesMetaInformation;
import org.emftext.language.java_properties.resource.properties.mopp.PropertiesResourceFactory;

public class PropertiesTest extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}
	
	private void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new PropertiesMetaInformation().getSyntaxName(),
				new PropertiesResourceFactory());
	}

	public void testParsing() {
		File[] inputFiles = new File("input").listFiles();
		for (File file : inputFiles) {
			PropertySet ecoreProperties = loadAsEcoreModel(file);
			Properties javaProperties = loadAsJavaObject(file);
			compare(ecoreProperties, javaProperties);
		}
	}

	private void compare(PropertySet ecoreProperties, Properties javaProperties) {
		List<KeyValuePair> ecorePairs = ecoreProperties.getProperties();
		int ecoreCount = ecorePairs.size();
		int javaCount = javaProperties.size();
		int commonCount = Math.min(ecoreCount, javaCount);
		Set<Object> javaKeys = javaProperties.keySet();
		List<Object> javaKeyList = new ArrayList<Object>();
		javaKeyList.addAll(javaKeys);
		for (int i = 0; i < commonCount; i++) {
			KeyValuePair ecorePair = ecorePairs.get(i);
			System.out.println("----------------------------------------------------------------");
			String ecoreKey = ecorePair.getKey();
			System.out.println("Ecore key:   '" + ecoreKey + "'");
			String ecoreValue = ecorePair.getValue();
			System.out.println("Ecore value: '" + ecoreValue + "'");
			Object javaValue = javaProperties.get(ecoreKey);
			assertNotNull("Found no java value for ecore key '" + ecoreKey + "'", javaValue);
			assertEquals("Values do not equal", ecoreValue, javaValue);
		}
	}

	private PropertySet loadAsEcoreModel(File file) {
		URI uri = URI.createFileURI(file.getAbsolutePath());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(uri);
		try {
			resource.load(null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		List<EObject> contents = resource.getContents();
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertTrue(root instanceof PropertySet);
		PropertySet propertySet = (PropertySet) root;
		return propertySet;
	}

	private Properties loadAsJavaObject(File file) {
		Properties properties = new Properties();
		try {
			FileInputStream stream = new FileInputStream(file);
			properties.load(stream);
			stream.close();
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return properties;
	}
	
	public void testRegexps() {
		String regex = PropertiesVALUETokenResolver.VALUE_PREFIX_REGEX;
		assertEquals("abc", "   abc".replaceAll(regex, ""));
		assertEquals("abc", " = abc".replaceAll(regex, ""));
		assertEquals("abc", " : abc".replaceAll(regex, ""));
	}
}
