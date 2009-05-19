package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.language.java.util.imports.ImportUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class ClassifierImportClassifierReferenceResolver extends 
	AbstractReferenceResolver<ClassifierImport, ConcreteClassifier> {
	
	@Override	
	protected java.lang.String doDeResolve(ConcreteClassifier element, ClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		return JavaUtil.getName(element);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, ClassifierImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<ConcreteClassifier> result) {
		ConcreteClassifier importedClassifier = ImportUtil.getClassifier(theImport, identifier);
		if (importedClassifier != null) {
			importedClassifier = (ConcreteClassifier) EcoreUtil.resolve(importedClassifier, theImport.eResource());
			if (!importedClassifier.eIsProxy()) {
				result.addMapping(identifier, importedClassifier);
			}
		}	
	}
}
