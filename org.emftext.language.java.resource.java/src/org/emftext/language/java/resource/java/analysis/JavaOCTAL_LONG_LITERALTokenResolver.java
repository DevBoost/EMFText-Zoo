package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.OCT_PREFIX;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.LONG_SUFFIX;

import java.math.BigInteger;

import org.emftext.language.java.literals.LiteralsPackage;
import org.emftext.language.java.literals.OctalLongLiteral;

public class JavaOCTAL_LONG_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof OctalLongLiteral;
		assert value instanceof BigInteger;

		return OCT_PREFIX + ((BigInteger) value).toString(8) + LONG_SUFFIX;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getLongLiteral());
		assert lexem.toLowerCase().endsWith(LONG_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 8, result);
	}
}
