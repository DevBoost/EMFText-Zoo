package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.LONG_SUFFIX;

import java.math.BigInteger;

import org.emftext.language.java.literals.DecimalLongLiteral;
import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.runtime.resource.ITokenResolveResult;

public class JavaDECIMAL_LONG_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalLongLiteral;
		assert value instanceof BigInteger;
		return value.toString() + LONG_SUFFIX;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getLongLiteral());
		assert lexem.toLowerCase().endsWith(LONG_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		parseToLong(lexem, 10, result);
	}

	public static void parseToLong(String lexem, int radix, ITokenResolveResult result) throws NumberFormatException {
		try {
			BigInteger tempInteger = new BigInteger(lexem, radix);
			result.setResolvedToken(tempInteger);
		} catch (NumberFormatException nfe) {
			result.setErrorMessage(nfe.getClass().getSimpleName() + ": " + nfe.getMessage());
		}
	}
}
