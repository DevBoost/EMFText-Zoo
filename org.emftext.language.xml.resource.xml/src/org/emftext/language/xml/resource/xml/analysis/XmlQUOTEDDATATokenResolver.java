package org.emftext.language.xml.resource.xml.analysis;

public class XmlQUOTEDDATATokenResolver extends org.emftext.runtime.resource.impl.AbstractTokenResolver {
	
	private org.emftext.language.xml.resource.xml.XmlDefaultTokenResolver defaultTokenResolver = new org.emftext.language.xml.resource.xml.XmlDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
