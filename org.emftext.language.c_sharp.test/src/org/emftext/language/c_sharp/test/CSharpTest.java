package org.emftext.language.c_sharp.test;

import java.util.List;

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
	public void testNamespace() throws Exception {
		String typename = "Namespace";
		String filename = typename + getFileExtension();
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		//assertMemberCount(cUnit, 2);
		
		List<NamespaceMemberDeclaration> nmd1 = cUnit.getNamespaceMemberDeclaration();
		assertType(nmd1.get(1), Namespace.class);
		List<NamespaceMemberDeclaration> nmd2 = ((Namespace)nmd1.get(1)).getNamespaceBody().getNamespaceMemberDeclaration();
		assertType(nmd2.get(1), Namespace.class);
		assertIdentifierName(((Namespace)nmd2.get(1)).getNamespaceName(), "Name4.Lol.Pol");
	
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testUsingDirective() throws Exception {
		String typename = "UsingDirective";
		String filename = typename + getFileExtension();
		CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		//assertMemberCount(cUnit, 0);
		
		List<UsingDirective> uds = cUnit.getUsingDirectives();
		assertEquals("Generic", uds.get(4).getNamespaceOrTypeName().getParts().get(2).getName());
		
		//parseAndReprint(filename);		
	}
	
	@Test
	public void testWarnings() throws Exception {
		String typename = "testwarnings";
		String filename = typename + getFileExtension();
		// TODO mrange: please fix this test as we can not do a build when this
		// test fails
		//CompilationUnit cUnit = assertParsesToCompilationUnit(typename);
		
		//org.emftext.language.java.classifiers.Class clazz = assertParsesToClass(typename);
		//assertMemberCount(clazz, 4);

		//parseAndReprint(filename);
	}
	
}
