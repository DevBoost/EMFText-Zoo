/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.PackageImport;

public class NewObjectEClassReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.NewObject, org.eclipse.emf.ecore.EClass> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.NewObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		Factory factory = findFactory(container);
		if (factory == null) {
			return;
		}
		EList<PackageImport> ePackages = factory.getEpackages();
		for (PackageImport packageImport : ePackages) {
			EList<EClassifier> eClassifiers = packageImport.getEPackage().getEClassifiers();
			for (EClassifier classifier : eClassifiers) {
				if (classifier != null && classifier instanceof EClass) {
					if (resolveFuzzy) {
						result.addMapping(classifier.getName(), (EClass) classifier);
					} else {
						if (identifier.equals(classifier.getName())) {
							result.addMapping(classifier.getName(), (EClass) classifier);
						}
					}
				}
			}
		}
	}
	
	private Factory findFactory(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Factory) {
			return (Factory) object;
		}
		return findFactory(object.eContainer());
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.efactory.NewObject container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
}
