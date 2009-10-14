package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.annotations.rtypes.AnnotationInstanceAnnotation;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;

public class AnnotationInstanceAnnotationValueReferenceResolver implements org.emftext.language.java.resource.java.IJavaReferenceResolver<org.emftext.language.java.annotations.rtypes.AnnotationInstanceAnnotation, org.emftext.language.java.classifiers.Classifier> {
	
	public java.lang.String deResolve(org.emftext.language.java.classifiers.Classifier element, AnnotationInstanceAnnotation container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, AnnotationInstanceAnnotation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<org.emftext.language.java.classifiers.Classifier> result) {
		if (!(container.eContainer() instanceof AnnotationInstance)) {
			return;
		}
		AnnotationInstance annotationInstance = (AnnotationInstance) container.eContainer();
		
		
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		EObject startingPoint = annotationInstance;
		EObject target =  null; 
		
		if(annotationInstance.getNamespaces().size() > 0) {
			EObject lastClassInNS = ConcreteClassifierDecider.resolveRelativeNamespace(
					annotationInstance, 0, annotationInstance, annotationInstance, reference);
			if (lastClassInNS != null) {
				startingPoint = lastClassInNS;
			}
			else {
				//absolute class starting with package
				target = resolveFullQualifiedAnnotationReferences(identifier, annotationInstance);
			}
		}
		
		if (target == null) {
			deciderList.add(new ConcreteClassifierDecider());		
			ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
			target = treeWalker.walk(startingPoint, identifier, annotationInstance, reference);
		}
		
		if (target != null) {
			result.addMapping(identifier, (Classifier) target);
		}
	}
	
	private EObject resolveFullQualifiedAnnotationReferences(String identifier,
			AnnotationInstance annotationInstance) {
			
		if (annotationInstance.getNamespaces().size() > 0) {
			String containerName = annotationInstance.getNamespacesAsString();
			ConcreteClassifier target = (ConcreteClassifier) EcoreUtil.resolve(
					JavaClasspath.get(annotationInstance).getClassifier(containerName + identifier), annotationInstance.eResource());
		
			if (target instanceof Annotation) {
				return target;
			}
		}
		
		return null;
	}

	public void setOptions(Map<?, ?> options) {
	}
}
