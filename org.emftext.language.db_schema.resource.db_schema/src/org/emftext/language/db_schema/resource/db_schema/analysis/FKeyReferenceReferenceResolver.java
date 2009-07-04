package org.emftext.language.db_schema.resource.db_schema.analysis;

public class FKeyReferenceReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.db_schema.FKey, org.emftext.language.db_schema.Table> {
	
	private org.emftext.language.db_schema.resource.db_schema.analysis.Db_schemaDefaultResolverDelegate<org.emftext.language.db_schema.FKey, org.emftext.language.db_schema.Table> delegate = new org.emftext.language.db_schema.resource.db_schema.analysis.Db_schemaDefaultResolverDelegate<org.emftext.language.db_schema.FKey, org.emftext.language.db_schema.Table>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.db_schema.FKey container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.db_schema.Table> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.db_schema.Table element, org.emftext.language.db_schema.FKey container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
