/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.sqljava.resource.sqljava.analysis;

import org.emftext.language.sql.resource.sql.ISqlReferenceMapping;
import org.emftext.language.sql.resource.sql.ISqlReferenceResolveResult;

public class OrderByColumnExpressionColumnReferenceReferenceResolver implements org.emftext.language.java.sqljava.resource.sqljava.ISqljavaReferenceResolver<org.emftext.language.sql.select.orderBy.OrderByColumnExpression, org.emftext.language.sql.select.column.Column> {
	
	private org.emftext.language.sql.resource.sql.analysis.OrderByColumnExpressionColumnReferenceReferenceResolver delegate = new org.emftext.language.sql.resource.sql.analysis.OrderByColumnExpressionColumnReferenceReferenceResolver();
	
	public void resolve(java.lang.String identifier, org.emftext.language.sql.select.orderBy.OrderByColumnExpression container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.java.sqljava.resource.sqljava.ISqljavaReferenceResolveResult<org.emftext.language.sql.select.column.Column> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, new ISqlReferenceResolveResult<org.emftext.language.sql.select.column.Column>() {
			
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
			
			public java.util.Collection<ISqlReferenceMapping<org.emftext.language.sql.select.column.Column>> getMappings() {
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
			
			public void addMapping(String identifier, org.emftext.language.sql.select.column.Column target) {
				result.addMapping(identifier, target);
			}
			
			public void addMapping(String identifier, org.emftext.language.sql.select.column.Column target, String warning) {
				result.addMapping(identifier, target, warning);
			}
		});
		
	}
	
	public java.lang.String deResolve(org.emftext.language.sql.select.column.Column element, org.emftext.language.sql.select.orderBy.OrderByColumnExpression container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
