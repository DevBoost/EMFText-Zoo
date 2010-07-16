/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.modelquery.resource.modelquery.mopp;

public class CustomModelqueryResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public CustomModelqueryResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new CustomModelqueryResource(uri);
	}
	
}
