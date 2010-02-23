/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.emftext.language.rolecore.dependencies.Domain;

public class CoreClassTypeReferenceResolver implements org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.CoreClass, org.eclipse.emf.ecore.EClass> {
	
	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.CoreClass, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.CoreClass, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.dependencies.CoreClass container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		Domain domain = null;
		if (container.eContainer() instanceof Domain)
			domain = (Domain)container.eContainer();
		if (domain == null)
			return;
		EList<EClassifier> classifiers = domain.getModelPackage().getEClassifiers();
		for (EClassifier classifier : classifiers){
			if (classifier.getName().equals(identifier+"Core")){
				result.addMapping(identifier, (EClass)classifier);
				return;
			}
		}
		// TODO add code for resolveFuzzy
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.rolecore.dependencies.CoreClass container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
