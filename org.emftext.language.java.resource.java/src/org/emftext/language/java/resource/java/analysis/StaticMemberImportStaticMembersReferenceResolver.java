package org.emftext.language.java.resource.java.analysis;

public class StaticMemberImportStaticMembersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.java.imports.StaticMemberImport, org.emftext.language.java.members.Member> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.members.Member element, org.emftext.language.java.imports.StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.imports.StaticMemberImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
