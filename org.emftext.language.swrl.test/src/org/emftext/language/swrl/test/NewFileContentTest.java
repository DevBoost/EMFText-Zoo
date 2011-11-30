package org.emftext.language.swrl.test;

import static org.junit.Assert.assertNotNull;

import org.emftext.language.swrl.resource.swrl.mopp.SwrlMetaInformation;
import org.junit.Test;

public class NewFileContentTest {

	@Test
	public void test() {
		String newFileContent = new SwrlMetaInformation().getNewFileContentProvider().getNewFileContent("new");
		assertNotNull(newFileContent);
	}

}
