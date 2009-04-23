package org.emftext.language.c_sharp.test;

import java.util.List;

import org.emftext.language.c_sharp.classes.Class;
import org.emftext.language.c_sharp.classes.ClassMemberDeclaration;
import org.emftext.language.c_sharp.classes.FieldDeclaration;
import org.emftext.language.c_sharp.classes.Method;
import org.emftext.language.c_sharp.expressions.ConditionalExpression;
import org.emftext.language.c_sharp.expressions.Expression;
import org.emftext.language.c_sharp.modifiers.Abstract;
import org.emftext.language.c_sharp.modifiers.Extern;
import org.emftext.language.c_sharp.modifiers.Internal;
import org.emftext.language.c_sharp.modifiers.New;
import org.emftext.language.c_sharp.modifiers.Private;
import org.emftext.language.c_sharp.modifiers.Protected;
import org.emftext.language.c_sharp.modifiers.Public;
import org.emftext.language.c_sharp.modifiers.Static;
import org.emftext.language.c_sharp.modifiers.Virtual;
import org.emftext.language.c_sharp.namespaces.CompilationUnit;
import org.emftext.language.c_sharp.namespaces.Namespace;
import org.emftext.language.c_sharp.namespaces.NamespaceMemberDeclaration;
import org.emftext.language.c_sharp.namespaces.UsingDirective;
import org.emftext.language.c_sharp.test.cssyntaxcheck.CheckCSSyntaxWrapper;
import org.emftext.language.c_sharp.types.Decimal;
import org.junit.Test;


public class CSharpTest extends AbstractCSharpTestCase {

	protected static final String TEST_INPUT_FOLDER = "input";
	
	@Override
	protected String getTestInputFolder() {
		return TEST_INPUT_FOLDER;
	}
	
	@Test
	public void testAllInputCSFiles(){
		//return;
		// TODO mrange: the CheckCSSynntax runs forever!
		// please fix this and the enable this test
		
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
	public void testArrays() throws Exception {
		String typename = "Arrays";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 7);
		
		//TODO: check Arrays 
		
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
	public void testLiteralsAndSimpleTypes() throws Exception {
		String typename = "LiteralsAndSimpleTypes";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 40);
		
		List<ClassMemberDeclaration> cmd = clazz.getClassMemberDeclarations();
		
		//TODO: check SimpleTypes and literals 
		for(int i = 0; i<40; i++){
			assertType(cmd.get(i), FieldDeclaration.class);
			FieldDeclaration fd = (FieldDeclaration)cmd.get(0);
			assertType(fd.getVariableDeclarator().get(0).getVariableInitializer(), Expression.class);
			ConditionalExpression ce = (ConditionalExpression)fd.getVariableDeclarator().get(0).getVariableInitializer();
			//ce.getConditionalOrExpression().get(0).eAllContents()	
			//catch:...
			//assertEquals("300.5m", );
			//assertType(fd.getType(), Decimal.class);
			//...
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
	
	@Test
	public void testStackalloc() throws Exception {
		String typename = "Stackalloc";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		assertMemberCount(clazz, 1);
		
		//TODO: check Stackalloc 
		
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
	
}
