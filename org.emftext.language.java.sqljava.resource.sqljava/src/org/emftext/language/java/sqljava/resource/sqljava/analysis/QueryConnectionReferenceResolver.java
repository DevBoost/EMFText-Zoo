/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.java.sqljava.resource.sqljava.analysis;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.sqljava.Connection;
import org.emftext.language.java.sqljava.SqljavaPackage;
import org.emftext.language.java.sqljava.resource.sqljava.util.SqljavaEObjectUtil;

public class QueryConnectionReferenceResolver implements org.emftext.language.java.sqljava.resource.sqljava.ISqljavaReferenceResolver<org.emftext.language.java.sqljava.Query, org.emftext.language.java.sqljava.Connection> {
	
	private org.emftext.language.java.sqljava.resource.sqljava.analysis.SqljavaDefaultResolverDelegate<org.emftext.language.java.sqljava.Query, org.emftext.language.java.sqljava.Connection> delegate = new org.emftext.language.java.sqljava.resource.sqljava.analysis.SqljavaDefaultResolverDelegate<org.emftext.language.java.sqljava.Query, org.emftext.language.java.sqljava.Connection>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.java.sqljava.Query container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.java.sqljava.resource.sqljava.ISqljavaReferenceResolveResult<org.emftext.language.java.sqljava.Connection> result) {
		
		EObject root = SqljavaEObjectUtil.findRootContainer(container);
		Collection<Connection> connections = 
			SqljavaEObjectUtil.getObjectsByType(root.eAllContents(), SqljavaPackage.eINSTANCE.getConnection());
	
		for (Connection connection : connections){
			if(connection.getName().equals(identifier))
				result.addMapping(identifier, connection);
		}
		
		if(!result.wasResolved())
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.java.sqljava.Connection element, org.emftext.language.java.sqljava.Query container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
