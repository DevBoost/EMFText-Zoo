package org.emftext.language.c_sharp.test;

import java.util.List;

import org.emftext.language.c_sharp.classes.Class;
import org.emftext.language.c_sharp.namespaces.CompilationUnit;
import org.emftext.language.c_sharp.namespaces.Namespace;
import org.emftext.language.c_sharp.namespaces.NamespaceMemberDeclaration;
import org.emftext.language.c_sharp.namespaces.UsingDirective;
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
	public void testMethods() throws Exception {
		String typename = "Methods";
		String filename = typename + getFileExtension();
		Class clazz = assertParseToClass(typename, "Class1");
		
		assertMemberCount(clazz, 3);
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
