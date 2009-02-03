package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.HexIntegerLiteral;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;

public class JavaHEX_INTEGER_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexIntegerLiteral;
		assert value instanceof Integer;
		return HEX_PREFIX + Integer.toHexString((Integer) value);
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container == null || container instanceof HexIntegerLiteral;
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		
		lexem = lexem.substring(2);
		
		return new Integer(JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 16, resource).intValue());
	}
}
