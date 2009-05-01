package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.FLOAT_SUFFIX;

import java.math.BigDecimal;

import org.emftext.language.java.literals.DecimalFloatLiteral;
import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.runtime.resource.ITokenResolveResult;

public class JavaDECIMAL_FLOAT_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalFloatLiteral;
		assert value instanceof Float;
		return value.toString() + FLOAT_SUFFIX;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getFloatLiteral());
		assert lexem.toLowerCase().endsWith(FLOAT_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		parseToFloat(lexem, result);
	}

	public static void parseToFloat(String lexem, ITokenResolveResult result) {
		try {
			BigDecimal tempDecimal = new BigDecimal(lexem);
			Float value = tempDecimal.floatValue();
			result.setResolvedToken(value);
		} catch (NumberFormatException nfe) {
			result.setErrorMessage(nfe.getClass().getSimpleName() + ": " + nfe.getMessage());
		}
	}
}
