package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.imports.StaticClassifierImport;
import org.emftext.language.java.members.Member;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class StaticClassifierImportStaticMembersReferenceResolver extends 
	AbstractReferenceResolver<StaticClassifierImport, Member> {
	
	@Override	
	protected java.lang.String doDeResolve(Member element, StaticClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, StaticClassifierImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<Member> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
