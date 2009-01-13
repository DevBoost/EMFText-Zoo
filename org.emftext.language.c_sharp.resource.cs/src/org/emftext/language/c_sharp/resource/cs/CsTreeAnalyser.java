package org.emftext.language.c_sharp.resource.cs; 

public class CsTreeAnalyser implements org.emftext.runtime.resource.IReferenceResolver {

	public void resolve(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		if (resolveFuzzy) {
			resolveFuzzy(identifier, container, position, result);
		} else {
			resolveStrict(identifier, container, reference, position, result);
		}
	}

	public void resolveStrict(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.runtime.resource.IResolveResult result) {
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		return null;
	}

	public void setOptions(java.util.Map<?, ?> options) {
	}

	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IResolveResult result) {

	}

	protected void resolveFuzzy(java.lang.Class<?> clazz, java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, 
			int featureID, 
			org.emftext.runtime.resource.IReferenceResolver resolver, org.emftext.runtime.resource.IResolveResult result
			) {

		//if (clazz.isInstance(container)) {
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(featureID);
			if (!(feature instanceof org.eclipse.emf.ecore.EReference)) {
				return;
			}
			resolver.resolve(identifier, container, (org.eclipse.emf.ecore.EReference) feature, position, true, result);
	}

}
