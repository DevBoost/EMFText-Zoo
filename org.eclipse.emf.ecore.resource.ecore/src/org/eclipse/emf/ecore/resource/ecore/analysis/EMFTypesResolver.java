package org.eclipse.emf.ecore.resource.ecore.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public class EMFTypesResolver {
	
	protected void doResolve(java.lang.String identifier, 
			Resource container, 
			org.eclipse.emf.ecore.EReference reference, 
			int position, 
			boolean resolveFuzzy, 
			org.emftext.runtime.resource.IReferenceResolveResult result) {
		
		EList<EObject> pkgs = container.getContents();

		for (EObject pkgCandidate : pkgs) {
			if (pkgCandidate instanceof EPackage) {
				EList<EClassifier> allClassifiers  = ((EPackage) pkgCandidate).getEClassifiers();
				addResults(identifier, allClassifiers, resolveFuzzy, result);
			}
		}	
	}


	private void addResults(java.lang.String identifier, EList<EClassifier> allClassifiers, boolean resolveFuzzy,
			org.emftext.runtime.resource.IReferenceResolveResult result) {
		if (resolveFuzzy) {			
			for (EClassifier classifier : allClassifiers) {
				if (classifier.getName().startsWith(identifier)) {
					result.addMapping(classifier.getName(), classifier);
				}
			}
		} else {
			for (EClassifier classifier : allClassifiers) {
				if (classifier.getName().equals(identifier)) {
					result.addMapping(identifier, classifier);
				}
			}
		}
	}
}


	