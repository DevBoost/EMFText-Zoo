package org.emftext.language.java.resource.java.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.resource.java.IJavaReferenceResolveResult;
import org.emftext.language.java.resource.java.analysis.decider.IResolutionTargetDecider;
import org.emftext.language.java.resource.java.analysis.decider.JumpLabelDecider;
import org.emftext.language.java.resource.java.analysis.helper.ScopedTreeWalker;
import org.emftext.language.java.statements.JumpLabel;
import org.emftext.language.java.statements.rtypes.JumpTarget;

public class JumpTargetValueReferenceResolver implements org.emftext.language.java.resource.java.IJavaReferenceResolver<org.emftext.language.java.statements.rtypes.JumpTarget, org.emftext.language.java.statements.JumpLabel> {
		
		public java.lang.String deResolve(JumpLabel element, JumpTarget container, org.eclipse.emf.ecore.EReference reference) {
			return element.getName();
		}
		
		public void resolve(java.lang.String identifier, JumpTarget container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IJavaReferenceResolveResult<JumpLabel> result) {
			List<IResolutionTargetDecider> deciderList = new ArrayList<IResolutionTargetDecider>();
			
			EObject startingPoint = container;
			
			deciderList.add(new JumpLabelDecider());
			
			ScopedTreeWalker treeWalker = new ScopedTreeWalker(deciderList);
			
			EObject target = treeWalker.walk(startingPoint, identifier, container, reference);
			
			if (target != null) {
				result.addMapping(identifier, (JumpLabel) target);
			}
		}

		public void setOptions(Map<?, ?> options) {
		}


}
