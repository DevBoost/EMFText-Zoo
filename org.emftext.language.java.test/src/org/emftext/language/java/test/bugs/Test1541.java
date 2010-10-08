package org.emftext.language.java.test.bugs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.classifiers.Class;
import org.emftext.language.java.classifiers.ClassifiersFactory;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.MembersFactory;
import org.junit.Test;

public class Test1541 extends AbstractTest {

	private static final String LB = System.getProperty("line.separator");

	@Test
	public void testPrinting() throws IOException {
		CompilationUnit cu = ContainersFactory.eINSTANCE.createCompilationUnit();
		Class classA = ClassifiersFactory.eINSTANCE.createClass();
		cu.getClassifiers().add(classA);
		
		cu.getNamespaces().add("org");
		cu.getNamespaces().add("my");
		cu.getNamespaces().add("namespace1");
		classA.setName("ClassA");
		
		ClassMethod m1 = MembersFactory.eINSTANCE.createClassMethod();
		m1.setName("m1");
		classA.getMembers().add(m1);
		
		Resource r = getResourceSet().createResource(URI.createURI("ClassA.java"));
		
		r.getContents().add(cu);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		r.save(out, null);
		System.out.println("Test1541.testPrinting() " + out.toString());
		assertEquals(
			"package org.my.namespace1;" + LB +
			LB +
			LB +
			"class ClassA {" + LB +
			"\t" + "m1 () {" + LB +
			"\t" + "}" + LB + // the tab at the beginning of this line was missing
			"}", 
			out.toString());
	}
}
