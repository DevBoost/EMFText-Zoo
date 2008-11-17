package org.reuseware.emftextedit.language.java.test.locations;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.reuseware.emftextedit.language.java.Member;
import org.reuseware.emftextedit.language.java.test.AbstractJavaParserTest;
import org.reuseware.emftextedit.runtime.resource.TextResource;

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
			org.reuseware.emftextedit.language.java.Class clazz = assertParsesToClass(new File(INPUT_FOLDER + typename + ".java"));
			
			List<Member> members = clazz.getMembers();
			// check location of the field 'm'
			assertElementLocation(members.get(0), 4, 2, 2, 13);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	private void assertElementLocation(EObject element, int line, int column, int charStart, int charEnd) {
		Resource resource = element.eResource();
		assertTrue(resource instanceof TextResource);
		TextResource textResource = (TextResource) resource;
		
		assertEquals("Wrong line", line, textResource.getElementLine(element));
		assertEquals("Wrong column", column, textResource.getElementColumn(element));
		assertEquals("Wrong start character", charStart, textResource.getElementCharStart(element));
		assertEquals("Wrong end character", charEnd, textResource.getElementCharEnd(element));
	}

	@Override
	protected boolean isExcludedFromReprintTest(String filename) {
		return true;
	}
}
