package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public class VariableReferenceVariableProxyResolver extends ProxyResolverImpl {

	// TODO all this code must probably go into class PackageOrClassifierOrMethodOrVariableReferenceTargetProxyResolver
	/*
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		VariableReference ref = (VariableReference) container;
		TypeReference type = null;
		
		//if (reference.equals(JavaPackage.Literals.REFERENCE__NEXT)) {
		if (ref.eContainer() instanceof VariableReference) {
			VariableReference parent = (VariableReference) ref.eContainer();
			type = parent.getVariable().getType();
		} else if (ref.eContainer() instanceof MethodCall) {
			MethodCall parent = (MethodCall) ref.eContainer();
			type = parent.getMethod().getType();
		}
		
		//}
		//else {
			//EObject result = super.doResolve(proxy, container, reference, resource);
//			return result;
		//}
		
		if (type instanceof org.reuseware.emftextedit.language.java.Class) {
			String varName = proxy.eProxyURI().fragment();
			for(org.reuseware.emftextedit.language.java.Member member : ((org.reuseware.emftextedit.language.java.Class) type).getMembers()) {
				if (member instanceof Variable) {
					if (varName.equals(((Variable) member).getName())) {
						return member;
					}
				}
			}
		}
		
		return super.doResolve(proxy, container, reference, resource);
	}
	*/
}
