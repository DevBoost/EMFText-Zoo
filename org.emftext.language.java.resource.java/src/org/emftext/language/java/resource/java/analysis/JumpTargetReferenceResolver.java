package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.resource.java.analysis.helper.JavaReferenceResolver;
import org.emftext.language.java.statements.Jump;
import org.emftext.language.java.statements.JumpLabel;

public class JumpTargetReferenceResolver extends 
	JavaReferenceResolver<Jump, JumpLabel> {
	
	@Override	
	protected java.lang.String doDeResolve(JumpLabel element, Jump container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, Jump container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<JumpLabel> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
