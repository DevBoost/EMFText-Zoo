package org.emftext.language.java.resource.java.analysis;

import java.math.BigInteger;

import org.emftext.language.java.literals.DecimalLongLiteral;

public class JavaDECIMAL_LONG_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		return result;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof DecimalLongLiteral;
		assert lexem.toLowerCase().endsWith("l");

		lexem = lexem.substring(0, lexem.length() - 1);
		Long result = parseToLong(lexem, 10, resource.getURI().toString());
		return result;
	}

	public static Long parseToLong(String lexem, int radix, String uri) throws NumberFormatException {
		BigInteger tempInteger = new BigInteger(lexem, radix);
		try {
			Long result = tempInteger.longValue();
			return result;
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getClass().getSimpleName() + ": " + nfe.getMessage() + " in " + uri);
			return null;
		}
	}
}
