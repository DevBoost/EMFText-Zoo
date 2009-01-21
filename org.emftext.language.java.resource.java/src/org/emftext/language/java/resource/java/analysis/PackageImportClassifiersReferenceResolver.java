package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.imports.PackageImport;

public class PackageImportClassifiersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<PackageImport> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, PackageImport container, org.eclipse.emf.ecore.EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			URI uri = element.eResource().getURI();
			String packageName = uri.trimFileExtension().lastSegment();
			int idx1 = packageName.lastIndexOf("$");
			int idx2 = packageName.lastIndexOf(".");
			if (idx1 != -1) {
				packageName = packageName.substring(0,idx1);
			}
			else if (idx2 != -1) {
				packageName = packageName.substring(0,idx2);
			}
			idx1 = packageName.lastIndexOf("$");
			idx2 = packageName.lastIndexOf(".");
			if (idx1 != -1) {
				packageName = packageName.substring(idx1 + 1);
			}
			else if (idx2 != -1) {
				packageName = packageName.substring(idx2 + 1);
			}
			return packageName;
		}
		else {
			return ""; // already returned by first element
		}
	}

	@Override
	protected void doResolve(java.lang.String identifier, PackageImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IResolveResult result) {
		
		EList<Classifier> importedClassifiers =  
			JavaClasspath.INSTANCE.getClassifiers(theImport, identifier);

		for (Classifier importedClassifier : importedClassifiers) {
			importedClassifier = (Classifier) EcoreUtil.resolve(importedClassifier, theImport.eResource());
			if (!importedClassifier.eIsProxy()) {
				result.addMapping(identifier, importedClassifier);
			}
		}
	}
}
