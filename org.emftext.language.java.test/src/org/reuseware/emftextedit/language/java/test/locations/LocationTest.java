package org.reuseware.emftextedit.language.java.test.locations;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.reuseware.emftextedit.language.java.test.AbstractJavaParserTest;
import org.emftext.language.java.Member;
import org.emftext.language.java.Method;
import org.emftext.runtime.resource.LocationMap;
import org.emftext.runtime.resource.TextResource;

/**
 * A test case that checks whether the generated parser creates 
 * correct location information (line, position...) for the 
 * elements in a TextResource.
 */
public class LocationTest extends AbstractJavaParserTest {
	
	private static final String INPUT_FOLDER = "locations" + File.separator;

	@Test
	public void testElementLocations() {
		String typename = "Location";
		try {
			org.emftext.language.java.Class clazz = assertParsesToClass(new File(INPUT_FOLDER + typename + ".java"));
			
			List<Member> members = clazz.getMembers();
			// check location of the method x
			Method x = (Method) members.get(1);
			assertElementLocation(x.getBody().getStatements().get(0), 6, 2, 85, 88);
			// check location of class
			assertElementLocation(clazz, 3, 0, 22, 96);
			// check location of the field 'm'
			assertElementLocation(members.get(0), 4, 1, 48, 59);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private void assertElementLocation(EObject element, int line, int column, int charStart, int charEnd) {
		Resource resource = element.eResource();
		assertTrue(resource instanceof TextResource);
		TextResource textResource = (TextResource) resource;
		LocationMap locationMap = textResource.getLocationMap();
		
		assertEquals(element.eClass().getName() + ": Wrong line", line, locationMap.getLine(element));
		assertEquals(element.eClass().getName() + ": Wrong column", column, locationMap.getColumn(element));
		assertEquals(element.eClass().getName() + ": Wrong start character", charStart, locationMap.getCharStart(element));
		assertEquals(element.eClass().getName() + ": Wrong end character", charEnd, locationMap.getCharEnd(element));
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
