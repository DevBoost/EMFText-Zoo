package org.emftext.language.java.test.bugs;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.java.resource.JavaSourceOrClassFileResourceFactoryImpl;
import org.emftext.language.java.resource.java.IJavaOptions;
import org.emftext.language.java.resource.util.JavaPostProcessor;
import org.emftext.language.java.resource.util.UnicodeConverterProvider;

import junit.framework.TestCase;

public abstract class AbstractTest extends TestCase {

	public AbstractTest() {
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
}
