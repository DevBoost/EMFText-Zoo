/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.pl0.resource.pl0;

public interface IPl0Builder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.pl0.resource.pl0.mopp.Pl0Resource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
