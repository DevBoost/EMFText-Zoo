package org.emftext.language.db_schema.resource.db_schema.analysis;

public class PKeyColumnReferenceResolver implements org.emftext.language.db_schema.resource.db_schema.IDb_schemaReferenceResolver<org.emftext.language.db_schema.PKey, org.emftext.language.db_schema.Column> {
	
	private org.emftext.language.db_schema.resource.db_schema.analysis.Db_schemaDefaultResolverDelegate<org.emftext.language.db_schema.PKey, org.emftext.language.db_schema.Column> delegate = new org.emftext.language.db_schema.resource.db_schema.analysis.Db_schemaDefaultResolverDelegate<org.emftext.language.db_schema.PKey, org.emftext.language.db_schema.Column>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.db_schema.PKey container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.db_schema.resource.db_schema.IDb_schemaReferenceResolveResult<org.emftext.language.db_schema.Column> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.db_schema.Column element, org.emftext.language.db_schema.PKey container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
