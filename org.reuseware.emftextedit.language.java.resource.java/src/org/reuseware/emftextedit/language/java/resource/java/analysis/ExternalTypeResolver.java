package org.reuseware.emftextedit.language.java.resource.java.analysis;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.language.java.JavaFactory;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public abstract class ExternalTypeResolver extends ProxyResolverImpl {

	private final static JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.reuseware.org/java"); 
	
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		String className = proxy.eProxyURI().fragment();
		String qualifiedName = getQualifiedClassName(container, proxy);
		EObject classFromClassPath = doResolveFromClasspathUsingReflection(qualifiedName, className);
		if (classFromClassPath != null) {
			return classFromClassPath;
		}
		// TODO resolve whether a package or a classifier is referenced and create the
		// appropriate element here
		org.reuseware.emftextedit.language.java.Class externalClassOrPackage = theJavaFactory.createClass();
		externalClassOrPackage.setName(className);
		return externalClassOrPackage;
	}
	
	protected abstract String getQualifiedClassName(EObject container, InternalEObject proxy);

	protected EObject doResolveFromClasspathUsingReflection(String qualifiedName, String name) {
		
		Class<?> theCLass;
		try {
			theCLass = Class.forName(qualifiedName);
			
			org.reuseware.emftextedit.language.java.Class importedClass = theJavaFactory.createClass();
			importedClass.setName(name);
			
			for(Method aMethod : theCLass.getMethods()) {
				org.reuseware.emftextedit.language.java.Method member = theJavaFactory.createMethod();
				member.setName(aMethod.getName());
				importedClass.getMembers().add(member);
			}
			
			// TODO look up remaining elements of the class
			return importedClass;
		} catch (ClassNotFoundException e) {
			// ignore exception
		}
		
		return null;
	}
}
