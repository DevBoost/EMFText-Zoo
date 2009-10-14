package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.annotations.AnnotationAttributeSetting;
import org.emftext.language.java.annotations.rtypes.AnnotationAttributeSettingAttribute;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.InterfaceMethodDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;

public class AnnotationAttributeSettingAttributeValueReferenceResolver implements org.emftext.language.java.resource.java.IJavaReferenceResolver<org.emftext.language.java.annotations.rtypes.AnnotationAttributeSettingAttribute, org.emftext.language.java.members.InterfaceMethod> {
	
	public java.lang.String deResolve(InterfaceMethod element, AnnotationAttributeSettingAttribute container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, AnnotationAttributeSettingAttribute tContainer, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<InterfaceMethod> result) {
		if (!(tContainer.eContainer() instanceof AnnotationAttributeSetting)) {
			return;
		}
		AnnotationAttributeSetting container = (AnnotationAttributeSetting) tContainer.eContainer();
		
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		
		EObject startingPoint = container.getContainingAnnotationInstance().getAnnotation();
		
		deciderList.add(new InterfaceMethodDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		EObject target = treeWalker.walk(startingPoint, identifier, container, reference);
		
		if (target != null) {
			result.addMapping(identifier, (InterfaceMethod) target);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
	
}
