package org.emftext.language.c_sharp.resource.cs.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EObject;

public class CsTEXTTokenResolver extends org.emftext.runtime.resource.impl.JavaBasedTokenResolver implements org.emftext.runtime.resource.ITokenResolver {
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, org.emftext.runtime.resource.ITextResource resource) {
		return super.resolve(lexem,feature,container,resource);
	}
}
