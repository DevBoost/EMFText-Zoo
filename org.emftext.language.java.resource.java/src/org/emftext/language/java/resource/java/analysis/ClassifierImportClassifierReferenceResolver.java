package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.runtime.resource.IResolveResult;

public class ClassifierImportClassifierReferenceResolver extends org.emftext.runtime.resource.impl.ReferenceResolverImpl {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference) {
		return ((NamedElement)element).getName();
	}

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {
		
		ClassifierImport theImport = (ClassifierImport) container;
		
		Classifier importedClassifier = JavaClasspath.INSTANCE.getClassifier(theImport, identifier);
		
		if (importedClassifier != null) {
			result.addMapping(identifier, importedClassifier);
		}
	}
}
