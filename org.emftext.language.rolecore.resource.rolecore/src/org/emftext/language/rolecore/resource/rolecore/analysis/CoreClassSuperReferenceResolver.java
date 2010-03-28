/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.resource.rolecore.analysis;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.rolecore.CoreClass;

public class CoreClassSuperReferenceResolver
		implements
		org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.emftext.language.rolecore.CoreClass, org.emftext.language.rolecore.CoreClass> {

	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.CoreClass, org.emftext.language.rolecore.CoreClass> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.CoreClass, org.emftext.language.rolecore.CoreClass>();

	public void resolve(
			java.lang.String identifier,
			org.emftext.language.rolecore.CoreClass container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.emftext.language.rolecore.CoreClass> result) {
		if (container.getRcPackage() != null) {
			EList<CoreClass> coreClasses = container.getRcPackage().getCoreClasses();
			for (CoreClass coreClass : coreClasses) {
				if (coreClass.getName().equals(identifier) || resolveFuzzy
						&& coreClass.getName().startsWith(identifier)) {
					result.addMapping(coreClass.getName(), (CoreClass) coreClass);
					if (!resolveFuzzy) {
						return;
					}
				}
			}
		} else {
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		}
	}

	public java.lang.String deResolve(org.emftext.language.rolecore.CoreClass element,
			org.emftext.language.rolecore.CoreClass container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend on any option
	}

}
