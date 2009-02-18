package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.references.MethodCall;
import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;

public class MethodCallTargetReferenceResolver extends JavaReferenceResolver<MethodCall> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.java.references.MethodCall container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.references.MethodCall container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
