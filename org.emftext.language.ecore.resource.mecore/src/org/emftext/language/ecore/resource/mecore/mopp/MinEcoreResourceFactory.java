/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.ecore.resource.mecore.mopp;

public class MinEcoreResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public MinEcoreResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new CustomMinEcoreResource(uri);
	}
}
