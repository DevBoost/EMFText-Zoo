package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;


public class MethodExceptionsProxyResolver extends ExternalTypeResolver {

	@Override
	protected String getQualifiedClassName(EObject container, InternalEObject proxy) {
		String className = proxy.eProxyURI().fragment();
		return "java.lang." + className;
	}
}
