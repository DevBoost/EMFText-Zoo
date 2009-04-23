package org.emftext.language.java.javabehavior4uml.resource.javabehavior;

public class JavabehaviorReferenceResolverSwitch implements org.emftext.runtime.resource.IReferenceResolverSwitch {
	
	protected org.emftext.language.java.javabehavior4uml.resource.javabehavior.analysis.BehaviorSpecificationReferenceResolver behaviorSpecificationReferenceResolver = new org.emftext.language.java.javabehavior4uml.resource.javabehavior.analysis.BehaviorSpecificationReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver classifierImportClassifierReferenceResolver = new org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.StaticMemberImportStaticMembersReferenceResolver staticMemberImportStaticMembersReferenceResolver = new org.emftext.language.java.resource.java.analysis.StaticMemberImportStaticMembersReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.StaticClassifierImportStaticMembersReferenceResolver staticClassifierImportStaticMembersReferenceResolver = new org.emftext.language.java.resource.java.analysis.StaticClassifierImportStaticMembersReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.AnnotationInstanceAnnotationReferenceResolver annotationInstanceAnnotationReferenceResolver = new org.emftext.language.java.resource.java.analysis.AnnotationInstanceAnnotationReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.AnnotationAttributeSettingAttributeReferenceResolver annotationAttributeSettingAttributeReferenceResolver = new org.emftext.language.java.resource.java.analysis.AnnotationAttributeSettingAttributeReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.ClassifierReferenceTargetReferenceResolver classifierReferenceTargetReferenceResolver = new org.emftext.language.java.resource.java.analysis.ClassifierReferenceTargetReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver elementReferenceTargetReferenceResolver = new org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver();
	protected org.emftext.language.java.resource.java.analysis.JumpTargetReferenceResolver jumpTargetReferenceResolver = new org.emftext.language.java.resource.java.analysis.JumpTargetReferenceResolver();
	
	public org.emftext.language.java.javabehavior4uml.resource.javabehavior.analysis.BehaviorSpecificationReferenceResolver getBehaviorSpecificationReferenceResolver() {
		return behaviorSpecificationReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.ClassifierImportClassifierReferenceResolver getClassifierImportClassifierReferenceResolver() {
		return classifierImportClassifierReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.StaticMemberImportStaticMembersReferenceResolver getStaticMemberImportStaticMembersReferenceResolver() {
		return staticMemberImportStaticMembersReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.StaticClassifierImportStaticMembersReferenceResolver getStaticClassifierImportStaticMembersReferenceResolver() {
		return staticClassifierImportStaticMembersReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.AnnotationInstanceAnnotationReferenceResolver getAnnotationInstanceAnnotationReferenceResolver() {
		return annotationInstanceAnnotationReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.AnnotationAttributeSettingAttributeReferenceResolver getAnnotationAttributeSettingAttributeReferenceResolver() {
		return annotationAttributeSettingAttributeReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.ClassifierReferenceTargetReferenceResolver getClassifierReferenceTargetReferenceResolver() {
		return classifierReferenceTargetReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.ElementReferenceTargetReferenceResolver getElementReferenceTargetReferenceResolver() {
		return elementReferenceTargetReferenceResolver;
	}
	
	public org.emftext.language.java.resource.java.analysis.JumpTargetReferenceResolver getJumpTargetReferenceResolver() {
		return jumpTargetReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		behaviorSpecificationReferenceResolver.setOptions(options);
		classifierImportClassifierReferenceResolver.setOptions(options);
		staticMemberImportStaticMembersReferenceResolver.setOptions(options);
		staticClassifierImportStaticMembersReferenceResolver.setOptions(options);
		annotationInstanceAnnotationReferenceResolver.setOptions(options);
		annotationAttributeSettingAttributeReferenceResolver.setOptions(options);
		classifierReferenceTargetReferenceResolver.setOptions(options);
		elementReferenceTargetReferenceResolver.setOptions(options);
		jumpTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, int position, org.emftext.runtime.resource.IReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getBehavior().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.uml2.uml.BehavioralFeature> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.eclipse.uml2.uml.BehavioralFeature>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.eclipse.uml2.uml.UMLPackage.BEHAVIOR__SPECIFICATION);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				behaviorSpecificationReferenceResolver.resolve(identifier, (org.eclipse.uml2.uml.Behavior) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getClassifierImport().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.classifiers.ConcreteClassifier> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.classifiers.ConcreteClassifier>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.CLASSIFIER_IMPORT__CLASSIFIER);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				classifierImportClassifierReferenceResolver.resolve(identifier, (org.emftext.language.java.imports.ClassifierImport) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getStaticMemberImport().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_MEMBER_IMPORT__STATIC_MEMBERS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				staticMemberImportStaticMembersReferenceResolver.resolve(identifier, (org.emftext.language.java.imports.StaticMemberImport) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.imports.ImportsPackage.eINSTANCE.getStaticClassifierImport().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.imports.ImportsPackage.STATIC_CLASSIFIER_IMPORT__STATIC_MEMBERS);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				staticClassifierImportStaticMembersReferenceResolver.resolve(identifier, (org.emftext.language.java.imports.StaticClassifierImport) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.annotations.AnnotationsPackage.eINSTANCE.getAnnotationInstance().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.classifiers.Classifier> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.classifiers.Classifier>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_INSTANCE__ANNOTATION);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				annotationInstanceAnnotationReferenceResolver.resolve(identifier, (org.emftext.language.java.annotations.AnnotationInstance) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.annotations.AnnotationsPackage.eINSTANCE.getAnnotationAttributeSetting().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.members.InterfaceMethod> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.members.InterfaceMethod>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.annotations.AnnotationsPackage.ANNOTATION_ATTRIBUTE_SETTING__ATTRIBUTE);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				annotationAttributeSettingAttributeReferenceResolver.resolve(identifier, (org.emftext.language.java.annotations.AnnotationAttributeSetting) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.types.TypesPackage.eINSTANCE.getClassifierReference().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.classifiers.Classifier> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.classifiers.Classifier>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.types.TypesPackage.CLASSIFIER_REFERENCE__TARGET);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				classifierReferenceTargetReferenceResolver.resolve(identifier, (org.emftext.language.java.types.ClassifierReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.references.ReferencesPackage.eINSTANCE.getElementReference().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.references.ReferenceableElement>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.references.ReferencesPackage.ELEMENT_REFERENCE__TARGET);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				elementReferenceTargetReferenceResolver.resolve(identifier, (org.emftext.language.java.references.ElementReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.java.statements.StatementsPackage.eINSTANCE.getJump().isInstance(container)) {
			org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.statements.JumpLabel> frr = new org.emftext.runtime.resource.impl.FuzzyResolveResult<org.emftext.language.java.statements.JumpLabel>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(org.emftext.language.java.statements.StatementsPackage.JUMP__TARGET);
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				jumpTargetReferenceResolver.resolve(identifier, (org.emftext.language.java.statements.Jump) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}
