/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.prolog.resource.pl.mopp;

public class PlResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public PlResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.prolog.resource.pl.mopp.PlResource(uri);
	}
	
}
