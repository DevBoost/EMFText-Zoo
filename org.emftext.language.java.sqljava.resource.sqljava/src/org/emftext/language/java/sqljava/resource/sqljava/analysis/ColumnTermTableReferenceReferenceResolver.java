/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.sqljava.resource.sqljava.analysis;

import org.emftext.language.sql.resource.sql.ISqlReferenceMapping;
import org.emftext.language.sql.resource.sql.ISqlReferenceResolveResult;

public class ColumnTermTableReferenceReferenceResolver implements org.emftext.language.java.sqljava.resource.sqljava.ISqljavaReferenceResolver<org.emftext.language.sql.select.term.ColumnTerm, org.emftext.language.sql.select.from.Table> {
	
	private org.emftext.language.sql.resource.sql.analysis.ColumnTermTableReferenceReferenceResolver delegate = new org.emftext.language.sql.resource.sql.analysis.ColumnTermTableReferenceReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.sql.select.term.ColumnTerm container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.java.sqljava.resource.sqljava.ISqljavaReferenceResolveResult<org.emftext.language.sql.select.from.Table> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new ISqlReferenceResolveResult<org.emftext.language.sql.select.from.Table>() {
			
			public boolean wasResolvedUniquely() {
				return result.wasResolvedUniquely();
			}
			
			public boolean wasResolvedMultiple() {
				return result.wasResolvedMultiple();
			}
			
			public boolean wasResolved() {
				return result.wasResolved();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public java.util.Collection<ISqlReferenceMapping<org.emftext.language.sql.select.from.Table>> getMappings() {
				throw new UnsupportedOperationException();
			}
			
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier) {
				result.addMapping(identifier, newIdentifier);
			}
			
			public void addMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
				result.addMapping(identifier, newIdentifier, warning);
			}
			
			public void addMapping(String identifier, org.emftext.language.sql.select.from.Table target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.sql.select.from.Table target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.sql.select.from.Table element, org.emftext.language.sql.select.term.ColumnTerm container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
