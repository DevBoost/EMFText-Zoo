package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.HexLongLiteral;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.LONG_SUFFIX;

public class JavaHEX_LONG_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container instanceof HexLongLiteral;
		assert value instanceof Long;
		return HEX_PREFIX + Long.toHexString((Long) value) + LONG_SUFFIX;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof HexLongLiteral;
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		assert lexem.toLowerCase().endsWith(LONG_SUFFIX);
		
		lexem = lexem.substring(2);
		lexem = lexem.substring(0, lexem.length() - 1);
		
		return JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 16, resource);
	}
}
