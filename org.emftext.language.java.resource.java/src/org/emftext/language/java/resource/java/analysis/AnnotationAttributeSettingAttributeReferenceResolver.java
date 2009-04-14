package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.InterfaceMethodDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class AnnotationAttributeSettingAttributeReferenceResolver extends 
	AbstractReferenceResolver<AnnotationAttributeSetting, InterfaceMethod> {
	
	@Override	
	protected java.lang.String doDeResolve(InterfaceMethod element, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<InterfaceMethod> result) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		
		EObject startingPoint = JavaUtil.findContainingAnnotationInstance(container).getAnnotation();
		
		deciderList.add(new InterfaceMethodDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		EObject target = treeWalker.walk(startingPoint, identifier, container, reference);
		
		if (target != null) {
			result.addMapping(identifier, (InterfaceMethod) target);
		}
	}
}
