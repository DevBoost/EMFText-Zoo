package org.emftext.language.c_sharp.test;

import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSSyntaxWrapper;


public class CSharpTest extends AbstractCSharpTest {
		
	public void testAllInputCSFiles(){
		if(checkCSharpPreconditons()){
			CheckCSSyntaxWrapper wrapper=new CheckCSSyntaxWrapper();
			assertEquals(true, wrapper.checkDefaultInputDirectory());				
		}
		else{
			fail("Windows and/or .Net not installed");
		}
		
	}
	
}
