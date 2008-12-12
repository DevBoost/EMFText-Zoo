package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.core.Classifier;
import org.emftext.language.java.core.Import;
import org.emftext.language.java.JavaClasspath;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;

public class ImportClassifiersReferenceResolver extends ReferenceResolverImpl {

	@Override
	protected String doDeResolve(EObject element, EObject container,
			EReference reference) {
		EList<?> classifierList = ((EList<?>)container.eGet(reference));
		
		if (classifierList.get(0).equals(element)) {
			if (classifierList.size() == 1) {
				return ((Classifier)element).getName();
			}
			else {
				return "*";
			}
		}
		else {
			return ""; // "*" already returned by first element
		}
	}

	@Override
	protected void doResolve(String proxyURIFragment, EObject container,
			EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {
		
		Import theImport = (Import) container;
		
		String packageName = createPackageName(theImport);
		
		EList<Classifier> classifiers =  
			JavaClasspath.INSTANCE.getClassifiers(packageName, proxyURIFragment);

		// TODO mseifert: this should return all classifiers as a collection
		while (classifiers.size() > 1) {
			theImport.getClassifiers().add(classifiers.remove(0));
		}
		
		if (classifiers.size() == 1) {
			result.addMapping(proxyURIFragment, classifiers.remove(0));
		}
	}
	
	public static String createPackageName(Import theImport) {
		String packageName = null;
		for(String packageNameFragment : theImport.getPackage()) {
			if (packageName == null) {
				packageName = packageNameFragment;
			}
			else {
				packageName = packageName + "." + packageNameFragment;
			}
		}
		return packageName;
	}
}
