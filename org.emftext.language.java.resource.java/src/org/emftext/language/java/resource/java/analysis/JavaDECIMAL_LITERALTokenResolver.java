package org.emftext.language.java.resource.java.analysis;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class JavaDECIMAL_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource) {
		//System.out.println("JavaDECIMAL_LITERALTokenResolver.resolve("+lexem+") : " + result.getClass());
		try {
			return parseInteger(lexem, resource);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getClass().getSimpleName() + ": " + nfe.getMessage() + " in " + resource.getURI());
			return null;
		}
	}


	public static Long parseInteger(String lexem, ITextResource resource) throws NumberFormatException {
		Long result;
		if (lexem.toLowerCase().endsWith("l")) {
			lexem = lexem.substring(0, lexem.length() - 1);
			BigInteger tempInteger = new BigInteger(lexem, 16);
			result = tempInteger.longValue();
		}
		else {
			BigInteger tempInteger = new BigInteger(lexem); //no radix!
			result = tempInteger.longValue();
		}

		return result;
	}
}
