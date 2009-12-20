/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.efactory.resource.efactory.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

public class NewObjectEClassReferenceResolver implements org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolver<org.emftext.language.efactory.NewObject, org.eclipse.emf.ecore.EClass> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.efactory.NewObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.efactory.resource.efactory.IEfactoryReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EFactory factory = findFactory(container);
		if (factory == null) {
			return;
		}
		EClassifier classifier = factory.getEPackage().getEClassifier(identifier);
		if (classifier != null && classifier instanceof EClass) {
			result.addMapping(identifier, (EClass) classifier);
		}
	}
	
	private EFactory findFactory(EObject object) {
		if (object instanceof EFactory) {
			return (EFactory) object;
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
