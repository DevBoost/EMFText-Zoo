package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.reuseware.emftextedit.resource.impl.ProxyResolverImpl;

public class MethodCallMethodProxyResolver extends ProxyResolverImpl {
	// TODO all this code must probably go into class PackageOrClassifierOrMethodOrVariableReferenceTargetProxyResolver
	/*
	@Override
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		MethodCall call = (MethodCall) container;
		TypeReference callTarget = null;
		
		 
		EObject callContainer = call.eContainer();
		if (callContainer instanceof VariableReference) {
			VariableReference parent = (VariableReference) callContainer;
			callTarget = parent.getVariable().getType();
		}
		else if (callContainer instanceof MethodCall) { //??
			MethodCall parent = (MethodCall) callContainer;
			callTarget = parent.getMethod().getType();
		}
		else if (callContainer instanceof SingleExpression){
			EObject declaringClass = callContainer;
			while (!(declaringClass instanceof org.reuseware.emftextedit.language.java.Class)) {
				declaringClass = declaringClass.eContainer();
			}
			//callTarget = (org.reuseware.emftextedit.language.java.Class) declaringClass;
		}
		
		if (callTarget instanceof org.reuseware.emftextedit.language.java.Class) {
			String methodName = proxy.eProxyURI().fragment();
			for (Member member : ((org.reuseware.emftextedit.language.java.Class) callTarget).getMembers()) {
				if (isCallTarget(member, methodName)) {
					return member;
				}
			}
		}
		return null;
	}

	private boolean isCallTarget(Member candidate, String methodName) {
		//is it a Method?
		if (!(candidate instanceof Method)) {
			return false;
		}
		//check name
		if (!methodName.equals(((Method) candidate).getName())) {
			return false;
		}
		//check signature

		
		return true;
	}
	*/
}
