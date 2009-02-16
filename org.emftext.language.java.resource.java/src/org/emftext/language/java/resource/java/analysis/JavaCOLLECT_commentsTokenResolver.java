package org.emftext.language.java.resource.java.analysis;

public class JavaCOLLECT_commentsTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String comment = (String) value;
		if (comment.startsWith("//")) {
			comment = comment + "\n";
		}
		return comment;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		//do nothing for now
		result.setResolvedToken(lexem);
	}
}
