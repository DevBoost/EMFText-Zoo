package org.emftext.language.calc.test;


public class ParserTest extends AbstractCalcTestCase {
	
	public void testParsing() {
		assertParseable("input double x output double y  x = y");
		assertParseable("input double x output double y  wenn x==y x = y + 1 y = 2");
		assertParseable("input double x output double y  wenn x<y x = y - 1");
		assertParseable("input double x output double y  wenn x>y x = y / 1");
		assertParseable("input double x output double y  wenn x>=y x = y * 1");
	}
}
