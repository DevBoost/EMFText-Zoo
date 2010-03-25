/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult;

public class SimpleTermRoleReferenceResolver implements org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.SimpleTerm, org.eclipse.emf.ecore.EClass> {
	
	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.SimpleTerm, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.SimpleTerm, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.dependencies.SimpleTerm container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		CoreClass coreClass = container.getCoreClass();
		if (coreClass != null){
			resolveRole(coreClass.getType(), identifier, result);
			return;
		}
		// 1st container is Edge, 2nd is mandatory/option, 3rd is Equivalence/CoreClass
		EObject eObject = container.eContainer().eContainer().eContainer();
		if (eObject instanceof CoreClass){
			coreClass = (CoreClass) eObject;
			resolveRole(coreClass.getType(), identifier, result);
			return;
		}
		// TODO add resolveFuzzy?
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	private void resolveRole(EClass coreClass, String identifier,
			IDependenciesReferenceResolveResult<EClass> result) {
		String interfaceName = coreClass.getName().substring(0, coreClass.getName().length()-4);
		EPackage ePackage = coreClass.getEPackage();
		EClassifier classifier = ePackage.getEClassifier(identifier);
		if (classifier instanceof EClass){
			EClass role = (EClass)classifier;
			EClass abstractRoleInterfaceFromRole = role.getESuperTypes().get(0);
			EClass abstractRoleInterface = (EClass) ePackage.getEClassifier(interfaceName+"Role");
			if (abstractRoleInterface.equals(abstractRoleInterfaceFromRole)){
				result.addMapping(identifier, role);
				return;
			}else{
				do {
					coreClass = coreClass.getESuperTypes().get(0);
					if (coreClass.equals(abstractRoleInterfaceFromRole)){
						result.addMapping(identifier, role);
						return;
					}
				}while (!coreClass.getName().equals("RCRole"));
			}
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.rolecore.dependencies.SimpleTerm container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
