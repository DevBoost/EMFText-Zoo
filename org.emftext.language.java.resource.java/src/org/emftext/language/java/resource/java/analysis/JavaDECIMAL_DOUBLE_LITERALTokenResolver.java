package org.emftext.language.java.resource.java.analysis;

import java.math.BigDecimal;

import org.emftext.language.java.literals.DecimalDoubleLiteral;
import org.emftext.runtime.resource.ITextResource;

public class JavaDECIMAL_DOUBLE_LITERALTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	
	@Override
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container instanceof DecimalDoubleLiteral;
		assert value instanceof Double;
		return value.toString();
	}

	@Override
	public java.lang.Object resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container, org.emftext.runtime.resource.ITextResource resource) {
		assert container instanceof DecimalDoubleLiteral;
		
		if (lexem.toLowerCase().endsWith("d")) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		
		return parseToDouble(lexem, resource);
	}


	public static Double parseToDouble(String lexem, ITextResource resource) throws NumberFormatException {
		try {
			BigDecimal tempDecimal = new BigDecimal(lexem);
			Double result = tempDecimal.doubleValue();
			return result;
		} catch (NumberFormatException nfe) {
			String uri = "unknown resource.";
			if (resource != null) {
				uri = resource.getURI().toString();
			}
			System.out.println(nfe.getClass().getSimpleName() + ": " + nfe.getMessage() + " in " + uri);
			return null;
		}
	}
}
