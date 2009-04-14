package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.instantiations.NewConstructorCall;
import org.emftext.language.java.references.Reference;
import org.emftext.language.java.references.ReferencesPackage;
import org.emftext.language.java.resource.java.analysis.decider.ConcreteClassifierDecider;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.TypeParameterDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.emftext.language.java.util.references.ReferenceUtil;
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
		
		EObject startingPoint = null;
		
		if (container.eContainer() instanceof NamespaceClassifierReference) {
			NamespaceClassifierReference ncr = (NamespaceClassifierReference) container.eContainer();
			int idx = ncr.getClassifierReferences().indexOf(container);
			if(idx > 0) {
				startingPoint = ncr.getClassifierReferences().get(idx - 1).getTarget();
			}
		}
		
		//new constructor call can be part of reference chain
		if (startingPoint == null && container.eContainer().eContainer() instanceof NewConstructorCall) {
			NewConstructorCall ncc = (NewConstructorCall) container.eContainer().eContainer();
			if (ncc.eContainmentFeature().equals(ReferencesPackage.Literals.REFERENCE__NEXT)) {
				startingPoint = ReferenceUtil.getType((Reference) ncc.eContainer());
			}
		}
		
		if (startingPoint == null) {
			startingPoint = container;
		}
		
		deciderList.add(new ConcreteClassifierDecider());
		deciderList.add(new TypeParameterDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		EObject target = treeWalker.walk(startingPoint, identifier, container, reference);
		
		if (target != null) {
			result.addMapping(identifier, (Classifier) target);
		}
	}
}
