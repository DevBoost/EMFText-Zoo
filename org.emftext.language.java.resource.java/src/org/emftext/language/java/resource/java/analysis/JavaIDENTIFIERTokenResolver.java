package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

// TODO @mseifert: add conversion of supplementary unicode characters
// see JavaSTRING_LITERALTokenResolver
public class JavaIDENTIFIERTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		super.resolve(lexem, feature, result);
	}
}
