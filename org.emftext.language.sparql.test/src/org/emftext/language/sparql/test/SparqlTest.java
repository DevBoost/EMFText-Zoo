/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.sparql.test;

import java.io.File;

import org.emftext.language.sparql.SparqlQueries;
import org.junit.Test;
import arq.query;

public class SparqlTest extends AbstractSparqlTestCase {

	private static final String USERDIR=System.getProperty("user.dir") + File.separator;
	private static final String INPUT=USERDIR+"input" + File.separator;
	
	@Override
	public String getTestInputFolder() {
		return INPUT;
	}
	
	@Test
	public void testAllInputCSFiles(){
		String file = INPUT + "helloworld.sparql";
		System.out.println(file);
		String[] input = {"--file="+file,} ;  //"--query=input/helloworld.sparql"
		arq.qparse.main(input);
		
		
	}
	
	@Test
	public void testHelloworld() throws Exception {
		String typename = "helloworld";
		String filename = typename + getFileExtension();
		SparqlQueries sQuer = assertParsesToSparqlQueries(typename);
	
	}
	
	@Test
	public void testTest() throws Exception {
		String typename = "test";
		String filename = typename + getFileExtension();
		SparqlQueries sQuer = assertParsesToSparqlQueries(typename);
	
	}
	
	/*
	@Test
	public void testArrays() throws Exception {
		String typename = "Arrays";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 7);
		
		// check that there are 6 field declarations
		Collection<Object> fieldDeclarations = CsharpEObjectUtil.getObjectsByType(clazz.eAllContents(), ClassesPackage.eINSTANCE.getFieldDeclaration());
		assertEquals(6, fieldDeclarations.size());
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		
		for(int i = 0; i<6; i++){
			assertType(cmd.get(i), FieldDeclaration.class);
			FieldDeclaration fd = (FieldDeclaration)cmd.get(i);
			EObject eObj = fd.getVariableDeclarator().get(0).getVariableInitializer();
			switch(i){
			case 0:
				eObj = isSpecialTypeOrIterate(ArrayCreationExpression.class, eObj);
				assertType(fd.getType(), ArrayType.class);				
				assertType(eObj, ArrayCreationExpression.class);
				break;
			case 1:
				eObj = isSpecialTypeOrIterate(ArrayCreationExpression.class, eObj);
				assertType(fd.getType(), ArrayType.class);				
				assertType(eObj, ArrayCreationExpression.class);
				assertEquals( 5,((ArrayCreationExpression)eObj).getArrayInitializer().getVariableInitializer().size());
				break;
			case 2:
				eObj = isSpecialTypeOrIterate(ArrayInitializer.class, eObj);
				assertType(fd.getType(), ArrayType.class);				
				assertType(eObj, ArrayInitializer.class);
				assertEquals( 6,((ArrayInitializer)eObj).getVariableInitializer().size());
				break;
			case 3:
				eObj = isSpecialTypeOrIterate(ArrayCreationExpression.class, eObj);
				assertType(fd.getType(), ArrayType.class);				
				assertType(eObj, ArrayCreationExpression.class);
				break;
			case 4:
				eObj = isSpecialTypeOrIterate(ArrayInitializer.class, eObj);
				assertType(fd.getType(), ArrayType.class);				
				assertType(eObj, ArrayInitializer.class);
				assertEquals( 2,((ArrayInitializer)eObj).getVariableInitializer().size());
				assertType(((ArrayInitializer)eObj).getVariableInitializer().get(1), ArrayInitializer.class);
				break;
			case 5:
				eObj = isSpecialTypeOrIterate(ArrayCreationExpression.class, eObj);
				assertType(fd.getType(), ArrayType.class);				
				assertType(eObj, ArrayCreationExpression.class);
				break;	
				
			default : System.out.println("Iterationsfehler");	
			}	
		}
		assertType(cmd.get(6), Method.class);
		EObject eObj = isSpecialTypeOrIterate(ArrayInitializer.class, cmd.get(6));
		assertType(eObj, ArrayInitializer.class);
		assertEquals( 4,((ArrayInitializer)eObj).getVariableInitializer().size());
		assertType(((ArrayInitializer)eObj).getVariableInitializer().get(3), Expression.class);
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testClass() throws Exception {
		String typename = "Class";
		String filename = typename + getFileExtension();
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		assertMemberCount(cUnit, 2);
		
		List<NamespaceMemberDeclaration> nmd = cUnit.getNamespaceMemberDeclaration();
		assertMemberCount(nmd.get(1), 5);
		
		Class clazz = (Class)((Namespace)nmd.get(1)).getNamespaceBody().getNamespaceMemberDeclaration().get(2);
		assertEquals(clazz.getName(), "Class3");
		assertEquals(namespaceOrTypeNameToString(clazz.getClassBase().getTypes().get(0).getNamespaceOrTypeName()), "Class2");
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testExpressions() throws Exception{
		String typename = "Expressions";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 2);
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		
	}
	
	@Test
	public void testLiteralsAndSimpleTypes() throws Exception {
		String typename = "LiteralsAndSimpleTypes";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 40);
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		
		for(int i = 0; i<39; i++){
			assertType(cmd.get(i), FieldDeclaration.class);
			FieldDeclaration fd = (FieldDeclaration)cmd.get(i);
			assertType(fd.getVariableDeclarator().get(0).getVariableInitializer(), ConditionalExpression.class);
			EObject treeEObj = (ConditionalExpression)fd.getVariableDeclarator().get(0).getVariableInitializer();
			
			EObject eObj = isSpecialTypeOrIterate(Literal.class, treeEObj);
			if(eObj instanceof Literal){
				switch(i){
					case 0:
						assertType(fd.getType(), Decimal.class);
						assertType(eObj, RealLiteral.class);
						assertEquals("300.5m",((RealLiteral)eObj).getValue());
						break;
					case 1:
						assertType(fd.getType(), Decimal.class);
						assertType(eObj, RealLiteral.class);
						assertEquals("123.4M",((RealLiteral)eObj).getValue());
						break;
					case 2:
						assertType(fd.getType(), Bool.class);
						assertType(eObj, BooleanLiteral.class);
						assertEquals(true,((BooleanLiteral)eObj).isValue());
						break;
					case 3:
						assertType(fd.getType(), Bool.class);
						assertType(eObj, BooleanLiteral.class);
						assertEquals(false,((BooleanLiteral)eObj).isValue());
						break;
					case 4:
						assertType(fd.getType(), SByte.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("128",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 5:
						assertType(fd.getType(), SByte.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("127",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 6:
						assertType(fd.getType(), Byte.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("0",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 7:
						assertType(fd.getType(), Byte.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("255",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 8:
						assertType(fd.getType(), Short.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("32767",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 9:
						assertType(fd.getType(), Short.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("32768",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 10:
						assertType(fd.getType(), UShort.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("0",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 11:
						assertType(fd.getType(), UShort.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("65535",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 12:
						assertType(fd.getType(), Int.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("2147483648",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 13:
						assertType(fd.getType(), Int.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("2147483647",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 14:
						assertType(fd.getType(), UInt.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("0u",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 15:
						assertType(fd.getType(), UInt.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("4294967295U",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 16:
						assertType(fd.getType(), Long.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("9223372036854775808l",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 17:
						assertType(fd.getType(), Long.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("9223372036854775807L",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 18:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("0ul",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 19:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("1Ul",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 20:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("2uL",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 21:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("3UL",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 22:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("4lu",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 23:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("5Lu",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 24:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("6lU",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 25:
						assertType(fd.getType(), ULong.class);
						assertType(eObj, DecimalIntegerLiteral.class);
						assertEquals("18446744073709551615LU",((DecimalIntegerLiteral)eObj).getValue());
						break;
					case 26:
						assertType(fd.getType(), Float.class);
						assertType(eObj, RealLiteral.class);
						assertEquals("3.5E12f",((RealLiteral)eObj).getValue());
						break;
					case 27:
						assertType(fd.getType(), Float.class);
						assertType(eObj, RealLiteral.class);
						assertEquals("3.5E-12F",((RealLiteral)eObj).getValue());
						break;
					case 28:
						assertType(fd.getType(), Double.class);
						assertType(eObj, RealLiteral.class);
						assertEquals("1.7456E+3d",((RealLiteral)eObj).getValue());
						break;
					case 29:
						assertType(fd.getType(), Double.class);
						assertType(eObj, RealLiteral.class);
						assertEquals("1.7123E-3D",((RealLiteral)eObj).getValue());
						break;
					case 30:
						assertType(fd.getType(), Char.class);
						assertType(eObj, CharacterLiteral.class);
						assertEquals("'z'",((CharacterLiteral)eObj).getValue());
						break;
					case 31:
						assertType(fd.getType(), Char.class);
						assertType(eObj, CharacterLiteral.class);
						assertEquals("'Z'",((CharacterLiteral)eObj).getValue());
						break;
					case 32:
						assertType(fd.getType(), Char.class);
						assertType(eObj, CharacterLiteral.class);
						assertEquals("'\\x0058'",((CharacterLiteral)eObj).getValue());
						break;
					case 33:
						assertType(fd.getType(), Char.class);
						assertType(eObj, CharacterLiteral.class);
						assertEquals("'\\u0058'",((CharacterLiteral)eObj).getValue());
						break;
					case 34:
						assertType(fd.getType(), org.emftext.language.c_sharp.types.String.class);
						assertType(eObj, StringLiteral.class);
						assertEquals("\"test\"",((StringLiteral)eObj).getValue());
						break;
					case 35:
						assertType(fd.getType(), org.emftext.language.c_sharp.types.String.class);
						assertType(eObj, StringLiteral.class);
						assertEquals("\"Test123\"",((StringLiteral)eObj).getValue());
						break;
					case 36:
						assertType(fd.getType(), org.emftext.language.c_sharp.types.String.class);
						assertType(eObj, StringLiteral.class);
						assertEquals("\"\\\\\\u0066\\n\"",((StringLiteral)eObj).getValue());
						break;
					case 37:
						assertType(fd.getType(), org.emftext.language.c_sharp.types.String.class);
						assertType(eObj, StringLiteral.class);
						assertEquals("@\"c:\\Docs\\Source\\a.txt\"",((StringLiteral)eObj).getValue());
						break;
					case 38:
						assertType(fd.getType(), org.emftext.language.c_sharp.types.String.class);
						assertType(eObj, StringLiteral.class);
						assertEquals("@\"\"\"Ahoy!\"\"\"",((StringLiteral)eObj).getValue());
						break;
					default : System.out.println("Iterationsfehler");
				}
			}
			
			assertTrue("Field #" + i + " should have a literal", eObj instanceof Literal);					
		}	
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testMethods() throws Exception {
		String typename = "Methods";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 3);
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		assertType(cmd.get(1), Method.class);
		Method meth = (Method)cmd.get(1);
		assertEquals("method2", meth.getName());
		assertType(meth.getModifiers().get(0),Public.class);
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testModifiers() throws Exception {
		String typename = "Modifiers";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");		
		assertMemberCount(clazz, 9);
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		for(ClassMemberDeclaration single: cmd){
			assertType(single, Method.class);
		}
		assertType(((Method)cmd.get(0)).getModifiers().get(0),New.class);
		assertType(((Method)cmd.get(1)).getModifiers().get(0),Public.class);
		assertType(((Method)cmd.get(2)).getModifiers().get(0),Protected.class);
		assertType(((Method)cmd.get(3)).getModifiers().get(0),Internal.class);
		assertType(((Method)cmd.get(4)).getModifiers().get(0),Private.class);
		assertType(((Method)cmd.get(5)).getModifiers().get(0),Static.class);
		assertType(((Method)cmd.get(6)).getModifiers().get(1),Virtual.class);
		assertType(((Method)cmd.get(7)).getModifiers().get(1),Abstract.class);
		assertType(((Method)cmd.get(8)).getModifiers().get(0),Extern.class);
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testNamespace() throws Exception {
		String typename = "Namespace";
		String filename = typename + getFileExtension();
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		assertMemberCount(cUnit, 2);
		
		List<NamespaceMemberDeclaration> nmd1 = cUnit.getNamespaceMemberDeclaration();
		assertType(nmd1.get(1), Namespace.class);
		assertMemberCount(nmd1.get(1), 2);
		
		List<NamespaceMemberDeclaration> nmd2 = ((Namespace)nmd1.get(1)).getNamespaceBody().getNamespaceMemberDeclaration();
		assertType(nmd2.get(1), Namespace.class);
		assertMemberCount(nmd2.get(1), 1);
		assertIdentifierName(((Namespace)nmd2.get(1)).getNamespaceName(), "Name4.Lol.Pol");
	
		//parseAndReprint(filename);		
	}
	/**@Test
	public void testOperators() throws Exception{
		String typename = "Operators";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 17);

	}
	

	@Test
	public void testStackalloc() throws Exception {
		String typename = "Stackalloc";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 1);
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		assertType(cmd.get(0), Method.class);
		Method meth = (Method)cmd.get(0);
		assertEquals("method", meth.getName());
		assertType(meth.getBlock().getStatement().get(0), DeclarationStatement.class);
		DeclarationStatement ds = (DeclarationStatement) meth.getBlock().getStatement().get(0);
		assertType(ds.getVariableDeclaration().getType(), PointerType.class);
		assertType(ds.getVariableDeclaration().getVariableDeclarator().getVariableInitializer(), StackallocInitializer.class);
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testUsingDirective() throws Exception {
		String typename = "UsingDirective";
		String filename = typename + getFileExtension();
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		assertMemberCount(cUnit, 6);
		
		List<UsingDirective> uds = cUnit.getUsingDirectives();
		assertEquals("Generic", uds.get(4).getNamespaceOrTypeName().getParts().get(2).getName());
		
		//parseAndReprint(filename);		
	}
	*/
}