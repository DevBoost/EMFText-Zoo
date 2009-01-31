package org.emftext.language.java.resource.java.analysis;

public class JavaFLOATING_POINT_HEX_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		return result;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		if (lexem.toLowerCase().startsWith("0x")) {
			lexem = lexem.substring(2);
		}
		
		assert lexem.contains(".");
		
		String[] parts = lexem.split("\\.");
		String beforePoint = parts[0];
		if (beforePoint.length() == 0) {
			return new Double(0);
		}
		// this is a hex float literal
		// TODO here is much more to do to resolve hex floats correctly
		return new Double(JavaDECIMAL_LITERALTokenResolver.parseInteger(beforePoint, 16));
	}
}
