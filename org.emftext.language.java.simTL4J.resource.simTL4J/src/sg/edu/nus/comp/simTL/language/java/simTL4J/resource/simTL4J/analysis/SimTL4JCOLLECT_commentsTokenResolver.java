
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis;

import java.util.Map;

import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolveResult;

public class SimTL4JCOLLECT_commentsTokenResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolver {
	
	private sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultTokenResolver defaultTokenResolver = new sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String comment = (String) value;
		if (comment.startsWith("//")) {
			comment = comment + "\n";
		}
		return comment;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimTL4JTokenResolveResult result) {
		//do nothing for now
		result.setResolvedToken(lexem);
	}
	
	public void setOptions(Map<?, ?> options) {
	}
	
}
