package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.runtime.resource.*;
import org.reuseware.emftextedit.runtime.resource.impl.*;

public class AnnotationElementValuePairKeyProxyResolver extends ProxyResolverImpl {

	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		//System.out.println("AnnotationElementValuePairKeyProxyResolver.doResolve("+proxy+")");
		return super.doResolve(proxy, container, reference, resource);
	}

}
