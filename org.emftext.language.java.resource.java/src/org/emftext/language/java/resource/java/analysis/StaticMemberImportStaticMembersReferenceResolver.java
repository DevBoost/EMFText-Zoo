package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.imports.StaticMemberImport;
import org.emftext.language.java.members.Member;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class StaticMemberImportStaticMembersReferenceResolver extends 
	AbstractReferenceResolver<StaticMemberImport, Member> {
	
	@Override	
	protected java.lang.String doDeResolve(Member element, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, StaticMemberImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<Member> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
