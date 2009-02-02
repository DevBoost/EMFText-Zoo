package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.HexFloatLiteral;

public class JavaHEX_FLOAT_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = super.deResolve(value, feature, container);
		return result;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof HexFloatLiteral;
		
		assert lexem.toLowerCase().startsWith("0x");
		assert lexem.toLowerCase().endsWith("f");
		
		lexem = lexem.substring(0, lexem.length() - 1);
		
		return Float.parseFloat(lexem);
	}
}
