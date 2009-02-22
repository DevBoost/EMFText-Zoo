package org.emftext.language.java.resource.java.analysis;

public class JumpTargetReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.java.statements.Jump, org.emftext.language.java.statements.JumpLabel> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.statements.JumpLabel element, org.emftext.language.java.statements.Jump container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.statements.Jump container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
