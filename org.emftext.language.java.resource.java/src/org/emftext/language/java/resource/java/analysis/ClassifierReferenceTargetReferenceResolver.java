package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.TypeParameterDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class ClassifierReferenceTargetReferenceResolver extends 
	AbstractReferenceResolver<ClassifierReference, Classifier> {
	
	@Override	
	protected java.lang.String doDeResolve(Classifier classifier, ClassifierReference container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(classifier, container, reference);
	}	
	@Override	
	protected void doResolve(java.lang.String identifier, ClassifierReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<Classifier> result) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		
		EObject startingPoint = container;
		
		deciderList.add(new ConcreteClassifierDecider());
		deciderList.add(new TypeParameterDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		EObject target = treeWalker.walk(startingPoint, identifier, container, reference);
		
		if (target != null) {
			result.addMapping(identifier, (Classifier) target);
		}
	}
}
