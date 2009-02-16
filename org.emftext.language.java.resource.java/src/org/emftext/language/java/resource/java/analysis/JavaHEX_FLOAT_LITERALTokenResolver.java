package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.FLOAT_SUFFIX;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_EXPONENT;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;

import org.emftext.language.java.literals.HexFloatLiteral;
import org.emftext.language.java.literals.LiteralsPackage;

public class JavaHEX_FLOAT_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {

	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexFloatLiteral;
		assert value instanceof Float;
		return Float.toHexString((Float) value) + FLOAT_SUFFIX;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getFloatLiteral());
		
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		assert lexem.toLowerCase().contains(HEX_EXPONENT);
		assert lexem.toLowerCase().endsWith(FLOAT_SUFFIX);
		
		lexem = lexem.substring(0, lexem.length() - 1);
		
		result.setResolvedToken(Float.parseFloat(lexem));
	}
}
