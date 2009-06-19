/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package operations.org.emftext.language.java.classifiers.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.util.JavaClasspathUtil;
import org.emftext.language.java.util.classifiers.ClassifierUtil;
import org.emftext.language.java.util.modifiers.ModifiableUtil;
import org.emftext.language.java.util.types.ClassifierReferenceUtil;

/**
 * @generated
 */
public abstract class ConcreteClassifierImpl implements ConcreteClassifier {

	public EList<ConcreteClassifier> getAllInnerClassifiers() {
		EList<ConcreteClassifier> innerClassifierList = new BasicEList<ConcreteClassifier>();

		innerClassifierList.addAll(JavaClasspath.get(this)
				.getInnnerClassifiers(this));

		for (ConcreteClassifier superClassifier : ClassifierUtil
				.getAllSuperClassifiers(this)) {
			EList<ConcreteClassifier> superInnerList = JavaClasspath.get(this)
					.getInnnerClassifiers(superClassifier);

			for (ConcreteClassifier superInner : superInnerList) {
				if (superInner.eIsProxy()) {
					superInner = (ConcreteClassifier) EcoreUtil.resolve(
							superInner, this);
				}
				if (!superInner.eIsProxy()
						&& !ModifiableUtil.isHidden(superInner, this)) {
					innerClassifierList.add(superInner);
				}
			}
		}

		return innerClassifierList;
	}

	public EList<ClassifierReference> getSuperTypeReferences() {
		EList<ClassifierReference> typeReferenceList = new BasicEList<ClassifierReference>();
		if (this == null) {
			return typeReferenceList;
		}

		if (this instanceof org.emftext.language.java.classifiers.Class) {
			org.emftext.language.java.classifiers.Class javaClass = (org.emftext.language.java.classifiers.Class) this;
			if (javaClass.getExtends() != null) {
				ClassifierReference classifierReference = ClassifierReferenceUtil
						.getPureClassifierReference(javaClass.getExtends());
				typeReferenceList.add(classifierReference);
				ConcreteClassifier target = (ConcreteClassifier) classifierReference
						.getTarget();
				if (!target.equals(JavaClasspathUtil.getObjectClass(this))) {
					typeReferenceList.addAll(target.getSuperTypeReferences());
				}
			}
			for (TypeReference interfaceReference : javaClass.getImplements()) {
				ClassifierReference classifierReference = ClassifierReferenceUtil
						.getPureClassifierReference(interfaceReference);
				typeReferenceList.add(classifierReference);
				typeReferenceList
						.addAll(((ConcreteClassifier) classifierReference.getTarget()).getSuperTypeReferences());
			}
		} else if (this instanceof Interface) {
			Interface javaInterface = (Interface) this;
			for (TypeReference interfaceReference : javaInterface.getExtends()) {
				ClassifierReference classifierReference = ClassifierReferenceUtil
						.getPureClassifierReference(interfaceReference);
				typeReferenceList.add(classifierReference);
				typeReferenceList
						.addAll(((ConcreteClassifier) classifierReference
								.getTarget()).getSuperTypeReferences());
			}
		}
		return typeReferenceList;
	}
}
