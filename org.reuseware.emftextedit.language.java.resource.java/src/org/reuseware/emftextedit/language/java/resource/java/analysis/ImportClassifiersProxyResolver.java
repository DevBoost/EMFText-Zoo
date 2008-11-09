package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.reuseware.emftextedit.language.java.Classifier;
import org.reuseware.emftextedit.language.java.Import;
import org.reuseware.emftextedit.language.java.resource.java.JavaClasspath;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.resource.impl.ProxyResolverImpl;

public class ImportClassifiersProxyResolver extends ProxyResolverImpl {

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
	protected EObject doResolve(InternalEObject proxy, EObject container,
			EReference reference, TextResource resource) {
		
		Import theImport = (Import) container;
		
		String packageName = null;
		for(String packageNameFragment : theImport.getPackage()) {
			if (packageName == null) {
				packageName = packageNameFragment;
			}
			else {
				packageName = packageName + "." + packageNameFragment;
			}
		}
		
		EList<Classifier> classifiers =  
			JavaClasspath.INSTANCE.getClassifiers(packageName, proxy.eProxyURI().fragment());
		
		while (classifiers.size() > 1) {
			theImport.getClassifiers().add(classifiers.remove(0));
		}
		
		return classifiers.remove(0);
	}

}
