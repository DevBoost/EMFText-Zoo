/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.resource.rolecore.analysis;

import org.emftext.language.rolecore.RCPackage;
import org.emftext.language.rolecore.Import;

public class CoreClassRcPackageReferenceResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.emftext.language.rolecore.CoreClass, org.emftext.language.rolecore.RCPackage> {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.CoreClass, org.emftext.language.rolecore.RCPackage> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.CoreClass, org.emftext.language.rolecore.RCPackage>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.CoreClass container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.emftext.language.rolecore.RCPackage> result) {
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		RCPackage rcPackage = (RCPackage) container.eContainer();
		if (rcPackage.getImports()!=null)
			for (Import packageImport : rcPackage.getImports()){
				if (packageImport.getPrefix().equals(identifier)){
					result.addMapping(identifier, packageImport.getRcPackage());
				}
			}
	}
	
	public java.lang.String deResolve(org.emftext.language.rolecore.RCPackage element, org.emftext.language.rolecore.CoreClass container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
