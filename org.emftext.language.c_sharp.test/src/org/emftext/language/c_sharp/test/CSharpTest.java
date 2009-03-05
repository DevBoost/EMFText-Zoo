package org.emftext.language.c_sharp.test;

import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSSyntaxWrapper;


public class CSharpTest extends AbstractCSharpTestCase {
		
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
}
