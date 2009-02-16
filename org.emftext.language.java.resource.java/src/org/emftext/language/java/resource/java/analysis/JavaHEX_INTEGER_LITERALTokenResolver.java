package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.HexIntegerLiteral;
import org.emftext.language.java.literals.LiteralsPackage;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;

public class JavaHEX_INTEGER_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexIntegerLiteral;
		assert value instanceof Integer;
		return HEX_PREFIX + Integer.toHexString((Integer) value);
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getIntegerLiteral());
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		
		lexem = lexem.substring(2);
		
		JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 16, result);
		Long longValue = (Long) result.getResolvedToken();
		result.setResolvedToken(new Integer(longValue.intValue()));
	}
}
