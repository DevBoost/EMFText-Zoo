/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.ecore.EPackage;

public class PackageImportEPackageURIReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.PackageImport, org.eclipse.emf.ecore.EPackage> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.PackageImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(identifier);
		if (ePackage != null) {
			result.addMapping(identifier, ePackage);
		}
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EPackage element, org.emftext.language.efactory.PackageImport container, org.eclipse.emf.ecore.EReference reference) {
		return element.getNsURI();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
