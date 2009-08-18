package org.emftext.language.java.util;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.impl.ClassifierImpl;

/**
 * A temporal create classifier that combines all type restrictions
 * of one type parameter.
 */
public class TemporalCompositeClassifier extends ClassifierImpl {

	private EObject creator;
	
	private EList<EObject> superTypes = new UniqueEList<EObject>();
	
	public TemporalCompositeClassifier(EObject creator) {
		this.creator = creator;
	}

	public Resource eResource() {
		return creator.eResource();
	}

	public EList<EObject> getSuperTypes() {
		return superTypes;
	}
	
	public EList<ConcreteClassifier> getAllSuperClassifiers() {
		EList<ConcreteClassifier> result = new UniqueEList<ConcreteClassifier>();
		for(EObject superType : getSuperTypes()) {
			result.addAll(((Classifier) superType).getAllSuperClassifiers());
		}
		return result;
	}
	
}
