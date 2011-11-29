/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.notes.resource.notes.mopp;

public class NotesResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public NotesResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.notes.resource.notes.mopp.NotesResource(uri);
	}
	
}
