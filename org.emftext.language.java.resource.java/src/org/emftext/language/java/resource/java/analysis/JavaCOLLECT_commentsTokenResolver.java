package org.emftext.language.java.resource.java.analysis;

public class JavaCOLLECT_commentsTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		System.out.println("JavaCOLLECT_commentsTokenResolver.deResolve(" + value + ")");
		java.lang.String result = super.deResolve(value, feature, container);
		return result;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		System.out.println("JavaCOLLECT_commentsTokenResolver.resolve(" + lexem + ")");
		return super.resolve(lexem,feature,container,resource);
	}
}
