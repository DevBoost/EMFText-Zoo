package org.emftext.language.c_sharp.test;

import org.emftext.language.c_sharp.namespaces.CompilationUnit;
import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSSyntaxWrapper;
import org.junit.Test;


public class CSharpTest extends AbstractCSharpTestCase {

	protected static final String TEST_INPUT_FOLDER = "input";
	
	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER;
	}
	
	@Test
	public void testAllInputCSFiles(){
		if(checkCSharpPreconditons()){
			CheckCSSyntaxWrapper wrapper=new CheckCSSyntaxWrapper();
			wrapper.assertAllFilesInInputDirectoryAreValid();				
		}
		else{
			System.out.println("CSharp test can not run on non-Windows systems");
			//fail("Windows and/or .Net not installed");
		}
	}
	
	
	@Test
	public void testWarnings() throws Exception {
		String typename = "testwarnings";
		String filename = typename + getFileExtension();
		
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		
		//org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		//assertMemberCount(clazz, 4);

		//parseAndReprint(filename);
	}
	
}
