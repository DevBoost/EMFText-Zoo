package org.emftext.language.java.resource.java.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.imports.rtypes.ClassifierImportClassifier;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;

public class ClassifierImportClassifierValueReferenceResolver implements org.emftext.language.java.resource.java.IJavaReferenceResolver<org.emftext.language.java.imports.rtypes.ClassifierImportClassifier, org.emftext.language.java.classifiers.ConcreteClassifier> {
	
	public java.lang.String deResolve(ConcreteClassifier element, ClassifierImportClassifier container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, ClassifierImportClassifier container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<ConcreteClassifier> result) {
		if (!(container.eContainer() instanceof ClassifierImport)) {
			return;
		}
		ClassifierImport theImport = (ClassifierImport) container.eContainer();
		
		
		ConcreteClassifier importedClassifier = theImport.getImportedClassifier(identifier);
		if (importedClassifier != null) {
			importedClassifier = (ConcreteClassifier) EcoreUtil.resolve(importedClassifier, theImport.eResource());
			if (!importedClassifier.eIsProxy()) {
				result.addMapping(identifier, importedClassifier);
			}
		}	
	}

	public void setOptions(Map<?, ?> options) {
	}
}

