package org.emftext.language.java.resource.java.analysis;

import org.emftext.language.java.literals.DecimalIntegerLiteral;
import org.emftext.language.java.literals.LiteralsPackage;

public class JavaDECIMAL_INTEGER_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalIntegerLiteral;
		assert value instanceof Long;
		return value.toString();
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getIntegerLiteral());
		
		JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 10, result);
		/*
		Long longValue = (Long) result.getResolvedToken();
		if (longValue != null) {
			result.setResolvedToken(new Integer(longValue.intValue()));
		}
		*/
	}
}
