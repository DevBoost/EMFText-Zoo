package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class JavaHEX_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource) {
		//System.out.println("JavaHEX_LITERALTokenResolver.resolve("+lexem+") : " + (result != null ? result.getClass() : "null"));
		try {
			if (lexem.endsWith("L")) {
				lexem = lexem.substring(0, lexem.length() - 1);
			}
			Long result = Long.decode(lexem);
			return result;
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage() + " in " + resource.getURI());
			return null;
		}
	}
}
