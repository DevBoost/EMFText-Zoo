package org.emftext.language.java.resource;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.JavaPackage;

public class JaMoPPUtil {

	public static void initialize() {
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, JavaPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionToFactoryMap.put("java", new JavaSourceOrClassFileResourceFactoryImpl());
		extensionToFactoryMap.put("class", new JavaSourceOrClassFileResourceFactoryImpl()); 
	}
}
