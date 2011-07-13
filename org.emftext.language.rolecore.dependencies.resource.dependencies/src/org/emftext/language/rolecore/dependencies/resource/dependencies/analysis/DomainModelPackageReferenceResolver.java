
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

import org.eclipse.emf.ecore.EPackage;

public class DomainModelPackageReferenceResolver
		implements
		org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.Domain, org.eclipse.emf.ecore.EPackage> {

	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.Domain, org.eclipse.emf.ecore.EPackage> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.Domain, org.eclipse.emf.ecore.EPackage>();

	public void resolve(
			java.lang.String identifier,
			org.emftext.language.rolecore.dependencies.Domain container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		if (resolveFuzzy) {
			String[] keySet = EPackage.Registry.INSTANCE.keySet().toArray(new String[] {});
			for (String namespaceURI : keySet) {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(namespaceURI);
				if (ePackage != null) {
					result.addMapping(namespaceURI, ePackage);
				}
			}
		} else {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(identifier);
			if (ePackage != null)
				result.addMapping(identifier, ePackage);
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EPackage element,
			org.emftext.language.rolecore.dependencies.Domain container, org.eclipse.emf.ecore.EReference reference) {
		if (element == null)
			return null;
		return element.getNsURI();
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend on any option
	}

}
