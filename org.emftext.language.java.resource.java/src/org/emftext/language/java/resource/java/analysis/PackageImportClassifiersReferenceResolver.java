package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.imports.PackageImport;

public class PackageImportClassifiersReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<PackageImport> {

	@Override
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, PackageImport container, org.eclipse.emf.ecore.EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			URI uri = element.eResource().getURI();
			String[] fullName = uri.lastSegment().split("\\.");
			String packageName = fullName[fullName.length - 3];
			
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

		for (Classifier classifier : importedClassifiers) {
			result.addMapping(identifier, classifier);
		}
	}
}
