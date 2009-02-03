package org.emftext.language.java.resource.java.analysis;

import static org.emftext.language.java.resource.java.analysis.helper.LiteralConstants.FLOAT_SUFFIX;

import org.emftext.language.java.literals.DecimalFloatLiteral;

public class JavaDECIMAL_FLOAT_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalFloatLiteral;
		assert value instanceof Float;
		return value.toString() + FLOAT_SUFFIX;
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container == null || container instanceof DecimalFloatLiteral;
		assert lexem.toLowerCase().endsWith(FLOAT_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		
		return new Float(JavaDECIMAL_DOUBLE_LITERALTokenResolver.parseToDouble(lexem, resource).floatValue());
	}
}
