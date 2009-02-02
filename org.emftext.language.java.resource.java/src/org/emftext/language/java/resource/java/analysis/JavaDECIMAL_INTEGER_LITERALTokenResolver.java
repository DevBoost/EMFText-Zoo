package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.DecimalIntegerLiteral;

public class JavaDECIMAL_INTEGER_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container instanceof DecimalIntegerLiteral;
		assert value instanceof Integer;
		return value.toString();
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof DecimalIntegerLiteral;
		
		Long result = JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 10, resource);
		return new Integer(result.intValue());
	}
}
