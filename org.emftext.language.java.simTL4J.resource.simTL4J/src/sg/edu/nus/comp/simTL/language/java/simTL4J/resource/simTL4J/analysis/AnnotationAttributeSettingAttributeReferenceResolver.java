/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationAttributeSetting;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.InterfaceMethod;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolveResult;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.IResolutionTargetDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.decider.InterfaceMethodDecider;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.ScopedTreeWalker;

public class AnnotationAttributeSettingAttributeReferenceResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JReferenceResolver<sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationAttributeSetting, sg.edu.nus.comp.simTL.language.java.simTL4J.members.InterfaceMethod> {
	
		
	public java.lang.String deResolve(InterfaceMethod element, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void resolve(java.lang.String identifier, AnnotationAttributeSetting container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, ISimTL4JReferenceResolveResult<InterfaceMethod> result) {
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
