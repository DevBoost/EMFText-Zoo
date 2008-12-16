package org.emftext.language.java.resource.java.analysis;

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
		//return super.resolve(lexem, feature, container, resource);
		if (lexem.toLowerCase().endsWith("l")) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		Long result = Long.decode(lexem);
		//System.out.println("JavaDECIMAL_LITERALTokenResolver.resolve("+lexem+") : " + result.getClass());
		return result;
	}
}
