package org.emftext.language.project.resource.project.analysis;

public class ProjectTEXTTokenResolver implements org.emftext.language.project.resource.project.IProjectTokenResolver {
	
	private org.emftext.language.project.resource.project.analysis.ProjectDefaultTokenResolver defaultTokenResolver = new org.emftext.language.project.resource.project.analysis.ProjectDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.project.resource.project.IProjectTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
