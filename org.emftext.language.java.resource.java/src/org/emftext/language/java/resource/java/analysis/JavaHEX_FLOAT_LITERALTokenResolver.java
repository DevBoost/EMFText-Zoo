package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.HexFloatLiteral;

public class JavaHEX_FLOAT_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		return result;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof HexFloatLiteral;
		// This assertion is wrong, because hex float literals must not contain a dot
		//assert lexem.contains(".");
		assert lexem.toLowerCase().startsWith("0x");
		
		lexem = lexem.substring(2);
		
		return new Float(parseFloatingHex(lexem).floatValue());
	}


	public static Double parseFloatingHex(String lexem) {
		// todo this must completely reworked
		return new Double(0);
		
		/*
		String[] parts = lexem.split("\\.");
		String beforePoint = parts[0];
		if (beforePoint.length() == 0) {
			return new Double(0);
		}
		// this is a hex float literal
		// TODO here is much more to do to resolve hex floats correctly
		return new Double(JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(beforePoint, 16));
		*/
	}
}
