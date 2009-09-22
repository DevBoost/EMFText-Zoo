package org.emftext.language.filesystem.resource.fs.analysis;

public class FsQUOTED_34_34TokenResolver implements org.emftext.language.filesystem.resource.fs.IFsTokenResolver {
	
	private org.emftext.language.filesystem.resource.fs.analysis.FsDefaultTokenResolver defaultTokenResolver = new org.emftext.language.filesystem.resource.fs.analysis.FsDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.filesystem.resource.fs.IFsTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
