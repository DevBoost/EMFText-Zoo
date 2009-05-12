package org.emftext.language.customburger.resource.customburger.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public class TemplateInputMetaClassReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.language.template_concepts.Template, org.eclipse.emf.ecore.EObject> {
	
	@Override	
	protected java.lang.String doDeResolve(org.eclipse.emf.ecore.EObject element, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.template_concepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		String[] namespaceAndClassName = identifier.split("::");
		if (namespaceAndClassName.length == 2) {
			String namespace = namespaceAndClassName[0];
			String className = namespaceAndClassName[1];
			EClassifier classifier = findEClassifier(namespace, className);
			if (classifier == null) {
				return;
			}
			if (classifier instanceof EClass) {
				result.addMapping(identifier, classifier);
			}
		}
	}
	
	private EClassifier findEClassifier(String nsURI, String eClassName) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		/*
	    for(Object ePackageCand : EPackage.Registry.INSTANCE.getEPackage(ePackagePrefix)values()) {
	        if (ePackageCand instanceof EPackage) {
	            if(((EPackage)ePackageCand).getNsPrefix().equals(ePackagePrefix)) {
	                ePackage = (EPackage) ePackageCand;
	                break;
	            }
	        }
	    }
	    */
	    if (ePackage == null) {
	    	return null;
	    } else {
	    	return ePackage.getEClassifier(eClassName);
	    }
	}
}
