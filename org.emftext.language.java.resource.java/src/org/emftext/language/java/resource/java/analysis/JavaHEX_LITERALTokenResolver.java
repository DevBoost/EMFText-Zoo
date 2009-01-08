package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class JavaHEX_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver {
	
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value, feature, container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource) {
		if (lexem.startsWith("0x")) {
			lexem = lexem.substring(2);
		}
		try {
			return JavaDECIMAL_LITERALTokenResolver.parseInteger(lexem, 16);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println(nfe.getClass().getSimpleName() + ": " + nfe.getMessage() + " in " + resource.getURI());
			return null;
		}
	}
}
