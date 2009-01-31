package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.java.literals.DecimalIntegerLiteral;
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
		assert container instanceof DecimalIntegerLiteral;
		try {
			Long result = JavaDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 10);
			return new Integer(result.intValue());
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getClass().getSimpleName() + ": " + nfe.getMessage() + " in " + resource.getURI());
			return null;
		}
	}
}
