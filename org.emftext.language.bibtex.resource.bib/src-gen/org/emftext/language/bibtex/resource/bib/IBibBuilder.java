/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.bibtex.resource.bib;

public interface IBibBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.bibtex.resource.bib.mopp.BibResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
