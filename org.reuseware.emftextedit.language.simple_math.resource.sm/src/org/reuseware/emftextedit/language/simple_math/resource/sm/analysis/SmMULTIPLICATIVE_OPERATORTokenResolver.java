package org.reuseware.emftextedit.language.simple_math.resource.sm.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.TokenResolver;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class SmMULTIPLICATIVE_OPERATORTokenResolver extends JavaBasedTokenResolver implements TokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, TextResource resource) {
		return super.resolve(lexem,feature,container,resource);
	}
}
