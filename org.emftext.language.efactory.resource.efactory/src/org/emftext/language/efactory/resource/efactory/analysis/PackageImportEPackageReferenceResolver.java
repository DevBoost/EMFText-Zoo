/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.efactory.PackageImport;

public class PackageImportEPackageReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.PackageImport, org.eclipse.emf.ecore.EPackage> {
	
	private EfactoryDefaultResolverDelegate<PackageImport, EPackage> delegate = 
		new EfactoryDefaultResolverDelegate<PackageImport, EPackage>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.PackageImport container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		String[] keySet = EPackage.Registry.INSTANCE.keySet().toArray(new String[] {});
		for (String namespaceURI : keySet) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(namespaceURI);
				if (ePackage != null) {
					if (resolveFuzzy) {
						result.addMapping(namespaceURI, ePackage);
					} else {
						if (identifier.equals(namespaceURI)) {
							result.addMapping(identifier, ePackage);
							return;
						}
					}
				}
			} catch (Exception e) {
				// ignore packages that cannot be loaded
			}
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EPackage element, org.emftext.language.efactory.PackageImport container, org.eclipse.emf.ecore.EReference reference) {
		return element.getNsURI();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
