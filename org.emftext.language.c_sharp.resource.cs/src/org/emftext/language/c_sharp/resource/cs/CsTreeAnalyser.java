package org.emftext.language.c_sharp.resource.cs; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class CsTreeAnalyser implements org.emftext.runtime.resource.IReferenceResolver {

	public void resolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(String identifier, EObject container, EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
	}

	public String deResolve(EObject refObject, EObject container, EReference reference) {
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
	}

	public void resolveFuzzy(java.lang.String identifier, EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {

	}

	protected void resolveFuzzy(Class<?> clazz, String identifier, EObject container, int position, 
			int featureID, 
			org.emftext.runtime.resource.IReferenceResolver resolver, org.emftext.runtime.resource.IResolveResult result
			) {

		//if (clazz.isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
			if (!(feature instanceof EReference)) {
				return;
			}
			resolver.resolve(identifier, container, (EReference) feature, position, true, result);
	}

}
