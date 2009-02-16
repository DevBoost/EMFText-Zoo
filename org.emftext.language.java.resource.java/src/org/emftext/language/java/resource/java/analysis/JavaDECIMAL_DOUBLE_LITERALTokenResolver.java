package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.DOUBLE_SUFFIX;

import java.math.BigDecimal;

import org.emftext.language.java.literals.DecimalDoubleLiteral;
import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.runtime.resource.ITokenResolveResult;

public class JavaDECIMAL_DOUBLE_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalDoubleLiteral;
		assert value instanceof Double;
		return value.toString();
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getDoubleLiteral());
		
		if (lexem.toLowerCase().endsWith(DOUBLE_SUFFIX)) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		
		parseToDouble(lexem, result);
	}


	public static void parseToDouble(String lexem, ITokenResolveResult result) {
		try {
			BigDecimal tempDecimal = new BigDecimal(lexem);
			Double value = tempDecimal.doubleValue();
			result.setResolvedToken(value);
		} catch (NumberFormatException nfe) {
			result.setErrorMessage(nfe.getClass().getSimpleName() + ": " + nfe.getMessage());
		}
	}
}
