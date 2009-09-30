package org.emftext.language.uml_class.resource.uml_class.analysis;

public class Uml_classTEXTTokenResolver implements org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolver {
	
	private org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultTokenResolver defaultTokenResolver = new org.emftext.language.uml_class.resource.uml_class.analysis.Uml_classDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.uml_class.resource.uml_class.IUml_classTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
