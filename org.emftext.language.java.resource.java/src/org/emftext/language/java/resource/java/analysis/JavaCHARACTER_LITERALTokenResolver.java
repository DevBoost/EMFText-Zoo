package org.emftext.language.java.resource.java.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.ITokenResolver;
import org.emftext.runtime.resource.impl.JavaBasedTokenResolver;

public class JavaCHARACTER_LITERALTokenResolver extends JavaBasedTokenResolver implements ITokenResolver{ 
	@Override
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = super.deResolve(value,feature,container);
		return result;
	}

	@Override
	public Object resolve(String lexem, EStructuralFeature feature, EObject container, ITextResource resource) {
		// TODO we must handle escaped character, for example '\u0000'
		assert lexem.length() == 3;
		// remove single quotes
		assert lexem.charAt(0) == '\'';
		assert lexem.charAt(lexem.length() - 1) == '\'';
		lexem = lexem.substring(1, lexem.length() - 1);
		Character result = Character.valueOf(lexem.charAt(0));
		//System.out.println("JavaCHARACTER_LITERALTokenResolver.resolve("+lexem+") : " + (result != null ? result.getClass() : "null"));
		return result;
	}
}
