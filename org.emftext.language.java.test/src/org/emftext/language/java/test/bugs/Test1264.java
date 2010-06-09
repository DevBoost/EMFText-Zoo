package org.emftext.language.java.test.bugs;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.commons.Commentable;
import org.emftext.language.java.containers.ContainersFactory;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.util.JavaPostProcessor;
import org.emftext.language.java.resource.util.UnicodeConverterProvider;
import org.junit.Test;

public class Test1264 extends TestCase {

	public Test1264() {
		super();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"java", new JavaSourceOrClassFileResourceFactoryImpl());
		
		
	}
	
	protected Map<?, ?> getLoadOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJavaOptions.INPUT_STREAM_PREPROCESSOR_PROVIDER, new UnicodeConverterProvider());
		map.put(IJavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new JavaPostProcessor());
		return map;
	}

	protected ResourceSet getResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getLoadOptions().putAll(getLoadOptions());
		return rs;
	}
	
	@Test
	public void testGetConcreteClassifierProxy() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		ConcreteClassifier result = commentable.getConcreteClassifierProxy("java.lang.Object");
		assertTrue(result.eIsProxy());
	}
	
	@Test
	public void testGetConcreteClassifierProxies() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		EList<ConcreteClassifier> result = 
			commentable.getConcreteClassifierProxies("java.lang","Object");
		assertEquals(1, result.size());
		assertTrue(result.get(0).eIsProxy());
	}
	
	@Test
	public void testGetConcreteClassifier() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		ConcreteClassifier result = commentable.getConcreteClassifier("java.lang.Object");
		assertTrue(!result.eIsProxy());
		assertEquals("Object", result.getName());
		assertEquals(14, result.getMembers().size());	
	}
	
	@Test
	public void testGetConcreteClassifiers() {
		ResourceSet rs = getResourceSet();
		Commentable commentable = ContainersFactory.eINSTANCE.createCompilationUnit();
		Resource r = rs.createResource(URI.createURI("test.java"));
		r.getContents().add(commentable);
		
		EList<ConcreteClassifier> result = 
			commentable.getConcreteClassifiers("java.lang","Object");
		assertEquals(1, result.size());
		assertTrue(!result.get(0).eIsProxy());
		assertEquals("Object", result.get(0).getName());
		assertEquals(14, result.get(0).getMembers().size());	
	}

}
