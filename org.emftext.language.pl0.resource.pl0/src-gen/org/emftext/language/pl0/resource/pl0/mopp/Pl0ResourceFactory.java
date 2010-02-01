/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0.mopp;

public class Pl0ResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public Pl0ResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource(uri);
	}
}
