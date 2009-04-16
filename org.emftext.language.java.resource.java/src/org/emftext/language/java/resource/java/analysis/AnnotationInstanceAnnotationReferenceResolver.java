package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.annotations.AnnotationInstance;
import org.emftext.language.java.classifiers.Annotation;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class AnnotationInstanceAnnotationReferenceResolver extends 
	AbstractReferenceResolver<org.emftext.language.java.annotations.AnnotationInstance, org.emftext.language.java.classifiers.Classifier> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.language.java.classifiers.Classifier element, org.emftext.language.java.annotations.AnnotationInstance container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.language.java.annotations.AnnotationInstance annotationInstance, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.language.java.classifiers.Classifier> result) {
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
			String containerName = JavaClasspath.INSTANCE.getContainerNameFromNamespace(annotationInstance);
			ConcreteClassifier target = (ConcreteClassifier) EcoreUtil.resolve(
					JavaClasspath.INSTANCE.getClassifier(containerName + identifier), annotationInstance.eResource());
		
			if (target instanceof Annotation) {
				return target;
			}
		}
		
		return null;
	}
}
