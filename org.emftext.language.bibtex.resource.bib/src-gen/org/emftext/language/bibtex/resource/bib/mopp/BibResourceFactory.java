/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib.mopp;

public class BibResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public BibResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.bibtex.resource.bib.mopp.BibResource(uri);
	}
	
}
