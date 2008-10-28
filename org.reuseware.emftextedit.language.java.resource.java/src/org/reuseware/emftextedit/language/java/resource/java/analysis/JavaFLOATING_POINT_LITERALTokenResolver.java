package org.reuseware.emftextedit.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.reuseware.emftextedit.resource.TextResource;
import org.reuseware.emftextedit.resource.TokenResolver;
import org.reuseware.emftextedit.resource.impl.JavaBasedTokenResolver;

public class JavaFLOATING_POINT_LITERALTokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		Object result = super.resolve(lexem,feature,container,resource);
		//System.out.println("JavaFLOATING_POINT_LITERALTokenResolver.resolve("+lexem+") : " + result.getClass());
		return result;
	}
}
