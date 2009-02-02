package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.HexDoubleLiteral;
import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.HEX_PREFIX;

public class JavaHEX_DOUBLE_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {

	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container instanceof HexDoubleLiteral;
		assert value instanceof Double;
		return Double.toHexString((Double) value);
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof HexDoubleLiteral;
		// this assertion is wrong, because hex literals of the form 0x1P10 are also valid
		//assert lexem.contains(".");
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		if (lexem.toLowerCase().endsWith("d")) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		
		return Double.parseDouble(lexem);
	}
}
