package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.LONG_SUFFIX;

import java.math.BigInteger;

import org.emftext.language.java.literals.DecimalLongLiteral;
import org.emftext.runtime.resource.ITextResource;

public class JavaDECIMAL_LONG_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container instanceof DecimalLongLiteral;
		assert value instanceof Long;
		return value.toString() + LONG_SUFFIX;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof DecimalLongLiteral;
		assert lexem.toLowerCase().endsWith(LONG_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		Long result = parseToLong(lexem, 10, resource);
		return result;
	}

	public static Long parseToLong(String lexem, int radix, ITextResource resource) throws NumberFormatException {
		try {
			BigInteger tempInteger = new BigInteger(lexem, radix);
			Long result = tempInteger.longValue();
			return result;
		} catch (NumberFormatException nfe) {
			String uri = "unknown resource.";
			if (resource != null) {
				uri = resource.getURI().toString();
			}
			System.out.println(nfe.getClass().getSimpleName() + ": " + nfe.getMessage() + " in " + uri);
			return null;
		}
	}
}
