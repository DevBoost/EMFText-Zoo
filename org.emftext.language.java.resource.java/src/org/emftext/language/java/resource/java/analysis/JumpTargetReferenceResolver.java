package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.JumpLabelDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.statements.Jump;
import org.emftext.language.java.statements.JumpLabel;
import org.emftext.language.java.util.JavaUtil;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

public class JumpTargetReferenceResolver extends 
	AbstractReferenceResolver<Jump, JumpLabel> {
	
	@Override	
	protected java.lang.String doDeResolve(JumpLabel element, Jump container, org.eclipse.emf.ecore.EReference reference) {
		return JavaUtil.getName(element);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, Jump container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<JumpLabel> result) {
		List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
		
		EObject startingPoint = container;
		
		deciderList.add(new JumpLabelDecider());
		
		ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
		
		EObject target = treeWalker.walk(startingPoint, identifier, container, reference);
		
		if (target != null) {
			result.addMapping(identifier, (JumpLabel) target);
		}
	}
}
