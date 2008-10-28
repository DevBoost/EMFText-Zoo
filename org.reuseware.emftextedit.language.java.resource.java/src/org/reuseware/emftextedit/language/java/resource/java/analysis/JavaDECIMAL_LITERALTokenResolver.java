package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.TokenResolver;
import org.reuseware.emftextedit.resource.impl.JavaBasedTokenResolver;

public class JavaDECIMAL_LITERALTokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		//return super.resolve(lexem, feature, container, resource);
		if (lexem.toLowerCase().endsWith("l")) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		Long result = Long.decode(lexem);
		//System.out.println("JavaDECIMAL_LITERALTokenResolver.resolve("+lexem+") : " + result.getClass());
		return result;
	}
}
