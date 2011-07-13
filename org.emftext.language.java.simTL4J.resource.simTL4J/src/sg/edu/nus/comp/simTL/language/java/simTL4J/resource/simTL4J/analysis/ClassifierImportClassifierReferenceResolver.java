
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;

import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ConcreteClassifier;
import sg.edu.nus.comp.simTL.language.java.simTL4J.imports.ClassifierImport;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolveResult;

public class ClassifierImportClassifierReferenceResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolver<sg.edu.nus.comp.simTL.language.java.simTL4J.imports.ClassifierImport, sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.ConcreteClassifier> {
	
	public java.lang.String deResolve(ConcreteClassifier element, ClassifierImport container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, ClassifierImport theImport, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ISimTL4JReferenceResolveResult<ConcreteClassifier> result) {
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
