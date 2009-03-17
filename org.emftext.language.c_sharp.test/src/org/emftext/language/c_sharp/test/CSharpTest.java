package org.emftext.language.c_sharp.test;

import org.emftext.language.c_sharp.namespaces.CompilationUnit;
import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSSyntaxWrapper;
import org.junit.Test;


public class CSharpTest extends AbstractCSharpTestCase {

	private static final String CSHARP_FILE_EXTENSION = ".csharp";
	protected static final String TEST_INPUT_FOLDER = "input";
	
	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER;
	}
	
	@Override
	protected String getFileExtension() {
		return CSHARP_FILE_EXTENSION;
	}
	
	@Test
	public void testAllInputCSFiles(){
		if(checkCSharpPreconditons()){
			CheckCSSyntaxWrapper wrapper=new CheckCSSyntaxWrapper();
			assertEquals(true, wrapper.checkDefaultInputDirectory());				
		}
		else{
			System.out.println("CSharp test can not run on non-Windows systems");
			//fail("Windows and/or .Net not installed");
		}
	}
	
	
	@Test
	public void testWarnings() throws Exception {
		String typename = "testwarnings";
		String filename = typename + CSHARP_FILE_EXTENSION;
		
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		
		//org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		//assertMemberCount(clazz, 4);

		//parseAndReprint(filename);
	}
	
}
